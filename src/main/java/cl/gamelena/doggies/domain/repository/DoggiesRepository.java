package cl.gamelena.doggies.domain.repository;

import cl.gamelena.doggies.data.entity.doggy.DoggiesList;
import cl.gamelena.doggies.data.entity.doggy.DoggyImage;

public interface DoggiesRepository {
    DoggiesList getDoggiesList();
    DoggyImage getDoggyImage();
}
