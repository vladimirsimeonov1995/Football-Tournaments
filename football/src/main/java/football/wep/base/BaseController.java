package football.wep.base;

import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;


public abstract class BaseController {

    protected ModelAndView view(String view, ModelAndView modelAndView) {
        modelAndView.setViewName(view);
        return modelAndView;
    }

    protected ModelAndView view(String view){
        return this.view(view, new ModelAndView());
    }

    protected ModelAndView redirect(String url) {
        return this.view("redirect:" + url);
    }

    protected ModelAndView viewWithUsername(String view, Principal principal, ModelAndView modelAndView){
        modelAndView.addObject("username", principal.getName());
        return this.view(view, modelAndView);
    }

    protected ModelAndView viewWithUsername(String view, Principal principal) {
        return this.viewWithUsername(view, principal, new ModelAndView());
    }


}
