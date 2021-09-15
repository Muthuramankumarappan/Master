import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { LoginBackgroundComponent } from './login-background/login-background.component';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { WelcomeComponent } from './welcome/welcome.component';
import { AssignComponent } from './assign/assign.component';
import { HeaderComponent } from './header/header.component';
import { ViewComponent } from './view/view.component';
import { MaterialModule } from './shared/model';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    LoginBackgroundComponent,
    WelcomeComponent,
    AssignComponent,
    HeaderComponent,
    ViewComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    MaterialModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
