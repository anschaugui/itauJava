package itaujava.itaujava.model.Transacoes;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransacaoRequest {

    @NotNull(message = "valor da transacao deve ser maior que zero")
    @Positive(message = "O valor da transacao deve ser igual ou maior a zero: ")
    private BigDecimal valor;
    private OffsetDateTime dataHora;
}
