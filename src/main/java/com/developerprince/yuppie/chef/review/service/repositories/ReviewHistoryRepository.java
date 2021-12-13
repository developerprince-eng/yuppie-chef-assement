package com.developerprince.yuppie.chef.review.service.repositories;

import com.developerprince.yuppie.chef.review.service.models.entity.ReviewHistory;
import com.developerprince.yuppie.chef.review.service.models.entity.ReviewHistoryFk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewHistoryRepository extends JpaRepository<ReviewHistory, ReviewHistoryFk> {

}
