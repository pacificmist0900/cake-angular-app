import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';





const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};
@Injectable()
export class CakeService {

  constructor(private httpClient: HttpClient) { }

  getCakes() {
    return this.httpClient.get('/api/cakes');
  }

  getCake(id: String) {
    return this.httpClient.get('/api/cakes/' + id);
  }

  createCake(cake) {
    let body = JSON.stringify(cake);
    return this.httpClient.post('/api/cake', body, httpOptions)

  }
}
