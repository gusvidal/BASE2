import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { timeout } from 'rxjs';
import { Diio } from 'src/app/modelo/diio';
import { FichaService } from 'src/app/servicio/ficha.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MAT_DATE_FORMATS } from '@angular/material/core';

export const MY_FORMATS = {
  parse: {
    dateInput: 'LL',
  },
  display: {
    dateInput: 'DD/MM/YYYY',
    monthYearLabel: 'MMM YYYY',
    dateA11yLabel: 'LL',
    monthYearA11yLabel: 'MMMM YYYY',
  },
};

@Component({
  selector: 'app-editar-diio',
  templateUrl: './editar-diio.component.html',
  styleUrls: ['./editar-diio.component.scss'],
  providers: [
    { provide: MAT_DATE_FORMATS, useValue: MY_FORMATS },
  ],
})
export class EditarDiioComponent implements OnInit {

  dataPost= {
    fechaAtencion: "",
    diagnostico: "",
    tratamiento: "",
    veterinario: "",
    diio : {
        nroDiio: ""
    }
}
    public form!: FormGroup;

  constructor(
    private fichaService: FichaService,
    private activatedRoute: ActivatedRoute,
    private toastr: ToastrService,
    private router: Router,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
    console.log("estoy en init")
    this.form = this.formBuilder.group({
      // aqui van los datos del formulario web
      nroDiio: ['',Validators.required],
      tratamiento: ['',Validators.required],
      fechaVisita: ['',Validators.required],
      peso: ['',Validators.required],
      veterinario: ['',Validators.required],
      diagnostico: ['',Validators.required]
    })
  }
  onSubmit(){
    if(this.form.valid){
      this.dataPost.fechaAtencion=this.form.value.fechaVisita;
      this.dataPost.diagnostico=this.form.value.diagnostico;
      this.dataPost.tratamiento=this.form.value.tratamiento;
      this.dataPost.veterinario=this.form.value.veterinario;
      this.dataPost.diio.nroDiio=this.form.value.nroDiio;


      this.fichaService.guardarFicha(this.dataPost, this.form.value.peso).subscribe(
        resp => {
          this.toastr.success('Ficha creada!!', 'Ok', {
            timeOut: 3000, positionClass: 'toastr-top-center'
          });
          this.router.navigate(['/']);
        },
        err => {
          this.toastr.error('Error al crear el registro!!', 'Fail', {
            timeOut: 3000, positionClass: 'toastr-top-center'
          });
          this.router.navigate(['/']);
        }
      );
    }else{
      console.log("Formulario invalido")
    }
    //throw new Error('Method not implemented.');
    }
}
