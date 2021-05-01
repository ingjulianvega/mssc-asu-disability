package ingjulianvega.ximic.msscasudisability.web.controller;

import ingjulianvega.ximic.msscasudisability.web.model.ApiError;
import ingjulianvega.ximic.msscasudisability.web.model.Disability;
import ingjulianvega.ximic.msscasudisability.web.model.DisabilityDto;
import ingjulianvega.ximic.msscasudisability.web.model.DisabilityList;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public interface DisabilityI {

    @Operation(summary = "Endpoint to get the list of disabilities", description = "Returns a list of disability", tags = {"disability"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The operation was successful.", content = @Content(schema = @Schema(implementation = DisabilityList.class))),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "/",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<DisabilityList> get();

    @Operation(summary = "Endpoint to get the information of a disability given the id", description = "Returns a disability", tags = {"disability"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The operation was successful.", content = @Content(schema = @Schema(implementation = DisabilityDto.class))),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "/{id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<DisabilityDto> getById(@Parameter(in = ParameterIn.PATH, description = "The disability id", required = true, schema = @Schema()) @NotNull @PathVariable("id") UUID id);

    @Operation(summary = "Endpoint to get the list of disabilities having the visitId", description = "Returns a list of disability for a visit", tags = {"disability"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The operation was successful.", content = @Content(schema = @Schema(implementation = DisabilityList.class))),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "/visit-id/{visit-id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<DisabilityList> getByVisittId(@Parameter(in = ParameterIn.PATH, description = "The visit id", required = true, schema = @Schema()) @NotNull @PathVariable("visit-id") UUID visitId);

    @Operation(summary = "Endpoint to create a disability", description = "Creates a new disability", tags = {"disability"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "The operation was successful."),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "/",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Void> create(@Parameter(in = ParameterIn.DEFAULT, description = "disability's attributes", required = true, schema = @Schema()) @NotNull @Valid @RequestBody Disability diability);

    @Operation(summary = "Endpoint to update the information of a disability given the id", description = "Updates a disability", tags = {"disability"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "The operation was successful."),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "/{id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    ResponseEntity<Void> updateById(@Parameter(in = ParameterIn.PATH, description = "The disability id", required = true, schema = @Schema()) @NotNull @PathVariable("id") UUID id,
                                    @Parameter(in = ParameterIn.DEFAULT, description = "disability's attributes", required = true, schema = @Schema()) @NotNull @Valid @RequestBody Disability disability);


    @Operation(summary = "Endpoint to delete a disability", description = "Deletes a disability", tags = {"disability"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "The operation was successful."),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "/{id}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteById(@Parameter(in = ParameterIn.PATH, description = "The disability id", required = true, schema = @Schema()) @NotNull @PathVariable("id") UUID id);

}
