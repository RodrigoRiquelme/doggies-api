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
            DoggiesList.builder()
                .message(
                    new HashMap<String, List<String>>() {{
                        put("akita", new ArrayList<>());
                        put("akitoy", new ArrayList<>(
                            Arrays.asList("one", "two", "three")
                        ));
                    }}
                )
                .status(SUCCESS)
                .build()
        );
        when(repository.getDoggyImages(anyString())).thenReturn(
            DoggyImages.builder()
                .message(new ArrayList<>(
                    Arrays.asList(
                        "one.jpg",
                        "two.jpg"
                    )
                ))
                .status(SUCCESS)
                .build()
        );
    }

    @Test
    void getBreedWhenSuccessfulReturnsBreedModel() {
        setUpRepository();
        BreedModel result = useCase.getBreed("akitoy");
        assertNotNull(result);
    }

    @Test
    void getBreedWhenNotFound() {
        setUpRepository();
        Assertions.assertThrows(DoggyNotFoundException.class, () -> {
            BreedModel result = useCase.getBreed("akinotoy");
        });
    }
}