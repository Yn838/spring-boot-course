package top.sy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.sy.enums.DrinkType;

@RestController
@RequestMapping("/drink")
public class DrinkTYPE {
    @GetMapping("/{status}")
    public String checkDrinkStatus(@PathVariable DrinkType status) {
        return "您点的是：" + status.getLabel()+ "，价格是：" + status.getPrice();
    }
}
