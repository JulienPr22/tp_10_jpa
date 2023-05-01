package fr.istic.taa.jaxrs.mappers;

import fr.istic.taa.jaxrs.domain.User;
import fr.istic.taa.jaxrs.dto.UserDTO;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
    public static UserDTO userToUserDTO(User u) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(u.getId());
        userDTO.setFirstname(u.getFirstname());
        userDTO.setLastname(u.getLastname());
        userDTO.setRegistrationDate(u.getRegistrationDate());
        return userDTO;
    }

    public static List<UserDTO> userListToUserDtoList(List<User> userList) {
        return userList.stream().map(UserMapper::userToUserDTO).collect(Collectors.toList());
    }
}

