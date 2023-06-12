import dayjs from 'dayjs/esm';

import { IDesignation, NewDesignation } from './designation.model';

export const sampleWithRequiredData: IDesignation = {
  id: 18278,
};

export const sampleWithPartialData: IDesignation = {
  id: 20362,
  name: 'contingency Officer',
  status: 'content-based Infrastructure',
  lastModified: dayjs('2023-06-12T05:29'),
};

export const sampleWithFullData: IDesignation = {
  id: 28375,
  name: 'architect THX',
  departmentId: 50838,
  status: 'generate connect',
  companyId: 21165,
  lastModified: dayjs('2023-06-11T18:13'),
  lastModifiedBy: 'silver synergy real-time',
};

export const sampleWithNewData: NewDesignation = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
