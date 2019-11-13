package cl.gamelena.doggies.data.repository;

import cl.gamelena.doggies.data.entity.doggy.DoggiesList;
import cl.gamelena.doggies.data.entity.doggy.DoggyImages;
import cl.gamelena.doggies.domain.repository.DoggiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestOperations;

@Repository
public class DoggiesRepositoryImpl implements DoggiesRepository {

    @Value("${configurations.doggies.endpoints.listAll}")
    private String listAllUrl;

    @Value("${configurations.doggies.endpoints.images}")
    private String imagesUrls;

    @Autowired
    private RestOperations restTemplate;

    @Override
    public DoggiesList getDoggiesList() {
        return restTemplate.getForObject(listAllUrl, DoggiesList.class);
    }

    @Override
    public DoggyImages getDoggyImages(String breedName) {
        ResponseEntity<DoggyImages> response = restTemplate.exchange(
            imagesUrls,
            HttpMethod.GET,
            httpEntity(),
            DoggyImages.class,
            breedName
        );
        return response.getBody();
    }

    private HttpEntity httpEntity() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        return new HttpEntity<>(httpHeaders);
    }
}
