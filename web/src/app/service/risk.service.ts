import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class RiskService {
  constructor() {}

  //se crea servicio de prueba

  getAll() {
    return [
      {
        id: '62a68211957b637d63566901',
        projectId: '62a68211957b637d63566901',
        name: 'Fallas en el sistema',
        detectedDate: '12/12/2021',
        endedDate: '12/24/2021',
        labels: 'etiqueta',
        description:
          'Lorem ipsum dolor sit amet consectetur adipisicing elit. Officia ad nobis quis natus fuga quisquam similique',
        risksState: 'mitigado',
        audience: 'interna',
        category: 'calidad',
        riskType: 'riesgo de proyecto',
        detailsRiskType:
          'Lorem ipsum dolor sit amet consectetur adipisicing elit. Officia ad nobis quis natus fuga quisquam similique, repellendus earum est, voluptas quasi hic unde facilis enim quas dicta adipisci! Fuga, facere?',
        probability: 20,
        impactValue: 30,
        mitigationPlan:
          'Lorem ipsum dolor sit amet consectetur adipisicing elit. Officia ad nobis quis natus fuga quisquam similique, repellendus earum est, voluptas quasi hic unde facilis enim quas dicta adipisci! Fuga, facere?',
        responsibleMitigationMails: ['ma@gmail.com', 'maria@gmail.com'],
        contingencyPlan:
          'Lorem ipsum dolor sit amet consectetur adipisicing elit. Officia ad nobis quis natus fuga quisquam similique, repellendus earum est, voluptas quasi hic unde facilis enim quas dicta adipisci! Fuga, facere?',
        responsibleContingencyMails: ['ma@gmail.com', 'maria@gmail.com'],
        state: 'activo',
      },
      {
        id: '31232ddewd957b637d63566901',
        projectId: 'xweed127b637d63566901',
        name: 'Retrasos en la entrega',
        detectedDate: '12/12/2021',
        endedDate: '12/24/2021',
        labels: 'etiqueta',
        description:
          'Lorem ipsum dolor sit amet consectetur adipisicing elit. Officia ad nobis quis natus fuga quisquam similique',
        risksState: 'mitigado',
        audience: 'interna',
        category: 'calidad',
        riskType: 'riesgo de proyecto',
        detailsRiskType:
          'Lorem ipsum dolor sit amet consectetur adipisicing elit. Officia ad nobis quis natus fuga quisquam similique, repellendus earum est, voluptas quasi hic unde facilis enim quas dicta adipisci! Fuga, facere?',
        probability: 20,
        impactValue: 30,
        mitigationPlan:
          'Lorem ipsum dolor sit amet consectetur adipisicing elit. Officia ad nobis quis natus fuga quisquam similique, repellendus earum est, voluptas quasi hic unde facilis enim quas dicta adipisci! Fuga, facere?',
        responsibleMitigationMails: ['ma@gmail.com', 'maria@gmail.com'],
        contingencyPlan:
          'Lorem ipsum dolor sit amet consectetur adipisicing elit. Officia ad nobis quis natus fuga quisquam similique, repellendus earum est, voluptas quasi hic unde facilis enim quas dicta adipisci! Fuga, facere?',
        responsibleContingencyMails: ['ma@gmail.com', 'maria@gmail.com'],
        state: 'inactivo',
      },
    ];
  }
}
