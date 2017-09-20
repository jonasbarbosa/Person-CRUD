package person;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AngularController {
    @RequestMapping(value = "/ng", method = RequestMethod.GET)
    public ModelAndView hello() {
        return new ModelAndView("angular.html");
    }
}