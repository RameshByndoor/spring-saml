package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by ramesh.bhana on 06/03/18.
 */

@SpringBootApplication(scanBasePackages = {"web"})
public class Run
{
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Run.class, args);
    }
}
