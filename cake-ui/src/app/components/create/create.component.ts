import { Component, OnInit } from '@angular/core';
import { CakeService } from 'src/app/services/cake.service';
import { FormGroup, FormControl, Validators } from '@angular/forms'
import { Observable } from 'rxjs';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  cakeForm: FormGroup;
  validMessage: string = "";

  constructor(private cakeService: CakeService) { }

  submitCake(){
    if(this.cakeForm.valid){
      this.validMessage = "cake has been created";
      this.cakeService.createCake(this.cakeForm.value).subscribe(
        data => {
          this.cakeForm.reset();
          return true;
        }, 
        error => {
          return Observable.throw(error);
        }

      )
    } else{
      this.validMessage = "Please fill out the form before submitting";
    }

  }

  ngOnInit() {
    this.cakeForm = new FormGroup({
      title: new FormControl('', Validators.required),
      description: new FormControl('', Validators.required),
      image: new FormControl('', Validators.required)
    });
  }

}
