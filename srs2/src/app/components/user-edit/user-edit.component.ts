import { HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { UsersService } from 'src/app/services/users/users.service';
import Swal from 'sweetalert2'
@Component({
  selector: 'app-user-edit',
  templateUrl: './user-edit.component.html',
  styleUrls: ['./user-edit.component.css']
})
export class UserEditComponent implements OnInit {
  email: string = '';
  password: string = '';
  date: string;
  name: string = '';
  surname: string = '';
  id: number = 1;


  constructor(private userService: UsersService) {


  }

  ngOnInit(): void {

    this.userService.getUserById().subscribe((data: any) => {

      this.email = data.email
      this.password = data.contrasenia
      this.date = data.fechaNacimiento
      this.name = data.nombre
      this.surname = data.apellido
      this.id = data.id

      var fecha

      fecha = new Date(data.fechaNacimiento);
      
      this.date = fecha.toLocaleDateString() // "Dec 20"
      
    })



  }

  update() {

    const userEdit = {
      nombre: this.name,
      apellido: this.surname,
      contrasenia: this.password,
      email: this.email,
      fechaNacimiento: this.date

    }

    this.userService.update(userEdit).subscribe((data: any) => {

      Swal.fire(
        'Actualizado.',
        '¡Datos actualizados correctamente!',
        'success'
      )

    },

      err => {
        Swal.fire(
          'ERROR.',
          '¡Ha ocurrido un error, inténtelo en otro momento!',
          'error'
        )


      });



  }
}
