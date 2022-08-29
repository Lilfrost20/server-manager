import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from "@angular/common/http";
import {Server} from "../interface/server";
import {BehaviorSubject, catchError, filter, Observable, tap, throwError} from "rxjs";
import {User} from "../interface/user";

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private http: HttpClient) {}

  private readonly BASE_URL: string = 'https://jsonplaceholder.typicode.com/users'

  users$: BehaviorSubject<User[]> = new BehaviorSubject<User[]>([])

  users: User[] = []

  getUsers() {
   return  this.http.get<User[]>(this.BASE_URL).subscribe(
     data => {
       this.users = data
       this.users$.next(this.users)
     })

  }

  createServer(server: Server): Observable<Server> {
    return this.http.post<Server>(this.BASE_URL, server)
      .pipe(
        catchError(this.handleError)
      )
  }

  deleteUser(id: number) {
    return this.http.delete(`${this.BASE_URL}/${id}`).pipe(
      catchError(this.handleError)
    )
  }

  private handleError(error: HttpErrorResponse) {
    console.log(error)
    if (error.status === 0) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong.
      console.error(
        `Backend returned code ${error.status}, body was: `, error.error);
    }
    // Return an observable with a user-facing error message.
    return throwError(() => new Error('Something bad happened; please try again later.'));
  }
}
