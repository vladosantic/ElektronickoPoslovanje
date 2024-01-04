package ba.sum.fsre.elektronickoPoslovanje.service;


import ba.sum.fsre.elektronickoPoslovanje.dto.UserDto;
import ba.sum.fsre.elektronickoPoslovanje.model.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}