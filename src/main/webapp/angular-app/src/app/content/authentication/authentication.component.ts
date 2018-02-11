import {Component, OnInit} from '@angular/core';
import {ServiceAuthentication} from './service-authentication';
import {User} from '../../shared/user';
import {ActivatedRoute, Router} from '@angular/router';
import {ServiceSercuriry} from '../../service.security-app';
import {actionsErrorForm} from '../error-handler';

@Component({
  selector: 'app-authentication',
  templateUrl: './authentication.component.html',
  styleUrls: ['./authentication.component.css']
})
export class AuthenticationComponent implements OnInit {
  private token;
  loading = false;
  private key = '';

  constructor(private serviceAut: ServiceAuthentication, private router: Router,
              private serviceSecurity: ServiceSercuriry, private activRoute: ActivatedRoute) {
  }

  ngOnInit() {
    this.activRoute.queryParams
      .subscribe(params => {
        this.key = params['message'];
      });
  }

  authenticationUser(login: string, password: string) {
    this.loading = true;
    this.serviceAut.authenticationUser(new User(login, password)).subscribe(result => {
        this.token = result.headers.get('X-Auth-Token');
        this.serviceSecurity.setToken(this.token);
        this.router.navigate(['/books']);
        this.loading = false;
      },
      (error) => {
        this.loading = false;
        this.key = actionsErrorForm(error);
      });

  }
  getKey() {
    return this.key;
  }


}
