package itaujava.itaujava.model.Transacoes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService service;
    private final TransacaoRepository repository;
    public TransacaoController(TransacaoService service,TransacaoRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity adicionar(@RequestBody TransacaoRequest transacaoRequest) {

        try {
            service.validarTransacao(transacaoRequest);
            repository.salvarDados(transacaoRequest);
            log.info("Salvando transacao: " + transacaoRequest);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (IllegalArgumentException exception) {
            log.error("Erro ao criar transacao", exception);
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).build();
        } catch (Exception e) {
            log.error("Erro ao criar transacao", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @DeleteMapping
    public ResponseEntity deletar(@RequestBody TransacaoRequest transacaoRequest) {
        repository.deletarDados(transacaoRequest);
        log.info("Deletando transacao: " + transacaoRequest);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
