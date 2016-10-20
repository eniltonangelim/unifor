import { Injectable } from '@angular/core';
import { Departamento } from '../models/departamento';
import {Http, Headers, RequestOptions } from '@angular/http';
import 'rxjs/Rx';

@Injectable()
export class DepartamentoService {

	urlServico: string = "http://localhost:8080/ExemploRest/rest/departamento";

    constructor(private http: Http) {

    }

	listar() {
        return this.http.get(this.urlServico).map(res => res.json());
    }

	cadastrar(departamento: Departamento) {
	    let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        let body = JSON.stringify(departamento);
        return this.http.post(this.urlServico, body, options).map(res => res.text());
    }

	atualizar(departamento: Departamento) {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        let body = JSON.stringify(departamento);
        return this.http.put(this.urlServico, body, options).map(res => res.text());   
    }

	excluir(id: number) {
		let url = this.urlServico + '/' + id;
        return this.http.delete(url).map(res => res.text());	
	}

	buscarPorId(id: number) {
		return this.http.get(this.urlServico + '/' + id).map(res => res.json());
	}
}