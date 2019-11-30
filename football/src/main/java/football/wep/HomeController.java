package football.wep;

import football.wep.base.BaseController;
import org.dom4j.rule.Mode;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class HomeController extends BaseController {

    @GetMapping("/")
    @PreAuthorize("isAnonymous()")
    public ModelAndView getIndex() {
        return super.view("home/index");
    }


    @GetMapping("/home")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView getHome(Principal principal, ModelAndView modelAndView) {
        return super.viewWithUsername("home/home",principal, modelAndView);
    }

    @GetMapping("/login")
    public ModelAndView getLoginAfterReg() {
        return super.redirect("/home");
    }

}
