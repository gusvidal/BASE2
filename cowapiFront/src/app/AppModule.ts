import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListaDiioComponent } from './diio/lista-diio/lista-diio.component';
import { DetalleDiioComponent } from './diio/detalle-diio/detalle-diio.component';
import { EditarDiioComponent } from './diio/editar-diio/editar-diio.component';
import { NuevoDiioComponent } from './diio/nuevo-diio/NuevoDiioComponent';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgxPaginationModule } from 'ngx-pagination';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';
import { FilterPipe } from './filter.pipe';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';

@NgModule({
  declarations: [
    AppComponent,
    ListaDiioComponent,
    DetalleDiioComponent,
    EditarDiioComponent,
    NuevoDiioComponent,
    FilterPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule, // required animations module
    ToastrModule.forRoot(), // ToastrModule added
    NgxPaginationModule, // agregado para paginar
    ReactiveFormsModule,
    MatDatepickerModule,
    MatNativeDateModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
