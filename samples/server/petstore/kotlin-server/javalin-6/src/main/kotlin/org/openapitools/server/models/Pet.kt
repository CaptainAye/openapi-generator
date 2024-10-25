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
package org.openapitools.server.models

import org.openapitools.server.models.Category
import org.openapitools.server.models.Tag

/**
 * A pet for sale in the pet store
 * @param name 
 * @param photoUrls 
 * @param id 
 * @param category 
 * @param tags 
 * @param status pet status in the store
 */
data class Pet(
    val name: String,
    val photoUrls: List<String>,
    val id: Long? = null,
    val category: Category? = null,
    val tags: List<Tag>? = null,
    /* pet status in the store */
    val status: Pet.Status? = null
) 
{
    /**
    * pet status in the store
    * Values: available,pending,sold
    */
    enum class Status(val value: String){
        available("available"),
        pending("pending"),
        sold("sold");
    }
}

