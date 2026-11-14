package com.ltp.contacts.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ltp.contacts.exception.ErrorResponse;
import com.ltp.contacts.pojo.Contact;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Contact Controller", description = "Create and retrieve contacts")
public interface ContactApi {

    @Operation(summary = "Retrieves contacts", description = "Provides a list of all contacts")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of contacts", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Contact.class))))
    ResponseEntity<List<Contact>> getContacts();

    @Operation(summary = "Get contact by Id", description = "Returns a contact based on an ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "404", description = "Contact doesn't exist", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "200", description = "Successful retrieval of contact", content = @Content(schema = @Schema(implementation = Contact.class)))
    })
    ResponseEntity<Contact> getContact(String id);

    @Operation(summary = "Create Contact", description = "Creates a contact from the provided payload")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Successful creation of contact"),
        @ApiResponse(responseCode = "400", description = "Bad request: unsuccessful submission", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    ResponseEntity<Contact> createContact(Contact contact);

    @Operation(summary = "Update Contact", description = "Updates a contact based on an ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successful update of contact", content = @Content(schema = @Schema(implementation = Contact.class))),
        @ApiResponse(responseCode = "400", description = "Bad request: unsuccessful submission", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "404", description = "Contact doesn't exist", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    ResponseEntity<Contact> updateContact(String id, Contact contact);

    @Operation(summary = "Delete Contact", description = "Deletes a contact based on an ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Successful deletion of contact"),
        @ApiResponse(responseCode = "404", description = "Contact doesn't exist", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    ResponseEntity<HttpStatus> deleteContact(String id);

}
