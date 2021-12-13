package com.developerprince.yuppie.chef.review.service.repositories;

import com.developerprince.yuppie.chef.review.service.models.entity.StoreUser;
import com.developerprince.yuppie.chef.review.service.models.entity.StoreUserFk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreUserRepository extends JpaRepository<StoreUser, StoreUserFk> {
}
