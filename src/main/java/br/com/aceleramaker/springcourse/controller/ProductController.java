package br.com.aceleramaker.springcourse.controller;

import br.com.aceleramaker.springcourse.model.entities.Product;
import br.com.aceleramaker.springcourse.model.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @PutMapping
    public Product updateProduct(@RequestBody @Valid Product product) {
        if (product.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please inform the product ID");
        }

        if (!productRepository.existsById(product.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found by ID");
        }
        
        return productRepository.save(product);
    }

}
