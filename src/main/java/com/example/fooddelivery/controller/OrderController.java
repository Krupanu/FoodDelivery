package com.example.fooddelivery.controller;

import com.example.fooddelivery.dto.OrderDto;
import com.example.fooddelivery.model.*;
import com.example.fooddelivery.service.FoodService;
import com.example.fooddelivery.service.OrderService;
import com.example.fooddelivery.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {
    private final OrderService orderService;
    private final UserService userService;
    private final FoodService foodService;

    public OrderController(OrderService orderService, UserService userService, FoodService foodService) {
        this.orderService = orderService;
        this.userService = userService;
        this.foodService = foodService;
    }

    @GetMapping("/order/{orderId}/applications")
    public String showOrder(Model model, @PathVariable Long orderId) {
        Order order = orderService.getOrderInfo(orderId);
        List<OrderDto> orderStatus = new ArrayList<>() {{
            add(new OrderDto(OrderStatus.APPROVED, "Одобрено"));
            add(new OrderDto(OrderStatus.DECLINED, "Отклонено"));
        }};

        model.addAttribute("order", order);
        model.addAttribute("approvedOrderStatus", OrderStatus.APPROVED);
        model.addAttribute("approvedApplicationStatus", ApplicationStatus.APPROVED);
        model.addAttribute("declinedApplicationStatus", ApplicationStatus.DECLINED);
        model.addAttribute("status", orderStatus);
        return "applications";
    }

    @GetMapping("/order/{orderId}")
    public String showOrder(Model model, @PathVariable Long orderId, Long applicationId, Long foodId) {
        Order order = orderService.getOrderInfo(orderId);
        List<OrderDto> orderStatus = new ArrayList<>() {{
            add(new OrderDto(OrderStatus.APPROVED, "Одобрено"));
            add(new OrderDto(OrderStatus.DECLINED, "Отклонено"));
        }};
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.findByEmail(authentication.getName());
        Food food = foodService.getFoodInfo(orderId);

        model.addAttribute("currentUser", currentUser);
        model.addAttribute("order", order);
        model.addAttribute("status", orderStatus);
        model.addAttribute("food", food);
        return "order";
    }

    @GetMapping("/orders")
    public String ShowAllOrders(Model model) {
        List<Order> orders = orderService.orders();
        List<OrderDto> orderStatus = new ArrayList<>() {{
            add(new OrderDto(OrderStatus.APPROVED, "Одобрено"));
            add(new OrderDto(OrderStatus.DECLINED, "Отклонено"));
        }};


        model.addAttribute("status", orderStatus);
        model.addAttribute("orders", orders);

        return "all_orders";
    }

    @GetMapping("/create-order")
    public String CreateOrder(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.findByEmail(authentication.getName());
        List<Food> foods = foodService.foods();
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("foods", foods);

        
        return "new_order";
    }
}
