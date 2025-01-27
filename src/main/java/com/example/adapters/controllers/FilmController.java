package com.example.adapters.controllers;

import com.example.application.dto.FilmDTO;
import com.example.application.services.FilmService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/films")
@Tag(name = "Film Management", description = "Endpoints for managing films")
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    @Operation(summary = "Get all films", description = "Retrieve a list of all films.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Films retrieved successfully."),
            @ApiResponse(responseCode = "500", description = "Internal server error.")
    })
    public ResponseEntity<List<FilmDTO>> getAllFilms() {
        return ResponseEntity.ok(filmService.getAllFilms());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a film by ID", description = "Retrieve details of a film by its ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Film retrieved successfully."),
            @ApiResponse(responseCode = "404", description = "Film not found.")
    })
    public ResponseEntity<FilmDTO> getFilmById(@PathVariable Long id) {
        return ResponseEntity.ok(filmService.getFilmById(id));
    }

    @PostMapping
    @Operation(summary = "Create a film", description = "Add a new film to the system.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Film created successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid film data.")
    })
    public ResponseEntity<FilmDTO> createFilm(@RequestBody FilmDTO filmDTO) {
        return ResponseEntity.status(201).body(filmService.addFilm(filmDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a film", description = "Delete a film by its ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Film deleted successfully."),
            @ApiResponse(responseCode = "404", description = "Film not found.")
    })
    public ResponseEntity<Void> deleteFilm(@PathVariable Long id) {
        filmService.deleteFilm(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a film", description = "Update information of an existing film.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Film updated successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid film data."),
            @ApiResponse(responseCode = "404", description = "Film not found.")
    })
    public ResponseEntity<FilmDTO> updateFilm(@PathVariable Long id, @RequestBody FilmDTO filmDTO) {
        return ResponseEntity.ok(filmService.updateFilm(id, filmDTO));
    }

    @GetMapping("/categorie/{categorie}")
    @Operation(summary = "Find films by category", description = "Retrieve a list of films in a specific category.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Films retrieved successfully."),
            @ApiResponse(responseCode = "404", description = "No films found in the category.")
    })
    public ResponseEntity<List<FilmDTO>> findFilmsByCategory(@PathVariable String categorie) {
        return ResponseEntity.ok(filmService.getFilmsByCategory(categorie));
    }
}
