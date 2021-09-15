import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Country } from '../shared/model';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.scss']
})
export class WelcomeComponent implements OnInit {

  viewAssignation = {title:"View Assignation"};

  massiveAssignation = {title:"Massive Assignation"};
  
  country: Country[] = [
    {value: 'mexico', viewValue: 'Mexico'},
    {value: 'usa', viewValue: 'USA'},
    {value: 'india', viewValue: 'INDIA'}
  ];
  selectedCountry = this.country[0].value
  constructor(private route : Router) { }

  ngOnInit(): void {
  }

  doLogOut(){
    this.route.navigate(["/"])
  }

  selectCountry(selectedCountry : Event){
    console.log((selectedCountry.target as HTMLSelectElement).value);
  }

}
