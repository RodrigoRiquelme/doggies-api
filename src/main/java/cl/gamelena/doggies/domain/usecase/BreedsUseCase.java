package cl.gamelena.doggies.domain.usecase;

import cl.gamelena.doggies.domain.model.BreedModel;
import cl.gamelena.doggies.domain.repository.DoggiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BreedsUseCase {
    @Autowired
    private DoggiesRepository repository;

    public BreedModel getBreed() {
        return null;
    }
}
