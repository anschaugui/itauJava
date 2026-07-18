package itaujava.itaujava.model.Estatisticas;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "estatistica")
public record EstatisticaProperties(
    @Positive(message = "estatistica.segundos deve ser maior que zero")
    @Min(value = 1, message = "O tempo deve ser de no mínimo 1 segundo")
    Integer segundos
) {
}
