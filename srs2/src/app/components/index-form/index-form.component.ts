import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-index-form',
  templateUrl: './index-form.component.html',
  styleUrls: ['./index-form.component.css']
})
export class IndexFormComponent implements OnInit {
  public search: boolean=true;
  constructor() { }

  ngOnInit(): void {
  }

  services_search(){
    if (this.search)
    this.search=false
    else  
    this.search=true
  }

}
