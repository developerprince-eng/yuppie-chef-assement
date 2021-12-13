package com.developerprince.yuppie.chef.review.service.repositories;

import com.developerprince.yuppie.chef.review.service.models.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
