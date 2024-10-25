package org.openapitools.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import java.time.OffsetDateTime
import java.io.Serializable
import javax.validation.constraints.DecimalMax
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Email
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size
import javax.validation.Valid
import io.swagger.v3.oas.annotations.media.Schema

/**
 * An order for a pets from the pet store
 * @param id 
 * @param petId 
 * @param quantity 
 * @param shipDate 
 * @param status Order Status
 * @param complete 
 */
data class Order(

    @Schema(example = "null", description = "")
    @get:JsonProperty("id") var id: Long? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("petId") var petId: Long? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("quantity") var quantity: Int? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("shipDate") var shipDate: OffsetDateTime? = null,

    @Schema(example = "null", description = "Order Status")
    @get:JsonProperty("status") var status: Order.Status? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("complete") var complete: Boolean? = false
    ) : Serializable{

    /**
    * Order Status
    * Values: placed,approved,delivered
    */
    enum class Status(@get:JsonValue val value: String) {

        placed("placed"),
        approved("approved"),
        delivered("delivered");

        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: String): Status {
                return values().first{it -> it.value == value}
            }
        }
    }

    companion object {
        private const val serialVersionUID: kotlin.Long = 1
    }
}

