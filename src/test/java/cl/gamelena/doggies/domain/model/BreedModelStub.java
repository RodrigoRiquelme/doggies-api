package cl.gamelena.doggies.domain.model;

import java.util.ArrayList;
import java.util.Arrays;

public class BreedModelStub {
    public static BreedModel breedModel() {
        return BreedModel.builder()
            .breed("Akita")
            .images(new ArrayList<>(
                Arrays.asList(
                    "image1.jpg",
                    "image2.jpg"
                )
            ))
            .subBreeds(new ArrayList<>(
                Arrays.asList(
                    "subhound1",
                    "subhound2"
                )
            ))
            .build();
    }

    public static BreedModel emptyBreedModel() {
        return BreedModel.builder()
            .breed("Akinota")
            .build();

    }

}