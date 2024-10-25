package org.openapitools.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import java.time.OffsetDateTime
import java.io.Serializable
import jakarta.validation.constraints.DecimalMax
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size
import jakarta.validation.Valid

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

    @get:JsonProperty("id") val id: Long? = null,

    @get:JsonProperty("petId") val petId: Long? = null,

    @get:JsonProperty("quantity") val quantity: Int? = null,

    @get:JsonProperty("shipDate") val shipDate: OffsetDateTime? = null,

    @get:JsonProperty("status") val status: Order.Status? = null,

    @get:JsonProperty("complete") val complete: Boolean? = false
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

