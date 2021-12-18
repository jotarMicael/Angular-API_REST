import { Component, OnInit, ViewChild } from '@angular/core';
import { ServiceService } from 'src/app/services/services/service.service';
import { first } from 'rxjs/operators';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-add-services',
  templateUrl: './add-services.component.html',
  styleUrls: ['./add-services.component.css']
})
export class AddServicesComponent implements OnInit {
  public myFiles: any[] = [];
  public service_name: string
  public service_type: number = 0
  public description: string
  public whatsapp: string
  public instagram: string
  public twitter: string
  public error: string
  constructor(private ServiceService: ServiceService) { }

  ngOnInit(): void {
  }

  upd() {
    console.log(this.service_type)
    if (this.service_name == '' || this.description == '' || this.service_type == 0 || this.myFiles.length == 0) {


      Swal.fire(
        'ERROR',
        '¡Debe completar todos los campos con *!',
        'error'
      )
    }
    else {
      Swal.fire({
        title: '¿Esta seguro que desea cargar este servicio?',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Si',
        cancelButtonText: 'No',
      }).then((result) => {

        if (result.isConfirmed) {
          const arr: any = [];

          if (this.instagram) {
            arr.push({ icono: 'fab fa-instagram', nombre: 'instagram', urlWeb: this.instagram })
          }
          if (this.whatsapp) {
            arr.push({ icono: 'fab fa-whatsapp', nombre: 'whatsapp', urlWeb: this.whatsapp })
          }

          if (this.twitter) {
            arr.push({ icono: 'fab fa-twitter', nombre: 'instagram', urlWeb: this.twitter })
          }

          const service = {
            nombre: this.service_name,
            descripcion: this.description,
            tipoServicio: { id: this.service_type },
            usuario: { id: JSON.parse(localStorage.getItem('currentUser') as string).userID },
            imagenes: this.myFiles,
            redesSociales: arr
          }
          this.ServiceService.addService(service)
            .pipe(first())
            .subscribe(
              data => {
                Swal.fire(
                  'Cargado.',
                  '¡Servicio cargado exitosamente!',
                  'success'
                )
                this.error = '¡Servicio cargado exitosamente!'

              },
              error => {

                Swal.fire(
                  'ERROR',
                  '¡No tiene permisos para realizar esta acción',
                  'error'
                )


              });


        }
      })
    }
  }

  onFileChange(event: any) {
    this.myFiles = [];
    for (var i = 0; i < event.target.files.length; i++) {
      this.myFiles.push({ ruta: event.target.files[i].name });
    }


  }



}
