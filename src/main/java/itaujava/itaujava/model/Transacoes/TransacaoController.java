package itaujava.itaujava.model.Transacoes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import itaujava.itaujava.model.docs.EstatisticaControllerDoc;
import itaujava.itaujava.model.docs.TransacaoControllerDoc;
import jdk.jfr.Description;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/transacao")
public class TransacaoController implements TransacaoControllerDoc {

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
        try {
            repository.deletarDados(transacaoRequest);
            log.info("Deletando transacao: " + transacaoRequest);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (IllegalArgumentException exception) {
            log.error("Erro ao deletar transacao", exception);
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).build();
        }
    }

}
