package cl.gamelena.doggies.data.entity.doggy;

import lombok.Data;

import java.util.List;

@Data
public class DoggiesList {
    private List<String> data;
    private String message;
}
