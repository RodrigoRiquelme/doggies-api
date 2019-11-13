package cl.gamelena.doggies.data.repository;

import cl.gamelena.doggies.data.entity.doggy.DoggiesList;
import cl.gamelena.doggies.data.entity.doggy.DoggyImage;
import cl.gamelena.doggies.domain.repository.DoggiesRepository;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Repository;

@Repository
@RefreshScope
public class DoggiesRepositoryImpl implements DoggiesRepository {
    @Override
    public DoggiesList getDoggiesList() {
        return null;
    }

    @Override
    public DoggyImage getDoggyImage() {
        return null;
    }
}
