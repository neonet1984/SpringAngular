import {Injectable} from '@angular/core';
import {Router} from '@angular/router';
import {TranslateService} from '@ngx-translate/core';
import {Http} from '@angular/http';

@Injectable()
export class ServiceSercuriry {
  private token: string;
  private key: string;

  constructor(private router: Router, private translate: TranslateService) {

  }

  getToken() {
    return this.token;
  }

  setToken(token: string) {
    this.token = token;
  }

  invalidToken() {
    this.key = 'INVALIDTOKEN';
    this.denyAccess();
  }

  notAuthorized() {
    this.key = 'UNAUTHORIZED';
    this.denyAccess();
  }


  private denyAccess() {
    this.token = null;
    this.router.navigate(['/library/authentication'], {queryParams: {message: this.key}});
  }



}
