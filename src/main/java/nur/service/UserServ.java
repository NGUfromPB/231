package nur.service;
import nur.models.User;
import javax.validation.Valid;
import java.util.List;

public interface UserServ {

    List<User> getAllUsers ();
    Object getUserById(long id);
    void addUser(User user);
    void removeUser(long id);
    void updateUser(User user);
}