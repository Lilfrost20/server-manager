import {Component, OnInit} from '@angular/core';
import {HttpService} from "./service/http.service";
import {BehaviorSubject, Observable} from "rxjs";
import {User} from "./interface/user";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  isLoading: boolean = true
  errorMessage: string = ""
  users$!: Observable<User[]>

  constructor(private httpService: HttpService) {
  }

  ngOnInit(): void {
    this.users$ = this.httpService.users$
    this.httpService.getUsers()
    this.isLoading = false
  }

  delete(id: number) {
    this.httpService.deleteUser(id).subscribe()
  }
}
