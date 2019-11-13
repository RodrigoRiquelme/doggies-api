package cl.gamelena.doggies.data.entity.doggy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoggyImages {
    private List<String> message;
    private String status;
}
