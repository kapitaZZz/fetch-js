package boot.service;

import boot.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    void updateUser(User user);

    void removeUserById(long id);

    User getUserById(long id);

    List<User> getAllUsers();

    User getUserByName(String username);

    User getUserByPhone(String phoneNumber);

    boolean existsUserById(long id);
}