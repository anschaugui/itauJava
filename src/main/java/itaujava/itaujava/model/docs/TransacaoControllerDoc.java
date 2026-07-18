package itaujava.itaujava.model.docs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import itaujava.itaujava.model.Transacoes.TransacaoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(   name = "Transações",
        description = "Endpoints de criacao de transacoes"
)
public interface TransacaoControllerDoc {

    // API DOCUMENTATION POST
    @Operation(summary = "Cria novas transacoes e adiciona em uma lista",
            description = "Recebe uma transacao valida e adiciona em uma lista")

    @ApiResponse(
            responseCode = "201",
            description = "Transacao criada com sucesso"
    )
    @ApiResponse(
            responseCode = "422",
            description = "Erro de validacao capturado"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Erro inesperado no servidor"
    )
    ResponseEntity<Void> adicionar(@RequestBody TransacaoRequest transacaoRequest);

    // API DOCUMENTATION DELETE

    @Operation(
            summary = "Deleta a Transao",
            description = "Remove todas as transacoes adicionadas a lista"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Transacao criada com sucesso"
    )
    @ApiResponse(
            responseCode = "422",
            description = "Erro ao deletar a transacao"
    )
    ResponseEntity<Void> deletar(@RequestBody TransacaoRequest transacaoRequest);
}
