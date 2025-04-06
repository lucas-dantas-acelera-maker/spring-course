package br.com.aceleramaker.springcourse.controller;

import br.com.aceleramaker.springcourse.model.Customer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @GetMapping("/any")
    public Customer getCustomer() {
        return new Customer(28, "Pedro", "123.456.789-00");
    }

    @GetMapping
    public Customer getCustomerById02(
            @RequestParam(name = "id", defaultValue = "1")
            int id) {
        return new Customer(id, "João Augusto", "111.222.333-44");
    }
}
