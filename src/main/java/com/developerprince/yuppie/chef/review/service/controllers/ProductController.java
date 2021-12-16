package com.developerprince.yuppie.chef.review.service.controllers;

        import com.developerprince.yuppie.chef.review.service.models.ProductDto;
        import com.developerprince.yuppie.chef.review.service.services.ProductService;
        import lombok.extern.slf4j.Slf4j;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.data.domain.PageRequest;
        import org.springframework.data.domain.Pageable;
        import org.springframework.data.domain.Sort;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")//NOSONAR
    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable("id") Long id){
        return productService.retrieveProductById(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")//NOSONAR
    @PostMapping("/")
    public  ResponseEntity<Object> saveProduct(@RequestBody ProductDto productDto){
        return productService.saveProduct( productDto );
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")//NOSONAR
    @GetMapping("/store/{id}")
    public ResponseEntity<Object> getAllProducts(@PathVariable("id")Long storeId, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10", required = false) int size){
        Pageable paging = PageRequest.of( page, size, Sort.by( "id" ).descending() );
        return productService.retrieveAllProductByStoreId(storeId, paging);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")//NOSONAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") Long id){
        return productService.deleteProductByProductId( id );
    }
}
