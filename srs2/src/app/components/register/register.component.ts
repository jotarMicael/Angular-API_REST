import { Component, OnInit } from '@angular/core';
import { RegisterService } from 'src/app/services/register/register.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2'
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  name: string = '';
  surname: string = '';
  password: string = '';
  email: string = '';
  date: string = '';
  error: string = '';

  constructor(public registerService: RegisterService, public router: Router) { }




  register() {

    if (this.name == '' || this.surname == '' || this.password == '' || this.email == '' || this.date == '') {
      Swal.fire(
        'Aviso.',
        '¡Todos los campos deben estar completos!',
        'warning'
      )
    }
    else {

      Swal.fire({
        title: '¿Esta seguro que desea registrarse con estos datos?',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Si',
        cancelButtonText: 'No',
      }).then((result) => {
        if (result.isConfirmed) {
          const userRegister = {
            nombre: this.name,
            apellido: this.surname,
            contrasenia: this.password,
            email: this.email,
            fechaNacimiento: this.date

          }

          this.registerService.register(userRegister).subscribe((data: any) => {

            let timerInterval: any
            Swal.fire({
              title: '¡Registro exitoso!',
              icon: 'success',
              html: 'Será redireccionado a la pantalla de inicio de sesión en <b></b>.',
              timer: 5000,
              timerProgressBar: true,
              didOpen: () => {
                Swal.showLoading()
                const c: any = Swal.getHtmlContainer()
                const b: any = c.querySelector('b')
                timerInterval = setInterval(() => {
                  b.textContent = Swal.getTimerLeft()
                }, 100)
              },
              willClose: () => {
                clearInterval(timerInterval)
              }
            }).then((result) => {
              /* Read more about handling dismissals below */
              if (result.dismiss === Swal.DismissReason.timer) {
                this.router.navigateByUrl('')
              }
            })

          },

            error => {
             
              if (error.status == 302) {
                Swal.fire(
                  'ERROR',
                  '¡El email ya se encuentra registrado en este sistema,inténte con otro!',
                  'warning'
                )

              }

              else {
                Swal.fire(
                  'ERROR',
                  '¡Ha ocurrido un error,inténtelo en otro momento!',
                  'error'
                )
              }

            });

        }
      });

    }
  }


  ngOnInit(): void {
  }

}
