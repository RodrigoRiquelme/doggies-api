package cl.gamelena.doggies.domain.usecase.impl;

import cl.gamelena.doggies.data.entity.doggy.DoggiesList;
import cl.gamelena.doggies.data.entity.doggy.DoggyImages;
import cl.gamelena.doggies.data.repository.DoggiesRepositoryImpl;
import cl.gamelena.doggies.domain.exception.DoggyNotFoundException;
import cl.gamelena.doggies.domain.model.BreedModel;
import cl.gamelena.doggies.domain.repository.DoggiesRepository;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static cl.gamelena.doggies.data.entity.doggy.DoggiesListStub.doggiesList;
import static cl.gamelena.doggies.data.entity.doggy.DoggyImagesStub.doggyImages;
import static junit.framework.TestCase.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BreedsUseCaseImplTest {

    @InjectMocks
    private BreedsUseCaseImpl useCase = new BreedsUseCaseImpl();

    @Mock
    private DoggiesRepository repository = new DoggiesRepositoryImpl();

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
        BreedModel result = useCase.getBreed("akita");
        assertNotNull(result);
    }

    @Test
    void getBreedWhenNotFound() {
        setUpRepository();
        Assertions.assertThrows(DoggyNotFoundException.class, () -> {
            useCase.getBreed("akinota");
        });
    }
}