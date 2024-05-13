import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { Diio } from 'src/app/modelo/diio';
import { DiioService } from 'src/app/servicio/diio.service';

@Component({
  selector: 'app-lista-diio',
  templateUrl: './lista-diio.component.html',
  styleUrls: ['./lista-diio.component.scss']
})
export class ListaDiioComponent implements OnInit {

  pagina: number = 1;

  searchtext:any;

  aretes: Diio[] = [];

  constructor(
      private diioService: DiioService,
      private toastr: ToastrService) { }

  ngOnInit(): void {
    this.cargarDiios()
  }

  cargarDiios(): void{
    this.diioService.lista().subscribe(
      result => {
        this.aretes = result;
      },
      err => {
        console.log(err);
      }
    )
  }
  borrar(id: string){
    this.diioService.eliminar(id).subscribe(
      resp => {
        this.toastr.success('Diio eliminado!!', 'Ok',{
          timeOut:3000, positionClass: 'toastr-top-center',
        });
        this.cargarDiios();
      },
      err => {
        console.log(err);
        this.toastr.error('No es posible eliminar!! ' + id, 'Fail',{
          timeOut: 3000, positionClass:'toast-top-center',
        });
        console.log.apply(err);
        this.cargarDiios();
      }
    );
  }
}
