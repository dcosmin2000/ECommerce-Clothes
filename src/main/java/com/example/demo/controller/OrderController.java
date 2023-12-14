package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.model.OrderDetails;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService; // Import ProductService
import org.springframework.beans.factory.annotation.Autowired; // Import Autowired
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order")
public class OrderController {
 private final Order order = new Order();

 @Autowired
 private ProductService productService;

 @GetMapping
 public String getOrder(Model model) {
     model.addAttribute("order", order);
     return "order";
 }

 @PostMapping("/add/{productId}")
 public String addToOrder(@PathVariable Long productId) {
     Product productToAdd = productService.getProductById(productId);
     order.addProduct(productToAdd);
     return "redirect:/order";
 }

 @GetMapping("/orderdetails")
 public String getOrderDetails(Model model) {
     model.addAttribute("order", order);
     model.addAttribute("orderDetails", new OrderDetails());
     return "orderdetails";
 }

 @PostMapping("/orderdetails")
 public String processOrderDetails(@ModelAttribute("orderDetails") OrderDetails orderDetails) {
	 
     order.clear();
     return "redirect:/order/orderplaced";
 }

 @GetMapping("/orderplaced")
 public String orderPlaced(Model model) {
     return "orderplaced";
 }
}
