package org.openapitools.client.apis

import org.openapitools.client.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Call
import okhttp3.RequestBody
import com.fasterxml.jackson.annotation.JsonProperty

import java.io.File
import org.openapitools.client.models.ModelApiResponse
import org.openapitools.client.models.Pet

import okhttp3.MultipartBody

interface PetApi {
    /**
     * Add a new pet to the store
     * 
     * Responses:
     *  - 200: successful operation
     *  - 405: Invalid input
     *
     * @param pet Pet object that needs to be added to the store
     * @return [Call]<[Pet]>
     */
    @POST("pet")
    fun addPet(@Body pet: Pet): Call<Pet>

    /**
     * Deletes a pet
     * 
     * Responses:
     *  - 400: Invalid pet value
     *
     * @param petId Pet id to delete
     * @param apiKey  (optional)
     * @return [Call]<[Unit]>
     */
    @DELETE("pet/{petId}")
    fun deletePet(@Path("petId") petId: Long, @Header("api_key") apiKey: String? = null): Call<Unit>


    /**
    * enum for parameter status
    */
    enum class StatusFindPetsByStatus(val value: kotlin.String) {
        @JsonProperty(value = "available") AVAILABLE("available"),
        @JsonProperty(value = "pending") PENDING("pending"),
        @JsonProperty(value = "sold") SOLD("sold")
    }

    /**
     * Finds Pets by status
     * Multiple status values can be provided with comma separated strings
     * Responses:
     *  - 200: successful operation
     *  - 400: Invalid status value
     *
     * @param status Status values that need to be considered for filter
     * @return [Call]<[List<Pet>]>
     */
    @GET("pet/findByStatus")
    fun findPetsByStatus(@Query("status") status: CSVParams): Call<List<Pet>>

    /**
     * Finds Pets by tags
     * Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     * Responses:
     *  - 200: successful operation
     *  - 400: Invalid tag value
     *
     * @param tags Tags to filter by
     * @return [Call]<[List<Pet>]>
     */
    @Deprecated("This api was deprecated")
    @GET("pet/findByTags")
    fun findPetsByTags(@Query("tags") tags: CSVParams): Call<List<Pet>>

    /**
     * Find pet by ID
     * Returns a single pet
     * Responses:
     *  - 200: successful operation
     *  - 400: Invalid ID supplied
     *  - 404: Pet not found
     *
     * @param petId ID of pet to return
     * @return [Call]<[Pet]>
     */
    @GET("pet/{petId}")
    fun getPetById(@Path("petId") petId: Long): Call<Pet>

    /**
     * Update an existing pet
     * 
     * Responses:
     *  - 200: successful operation
     *  - 400: Invalid ID supplied
     *  - 404: Pet not found
     *  - 405: Validation exception
     *
     * @param pet Pet object that needs to be added to the store
     * @return [Call]<[Pet]>
     */
    @PUT("pet")
    fun updatePet(@Body pet: Pet): Call<Pet>

    /**
     * Updates a pet in the store with form data
     * 
     * Responses:
     *  - 405: Invalid input
     *
     * @param petId ID of pet that needs to be updated
     * @param name Updated name of the pet (optional)
     * @param status Updated status of the pet (optional)
     * @return [Call]<[Unit]>
     */
    @FormUrlEncoded
    @POST("pet/{petId}")
    fun updatePetWithForm(@Path("petId") petId: Long, @Field("name") name: String? = null, @Field("status") status: String? = null): Call<Unit>

    /**
     * uploads an image
     * 
     * Responses:
     *  - 200: successful operation
     *
     * @param petId ID of pet to update
     * @param additionalMetadata Additional data to pass to server (optional)
     * @param file file to upload (optional)
     * @return [Call]<[ModelApiResponse]>
     */
    @Multipart
    @POST("pet/{petId}/uploadImage")
    fun uploadFile(@Path("petId") petId: Long, @Part("additionalMetadata") additionalMetadata: String? = null, @Part file: MultipartBody.Part? = null): Call<ModelApiResponse>

}
