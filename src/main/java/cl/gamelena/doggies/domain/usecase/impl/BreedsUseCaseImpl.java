package cl.gamelena.doggies.domain.usecase.impl;

import cl.gamelena.doggies.data.entity.doggy.DoggiesList;
import cl.gamelena.doggies.data.entity.doggy.DoggyImages;
import cl.gamelena.doggies.domain.exception.DoggyNotFoundException;
import cl.gamelena.doggies.domain.model.BreedModel;
import cl.gamelena.doggies.domain.repository.DoggiesRepository;
import cl.gamelena.doggies.domain.usecase.BreedsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.util.StringUtils.capitalize;


@Service
public class BreedsUseCaseImpl implements BreedsUseCase {
    @Autowired
    private DoggiesRepository repository;

    @Override
    public BreedModel getBreed(String breedName) {
        DoggiesList doggiesList = repository.getDoggiesList();
        DoggyImages doggyImages = repository.getDoggyImages(breedName);

        List<String> subBreeds = doggiesList.getMessage().get(breedName);
        List<String> images = doggyImages.getMessage();

        if (!subBreedsExists(subBreeds)) {
            throw new DoggyNotFoundException();
        }

        return BreedModel
            .builder()
                .breed(
                   capitalize(breedName)
                )
                .subBreeds(subBreeds)
                .images(images)
            .build();
    }

    private Boolean subBreedsExists(List<String> subBreeds) {
        return subBreeds != null;
    }

}
