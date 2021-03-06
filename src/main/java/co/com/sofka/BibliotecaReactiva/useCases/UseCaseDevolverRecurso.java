package co.com.sofka.BibliotecaReactiva.useCases;
import co.com.sofka.BibliotecaReactiva.collections.Recurso;
import co.com.sofka.BibliotecaReactiva.mapper.RecursoMapper;
import co.com.sofka.BibliotecaReactiva.repository.RepositorioRecurso;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
@Validated
public class UseCaseDevolverRecurso implements ObtenerDisponibilidad{
    private final RepositorioRecurso repositorio;
    private final RecursoMapper mapper;

    public UseCaseDevolverRecurso(RepositorioRecurso repositorio, RecursoMapper mapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    @Override
    public Mono<String> get(String id) {
        Mono<Recurso> recursoMono = repositorio.findById(id);
        return recursoMono.flatMap(r -> {
            if (!r.isDisponible()) {
                r.setDisponible(true);
                r.setFecha(LocalDate.now());
                repositorio.save(r);
                return Mono.just("El recurso se devolvio con exito");
            }
            return Mono.just("El recurso no está prestado");
        });
    }
}