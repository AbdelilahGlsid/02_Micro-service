import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-bills-details',
  templateUrl: './bills-details.component.html',
  styleUrl: './bills-details.component.css'
})
export class BillsDetailsComponent implements OnInit{
  billDetails : any;
  billId!: number;
  constructor(private http:HttpClient,
              private router:Router,
              private route:ActivatedRoute) {
    this.billId = route.snapshot.params['billId'];
  }

  ngOnInit() {
    this.http.get("http://localhost:8888/BILLING-SERVICE/fullBill/"+this.billId).subscribe({
      next:(data)=>{
        this.billDetails = data;
      },
      error:(err)=>{}
    })
  }
}
