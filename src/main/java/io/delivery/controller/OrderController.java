package io.delivery.controller;

import io.delivery.entity.BasketUnit;
import io.delivery.entity.Order;
import io.delivery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/basket/get/id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public BasketUnit getBasketUnitById(@PathVariable(value = "id") String id) {
        return orderService.findBasketUnitById(Long.parseLong(id));
    }

    @RequestMapping(value = "/basket/delete/id/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public BasketUnit deleteBasketUnitById(@PathVariable(value = "id") String id) {
        return orderService.deleteBasketUnitById(Long.parseLong(id));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Order addOrder(@RequestBody Order order) {
        orderService.create(order);
        return order;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Order updateOrder(@RequestBody Order order) {
        orderService.updateOrder(order);
        return order;
    }

    @RequestMapping(value = "/get/uid/{uid}", method = RequestMethod.GET)
    @ResponseBody
    public List<Order> findByUserId(@PathVariable(value = "uid") String uid) {
        return orderService.findByUserId(Long.parseLong(uid));
    }

    @RequestMapping(value = "/get/id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Order getOrderById(@PathVariable(value = "id") String id) {
        return orderService.findById(Long.parseLong(id));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Order deleteOrder(@PathVariable(value = "id") String id) {
        return orderService.deleteOrder(Long.parseLong(id));
    }

    @RequestMapping(value = "/get/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Order> getOrderList() {
        return orderService.getOrderList();
    }
}
