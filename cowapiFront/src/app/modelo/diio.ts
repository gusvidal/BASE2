export class Diio {
    id!: string;
    nroDiio!: string;
    desc!: string;
    fechaNacimiento!: string;
    instalacion!: string;

    constructor(diio: string, desc: string, born:string, install:string){
        this.nroDiio = diio;
        this.desc = desc;
        this.fechaNacimiento = born;
        this.instalacion = install;
    }
}
