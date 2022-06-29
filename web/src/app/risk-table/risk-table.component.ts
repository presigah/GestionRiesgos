import { RiskService } from './../service/risk.service';
import {
  Component,
  Input,
  OnInit,
  QueryList,
  ViewChildren,
} from '@angular/core';
import { Risk } from '../models/risk';
import {
  SortableHeaderRiskDirective,
  SortRiskEvent,
} from '../directives/sortable-header-risk.directive';
import {
  faHeartCirclePlus,
  faArrowUpRightFromSquare,
  faTrashCan,
} from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-risk-table',
  templateUrl: './risk-table.component.html',
  styleUrls: ['./risk-table.component.css'],
})
export class RiskTableComponent implements OnInit {
  @ViewChildren(SortableHeaderRiskDirective) headers:
    | QueryList<SortableHeaderRiskDirective>
    | undefined;

  compare = (
    v1: string | Date | string[] | number,
    v2: string | Date | string[] | number
  ) => (v1 < v2 ? -1 : v1 > v2 ? 1 : 0);

  faHeartCirclePlus = faHeartCirclePlus;
  faArrowUpRightFromSquare = faArrowUpRightFromSquare;
  faTrashCan = faTrashCan;

  page: number = 1;

  @Input() projectId?: string;
  @Input() risks: Risk[] = [];
  constructor(private service: RiskService) {}

  ngOnInit(): void {}

  onRiskSort({ columnRisk, directionRisk }: SortRiskEvent) {
    // resetting other headers
    this.headers?.forEach((header) => {
      if (header.sortableRisk !== columnRisk) {
        header.directionRisk = '';
      }
    });

    if (directionRisk === '' || columnRisk == null) {
      this.risks;
    } else {
      this.risks.sort((a, b) => {
        if (columnRisk == null || columnRisk == '') return 0;
        const aColumnRisk = a[columnRisk];
        const bColumnRisk = b[columnRisk];
        if (aColumnRisk == null && bColumnRisk == null) return 0;
        if (aColumnRisk == null) return 1;
        if (bColumnRisk == null) return -1;
        const res = this.compare(aColumnRisk, bColumnRisk);
        return directionRisk === 'asc' ? res : -res;
      });
    }
  }

  deleteRisk(risk: Risk) {
    risk.state = 0;
    this.service.updateRisk(risk).subscribe(() => {
      setTimeout(() => {
        window.location.reload();
      }, 1000);
    });
  }
}
