package com.example.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${user.url}")
    private String url;

    @GetMapping(value = "/customer")
    public Customer getCustomer() {
        return Customer.builder().id(1L).name("Raja").build();
    }

    @GetMapping(value = "/customers")
    public List<Customer> getCustomers() {
        return Collections.singletonList(Customer.builder().id(1L).name("Raja").build());
    }

    @GetMapping(value = "/customer/user")
    public User getUserInfo() {
        return restTemplate.getForObject(this.url, User.class);
    }
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class Customer {
    private String name;
    private Long id;
}


@Data
@Builder
class User {
    private String name;
    private Long id;
}