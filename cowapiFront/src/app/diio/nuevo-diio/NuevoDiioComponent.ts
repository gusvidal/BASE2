import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Diio } from 'src/app/modelo/diio';
import { DiioService } from 'src/app/servicio/diio.service';


@Component({
  selector: 'app-nuevo-diio',
  templateUrl: './nuevo-diio.component.html',
  styleUrls: ['./nuevo-diio.component.scss']
})
export class NuevoDiioComponent implements OnInit {

dataPost= {
  nroDiio: "",
  fechaInstall: "",
  desc: "",
  fechaNacimiento: "",
  campo:
    {
      id: 1
    }
}
  public form!: FormGroup;

  constructor(private diioService: DiioService,
    private toastr: ToastrService,
    private router: Router,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      // aqui van los datos del formulario web
      nroDiio: ['',Validators.required],
      descripcion: ['',Validators.required],
      nacimiento: ['',Validators.required],
      instalacion: ['',Validators.required]
    })
  }

  onCreate(): void {
    const diio = new Diio(this.form.value.nroDiio, this.form.value.descripcion, this.form.value.nacimiento, this.form.value.instalacion/*, this.dataDiio.campo.id*/);
    this.diioService.guardar(this.form).subscribe(
      resp => {
        this.toastr.success('Diio creado!!', 'Ok', {
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
  }
  onSubmit() {
    if(this.form.valid){
      this.dataPost.nroDiio=this.form.value.nroDiio;
      this.dataPost.desc=this.form.value.descripcion;
      this.dataPost.fechaNacimiento=this.form.value.nacimiento;
      this.dataPost.fechaInstall=this.form.value.instalacion;
      this.dataPost.campo.id=1;

      this.diioService.guardar(this.dataPost).subscribe(
        resp => {
          this.toastr.success('Diio creado!!', 'Ok', {
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
