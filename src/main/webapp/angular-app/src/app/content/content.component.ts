import {Component, OnInit} from '@angular/core';
import {AutOut} from '../shared/aut-out';
import {TranslateService} from '@ngx-translate/core';
import {ServiceSercuriry} from '../service.security-app';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})


export class ContentComponent implements OnInit {

  ngOnInit() {
  }

  constructor(private serviceSecurity: ServiceSercuriry,
              private translate: TranslateService) {

  };

  setLocale(str) {
    this.translate.use(str);

  }

  getMessage() {
    if (this.serviceSecurity.getToken() == null) {
      return 'LOGIN';
    }else {
      return 'EXIT';
    }
  }
}

