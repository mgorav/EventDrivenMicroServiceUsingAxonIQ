package com.gm.axoniq.cqrs;

import com.gm.axoniq.cqrs.entity.PolicyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Standard JPA repository for accessing the Query Policy entity
 */

public interface PolicyQueryRepository extends JpaRepository<PolicyEntity, String> {
}
