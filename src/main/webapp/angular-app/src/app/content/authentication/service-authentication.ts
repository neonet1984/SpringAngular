import {Injectable} from '@angular/core';
import {User} from '../../shared/user';
import {log} from 'util';
import {Http, RequestOptions, Headers} from '@angular/http';
import {ServiceSercuriry} from '../../service.security-app';
import {Observable} from 'rxjs/Observable';


@Injectable()
export class ServiceAuthentication {

  private token: string;

  constructor(private http: Http) {

  }

  authenticationUser(user: User): any {
    const url = 'http://localhost:8080/login/authentication';
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    const options = new RequestOptions();
    options.headers = headers;
    return this.http.post(url, user, options);


  }
}
