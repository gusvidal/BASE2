import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { Ficha } from 'src/app/modelo/ficha';
import { FichaService } from 'src/app/servicio/ficha.service';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpParams } from '@angular/common/http';

@Component({
  selector: 'app-detalle-diio',
  templateUrl: './detalle-diio.component.html',
  styleUrls: ['./detalle-diio.component.scss']
})
export class DetalleDiioComponent implements OnInit {

  id!: string;
  pagina: number = 1;
  searchtext: any;

  ficha: Ficha[] = [];

  constructor(
      private fichaService: FichaService,
      private toastr: ToastrService,
      private activatedRoute: ActivatedRoute,) { }

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    console.log(id);
    this.fichaService.detail(id).subscribe(
      result => {
        this.ficha = result;
      },
      err => {
        console.log(err);
      }
    );
  }

  cargarFichas(): void{
    this.fichaService.lista().subscribe(
      result => {
        this.ficha = result;
      },
      err => {
        console.log(err);
      }
    )
  }

}
