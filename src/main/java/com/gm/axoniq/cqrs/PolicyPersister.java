package com.gm.axoniq.cqrs;

import com.gm.axoniq.cqrs.entity.PolicyEntity;
import com.gm.axoniq.domain.Policy;
import com.gm.axoniq.event.PolicyEvent;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PolicyPersister {

    private final PolicyQueryRepository policyRepository;

    private final EventSourcingRepository<Policy> policyEventSourcingRepository;

    public PolicyPersister(PolicyQueryRepository policyRepository, EventSourcingRepository<Policy> policyEventSourcingRepository) {
        this.policyRepository = policyRepository;
        this.policyEventSourcingRepository = policyEventSourcingRepository;
    }

    @EventSourcingHandler
    public void on(PolicyEvent event) {
        Policy policy = loadPolicy(event);
        savePolicy(toPolicyEntity(policy));
    }

    private Policy loadPolicy(PolicyEvent event) {
        return policyEventSourcingRepository.load(event.getId()).getWrappedAggregate().getAggregateRoot();
    }

    private PolicyEntity toPolicyEntity(Policy policy) {

        PolicyEntity policyEntity = loadOrCreateQueryPolicy(policy.getId());

        policyEntity.setClaimAmount(policy.getClaimAmount());
        policyEntity.setState(policy.getState());
        policyEntity.setPolicyStartDate(policy.getPolicyStartDate());
        policyEntity.setPolicyEndDate(policy.getPolicyEndDate());

        return policyEntity;
    }

    private PolicyEntity savePolicy(PolicyEntity policyEntity) {
        return policyRepository.save(policyEntity);
    }

    private PolicyEntity loadOrCreateQueryPolicy(String id) {

        final Optional<PolicyEntity> byId = policyRepository.findById(id);

        return byId.isPresent()  ? byId.get() : new PolicyEntity(id);

    }
}
