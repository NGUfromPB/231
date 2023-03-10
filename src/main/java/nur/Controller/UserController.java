package nur.Controller;
import nur.models.User;
import nur.service.UserServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller

public class UserController {
    private final UserServ userServ;

    @Autowired()
    public UserController(UserServ userService) {
        this.userServ = userService;
    }
    @GetMapping("/")
    public String users(Model model) {
        model.addAttribute("users", userServ.getAllUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public String getUser (@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userServ.getUserById(id));
        return "user";
    }

    @GetMapping("/new")
    public String addUser(@ModelAttribute("user")  User user) {

        return "new";
    }

    @PostMapping("/new")
    public String add(@ModelAttribute("user") User user) {
        userServ.addUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        userServ.removeUser(id);
        return "redirect:/";
    }

    @PatchMapping("edit/{id}")
    public String updateUser(@PathVariable("id") long id, Model model) {
        model.addAttribute(userServ.getUserById(id));
        return "edit";
    }

    @PatchMapping("/edit")
    public String update(@ModelAttribute("user") User user) {
        userServ.updateUser(user);
        return "redirect:/";
    }



}

