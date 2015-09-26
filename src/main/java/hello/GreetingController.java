package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetingController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/login")
    public @ResponseBody Greeting login(
            @RequestParam(value="usuario", required=true, defaultValue="World") String usuario,
            @RequestParam(value="password", required=true, defaultValue="World") String password
    ) {
        return new Greeting(counter.incrementAndGet(),usuario, password);
    }
}