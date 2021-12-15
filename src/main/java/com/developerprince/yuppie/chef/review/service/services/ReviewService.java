package com.developerprince.yuppie.chef.review.service.services;

import com.developerprince.yuppie.chef.review.service.models.ReviewDto;
import com.developerprince.yuppie.chef.review.service.models.entity.*;
import com.developerprince.yuppie.chef.review.service.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ReviewService extends  BaseResources{

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    StoreRepository storeRepository;

    public ResponseEntity<Object> addNewReviewAsACustomer(ReviewDto reviewDto){
        Optional<Customer> customer = customerRepository.findCustomerByFirstName(reviewDto.getCustomer().getFirstName());
        Optional<Store> store = storeRepository.findById(reviewDto.getStoreId());
        if(customer.isPresent() && store.isPresent()){
            reviewRepository.save( Review.builder()
                    .description( reviewDto.getDescription() )
                    .rating( reviewDto.getRating() )
                    .store( store.get())
                    .customer( customer.get() )
                    .build() );
        }
        Set<Address> addresses = new HashSet<>(  );
        reviewDto.getCustomer().getAddresses().forEach( addressDto -> {
            Address address =  addressRepository.saveAndFlush( Address.builder()
                    .street( addressDto.getStreet() )
                    .addressUnit( addressDto.getAddressUnit() )
                    .zipCode( addressDto.getZipCode() )
                    .build() );
            addresses.add( address );
        } );

        Set<Contact> contacts = new HashSet<>(  );
        reviewDto.getCustomer().getContacts().stream().forEach( contactDto -> {
            Contact contact = contactRepository.saveAndFlush( Contact.builder()
                    .emailAddress( contactDto.getEmailAddress() )
                    .mobile( contactDto.getMobile() )
                    .telephone( contactDto.getTelephone() )
                    .build());
            contacts.add( contact );
        } );


        Set<Address> addressSet = new HashSet<>();
        Set<Contact> contactSet = new HashSet<>();

        iteratorToIterable( addresses.iterator() ).forEach(addresses::add);
        iteratorToIterable( contacts.iterator() ).forEach(contacts::add);
        return new ResponseEntity<>( customerRepository.save( Customer.builder()
                .firstName( reviewDto.getCustomer().getFirstName() )
                .lastName( reviewDto.getCustomer().getLastName() )
                .dob( reviewDto.getCustomer().getDob() )
                .addresses(addressSet)
                .contacts(contactSet )
                .build()), HttpStatus.CREATED );
    }

    public ResponseEntity<Object> editReview(ReviewDto reviewDto){
        Optional<Review> review = reviewRepository.findById( reviewDto.getId());
        if(review.isPresent()){
            return new ResponseEntity<>(reviewRepository.saveAndFlush( Review.builder()
                    .customer(Customer.builder()
                            .lastName(reviewDto.getCustomer().getLastName())
                            .firstName(reviewDto.getCustomer().getFirstName())
                            .build())
                    .rating( reviewDto.getRating() )
                    .description( reviewDto.getDescription() )
                    .build()), HttpStatus.OK) ;
        }
        return new ResponseEntity<>( "No Such Review", HttpStatus.NOT_FOUND );
    }

    public ResponseEntity<Object> retrieveReiewsByStore(Long storeId){
        Optional<Store> store = storeRepository.findById(storeId);
        if(store.isPresent()){
            return new ResponseEntity<>(reviewRepository.findByStore( store.get()), HttpStatus.OK );
        }
        return new ResponseEntity<>( "No Such store", HttpStatus.NOT_FOUND );
    }

}
