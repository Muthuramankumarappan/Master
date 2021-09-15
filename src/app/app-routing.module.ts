import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginBackgroundComponent } from './login-background/login-background.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { AssignComponent } from './assign/assign.component';
import { ViewComponent } from './view/view.component';

const routes: Routes = [
  {path:'\login' , component: LoginBackgroundComponent},
  {path:'\welcome' , component: WelcomeComponent,
  children: [
    {path:'\assign' , component: AssignComponent},
    {path:'view' , component: ViewComponent}
  ]},
  {path:'', redirectTo:'\login' , pathMatch: 'full'}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }


