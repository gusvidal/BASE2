import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ObjectUnsubscribedError, Observable } from 'rxjs';
import { Diio } from '../modelo/diio';

@Injectable({
  providedIn: 'root'
})
export class DiioService {

  diioUrl = 'http://localhost:8001/diio/'

  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Diio[]>{
    return this.httpClient.get<Diio[]>(this.diioUrl + 'lista');
  }

  // No está implementado en el servicio
   public detail(id: String): Observable<Diio> {
    return this.httpClient.get<Diio>(this.diioUrl + `lista/${id}`);
  }

  public guardar(diio: any): Observable<any>{
    return this.httpClient.post<any>(this.diioUrl + 'nuevo-diio', diio);
  }

  // Todos lo usan asi
  public update(diio: Diio): Observable<any>{
    return this.httpClient.put<any>(this.diioUrl + 'update', diio);
  }

   /*
   public update(id: string, diio: Diio): Observable<any>{
    return this.httpClient.put<any>(this.diioUrl + 'update/${id}', diio);
  }*/

  public actualizar(diio: Diio): Observable<any>{
    return this.httpClient.put<any>(this.diioUrl + 'update', diio);
  }

  public eliminar(id: string): Observable<any>{
    return this.httpClient.delete<any>(this.diioUrl + `delete/${id}`);
  }
}
