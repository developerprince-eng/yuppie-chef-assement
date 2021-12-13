package com.developerprince.yuppie.chef.review.service.controllers;

import com.developerprince.yuppie.chef.review.service.models.ReviewDto;
import com.developerprince.yuppie.chef.review.service.services.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping("/customer")
    public ResponseEntity<Object> addReviewAsACustomer(@RequestBody ReviewDto reviewDto){
        return reviewService.addNewReviewAsACustomer( reviewDto.getCustomer(), reviewDto );
    }

    @PutMapping("/edit")
    public ResponseEntity<Object> editReview(@RequestBody ReviewDto reviewDto){
        return reviewService.editReview(reviewDto);
    }

    @GetMapping("/store/{storeId}")
    public ResponseEntity<Object> getReviews(@PathVariable("storeId")Long storeId){
        return reviewService.retrieveReiewsByStore(storeId);
    }

}
