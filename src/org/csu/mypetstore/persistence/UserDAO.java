package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.User;

public interface UserDAO {
    public User findUserByUsername(String username);
    public int updateUserByUsername(User user);
    public User findUserByUsernameAndPassword(User user);
    public int insertUserByUsernameAndPassword(User user);
}
