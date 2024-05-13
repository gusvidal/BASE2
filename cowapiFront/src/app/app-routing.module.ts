import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListaDiioComponent } from './diio/lista-diio/lista-diio.component';
import { DetalleDiioComponent } from './diio/detalle-diio/detalle-diio.component';
import { NuevoDiioComponent } from './diio/nuevo-diio/NuevoDiioComponent';
import { EditarDiioComponent } from './diio/editar-diio/editar-diio.component';

const routes: Routes = [
  {path: '', component:ListaDiioComponent},
  {path: 'detalle/:id', component: DetalleDiioComponent},
  {path: 'nuevo', component: NuevoDiioComponent},
  //{path: 'editar/:id', component: EditarDiioComponent},
  {path: 'ficha/:nroDiio', component: EditarDiioComponent},
  // esta es una expresion regular que sirve para redirigir a la raiz
  // si no se encuentra la url. Siempre va al ultimo
  {path: '**', redirectTo: '', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
