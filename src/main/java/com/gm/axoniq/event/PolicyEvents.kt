package com.gm.axoniq.event


open class PolicyEvent(open var id: String)

class PolicyCreatedEvent(override var id: String) : PolicyEvent(id)

class PolicyUpdatedEvent(override var id: String, val claimAmount: Double) : PolicyEvent(id)

class PolicyCancelledEvent(override var id: String, val endDate: String) : PolicyEvent(id)

