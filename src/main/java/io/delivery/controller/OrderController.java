package io.delivery.controller;

import io.delivery.entity.Order;
import io.delivery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Order addOrder(@RequestBody Order order) {
        orderService.create(order);
        return order;
    }

    @RequestMapping(value = "/get/id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Order getOrderById(@PathVariable(value = "id") String id) {
        return orderService.findById(Long.parseLong(id));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Order deleteOrder(@PathVariable(value = "id") String id) {
        return orderService.delete(Long.parseLong(id));
    }

    @RequestMapping(value = "/web")
    public String getOrderInfo() {
        return "order";
    }
}
