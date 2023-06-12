import dayjs from 'dayjs/esm';

import { IWorkExperience, NewWorkExperience } from './work-experience.model';

export const sampleWithRequiredData: IWorkExperience = {
  id: 92187,
};

export const sampleWithPartialData: IWorkExperience = {
  id: 10295,
  jobTitle: 'Legacy Assurance Orchestrator',
  companyName: 'overriding France',
  lastModifiedBy: 'proactive',
};

export const sampleWithFullData: IWorkExperience = {
  id: 70973,
  jobTitle: 'Global Interactions Director',
  companyName: 'Computer',
  startDate: dayjs('2023-06-11T21:17'),
  endDate: dayjs('2023-06-11T23:11'),
  addressId: 95881,
  employeeId: 69234,
  jobDesc: 'monitor',
  status: 'matrix',
  companyId: 91151,
  lastModified: dayjs('2023-06-11T11:38'),
  lastModifiedBy: 'Quality',
};

export const sampleWithNewData: NewWorkExperience = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
