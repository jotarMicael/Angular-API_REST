import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { PublicHomeComponent } from './components/public-home/public-home.component';
import { IndexFormComponent } from './components/index-form/index-form.component';
import { UserEditComponent } from './components/user-edit/user-edit.component';
import { AuthGuard } from './guard/auth-guard.service';
import { MyServicesComponent } from './components/my_services/my-services/my-services.component';
import { AddServicesComponent } from './components/add_services/add-services/add-services.component';
import { EditServiceComponent } from './components/edit_service/edit-service/edit-service.component';
const routes: Routes = [

  { path: '', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  
  {
    path: 'home', component: PublicHomeComponent,
    canActivate: [AuthGuard],
    children: [
      { path: '', component: IndexFormComponent,canActivate: [AuthGuard] },
      { path: 'user_edit', component: UserEditComponent ,canActivate: [AuthGuard] },
      { path: 'my_services', component: MyServicesComponent,canActivate: [AuthGuard]  },
      { path: 'add_services', component: AddServicesComponent,canActivate: [AuthGuard]  },
      { path: 'edit_service/:id', component: EditServiceComponent,canActivate: [AuthGuard]  },
    ]
  },
  // otherwise redirect to home
  { path: '**', redirectTo: 'home' }
]
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
