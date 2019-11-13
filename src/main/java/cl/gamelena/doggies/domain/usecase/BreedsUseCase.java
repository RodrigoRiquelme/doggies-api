package cl.gamelena.doggies.domain.usecase;

import cl.gamelena.doggies.domain.model.BreedModel;
import org.springframework.stereotype.Service;

@Service
public interface BreedsUseCase {
    BreedModel getBreed(String breedName);
}
