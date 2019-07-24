import { Component, OnInit, Input } from '@angular/core';
import { User } from '../user';
import { UserListService } from '../user-list.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {
  @Input() user = new User();

  constructor(
    private userListService: UserListService,
    private route: Router,
    private activatedRoute: ActivatedRoute
  ) { }

  ngOnInit() {
    this.getUserDetails();
  }

  chooseOperation(user: User): void {
    if (user.id) {
      this.updateUser(user);
    } else {
      this.addUser(user);
    }
  }

  addUser(user: User): void {
    this.userListService.addUser(user).subscribe();
    this.route.navigate(['/dashboard']);
  }

  updateUser(user: User): void {
    const id = +this.activatedRoute.snapshot.paramMap.get('id');
    this.userListService.updateUser(user, id).subscribe();
    this.route.navigate(['/dashboard']);
  }

  getUserDetails(): void {
    const id = +this.activatedRoute.snapshot.paramMap.get('id');
    if (id != 0) {
      this.userListService.getUserDetails(id)
        .subscribe(response => this.user = response);
    }
  }
}
