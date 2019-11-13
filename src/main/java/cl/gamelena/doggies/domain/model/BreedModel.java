package cl.gamelena.doggies.domain.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BreedModel {
    private String breed;
    private List<String> subBreeds;
    private List<String> images;
}
