import { Component, OnInit, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ServiceService } from 'src/app/services/services/service.service';
import { first } from 'rxjs/operators';
import { NgbModal, NgbCarouselConfig, } from '@ng-bootstrap/ng-bootstrap';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-home-table',
  templateUrl: './home-table.component.html',
  styleUrls: ['./home-table.component.css'],
  providers: [NgbCarouselConfig]
})
export class HomeTableComponent implements OnInit {
  closeResult:string;
  @Input() search: boolean = true
  public error: boolean = false
  public services: any

  constructor(public router: Router, public serviceService: ServiceService, private route: ActivatedRoute,
    private modalService: NgbModal) { }

  ngOnInit(): void {

    this.serviceService.getServicesByUser()
      .pipe(first())
      .subscribe(
        data => {

          this.services = data
        },
        error => {
          this.error = true
        });

  }

  openBackDropCustomClass(content:any) {
    
    this.modalService.open(content,{size:'md'});
  }

  update(id:number){

    
  }


  

  
  delete(id: number) {
    Swal.fire({
      title: '¿Esta seguro que desea eliminar este servicio?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si',
      cancelButtonText: 'No',
    }).then((result) => {
      if (result.isConfirmed) {

        this.serviceService.delete(id).subscribe((data: any) => {

        },

          err => {
            if (err.status == 200) {
              Swal.fire(
                'Cargado.',
                '¡Servicio Eliminado exitosamente!',
                'success',

              )

              this.ngOnInit();


            }
            else {
              Swal.fire(
                'ERROR',
                '¡No tiene permisos para realizar esta acción',
                'error'
              )
            }
          });
      }
    })
  }
}
