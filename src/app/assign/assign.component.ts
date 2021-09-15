import { Component, OnInit } from '@angular/core';
import { ButtonTemplate } from '../shared/model';

@Component({
  selector: 'app-assign',
  templateUrl: './assign.component.html',
  styleUrls: ['./assign.component.scss']
})
export class AssignComponent implements OnInit {

  constructor() { }
  title = "Assign Portfolio"
  todayDate: string[] = [];
  selectedDate : string = '';
  branchArray = ["b1","b2","b3","b4"]
  portfolioArray = ["","pb1","pb2","pb3","pb4"]
  systemArray = ["120","dlr"]
  priorityArray = ["U","N"]
  selectedSystem = "120"
  selectedBranch = "b1";
  selectedPortfolio = "";
  selectedPriority = "U"
  numbers=7
  pending=1
  totalNumber=9
  totalPending=3


  assignFunction : ButtonTemplate[] = [
    {label:'One', action: () => {console.log(this.todayDate)}}
  ,{label:'Two', action: (downloadFile : String) => {console.log(`${downloadFile}`)}}
   ,{label:'Thrree', action: () => {console.log(this.todayDate)}}
   ,{label:'Four', action: () => {console.log(this.todayDate)}}
  ] ;
  ngOnInit(): void {
    this.getDate();
  }


  getDate(){
    let today = new Date();
    let dd = String(today.getDate()).padStart(2, '0');
   let mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
   let yyyy = today.getFullYear();
   this.selectedDate = `${mm} - ${+dd} - ${yyyy}`;
   for(let i = 0 ; i < 7 ; i++){
    this.todayDate.push(`${mm} - ${+dd + i} - ${yyyy}`);
   }
    }

}
