/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package org.openapitools.client.models

import java.time.OffsetDateTime

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Contextual

/**
 * An order for a pets from the pet store
 *
 * @param id 
 * @param petId 
 * @param quantity 
 * @param shipDate 
 * @param status Order Status
 * @param complete 
 */
@Serializable

data class Order (

    @SerialName(value = "id")
    val id: Long? = null,

    @SerialName(value = "petId")
    val petId: Long? = null,

    @SerialName(value = "quantity")
    val quantity: Int? = null,

    @Contextual @SerialName(value = "shipDate")
    val shipDate: OffsetDateTime? = null,

    /* Order Status */
    @SerialName(value = "status")
    val status: Order.Status? = null,

    @SerialName(value = "complete")
    val complete: Boolean? = false

) {

    /**
     * Order Status
     *
     * Values: placed,approved,delivered
     */
    @Serializable
    enum class Status(val value: String) {
        @SerialName(value = "placed") placed("placed"),
        @SerialName(value = "approved") approved("approved"),
        @SerialName(value = "delivered") delivered("delivered");
    }

}

