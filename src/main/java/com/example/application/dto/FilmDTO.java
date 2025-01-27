package com.example.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "Representation of a film.")
public class FilmDTO {

    @Schema(description = "Unique identifier of the film.", example = "1")
    private Long id;

    @Schema(description = "Title of the film.", example = "Inception")
    private String titre;

    @Schema(description = "Description of the film.", example = "A thriller about dreams and reality.")
    private String description;

    @Schema(description = "Category of the film.", example = "Science Fiction")
    private String categorie;

    @Schema(description = "List of associated session IDs.", example = "[1, 2, 3]")
    private List<Long> seanceIds;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCategorie() { return categorie; }
    public void setCategorie(String categorie) { this.categorie = categorie; }

    public List<Long> getSeanceIds() { return seanceIds; }
    public void setSeanceIds(List<Long> seanceIds) { this.seanceIds = seanceIds; }
}
