package co.com.sofka.BibliotecaReactiva.useCases;

import co.com.sofka.BibliotecaReactiva.dto.RecursoDTO;
import reactor.core.publisher.Mono;

public interface ObtenerPorId {
    Mono<RecursoDTO> get(String id);
}
