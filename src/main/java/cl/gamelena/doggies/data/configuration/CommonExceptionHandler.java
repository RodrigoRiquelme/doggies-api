package cl.gamelena.doggies.data.configuration;

import cl.gamelena.doggies.domain.exception.DoggyNotFoundException;
import cl.gamelena.doggies.domain.model.BreedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;

@RestControllerAdvice
public class CommonExceptionHandler {
    @ExceptionHandler(value = {ResourceAccessException.class, HttpClientErrorException.class, DoggyNotFoundException.class})
    public ResponseEntity<?> handler(RuntimeException ex) {
        BreedModel model = BreedModel.builder().build();
        return new ResponseEntity<>(model, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handler(Exception ex) {
        BreedModel model = BreedModel.builder().build();
        return new ResponseEntity<>(model, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
