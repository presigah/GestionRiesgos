import { Project } from './project'

export interface History {
    id: string;
    dateTiem: Date;
    project: [Project]
}