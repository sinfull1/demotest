package com.example.demo;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResourceController {

    final ResourceRepository resourceRepository;
    final FuncInterface funcInterface;
    final FuncInterface2 funcInterface2;

    @Autowired
    public ResourceController(ResourceRepository resourceRepository, FuncInterface funcInterface,
                              FuncInterface2 funcInterface2) {
        this.resourceRepository = resourceRepository;
        this.funcInterface = funcInterface;
        this.funcInterface2 = funcInterface2;
    }
    @Operation(summary = "Get a resource by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the resource",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MyResource.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Resource not found",
                    content = @Content) })
    @GetMapping("/resource")
    public List<MyResource> getResource() {
        return resourceRepository.findAll();
    }

    @GetMapping("/func")
    public String getFunc() {
        return funcInterface.getName();
    }

    @GetMapping("/func2")
    public String getFunc2() {
        return funcInterface2.getLocation();
    }
}
