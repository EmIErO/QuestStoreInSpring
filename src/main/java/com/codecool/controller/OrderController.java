package com.codecool.controller;


import com.codecool.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("/order/{numericId:[\\d]+}")
    public String proccess() {
        orderService.proccessOrder(1);
        return "redirect:/artifacts";
    }
}
