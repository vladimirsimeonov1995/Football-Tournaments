package football.wep;

import football.wep.base.BaseController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController {

    @GetMapping("/")
    @PreAuthorize("isAnonymous()")
    public ModelAndView getIndex() {
        return super.view("home/index");
    }


    @GetMapping("/home")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView getHome() {
        return super.view("home/home");
    }

    @GetMapping("/login")
    public ModelAndView getLoginAfterReg() {
        return super.redirect("/home");
    }

}
