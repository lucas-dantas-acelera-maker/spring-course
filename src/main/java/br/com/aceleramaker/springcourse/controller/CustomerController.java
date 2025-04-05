package br.com.aceleramaker.springcourse.controller;

import br.com.aceleramaker.springcourse.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @GetMapping("/any")
    public Customer getCustomer() {
        return new Customer(28, "Pedro", "123.456.789-00");
    }
}
