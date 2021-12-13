package com.developerprince.yuppie.chef.review.service.services;

import com.developerprince.yuppie.chef.review.service.models.ProductDto;
import com.developerprince.yuppie.chef.review.service.models.entity.Product;
import com.developerprince.yuppie.chef.review.service.models.entity.Store;
import com.developerprince.yuppie.chef.review.service.repositories.CategoryRepository;
import com.developerprince.yuppie.chef.review.service.repositories.ProductRepository;
import com.developerprince.yuppie.chef.review.service.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Optional;


@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    StoreRepository storeRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public ResponseEntity<Object> retrieveProductById(Long id){
        return new ResponseEntity<>( productRepository.findById(id), HttpStatus.OK);
    }

    public ResponseEntity<Object> saveProduct(ProductDto productDto){
        Iterator<String> iterable =   productDto.getCategories().iterator();
        Product.builder();
        return new ResponseEntity<>( productRepository.save( Product.builder()
                .color( productDto.getColor() )
                .dimensions( productDto.getDimensions() )
                .name( productDto.getName() )
                .modelType( productDto.getModelType() )
                .weight( productDto.getWeight() )
                .categories(categoryRepository.findAllByName( iterable ))
                .build() ), HttpStatus.CREATED);
    }

    public ResponseEntity<Object> retrieveAllProductByStoreId(Long storeId){
        Optional<Store> store = storeRepository.findById( storeId );
        if(store.isPresent()){
            return new ResponseEntity<>( productRepository.findAllByStore(store.get()), HttpStatus.OK );
        }
        return new ResponseEntity<>( "Can not find Store", HttpStatus.EXPECTATION_FAILED );
    }
}