package itaujava.itaujava.model.docs;


import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import itaujava.itaujava.model.Transacoes.TransacaoRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

@Tag(
        name = "Estatistica",
        description = "Endpoint de criacao das estatisticas"
)
public interface EstatisticaControllerDoc {

    @ApiResponse(
            responseCode = "200",
            description = "Estatistica criada com sucesso"
    )
    ResponseEntity<Void> estatistica();

}
