package cl.gamelena.doggies.data.repository;

import cl.gamelena.doggies.data.entity.doggy.DoggiesList;
import cl.gamelena.doggies.data.entity.doggy.DoggyImages;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestOperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static cl.gamelena.doggies.data.entity.doggy.DoggiesListStub.doggiesList;
import static cl.gamelena.doggies.data.entity.doggy.DoggyImagesStub.doggyImages;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DoggiesRepositoryImplTest {

    @InjectMocks
    private DoggiesRepositoryImpl repository;

    @Mock
    private RestOperations restTemplate;

    private final String SUCCESS = "success";

    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(repository, "listAllUrl", "list/all");
        ReflectionTestUtils.setField(repository, "imagesUrls", "/image");
    }

    @Test
    void getDoggiesList() {
        when(restTemplate.exchange(
            anyString(),
            any(),
            any(),
            eq(DoggiesList.class)
        )).thenReturn(
            new ResponseEntity<DoggiesList>(
                doggiesList(),
                HttpStatus.OK
            )
        );
        DoggiesList result = repository.getDoggiesList();
        assertEquals(doggiesList().getMessage().size(), result.getMessage().size());
        assertEquals(doggiesList().getStatus(), result.getStatus());
    }

    @Test
    void getDoggyImages() {
        when(restTemplate.exchange(
            anyString(),
            any(),
            any(),
            eq(DoggyImages.class),
            anyString()
        )).thenReturn(
            new ResponseEntity<DoggyImages>(
                doggyImages(),
                HttpStatus.OK
            )
        );
        DoggyImages result = repository.getDoggyImages("anystring");
        assertEquals(doggyImages().getMessage().size(), result.getMessage().size());
        assertEquals(doggyImages().getStatus(), result.getStatus());
    }
}