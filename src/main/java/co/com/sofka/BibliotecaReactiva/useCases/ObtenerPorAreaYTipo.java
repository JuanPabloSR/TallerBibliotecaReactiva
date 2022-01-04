package co.com.sofka.BibliotecaReactiva.useCases;

import co.com.sofka.BibliotecaReactiva.dto.RecursoDTO;
import reactor.core.publisher.Flux;

public interface ObtenerPorAreaYTipo {
    Flux<RecursoDTO> get(String area, String tipo);
}
