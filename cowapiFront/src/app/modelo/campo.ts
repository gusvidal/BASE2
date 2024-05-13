export class Diio {
    id!: string;
    rup!: string;
    direccion!: string;

    constructor(id: string, rup: string, direccion:string){
        this.id = id;
        this.rup = rup;
        this.direccion = direccion;
    }
}
