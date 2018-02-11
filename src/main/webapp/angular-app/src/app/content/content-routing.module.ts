import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {BooksContentComponent} from './books/books-content.component';
import {ContentComponent} from './content.component';
import {AuthenticationComponent} from './authentication/authentication.component';
import {BookComponent} from './books/book/book.component';
import {ServiceSecurityRout} from '../service.security-rout';

const routes: Routes = [
  {
    path: 'library', component: ContentComponent,
    children: [
      {path: 'authentication', component: AuthenticationComponent},
      {path: 'book/:id', component: BookComponent, canActivate: [ServiceSecurityRout]},
      {path: 'books', component: BooksContentComponent, canActivate: [ServiceSecurityRout]}
    ]
  },

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ContentRoutingModule {
}
