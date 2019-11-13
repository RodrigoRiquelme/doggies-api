package cl.gamelena.doggies.presentation.controller;

import cl.gamelena.doggies.domain.model.BreedModel;
import cl.gamelena.doggies.domain.usecase.BreedsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doggies")
public class DoggiesController {
    @Autowired
    private BreedsUseCase useCase;

    @GetMapping(value = "/breed/{breedName}")
    public BreedModel getBreed(@PathVariable(value = "breedName") String breedName) {

        return BreedModel.builder().breed("WOOF").build();
    }
}
