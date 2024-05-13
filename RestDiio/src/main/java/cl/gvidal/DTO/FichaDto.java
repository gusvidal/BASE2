package cl.gvidal.DTO;

import cl.gvidal.model.Diio;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter

public class FichaDto {
    private int id;

    private String fechaAtencion;

    private String diagnostico;

    private String tratamiento;

    private String veterinario;

    private String diio;


    public FichaDto(int id, String fechaAtencion, String diagnostico, String tratamiento, String veterinario, String diio) {
        this.id = id;
        this.fechaAtencion = fechaAtencion;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.veterinario = veterinario;
        this.diio = diio;
    }
}
