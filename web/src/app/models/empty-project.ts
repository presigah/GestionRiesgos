export interface EmptyProject {
    id: string;
    name: string;
    startDate: Date;
    endingDate: Date;
    labels: [string];
    emails: [string];
    description: string;
    risks: [any];
}