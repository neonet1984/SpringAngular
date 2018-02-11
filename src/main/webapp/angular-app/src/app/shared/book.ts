export class Book {
  constructor(private _id: number, private _title: string, private _description, private _imgLink) {

  }

  get id() {
    return this._id;
  }

  set id(value) {
    this._id = value;
  }

  get title(): string {
    return this._title;
  }

  set title(value: string) {
    this._title = value;
  }

  get description() {
    return this._description;
  }

  set description(value) {
    this._description = value;
  }

  get imgLink() {
    return this._imgLink;
  }

  set imgLink(value) {
    this._imgLink = value;
  }
}
