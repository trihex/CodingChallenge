export class User {
  id:number;
  username:string;
  email:string;
  registrationDate:Date;

  constructor(id:number, username:string, email:string, registrationDate:Date)
  {
    this.id = id;
    this.username = username;
    this.email = email;
    this.registrationDate = registrationDate;
  }
}
