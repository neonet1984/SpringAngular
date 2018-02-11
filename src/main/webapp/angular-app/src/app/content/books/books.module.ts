import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {BooksContentComponent} from './books-content.component';
import {BookComponent} from './book/book.component';
import {ServiceBooks} from './service.books';
import {BooksRoutingModule} from './books-routing.module';
import {TranslateModule} from '@ngx-translate/core';

@NgModule({
  imports: [
    CommonModule,
    BooksRoutingModule,
    [TranslateModule.forChild()]
  ],
  providers: [ServiceBooks],
  declarations: [BooksContentComponent, BookComponent]
})
export class BooksModule {
}
