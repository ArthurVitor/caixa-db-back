package com.example.patocheckout.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.patocheckout.entities.Product;
import com.example.patocheckout.service.impl.ProductServiceImpl;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private final ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productServiceImpl) {
        this.productService = productServiceImpl;
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productService.findAllProducts();

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
        Optional<Product> product = productService.findProductById(id);

        if (product.isPresent() == false) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        Product productFound = product.get();
        return new ResponseEntity<>(productFound, HttpStatus.OK);
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<Product> getProductByBarcode(@RequestParam(name = "barcode") String barcode) {
        List<Product> productByBarcode = productService.findProductByBarcode(barcode);

        if (productByBarcode.size() == 0) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        Product productFound = productByBarcode.get(0);
        return new ResponseEntity<>(productFound, HttpStatus.OK);
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Product> Post(@RequestBody Product product) {
        productService.saveProduct(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
    public @ResponseBody ResponseEntity<String> Put(@RequestBody Product product, @PathVariable Long id) {
        Optional<Product> currentProduct = productService.findProductById(id);

        if (currentProduct.isPresent() == false) return new ResponseEntity<>("Product not found!", HttpStatus.NOT_FOUND);

        currentProduct.get().setName(product.getName());
        currentProduct.get().setPrice(product.getPrice());
        currentProduct.get().setBarcode(product.getBarcode());

        Product productToSave = currentProduct.get();
        productService.saveProduct(productToSave);

        return new ResponseEntity<>("Product edited!", HttpStatus.CREATED);

    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity<String> Delete(@PathVariable Long id) {
        Optional<Product> currentProduct = productService.findProductById(id);

        if (currentProduct.isPresent() == false) return new ResponseEntity<>("Product not found!", HttpStatus.NOT_FOUND);

        Product product = currentProduct.get();
        productService.deleteProduct(product);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
