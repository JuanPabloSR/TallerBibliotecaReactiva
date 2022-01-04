package co.com.sofka.BibliotecaReactiva.useCases;

import reactor.core.publisher.Mono;

public interface BorrarRecurso {
    Mono<Void> deleteById(String id);
}