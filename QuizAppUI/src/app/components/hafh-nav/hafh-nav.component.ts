import { Component, OnInit, OnDestroy } from '@angular/core';
import { AppUser } from 'src/app/models/user.model';
import { Subscription } from 'rxjs';
import { AuthService } from 'src/app/services/AuthService/auth.service';

@Component({
  selector: 'app-hafh-nav',
  templateUrl: './hafh-nav.component.html',
  styleUrls: ['./hafh-nav.component.css']
})
export class HafhNavComponent implements OnInit, OnDestroy {

  currenUser: AppUser;
  userSubscription: Subscription;

  constructor(private authService: AuthService) { }

  ngOnInit() {
    this.userSubscription = this.authService.$currentUser.subscribe(user => {
      this.currenUser = user;
    });
  }

  ngOnDestroy() {
    this.userSubscription.unsubscribe();
  }

}
