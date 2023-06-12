import dayjs from 'dayjs/esm';

import { IDepartment, NewDepartment } from './department.model';

export const sampleWithRequiredData: IDepartment = {
  id: 39095,
};

export const sampleWithPartialData: IDepartment = {
  id: 8019,
  name: 'Cheese encryption Tuna',
  companyId: 44144,
  lastModified: dayjs('2023-06-11T22:33'),
};

export const sampleWithFullData: IDepartment = {
  id: 20843,
  name: 'Morocco',
  status: 'Facilitator',
  companyId: 74996,
  lastModified: dayjs('2023-06-12T01:28'),
  lastModifiedBy: 'engineer Hat best-of-breed',
};

export const sampleWithNewData: NewDepartment = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
