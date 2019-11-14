package cl.gamelena.doggies.presentation.controller;

import cl.gamelena.doggies.domain.usecase.BreedsUseCase;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.MimeTypeUtils;

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
    void getBreed() throws Exception {
        when(useCase.getBreed(anyString())).thenReturn(breedModel());

        mockMvc.perform(
            get("/doggies/breed/hound")
                .accept(MimeTypeUtils.APPLICATION_JSON_VALUE)
        )
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.breed", is(breedModel().getBreed())))
        .andExpect(jsonPath("$.subBreeds", is(breedModel().getSubBreeds())))
        .andExpect(jsonPath("$.images", is(breedModel().getImages())));

    }
}
