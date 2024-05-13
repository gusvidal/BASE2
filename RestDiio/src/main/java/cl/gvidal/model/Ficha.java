package cl.gvidal.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="FICHA")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Ficha {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="FICHA_ID")
    private int id;

    @Column(name="FECHA_ATENCION")

    private String fechaAtencion;

    @Column(name="DIAGNOSTICO")
    private String diagnostico;

    @Column(name="INDICACIONES")
    private String tratamiento;

    @Column(name="MEDICO_TRATANTE")
    private String veterinario;

    @ManyToOne
    @JoinColumn(name="DIIO_ID")
    private Diio diio;
}
