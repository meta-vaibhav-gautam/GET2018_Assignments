import { Injectable } from '@angular/core';
import { User } from './user';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class UserListService {

  constructor(
    private http: HttpClient
  ) { }

  private userUrl = "http://localhost:3000/user";

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.userUrl);
  }

  addUser(user: User): Observable<User> {
    return this.http.post<User>(this.userUrl, user, httpOptions);
  }

  updateUser(user: User, id:number): Observable<any> {
    return this.http.put<User>((this.userUrl+'/'+id),user,httpOptions);
  }

  getUserDetails(id: number): Observable<User> {
    return this.http.get<User>(this.userUrl+'/'+id);
  }
}
