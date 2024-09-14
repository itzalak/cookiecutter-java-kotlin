package io.template.app.api.controller.v1;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/v0")
@Tag(name = "java api Controller", description = "Some endpoint")
public class JavaApiController {

    @Operation(
            summary = "Returns 'successful' string",
            method = "GET"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Successfully returned"
    )
    @GetMapping("/endpoint/{id}")
    public ResponseEntity<String> getEndpoint(@PathVariable @NotNull Long id) {
        return ResponseEntity.ok("Successful");
    }

    private static ResponseEntity<String> emptyResponse() {
        return ResponseEntity.status(HttpStatus.OK)
                .body("");
    }
}
