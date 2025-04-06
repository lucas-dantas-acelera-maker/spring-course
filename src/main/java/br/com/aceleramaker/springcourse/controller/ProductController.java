package br.com.aceleramaker.springcourse.controller;

import br.com.aceleramaker.springcourse.model.entities.Product;
import br.com.aceleramaker.springcourse.model.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public Product addProduct(@Valid Product product) {
        productRepository.save(product);
        return product;
    }

    @GetMapping
    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<Product> getProductById(@PathVariable Integer id) {
        return productRepository.findById(id);
    }

}
