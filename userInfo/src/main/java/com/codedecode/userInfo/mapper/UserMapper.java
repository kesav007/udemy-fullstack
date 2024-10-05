package com.codedecode.userInfo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.codedecode.userInfo.dto.UserDTO;
import com.codedecode.userInfo.entity.User;

@Mapper
public interface UserMapper {
	
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	User mapUserDTOToUser(UserDTO userDto);
	
	UserDTO mapUserToUserDTO(User user);

}
