import {Injectable} from '@angular/core';
import {CanActivate} from '@angular/router';
import {ServiceSercuriry} from './service.security-app';
import {log} from 'util';

@Injectable()
export class ServiceSecurityRout implements CanActivate {

  constructor(private serviceSecurity: ServiceSercuriry) {

  }

  canActivate() {
    if (this.serviceSecurity.getToken() == null) {
      this.serviceSecurity.notAuthorized();
      return false;
    }
    return true;
  }


}
