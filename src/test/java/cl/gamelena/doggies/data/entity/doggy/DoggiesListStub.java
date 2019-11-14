package cl.gamelena.doggies.data.entity.doggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DoggiesListStub {
    public static DoggiesList doggiesList() {
        return DoggiesList.builder()
            .message(doggiesListMessage())
            .status("success")
            .build();
    }

    private static HashMap<String, List<String>> doggiesListMessage() {
        return new HashMap<String, List<String>>() {{
            put("akita", new ArrayList<>());
            put("akitoy", new ArrayList<>(
                Arrays.asList("one", "two", "three")
            ));
        }};
    }
}