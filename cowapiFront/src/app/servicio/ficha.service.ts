import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ObjectUnsubscribedError, Observable } from 'rxjs';
import { Ficha } from '../modelo/ficha';

@Injectable({
  providedIn: 'root'
})
export class FichaService {

  fichaUrl = 'http://localhost:8001/fichas/'

  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Ficha[]>{
    return this.httpClient.get<Ficha[]>(this.fichaUrl + 'lista');
  }

   public detail(id: number): Observable<Ficha[]> {
    console.log(this.fichaUrl + `lista/${id}`)
    return this.httpClient.get<Ficha[]>(this.fichaUrl + `lista/${id}`);
  }
  public guardarFicha(ficha: any, peso: number): Observable<any>{
    return this.httpClient.post<any>(this.fichaUrl + 'atencion?peso=' + peso, ficha);
  }
/*
  public guardar(diio: Ficha): Observable<any>{
    return this.httpClient.post<any>(this.fichaUrl + 'nuevo-diio', diio);
  }

  // Todos lo usan asi
  public update(diio: Ficha): Observable<any>{
    return this.httpClient.put<any>(this.fichaUrl + 'update', diio);
  }


   public update(id: string, diio: Diio): Observable<any>{
    return this.httpClient.put<any>(this.diioUrl + 'update/${id}', diio);
  }

  public actualizar(diio: Ficha): Observable<any>{
    return this.httpClient.put<any>(this.fichaUrl + 'update', diio);
  }

  public eliminar(id: string): Observable<any>{
    return this.httpClient.delete<any>(this.fichaUrl + `delete/${id}`);
  }*/
}
