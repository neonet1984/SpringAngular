export class AutOut {
   constructor(public link: string, public message: string) {
  }

  getLink(): string {
    return this.link;
  }

  getMessage(): string {
    return this.message;
  }
}
