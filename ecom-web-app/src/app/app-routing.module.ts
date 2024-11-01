import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ProductsComponent} from "./products/products.component";
import {CustomersComponent} from "./customers/customers.component";
import {BillsComponent} from "./bills/bills.component";
import {BillsDetailsComponent} from "./bills-details/bills-details.component";

const routes: Routes = [
  { path : "products", component : ProductsComponent },
  { path : "customers", component : CustomersComponent },
  { path : "bills/:customerId", component : BillsComponent },
  { path : "bill-details/:billId", component : BillsDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
