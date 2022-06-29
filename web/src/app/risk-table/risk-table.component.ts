import { Component, Input, OnInit, QueryList, ViewChildren } from '@angular/core';
import { Risk } from '../models/risk';
import { SortableHeaderRiskDirective, SortRiskEvent } from '../directives/sortable-header-risk.directive';
import { faHeartCirclePlus, faArrowUpRightFromSquare, faTrashCan } from '@fortawesome/free-solid-svg-icons';
import { map, Observable, startWith } from 'rxjs';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-risk-table',
  templateUrl: './risk-table.component.html',
  styleUrls: ['./risk-table.component.css'],
})
export class RiskTableComponent implements OnInit {
  @ViewChildren(SortableHeaderRiskDirective) headers: QueryList<SortableHeaderRiskDirective> | undefined;

  compare = (v1: string | Date | [string] | number, v2: string | Date | [string] | number ) => v1 < v2 ? -1 : v1 > v2 ? 1 : 0;

  faHeartCirclePlus = faHeartCirclePlus;
  faArrowUpRightFromSquare = faArrowUpRightFromSquare;
  faTrashCan = faTrashCan;

  page: number = 1;

  risks$: Observable<Risk[]>;
  filter = new FormControl('');

  @Input() risks: Risk[] = [];
  constructor() {
    this.risks$ = this.filter.valueChanges.pipe(
      startWith(''),
      map(text => this.search(text!))
    )
  }

  ngOnInit(): void {}

  onRiskSort({columnRisk, directionRisk}: SortRiskEvent) {
    // resetting other headers
    this.headers?.forEach(header => {
      if (header.sortableRisk !== columnRisk) {
        header.directionRisk = '';
      }
    });

    if(directionRisk === '' || columnRisk == null){
      this.risks;
    } else {
      this.risks.sort((a, b) => {
        if (columnRisk == null || columnRisk == '') return 0
        const aColumnRisk = a[columnRisk]
        const bColumnRisk = b[columnRisk]
        if (aColumnRisk == null && bColumnRisk == null) return 0
        if (aColumnRisk == null) return 1
        if (bColumnRisk == null) return -1
        const res = this.compare(aColumnRisk, bColumnRisk);
        return directionRisk === 'asc' ? res : -res;
      });
    }
  }
    
  deleteRisk(risk: Risk) {
    console.log(risk);
  }

  search(text: string): Risk[] {
    return this.risks.filter(risk => {
      const term = text.toLowerCase();
      //console.log(pipe.transform(project.startDate, 'yyyy,M,dd'))
      return risk.name.toLowerCase().includes(term)
        || risk.riskState.toLowerCase().includes(term)
        || risk.riskType.toLowerCase().includes(term)
        || risk.category.toLowerCase().includes(term)
        || risk.audience.toLowerCase().includes(term);
    });
  }
}
