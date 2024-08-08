package io.itzalak.app.api.controller.v1

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1")
@ApiResponse(responseCode = "500", description = "Internal server error, this should not happen")
@Tag(name = "Api Controller", description = "Some endpoint")
class ApiController {

    @Operation(
        method = "GET",
        summary = "Returns 'successful' string",
    )
    @ApiResponse(
        responseCode = "200",
        description = "Successful returned"
    )
    @GetMapping("endpoint/{id}")
    fun getEndpoint(@PathVariable id: Long): String {
        return "Successful"
    }
}
