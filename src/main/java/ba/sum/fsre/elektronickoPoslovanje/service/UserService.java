package ba.sum.fsre.elektronickoPoslovanje.service;


import ba.sum.fsre.elektronickoPoslovanje.dto.UserDto;
import ba.sum.fsre.elektronickoPoslovanje.model.UserEntity;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    UserEntity findUserByEmail(String email);

    List<UserDto> findAllUsers();
}