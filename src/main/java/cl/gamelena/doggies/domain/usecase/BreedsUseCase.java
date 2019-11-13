package cl.gamelena.doggies.domain.usecase;

import cl.gamelena.doggies.domain.model.BreedModel;

public interface BreedsUseCase {
    BreedModel getBreed(String breedName);
}
