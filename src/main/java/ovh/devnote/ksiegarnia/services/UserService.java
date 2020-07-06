package ovh.devnote.ksiegarnia.services;

import ovh.devnote.ksiegarnia.entity.User;

public interface UserService {

    void saveUser(User user);

    User getUser(String userId);

}
