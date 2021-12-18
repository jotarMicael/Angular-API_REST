import { Component, OnInit } from '@angular/core';
import { UsersService } from 'src/app/services/users/users.service';
@Component({
  selector: 'app-public-home',
  templateUrl: './public-home.component.html',
  styleUrls: ['./public-home.component.css']
})
export class PublicHomeComponent implements OnInit {

  constructor(public userService: UsersService) { }

  ngOnInit(): void {

    
    
  }

}
