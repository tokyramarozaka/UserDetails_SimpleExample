package school.hei.helloworldapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloWorldController {
    @GetMapping({"/hello/{name}","/hello/"})
    public String helloWorld(@PathVariable(required = false) String name){
        log.info(SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString());

        if (name == null){
            return "Hello world";
        }else{
            return "Hello "+name;
        }
    }

}