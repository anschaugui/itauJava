package itaujava.itaujava.model.Transacoes;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class TransacaoService {

    public void validarTransacao(TransacaoRequest transacaoRequest) {
        // valor maior ou igual a 0
        if (transacaoRequest.getValor().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Valor invalido, transacoes devem ter valor maior que zero");
        }
        // data menor ou igual a data de hoje
        if (transacaoRequest.getDataHora().isAfter(OffsetDateTime.now())) {
            throw new IllegalArgumentException("Erro na data da transacao");
        }
        // data e hora presentes (body nao pode ser vazio)
        if (transacaoRequest.getValor() == null){
            throw new IllegalArgumentException("Valor invalido, favor informe um valor");
        }
        if (transacaoRequest.getDataHora() == null){
            throw new IllegalArgumentException("Data da transacao favor informe uma data");
        }

    }

}
