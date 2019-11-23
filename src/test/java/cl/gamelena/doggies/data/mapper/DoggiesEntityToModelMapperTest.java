package cl.gamelena.doggies.data.mapper;

import cl.gamelena.doggies.data.entity.doggy.DoggiesList;
import cl.gamelena.doggies.data.entity.doggy.DoggiesListImages;
import cl.gamelena.doggies.data.entity.doggy.DoggyImages;
import cl.gamelena.doggies.domain.model.BreedModel;
import org.junit.jupiter.api.Test;

import static cl.gamelena.doggies.data.entity.doggy.DoggiesListStub.doggiesList;
import static cl.gamelena.doggies.data.entity.doggy.DoggyImagesStub.doggyImages;
import static org.junit.jupiter.api.Assertions.*;

class DoggiesEntityToModelMapperTest {

    DoggiesEntityToModelMapper mapper = new DoggiesEntityToModelMapper();

    @Test
    void convert() {
        String breedName = "Hound";
        DoggiesList doggiesList = doggiesList();
        DoggyImages doggyImages = doggyImages();

        BreedModel result = mapper.convert(
            DoggiesListImages
                .builder()
                .breedName(breedName)
                .doggiesList(doggiesList)
                .doggyImages(doggyImages)
                .build()
        );
        
        assertEquals(breedName, result.getBreed());
        assertEquals(doggyImages.getMessage().size(), result.getImages().size());
    }
}