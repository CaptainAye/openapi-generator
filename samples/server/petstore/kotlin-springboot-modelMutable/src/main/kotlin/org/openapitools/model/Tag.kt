package org.openapitools.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
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
 * A tag for a pet
 * @param id 
 * @param name 
 */
data class Tag(

    @Schema(example = "null", description = "")
    @get:JsonProperty("id") var id: Long? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("name") var name: String? = null
    ) : Serializable{

    companion object {
        private const val serialVersionUID: kotlin.Long = 1
    }
}

