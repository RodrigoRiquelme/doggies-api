package cl.gamelena.doggies.data.entity.doggy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoggiesList {
    private HashMap<String, List<String>> message;
    private String status;
}
