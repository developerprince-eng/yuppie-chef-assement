package com.developerprince.yuppie.chef.review.service.repositories;

import com.developerprince.yuppie.chef.review.service.models.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
