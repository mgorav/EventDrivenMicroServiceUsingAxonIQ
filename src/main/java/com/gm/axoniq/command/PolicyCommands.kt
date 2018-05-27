package com.gm.axoniq.command

import com.fasterxml.jackson.annotation.JsonIgnore
import org.axonframework.commandhandling.TargetAggregateIdentifier


open class PolicyCommand(@TargetAggregateIdentifier @JsonIgnore open var id: String? = null) {

    constructor() : this(null)
}


class PolicyCreatedCommand(@TargetAggregateIdentifier @JsonIgnore override var id: String? = null) : PolicyCommand(id) {
    constructor() : this(null)
}

class PolicyUpdatedCommand(@TargetAggregateIdentifier @JsonIgnore override var id: String? = null, val claimAmount: Double? = null) : PolicyCommand(id) {
    constructor() : this(null, null)
}


class PolicyCanceledCommand(@TargetAggregateIdentifier @JsonIgnore override var id: String? = null, val endDate: String? = null) : PolicyCommand(id) {
    constructor() : this(null, null)
}	