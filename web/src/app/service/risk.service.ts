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
        idProyecto: '62a68211957b637d63566901',
        nombreProyecto: 'nombreProyecto',
        nombreRiesgo: 'Fallas en el sistema',
        fechaDetencion: '12/12/2021',
        fechaCierre: '12/24/2021',
        etiqueta: 'etiqueta',
        descripcion:
          'Lorem ipsum dolor sit amet consectetur adipisicing elit. Officia ad nobis quis natus fuga quisquam similique',
        estado: 'mitigado',
        audiencia: 'interna',
        categoria: 'calidad',
        tipo: 'riesgo de proyecto',
        detalles:
          'Lorem ipsum dolor sit amet consectetur adipisicing elit. Officia ad nobis quis natus fuga quisquam similique, repellendus earum est, voluptas quasi hic unde facilis enim quas dicta adipisci! Fuga, facere?',
        ProbabilidadDeOcurrencia: 20,
        valorImpacto: 30,
        planMitigacion:
          'Lorem ipsum dolor sit amet consectetur adipisicing elit. Officia ad nobis quis natus fuga quisquam similique, repellendus earum est, voluptas quasi hic unde facilis enim quas dicta adipisci! Fuga, facere?',
        responsablesMitigacion: ['ma@gmail.com', 'maria@gmail.com'],
        planContingencia:
          'Lorem ipsum dolor sit amet consectetur adipisicing elit. Officia ad nobis quis natus fuga quisquam similique, repellendus earum est, voluptas quasi hic unde facilis enim quas dicta adipisci! Fuga, facere?',
        responsablesContingencias: ['ma@gmail.com', 'maria@gmail.com'],
        criticidad: 'bajo',
        estadoDeVida: 'alto',
      },
      {
        id: '62a6964bb88b437b1dfe1503',
        idProyecto: '62a6964bbdsd437b1dfe1503',
        nombreProyecto: 'nombreProyecto2',
        nombreRiesgo: 'Retrasos en la entrega',
        fechaDetencion: '12/12/2021',
        fechaCierre: '12/24/2021',
        etiqueta: 'etiqueta',
        descripcion:
          'Lorem ipsum dolor sit amet consectetur adipisicing elit. Officia ad nobis quis natus fuga quisquam similique',
        estado: 'mitigado',
        audiencia: 'interna',
        categoria: 'calidad',
        tipo: 'riesgo de proyecto',
        detalles:
          'Lorem ipsum dolor sit amet consectetur adipisicing elit. Officia ad nobis quis natus fuga quisquam similique, repellendus earum est, voluptas quasi hic unde facilis enim quas dicta adipisci! Fuga, facere?',
        ProbabilidadDeOcurrencia: 70,
        valorImpacto: 50,
        planMitigacion:
          'Lorem ipsum dolor sit amet consectetur adipisicing elit. Officia ad nobis quis natus fuga quisquam similique, repellendus earum est, voluptas quasi hic unde facilis enim quas dicta adipisci! Fuga, facere?',
        responsablesMitigacion: ['ma@gmail.com', 'maria@gmail.com'],
        planContingencia:
          'Lorem ipsum dolor sit amet consectetur adipisicing elit. Officia ad nobis quis natus fuga quisquam similique, repellendus earum est, voluptas quasi hic unde facilis enim quas dicta adipisci! Fuga, facere?',
        responsablesContingencias: ['ma@gmail.com', 'maria@gmail.com'],
        criticidad: 'bajo',
        estadoDeVida: 'alto',
      },
    ];
  }
}
