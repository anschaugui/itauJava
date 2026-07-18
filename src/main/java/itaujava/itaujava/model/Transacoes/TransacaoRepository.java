package itaujava.itaujava.model.Transacoes;

import itaujava.itaujava.model.Estatisticas.EstatisticaDTO;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TransacaoRepository {
    // regras para persistencia de dados
    List<TransacaoRequest> listaDeTransacoes = new ArrayList<>();

    // salvar os dados em uma lista
    public void salvarDados(TransacaoRequest transacaoRequest) {
        listaDeTransacoes.add(transacaoRequest);
    }

    // apagar essa lista depois de 60 segundos
    public void limparDados(TransacaoRequest transacaoRequest) {
    }

    // apagar todas as transacoes da lista
    public void deletarDados(TransacaoRequest transacaoRequest) {
        listaDeTransacoes.clear();
    }


    // gerar estatisticas
    public EstatisticaDTO estatistica(OffsetDateTime horaInicial) {

        if (listaDeTransacoes.isEmpty()) {
            return new EstatisticaDTO(0,0.0,0.0,0.0,0.0);
        }

        //transformar a lista de transacoes em numeros para fazer uma operacao
        final var summary = listaDeTransacoes
                .stream()
                .filter(t ->
                        t.getDataHora().isAfter(horaInicial) || t.getDataHora().isEqual(horaInicial)
                ).mapToDouble(t -> t.getValor().doubleValue())
                .summaryStatistics();

        return new EstatisticaDTO(
                summary.getCount(),
                summary.getAverage(),
                summary.getMax(),
                summary.getMin(),
                summary.getSum()
        );


    }
}
