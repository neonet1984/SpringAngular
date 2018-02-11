import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AuthenticationComponent} from './authentication.component';
import {ServiceAuthentication} from './service-authentication';
import {TranslateModule} from '@ngx-translate/core';

@NgModule({
  imports: [
    CommonModule,
    [TranslateModule.forChild()]
  ],
  declarations: [AuthenticationComponent],
  providers: [ServiceAuthentication]
})
export class AuthenticationModule {

}
