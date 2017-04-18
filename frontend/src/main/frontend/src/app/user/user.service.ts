import {Injectable} from "@angular/core";
import {Http, Response, Headers} from "@angular/http";
import {Observable} from "rxjs/Observable";
import {User} from "./user"

@Injectable()
export class UserService {
  constructor(private _http: Http){}

  public getUsers = (): Observable<Array<User>> =>
  {
    let headers = new Headers();
    headers.append("Accept", "application/json;charset=utf-8");
    return this._http.get("http://localhost:8080/user", { headers: headers }).map((response: Response) =>
    {
      var json = response.json();
      if(json.success)
      {
        let result: Array<User> = [];

        json.responseObject.forEach(object =>{
          result.push(object);
        });

        return result;
      }
    });

  };

  public addUser = (user:User) =>
  {
    let headers = new Headers();
    headers.append("Accept", "application/json;charset=utf-8");
    return this._http.post("http://localhost:8080/user", user, headers).map((response: Response) =>
    {
      var json = response.json();
      return json.success;
    });
  };

  public removeUser = (user:User) =>
  {
    let headers = new Headers();
    headers.append("Accept", "application/json;charset=utf-8");
    return this._http.delete("http://localhost:8080/user/" + user.id, headers).map((response: Response) =>
    {
      var json = response.json();
      return json.success;
    });
  }
}
