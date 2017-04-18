import {Http, Response} from '@angular/http';
import {Injectable, Component, Input} from '@angular/core';
import {ColumnComponent} from './column.component';

@Component({
  selector: 'datatable',
  templateUrl: './datatable.component.html'
})
export class DatatableComponent {

  @Input() dataset;
  columns: ColumnComponent[] = [];

  addColumn(column){
    this.columns.push(column);
  }
}
