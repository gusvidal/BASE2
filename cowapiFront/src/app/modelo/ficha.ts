export class Ficha {
    id!: string;
    fechaAtencion!: string;
    diagnostico!: string;
    tratamiento!: string;
    veterinario!: string;

    constructor(fechaAt: string, diag: string, trata:string, vet:string){
        this.fechaAtencion = fechaAt;
        this.diagnostico = diag;
        this.tratamiento = trata;
        this.veterinario = vet;
    }
}
