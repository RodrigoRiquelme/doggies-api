package cl.gamelena.doggies.domain.repository;

import cl.gamelena.doggies.data.entity.doggy.DoggiesList;
import cl.gamelena.doggies.data.entity.doggy.DoggyImages;

public interface DoggiesRepository {
    DoggiesList getDoggiesList();
    DoggyImages getDoggyImages(String breedName);
}
