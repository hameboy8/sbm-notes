package tw.sian.notes.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    static final Logger logger = LoggerFactory.getLogger(HelloController.class.getName());

    @GetMapping("/hello")
    public String hello() {
        logger.info("running hello");
        return "hello moneynote";
    }

}