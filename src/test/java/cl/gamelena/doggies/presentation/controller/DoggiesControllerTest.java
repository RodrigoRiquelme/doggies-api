package cl.gamelena.doggies.presentation.controller;

import cl.gamelena.doggies.domain.exception.DoggyNotFoundException;
import cl.gamelena.doggies.domain.usecase.BreedsUseCase;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.client.HttpClientErrorException;

import static cl.gamelena.doggies.domain.model.BreedModelStub.breedModel;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = DoggiesController.class)
class DoggiesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BreedsUseCase useCase;


    @Test
    void getBreedWhenIsOkTheReturnsBreedModel() throws Exception {
        when(useCase.getBreed(anyString())).thenReturn(breedModel());

        performMockMvc()
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.breed", is(breedModel().getBreed())))
            .andExpect(jsonPath("$.subBreeds", is(breedModel().getSubBreeds())))
            .andExpect(jsonPath("$.images", is(breedModel().getImages())));

    }

    @Test
    void getBreedWhenIsDoggyNotFoundThenReturnsNotFoundStatus() throws Exception {
        when(useCase.getBreed(anyString())).thenThrow(DoggyNotFoundException.class);

        performMockMvc()
            .andExpect(status().isNotFound());

    }

    @Test
    void getBreedWhenErrorOccursThenReturnsServerErrorStatus() throws Exception {
        when(useCase.getBreed(anyString())).thenThrow(RuntimeException.class);

        performMockMvc()
            .andExpect(status().is5xxServerError());
    }

    @Test
    void getBreedWhenHttpClientErrorOccursThenThrowsException() throws Exception {

        when(useCase.getBreed(anyString())).thenThrow(
            new HttpClientErrorException(HttpStatus.SERVICE_UNAVAILABLE)
        );

        performMockMvc()
                .andExpect(status().isServiceUnavailable());
    }

    private ResultActions performMockMvc() throws Exception {
        return mockMvc.perform(
            get("/doggies/breed/hound")
            .accept(MimeTypeUtils.APPLICATION_JSON_VALUE)
        );
    }
}
