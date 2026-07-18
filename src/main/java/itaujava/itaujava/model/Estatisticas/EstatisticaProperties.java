package itaujava.itaujava.model.Estatisticas;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties(prefix = "estatistica")
public record EstatisticaProperties(
        // nao pode ser 0 ou numero negativo e tambem nao pode ser vazio
    @NotNull(message = "Segundos nao aceita valores nulos")
    @Positive(message = "estatistica.segundos deve ser maior que zero")
    @Min(value = 1, message = "O tempo deve ser de no mínimo 1 segundo")
    Integer segundos
) {
}
