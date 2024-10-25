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

package org.openapitools.client.models.room

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import org.openapitools.client.models.Category
import org.openapitools.client.models.Tag
import org.openapitools.client.models.*


@Entity(tableName = "Pet")
/**
* Room model for A pet for sale in the pet store
* @param name 
* @param photoUrls 
* @param id 
* @param category 
* @param tags 
* @param status pet status in the store
*/
data class PetRoomModel (
    @PrimaryKey(autoGenerate = true) var roomTableId: Int,
    var photoUrls: List<String>,
    
    var name: String,
    var id: Long? = null,
    var category: Category? = null,
    
    var status: Pet.Status? = null,
    ) {

    @Ignore
    var tags: List<Tag>? = null

    companion object { }

        fun toApiModel(): Pet = Pet(
        name = this.name,
        photoUrls = this.photoUrls,
        id = this.id,
        category = this.category,
        tags = this.tags,
        status = this.status,
        )
}
