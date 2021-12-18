import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs/operators';
import Swal from 'sweetalert2'
import { ServiceService } from 'src/app/services/services/service.service';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-edit-service',
  templateUrl: './edit-service.component.html',
  styleUrls: ['./edit-service.component.css']
})
export class EditServiceComponent implements OnInit {


  public myFiles: any[] = [];

  //actual_service
  public service: any;

  constructor(private serviceService: ServiceService, private rutaActiva: ActivatedRoute) {


  }

  ngOnInit(): void {
    this.serviceService.getService(this.rutaActiva.snapshot.params['id'])
      .pipe(first())
      .subscribe(
        data => {
          this.service = data;
        },
        error => {


        });



  }
  onFileChange(event: any) {
    this.myFiles = [];
    for (var i = 0; i < event.target.files.length; i++) {
      this.myFiles.push({ ruta: event.target.files[i].name });
    }
  }

  service_update() {

    if (this.service.nombre == '' || this.service.descripcion == '' || this.service.tipoServicio.nombre == '' || this.service.redesSociales == null) {


      Swal.fire(
        'ERROR',
        '¡No debe dejar ningun campo vacío',
        'error'
      )
    }
    else {
      Swal.fire({
        title: '¿Esta seguro que desea actualizar este servicio?',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Si',
        cancelButtonText: 'No',
      }).then((result) => {

        if (result.isConfirmed) {
          console.log(this.service)
          this.serviceService.updateService(this.service)
            .pipe(first())
            .subscribe(
              () => {


              },
              error => {
                if (error.status == 200) {
                  Swal.fire(
                    'Actualizado.',
                    '¡Servicio actualizado exitosamente!',
                    'success'
                  )
                }
                else {
                  Swal.fire(
                    'ERROR',
                    '¡No tiene permisos para realizar esta acción',
                    'error'
                  )
                }
              }
            );




        }
      })
    }

  }
}
