package ovh.devnote.ksiegarnia.dao;

import ovh.devnote.ksiegarnia.entity.User;

public interface UserDAO {

    void saveUser(User user);

    User getUser(String userId);

}
