package itaujava.itaujava.model.Transacoes;

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

    private BigDecimal valor;
    private OffsetDateTime dataHora;
}
