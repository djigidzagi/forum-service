package telran.java53.accounting.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import telran.java53.accounting.dao.UserRepository;
import telran.java53.accounting.dto.RolesDto;
import telran.java53.accounting.dto.UserDto;
import telran.java53.accounting.dto.UserEditDto;
import telran.java53.accounting.dto.UserRegisterDto;
import telran.java53.accounting.model.User;


@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {
	
	final UserRepository userRepository;
	final ModelMapper modelMapper;

	@Override
	public UserDto register(UserRegisterDto userRegisterDto) {
		 User user = modelMapper.map(userRegisterDto, User.class);
		 user = userRepository.save(user);
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public UserDto getUser(String login) {
		//когда я пишу orElseThrow(UserNotFoundException::new) подчеркивает красным
		User user = userRepository.findByLoginIgnoreCase(login).findFirst().orElseThrow();
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public UserDto removeUser(String login) {
		User user = userRepository.findByLoginIgnoreCase(login).findFirst().orElseThrow();
		userRepository.delete(user);
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public UserDto updateUser(String login, UserEditDto userEditDto) {
		User user = userRepository.findByLoginIgnoreCase(login).findFirst().orElseThrow();
		String newFirstName = userEditDto.getFirstName();
		if (newFirstName != null) {
			user.setFirstName(newFirstName);
		}
		String newLastName = userEditDto.getFirstName();
		if (newLastName != null) {
			user.setLastName(newLastName);
		}
		user = userRepository.save(user);
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public RolesDto changeRolesList(String login, String role, boolean isAddRole) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changePassword(String login, String newPassword) {
		// TODO Auto-generated method stub

	}

}
