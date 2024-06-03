package com.springapp.iaBiletclone.service;

import com.springapp.iaBiletclone.entities.Order;
import com.springapp.iaBiletclone.entities.ShoppingCart;
import com.springapp.iaBiletclone.exceptions.ResourceNotFoundException;
import com.springapp.iaBiletclone.repositories.OrderRepository;
import com.springapp.iaBiletclone.repositories.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, ShoppingCartRepository shoppingCartRepository) {
        this.orderRepository = orderRepository;
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public Order placeOrder(Long userId, Order order) {
        ShoppingCart cart = shoppingCartRepository.findByUser_Id(userId).orElseThrow(() -> new ResourceNotFoundException("cart not found"));
        //   Order order = new Order();
//        order.setUser(user);
//
//        Set<OrderItem> orderItems = new HashSet<>();
//        for (TicketItem ticketItem : cart.getTicketItems()) {
//            OrderItem orderItem = new OrderItem();
//            orderItem.setOrder(order);
//            orderItem.setTicket(ticketItem.getTicket());
//            orderItem.setQuantity(ticketItem.getQuantity());
//            orderItems.add(orderItem);
//        }
//
//        order.setOrderItems(orderItems);
//        orderRepository.save(order);
//
//        // Clear the shopping cart
//        cart.getTicketItems().clear();
//        shoppingCartRepository.save(cart);
        return order;
    }
}
