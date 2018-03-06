package web;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@ComponentScan
@RestController
@EnableAutoConfiguration
public class HomeController {
    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }
}
