package cl.gamelena.doggies.data.entity.doggy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoggyImages {
    private List<String> message;
    private String status;
}
