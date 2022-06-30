import { RiskService } from './../../service/risk.service';
import { Risk } from './../../models/risk';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-risk-form',
  templateUrl: './risk-form.component.html',
  styleUrls: ['./risk-form.component.css'],
})
export class RiskFormComponent implements OnInit {
  @Input() projectId: string | undefined;
  risk: Risk = this.getEmptyRisk();

  constructor(private service: RiskService) {}

  ngOnInit(): void {
  }

  saveRisk() {
    this.risk.projectId = this.projectId;
    console.log(this.risk);

    console.log('guardando');
    this.service.saveRisk(this.risk).subscribe(() => {
      setTimeout(() => {
        window.location.reload();
      }, 1000);
    });
  }

  onSubmit() {
    console.log({ risk: this.risk });
    this.risk = this.getEmptyRisk();
  }

  getEmptyRisk(): Risk {
    return {
      id: '',
      projectId: '',
      name: '',
      userId: '',
      labels: [''],
      description: '',
      riskState: '',
      audience: '',
      category: '',
      riskType: '',
      detailsRiskType: '',
      probability: 0,
      impactValue: 0,
      mitigationPlan: '',
      responsibleMitigationMails: [''],
      contingencyPlan: '',
      responsibleContingencyMails: [''],
    };
  }
}
