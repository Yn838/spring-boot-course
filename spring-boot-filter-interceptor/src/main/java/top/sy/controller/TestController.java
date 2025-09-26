package top.sy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class TestController {
    @GetMapping("/test")
    public String get() {
      log.info("进入Controller");
        return "hello world";
    }
}
