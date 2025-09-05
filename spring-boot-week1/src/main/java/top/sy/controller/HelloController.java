package top.sy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${my.mood.today}")
    private String today;

    @Value("${my.mood.content}")
    private String content;

    @Value("${my.mood.author}")
    private String author;

    @GetMapping("getMood")
    public String getMoodToday() {
        return "今天是:"+today+"心情是:"+content+"作者是:"+author;
    }
}
