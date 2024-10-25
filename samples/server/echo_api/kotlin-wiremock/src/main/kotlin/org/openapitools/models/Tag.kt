@file:Suppress(
    "RemoveRedundantQualifierName",
    "unused",
)

package org.openapitools.models

import com.fasterxml.jackson.annotation.JsonProperty

data class Tag(
    @field:JsonProperty("id")
    val id: Long? = null,

    @field:JsonProperty("name")
    val name: String? = null,

)
