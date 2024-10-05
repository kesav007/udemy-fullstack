package com.codedecode.userInfo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.codedecode.userInfo.dto.UserDTO;
import com.codedecode.userInfo.entity.User;
import com.codedecode.userInfo.mapper.UserMapper;
import com.codedecode.userInfo.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo userRepo;

	public UserDTO addUser(UserDTO userDTO) {
		User user = UserMapper.INSTANCE.mapUserDTOToUser(userDTO);
		return UserMapper.INSTANCE.mapUserToUserDTO(userRepo.save(user));
	}

	public ResponseEntity<UserDTO> getUserDetailsById(Integer userid) {
		Optional<User> user = userRepo.findById(userid);
		if(user.isPresent()) {
			return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDTO(user.get()), HttpStatus.FOUND);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

}
