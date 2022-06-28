import { Component, Input, OnInit, QueryList, ViewChildren } from '@angular/core';
import { Risk } from '../models/risk';
import { SortableHeaderRiskDirective, SortRiskEvent } from '../directives/sortable-header-risk.directive';

@Component({
  selector: 'app-risk-table',
  templateUrl: './risk-table.component.html',
  styleUrls: ['./risk-table.component.css'],
})
export class RiskTableComponent implements OnInit {
  @ViewChildren(SortableHeaderRiskDirective) headers: QueryList<SortableHeaderRiskDirective> | undefined;

  compare = (v1: string | Date | [string] | number, v2: string | Date | [string] | number ) => v1 < v2 ? -1 : v1 > v2 ? 1 : 0;

  @Input() risks: Risk[] = [];
  constructor() {}

  ngOnInit(): void {}

  onRiskSort({columnRisk, directionRisk}: SortRiskEvent) {
    // resetting other headers
    this.headers?.forEach(header => {
      if (header.sortableRisk !== columnRisk) {
        header.directionRisk = '';
      }
    });

    if(directionRisk === '' || columnRisk === ''){
      this.risks;
    } else {
      this.risks.sort((a, b) => {
        const res = this.compare(a[columnRisk], b[columnRisk]);
        return directionRisk === 'asc' ? res : -res;
      });
    }
  }
}
