import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AuthenticationModule} from './authentication/authentication.module';
import {BooksModule} from './books/books.module';
import {ContentRoutingModule} from './content-routing.module';
import {ContentComponent} from './content.component';
import {TranslateModule} from '@ngx-translate/core';

@NgModule({
  imports: [
    AuthenticationModule,
    BooksModule,
    CommonModule,
    ContentRoutingModule,
    [TranslateModule.forChild()]
  ],
  declarations: [ContentComponent]
})
export class ContentModule {
}
