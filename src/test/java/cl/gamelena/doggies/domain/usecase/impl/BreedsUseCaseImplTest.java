package cl.gamelena.doggies.domain.usecase.impl;

import cl.gamelena.doggies.data.entity.doggy.DoggiesListImages;
import cl.gamelena.doggies.domain.exception.DoggyNotFoundException;
import cl.gamelena.doggies.domain.model.BreedModel;
import cl.gamelena.doggies.domain.repository.DoggiesRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.convert.converter.Converter;

import static cl.gamelena.doggies.data.entity.doggy.DoggiesListStub.doggiesList;
import static cl.gamelena.doggies.data.entity.doggy.DoggyImagesStub.doggyImages;
import static cl.gamelena.doggies.domain.model.BreedModelStub.breedModel;
import static cl.gamelena.doggies.domain.model.BreedModelStub.emptyBreedModel;
import static junit.framework.TestCase.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BreedsUseCaseImplTest {

    @InjectMocks
    private BreedsUseCaseImpl useCase;

    @Mock
    private DoggiesRepository repository;

    @Mock
    private Converter<DoggiesListImages, BreedModel> mapper;

    private final static String SUCCESS = "success";

    private void setUpRepository() {
        when(repository.getDoggiesList()).thenReturn(
            doggiesList()
        );
        when(repository.getDoggyImages(anyString())).thenReturn(
            doggyImages()
        );
    }

    @Test
    void getBreedWhenSuccessfulReturnsBreedModel() {
        setUpRepository();
        when(mapper.convert(any(DoggiesListImages.class))).thenReturn(
            breedModel()
        );
        BreedModel result = useCase.getBreed("akita");
        assertNotNull(result);
    }

    @Test
    void getBreedWhenNotFound() {
        setUpRepository();
        when(mapper.convert(any(DoggiesListImages.class))).thenReturn(
            emptyBreedModel()
        );
        Assertions.assertThrows(DoggyNotFoundException.class, () -> {
            useCase.getBreed("akinota");
        });
    }
}