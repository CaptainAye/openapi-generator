/**
* OpenAPI Petstore
* This is a sample server Petstore server. For this sample, you can use the api key `special-key` to test the authorization filters.
*
* The version of the OpenAPI document: 1.0.0
* 
*
* NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
* https://openapi-generator.tech
* Do not edit the class manually.
*/
package org.openapitools.server.api.model

import java.time.OffsetDateTime

        
import com.google.gson.annotations.SerializedName
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
/**
 * An order for a pets from the pet store
 * @param id 
 * @param petId 
 * @param quantity 
 * @param shipDate 
 * @param status Order Status
 * @param complete 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class Order (
    val id: Long? = null,
    val petId: Long? = null,
    val quantity: Int? = null,
    val shipDate: OffsetDateTime? = null,
    /* Order Status */
    val status: Order.Status? = null,
    val complete: Boolean? = false
) {

    /**
    * Order Status
    * Values: placed,approved,delivered
    */
    enum class Status(val value: String){
    
        placed("placed"),
    
        approved("approved"),
    
        delivered("delivered");
    
    }

}

