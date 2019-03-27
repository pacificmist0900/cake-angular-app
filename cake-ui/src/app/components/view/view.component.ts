import { Component, OnInit } from '@angular/core';
import { CakeService } from 'src/app/services/cake.service';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class ViewComponent implements OnInit {

  public cakes;
  constructor(private cakeService: CakeService) { }

  ngOnInit() {
    this.getCakes();
  }

  getCakes() {
    this.cakeService.getCakes().subscribe(
      cakesResult => { this.cakes = cakesResult },
      err => console.error(err),
      () => console.log('cakes loaded')

    )
  }

}
