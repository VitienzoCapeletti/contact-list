package com.contactlist.mapper;

import com.contactlist.dto.UserDTO;
import com.contactlist.dto.UserRequestDTO;
import com.contactlist.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    User buildUserEntity(UserDTO user);

    User buildUserEntity(UserRequestDTO user);

    UserDTO buildUserDTO(User user);

}
