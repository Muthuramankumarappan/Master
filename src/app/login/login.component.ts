import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Route, ActivatedRoute, Router } from '@angular/router';
import { AppRoutingModule } from '../app-routing.module';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  @ViewChild('userdata') userData : NgForm | undefined;

  constructor(private route : Router) { }

  ngOnInit(): void {
    console.log(this.userData)
  }

  onSubmit(validate: NgForm){
    this.route.navigate(['\welcome']);
  }

}
