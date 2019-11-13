package cl.gamelena.doggies.domain.usecase.impl;

import cl.gamelena.doggies.data.entity.doggy.DoggiesList;
import cl.gamelena.doggies.domain.model.BreedModel;
import cl.gamelena.doggies.domain.repository.DoggiesRepository;
import cl.gamelena.doggies.domain.usecase.BreedsUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class BreedsUseCaseImplTest {

    @Mock
    private DoggiesRepository repository;

    @InjectMocks
    private BreedsUseCase useCase;

    private final static String SUCCESS = "success";

    @BeforeEach
    void setUp() {
        when(repository.getDoggiesList()).thenReturn(
            DoggiesList.builder()
                .message(null)
                .status(SUCCESS)
                .build()
        );
    }

    @Test
    void getBreed() {
        BreedModel result = useCase.getBreed("mybreed");
        assertNotNull(result);
    }
}