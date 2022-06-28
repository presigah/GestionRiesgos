import { Risk } from './../../models/risk';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-risk-form',
  templateUrl: './risk-form.component.html',
  styleUrls: ['./risk-form.component.css'],
})
export class RiskFormComponent implements OnInit {
  @Input() projectId?: string;
  risk: Risk | undefined;

  constructor() {}

  ngOnInit(): void {}

  saveRisk() {
    console.log('nombre' + this.risk?.name);
  }
}
