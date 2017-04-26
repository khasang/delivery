package io.delivery.controller;

import io.delivery.entity.User;
import io.delivery.model.BackupCreator;
import io.delivery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private BackupCreator backupCreator;

    final private UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users/get/all", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUserList() {
        return userService.getUserList();
    }

    @RequestMapping(value = "/users/get/id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUserById(@PathVariable(value = "id") String InputID) {
        return userService.findById(Long.parseLong(InputID));
    }

    @RequestMapping(value = "/users/get/login/{login}", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUserByLogin(@PathVariable(value = "login") String InputLogin) {
        return userService.findByLogin(InputLogin);
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public User addUser(@RequestBody User user) {
        user.EncodePassword();
        return userService.create(user);
    }

    @RequestMapping(value = "/users/update", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/users/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public User deleteUser(@PathVariable(value = "id") String InputID) {
        return userService.deleteUser(Long.parseLong(InputID));
    }

    @RequestMapping(value = "/users")
    public String getUsersInfo(){
        return "/admin/users";
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.GET)
    public String getUserForm(Model model){
        return "/admin/user";
    }

    @RequestMapping(value = "/backup")
    public String backup(Model model) {
        model.addAttribute("status", backupCreator.createBackup());
        return "create";
    }
}
