import {Component} from '@angular/core';
import {TranslateService} from '@ngx-translate/core';
import {log} from 'util';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';

  constructor(private translate: TranslateService) {
    this.translate.setDefaultLang('en');
  };


}





