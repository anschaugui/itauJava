package itaujava.itaujava.model.Estatisticas;

import itaujava.itaujava.model.Transacoes.TransacaoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@Slf4j
@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    // criar rota de estatistica
    private final EstatisticaProperties estatisticaProperties;
    private final TransacaoRepository transacaoRepository;

    public EstatisticaController(EstatisticaProperties estatisticaProperties, TransacaoRepository transacaoRepository) {
        this.estatisticaProperties = estatisticaProperties;
        this.transacaoRepository = transacaoRepository;
    }

    @GetMapping
    public ResponseEntity estatistica() {
      // Log de requisicao criado via lombok
        log.info("Calculando estatistica de transacoes nos ultimos: " + estatisticaProperties.segundos());

      // calcular quantas transacoes acontecem em N segundos
        final var horaInicial = OffsetDateTime
                .now()
                .minusSeconds(estatisticaProperties.segundos());
        return ResponseEntity.ok().body(transacaoRepository.estatistica(horaInicial));
    }

}
