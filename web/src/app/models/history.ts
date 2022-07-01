import { Project } from './project'

export interface History {
    id: string;
    dateTime: Date;
    project: [Project]
}