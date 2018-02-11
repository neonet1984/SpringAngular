import {Component, OnInit} from '@angular/core';
import {ServiceBooks} from './service.books';
import {ServiceSercuriry} from '../../service.security-app';
import {TranslateService} from '@ngx-translate/core';

@Component({
  selector: 'app-books-content',
  templateUrl: './books-content.component.html',
  styleUrls: ['./books-content.component.css']
})
export class BooksContentComponent implements OnInit {

  private booksList: any = [{id: '', title: '', description: '', imageLink: ''}];

  constructor(private serviceBook: ServiceBooks, private serviceSecurity: ServiceSercuriry) {
  }
  ngOnInit() {

   const self = this;
    this.serviceBook.getBooksList().subscribe(data => {
        self.booksList = data;
      },
      err => {
        this.errorActive(err);
      }
    );
  }

  public books() {
    return this.booksList;
  }

  errorActive(err) {
    if (err.status = 401) {
    this.serviceSecurity.invalidToken();
    } else {
    this.serviceSecurity.notAuthorized();
    }
  }
}
