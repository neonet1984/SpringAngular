import {Component, OnInit} from '@angular/core';
import {ServiceBooks} from '../service.books';
import {ActivatedRoute} from '@angular/router';
import {log} from 'util';
import {ServiceSercuriry} from '../../../service.security-app';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {

  private book: any = {title: '', content: ''};
  private id: number;

  constructor(private bookService: ServiceBooks, private activRoute: ActivatedRoute,
              private serviceSecurity: ServiceSercuriry) {

  }

  ngOnInit() {
    this.activRoute.params.subscribe(id => this.id = (id.id));
    const self = this;
    this.bookService.getBookById(this.id).subscribe(data => {
        self.book = data;
      },
      err => {
        log(err);
        this.errorActive(err);
      });
  }

  getBook() {
    return this.book;
  }

  private errorActive(err) {
    if (err.status = 401) {
      this.serviceSecurity.invalidToken();
    } else {
      this.serviceSecurity.notAuthorized();
    }
  }

}
