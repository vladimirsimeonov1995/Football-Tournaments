package football.wep;

import football.service.UserService;
import football.service.models.UserServiceModel;
import football.wep.base.BaseController;
import football.wep.models.RegisterUserModel;
import football.wep.models.UserProfileViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/register")
    @PreAuthorize("isAnonymous()")
    public ModelAndView register() {
        return super.view("users/register");
    }

    @PostMapping("/register")
    @PreAuthorize("isAnonymous()")
    public ModelAndView registerConfirm(@ModelAttribute RegisterUserModel model) {
        if (!model.getPassword().equals(model.getConfirmPassword())) {
            return super.view("users/register");
        }
        this.userService.register(this.modelMapper.map(model, UserServiceModel.class));

        return super.redirect("/login");
    }

    @GetMapping("/login")
    @PreAuthorize("isAnonymous()")
    public ModelAndView login() {
        return super.view("users/login");
    }

    @GetMapping("/profile/{username}")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView profile(@PathVariable("username") String username, Principal principal, ModelAndView modelAndView) {
        UserServiceModel userServiceModel = this.userService.findUserByUsername(username);
        if(userServiceModel == null){
            throw new IllegalArgumentException("There is no user with that username!");
        }
        UserProfileViewModel model = this.modelMapper.map(userServiceModel, UserProfileViewModel.class);
        modelAndView.addObject("model", model);
        return super.viewWithUsername("users/profile", principal, modelAndView);
    }

//    @GetMapping("/profile/edit/{username}")
//    @PreAuthorize("isAuthenticated()")
//    public ModelAndView editProfile(@PathVariable("username") String username, Principal principal){
//
//        return null;
//    }



}
