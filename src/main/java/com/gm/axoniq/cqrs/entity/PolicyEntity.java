package com.gm.axoniq.cqrs.entity;


import com.gm.axoniq.domain.PolicyState;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * An example of the query side of the Policy Entity
 * <p>
 * In this case it contains the same attributes, but the idea is to create a entity
 * for every query requirement
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor()
@EqualsAndHashCode(of = "id")
@ToString
public class PolicyEntity implements Serializable {

    private static final long serialVersionUID = -6043182657756819128L;
    @Id
    private String id;

    private String policyStartDate;

    private String policyEndDate;

    private PolicyState state;

    private Double claimAmount;

    public PolicyEntity(String id) {
        this.id = id;
    }

}
