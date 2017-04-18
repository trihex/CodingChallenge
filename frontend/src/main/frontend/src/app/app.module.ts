import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import {DatatableComponent} from './datatable/datatable.component';
import {ColumnComponent} from "./datatable/column.component";
import {UserService} from "./user/user.service";

@NgModule({
  declarations: [
    AppComponent,
    DatatableComponent,
    ColumnComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    NgbModule
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
