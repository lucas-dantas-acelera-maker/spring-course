package br.com.aceleramaker.springcourse.controller;

import br.com.aceleramaker.springcourse.model.entities.Product;
import br.com.aceleramaker.springcourse.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public Product addProduct(Product product) {
        productRepository.save(product);
        return product;
    }
}
