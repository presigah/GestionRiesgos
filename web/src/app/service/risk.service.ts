import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class RiskService {
  constructor() {}

  //se crea servicio de prueba

  getAllRisks() {
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

  getRisk(id: string) {
    return {
      id: '908098908hiaiusb',
      projectId: '908098908hiaiusb',
      name: 'Fallas en el sistema',
      userId: '6786876huigu',
      detectedDate: '12/12/2021',
      endedDate: '12/12/2021',
      labels: ['ambiental', 'etiqueta2'],
      description:
        'Lorem ipsum dolor sit amet consectetur adipisicing elit. Officia ad nobis quis natus fuga quisquam similique, repellendus earum est, voluptas quasi hic unde facilis enim quas dicta adipisci! Fuga, facere?',
      // (Abierto; mitigado; Cerrado; Problema)
      risksState: 'mitigado',
      // (Interna; Externa)
      audience: 'interna',
      // (Costo; Tiempo; Calidad)
      category: 'costo',
      // (Riesgo de producto o calidad; Riesgo de proyecto)
      riskType: 'producto',
      detailsRiskType:
        'Lorem ipsum dolor sit amet consectetur adipisicing elit. Officia ad nobis quis natus fuga quisquam similique, repellendus earum est, voluptas quasi hic unde facilis enim quas dicta adipisci! Fuga, facere?',
      probability: 60,
      impactValue: 10,
      mitigationPlan:
        'Lorem ipsum dolor sit amet consectetur adipisicing elit. Officia ad nobis quis natus fuga quisquam similique',
      responsibleMitigationMails: [
        'maria@faGlassMartiniAlt.com',
        'juan@faGlassMartiniAlt.com',
      ],
      contingencyPlan:
        'Lorem ipsum dolor sit amet consectetur adipisicing elit. Officia ad nobis quis natus fuga quisquam similique',
      responsibleContingencyMails: ['juan@gmail.com', 'maria@gmail.com'],
      Integer: 2,
    };
  }
}
