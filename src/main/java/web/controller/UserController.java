package web.controller;

import web.model.Role;
import web.model.User;
import web.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView getUserPage(Authentication authentication, ModelAndView model) {
        List<User> user = new ArrayList<>();
        user.add(userService.findUserByName(authentication.getName()));
        model.addObject("user", user);
        model.setViewName("user-page");
        return model;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView allUsers(ModelAndView modelAndView) {
        List<User> allUser = userService.getAllUsers();
        modelAndView.setViewName("admin-page");
        modelAndView.addObject("listUser", allUser);
        return modelAndView;
    }

    @RequestMapping(value = "/admin/new", method = RequestMethod.GET)
    public String addUser(@ModelAttribute("user") User user, HttpServletRequest request) {
        Set<Role> roles = user.getRoles();
        String RoleUser = request.getParameter("role1");
        String RoleAdmin = request.getParameter("role2");
        if (RoleUser != null) {
            roles.add(Role.USER);
        }
        if (RoleAdmin != null) {
            roles.add(Role.ADMIN);
        }
        user.setRoles(roles);
        userService.addUser(user);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/edit", method = RequestMethod.GET)
    public ModelAndView editPage(@RequestParam("id") Long id, ModelAndView modelAndView) {
        User user = userService.findUserById(id);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("edit-page");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/update", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("user") User user, HttpServletRequest request) {
        Set<Role> roles = user.getRoles();
        String RoleUser = request.getParameter("user");
        String RoleAdmin = request.getParameter("admin");
        if (RoleUser != null) {
            roles.add(Role.USER);
        }
        if (RoleAdmin != null) {
            roles.add(Role.ADMIN);
        }
        user.setRoles(roles);
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/delete", method = RequestMethod.GET)
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(userService.findUserById(id));
        return "redirect:/admin";
    }
}
