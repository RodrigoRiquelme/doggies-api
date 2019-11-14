package cl.gamelena.doggies.data.entity.doggy;

import java.util.ArrayList;
import java.util.Arrays;

public class DoggyImagesStub {
    public static DoggyImages doggyImages() {
        return DoggyImages
            .builder()
            .message(doggyImagesMessage())
            .status("success")
            .build();
    }

    private static ArrayList<String> doggyImagesMessage() {
        return new ArrayList<>(
            Arrays.asList(
                "image1.jpg",
                "image2.jpg"
            )
        );
    }
}