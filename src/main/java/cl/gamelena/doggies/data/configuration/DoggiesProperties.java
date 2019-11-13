package cl.gamelena.doggies.data.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("configurations.doggies.endpoints")
public class DoggiesProperties {
    private String list;
    private String images;
}
