import {Injectable} from '@angular/core';
import {Http, RequestOptions, Headers} from '@angular/http';
import 'rxjs/add/operator/map';
import {ServiceSercuriry} from '../../service.security-app';

@Injectable()
export class ServiceBooks {

  constructor(private http: Http, private securityService: ServiceSercuriry) {

  }

  getBooksList() {
    return this.http.get('http://localhost:8080/rest/getBooks', this.getHeaders()).map(res => res.json());
  }

  getBookById(id) {
    return this.http.get('http://localhost:8080/rest/getBookId?id=' + id, this.getHeaders()).map(res => res.json());
  }

  private getHeaders(): RequestOptions {
    const headers = new Headers();
    headers.append('X-Auth-Token', this.securityService.getToken());
    const options = new RequestOptions();
    options.headers = headers;
    return options;
  }

}
