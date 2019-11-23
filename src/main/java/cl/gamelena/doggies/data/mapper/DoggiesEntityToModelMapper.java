package cl.gamelena.doggies.data.mapper;

import cl.gamelena.doggies.data.entity.doggy.DoggiesListImages;
import cl.gamelena.doggies.domain.model.BreedModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.util.StringUtils.capitalize;

@Component
public class DoggiesEntityToModelMapper implements Converter<DoggiesListImages, BreedModel> {
    @Override
    public BreedModel convert(DoggiesListImages source) {
        String breedName = source.getBreedName();
        List<String> subBreeds = source.getDoggiesList().getMessage().get(breedName);
        List<String> images = source.getDoggyImages().getMessage();

        return BreedModel.builder()
            .breed(
                capitalize(breedName)
            )
            .subBreeds(subBreeds)
            .images(images)
            .build();
    }
}
