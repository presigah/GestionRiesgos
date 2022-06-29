import { Directive, EventEmitter, Input, Output } from '@angular/core';
import { Risk } from '../models/risk';

export type SortRiskColumn = keyof Risk | '';
export type SortRiskDirection = 'asc' | 'desc' | '';
const rotate: {[key: string]: SortRiskDirection} = { 'asc': 'desc', 'desc': '', '': 'asc' };

export interface SortRiskEvent {
  columnRisk: SortRiskColumn;
  directionRisk: SortRiskDirection;
}

@Directive({
  selector: 'th[sortableRisk]',
  host: {
    '[class.asc]': 'direction === "asc"',
    '[class.desc]': 'direction === "desc"',
    '(click)': 'rotate()'
  }
})
export class SortableHeaderRiskDirective {

  @Input() sortableRisk: SortRiskColumn = '';
  @Input() directionRisk: SortRiskDirection = '';
  @Output() sort = new EventEmitter<SortRiskEvent>();

  rotate() {
    this.directionRisk = rotate[this.directionRisk];
    this.sort.emit({columnRisk: this.sortableRisk, directionRisk: this.directionRisk});
  }
}
