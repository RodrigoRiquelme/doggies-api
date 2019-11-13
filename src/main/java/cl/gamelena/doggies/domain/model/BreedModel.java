package cl.gamelena.doggies.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BreedModel {
    private String breed;
    private List<String> subBreeds;
    private List<String> images;
}
