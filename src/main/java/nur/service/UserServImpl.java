package nur.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import nur.dao.UserDao;
import nur.models.User;
import java.util.List;

@Service
public class UserServImpl implements UserServ{
    private final UserDao userDao;
    @Autowired
    public UserServImpl (UserDao userDao) {
        this.userDao=userDao;
    }
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public Object getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    @Transactional
    public void removeUser(long id) {
        userDao.removeUser(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
