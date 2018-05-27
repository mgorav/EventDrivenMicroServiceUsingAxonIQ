package com.gm.axoniq.api;

import com.gm.axoniq.command.PolicyCanceledCommand;
import com.gm.axoniq.command.PolicyCreatedCommand;
import com.gm.axoniq.command.PolicyUpdatedCommand;
import com.gm.axoniq.cqrs.entity.PolicyEntity;
import com.gm.axoniq.domain.Policy;
import io.swagger.annotations.Api;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@Transactional
public class PolicyCommandService {
    private final CommandGateway commandGateway;
    private final EntityManager entityManager;
    private final EventSourcingRepository<Policy> policyEventSourcingRepository;


    public PolicyCommandService(CommandGateway commandGateway, EntityManager entityManager, EventSourcingRepository<Policy> policyEventSourcingRepository) {
        this.commandGateway = commandGateway;
        this.entityManager = entityManager;
        this.policyEventSourcingRepository = policyEventSourcingRepository;
    }

    public List<PolicyEntity>  getAllPolicyEntities() {
        return entityManager.createQuery("select o from PolicyEntity o").getResultList();
    }


    public PolicyEntity  getPolicyEntity(@PathVariable String policyId) {
        return entityManager.find(PolicyEntity.class,policyId);
    }

    public CompletableFuture<String> createPolicy() {
        return commandGateway.send(new PolicyCreatedCommand(randomId()));
    }


    public CompletableFuture<String> modifyPolicy(@PathVariable String policyId,@RequestBody PolicyUpdatedCommand command) {
        command.setId(policyId);

        return commandGateway.send(command);
    }

    public CompletableFuture<String> cancelPolicy(@PathVariable String policyId, @RequestBody PolicyCanceledCommand command) {

        command.setId(policyId);

        return commandGateway.send(command);
    }


    private String randomId() {
        return UUID.randomUUID().toString();
    }
}
