package cl.gamelena.doggies.domain.usecase.impl;

import cl.gamelena.doggies.data.entity.doggy.DoggiesList;
import cl.gamelena.doggies.data.entity.doggy.DoggiesListImages;
import cl.gamelena.doggies.data.entity.doggy.DoggyImages;
import cl.gamelena.doggies.domain.exception.DoggyNotFoundException;
import cl.gamelena.doggies.domain.model.BreedModel;
import cl.gamelena.doggies.domain.repository.DoggiesRepository;
import cl.gamelena.doggies.domain.usecase.BreedsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BreedsUseCaseImpl implements BreedsUseCase {

    @Autowired
    private DoggiesRepository repository;

    @Autowired
    private Converter<DoggiesListImages, BreedModel> mapper;

    @Override
    public BreedModel getBreed(String breedName) {
        DoggiesList doggiesList = repository.getDoggiesList();
        DoggyImages doggyImages = repository.getDoggyImages(breedName);

        DoggiesListImages doggiesListImages = DoggiesListImages.builder()
            .breedName(breedName)
            .doggiesList(doggiesList)
            .doggyImages(doggyImages)
            .build();

        BreedModel response = mapper.convert(doggiesListImages);

        if (!subBreedsExists(response.getSubBreeds())) {
            throw new DoggyNotFoundException();
        }

        return response;
    }

    private Boolean subBreedsExists(List<String> subBreeds) {
        return subBreeds != null;
    }
}
