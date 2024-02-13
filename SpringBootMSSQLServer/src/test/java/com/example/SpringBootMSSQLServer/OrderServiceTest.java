package com.example.SpringBootMSSQLServer;

import com.example.SpringBootMSSQLServer.Model.Order;
import com.example.SpringBootMSSQLServer.Repository.OrderRepository;
import com.example.SpringBootMSSQLServer.Service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {
    @Mock
    private OrderRepository orderRepository;
    @InjectMocks
    private OrderService orderService;

    @Test
    public void getAllOrders(){
          Order order1 = new Order("Jakarta","2024-02-07");
          Order order2 = new Order("Dubai","2024-02-13");
          when(orderRepository.findAll()).thenReturn(asList(order1,order2));

          List<Order> orderList = orderService.getAllOrders();

          assertThat(orderList).isNotNull();
          assertThat(orderList.size()).isEqualTo(2);
    }
}
