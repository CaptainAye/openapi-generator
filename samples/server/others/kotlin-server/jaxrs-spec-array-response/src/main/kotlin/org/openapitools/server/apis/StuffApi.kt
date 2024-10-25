package org.openapitools.server.apis;

import org.openapitools.server.models.Stuff

import jakarta.ws.rs.*
import jakarta.ws.rs.core.Response


import java.io.InputStream



@Path("/")
@jakarta.annotation.Generated(value = arrayOf("org.openapitools.codegen.languages.KotlinServerCodegen"), comments = "Generator version: 7.10.0-SNAPSHOT")
interface StuffApi {

    @GET
    @Path("/stuff")
    @Produces("application/json")
    fun findStuff(): List<Stuff>

    @GET
    @Path("/uniquestuff")
    @Produces("application/json")
    fun findUniqueStuff(): Set<Stuff>
}
