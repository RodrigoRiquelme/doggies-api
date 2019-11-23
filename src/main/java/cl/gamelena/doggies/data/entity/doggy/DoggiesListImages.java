package cl.gamelena.doggies.data.entity.doggy;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DoggiesListImages {
    String breedName;
    DoggyImages doggyImages;
    DoggiesList doggiesList;
}
