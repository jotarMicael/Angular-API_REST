import { NgModule, } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CookieService } from 'ngx-cookie-service';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from "@angular/common/http";

import { FooterComponent } from './components/footer/footer.component';
import { PublicHomeComponent } from './components/public-home/public-home.component';

import { IndexFormComponent } from './components/index-form/index-form.component';
import { HomeTableComponent } from './components/home-table/home-table.component';
import { UserEditComponent } from './components/user-edit/user-edit.component';
import { MyServicesComponent } from './components/my_services/my-services/my-services.component';
import { AddServicesComponent } from './components/add_services/add-services/add-services.component';
import { EditServiceComponent } from './components/edit_service/edit-service/edit-service.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,

    FooterComponent,
    PublicHomeComponent,

    IndexFormComponent,
    HomeTableComponent,
    UserEditComponent,
    MyServicesComponent,
    AddServicesComponent,
    EditServiceComponent,


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgbModule,
    

  ],
  providers: [CookieService],
  bootstrap: [AppComponent]

  
})
export class AppModule { }
