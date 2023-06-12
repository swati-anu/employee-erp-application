import dayjs from 'dayjs/esm';

import { IPersonalDetails, NewPersonalDetails } from './personal-details.model';

export const sampleWithRequiredData: IPersonalDetails = {
  id: 97979,
};

export const sampleWithPartialData: IPersonalDetails = {
  id: 72500,
  nationality: 'Incredible Cliff programming',
  employeeId: 99542,
  companyId: 8416,
  bloodGroup: 'secured',
  dateOfBirth: dayjs('2023-06-11'),
  status: 'Cotton Communications',
  lastModified: dayjs('2023-06-11T17:37'),
  lastModifiedBy: 'input leverage',
};

export const sampleWithFullData: IPersonalDetails = {
  id: 6200,
  telephoneNo: 'haptic',
  nationality: 'Bike Avon',
  maritalStatus: 'Rwanda open-source Fresh',
  religion: 'policy Island withdrawal',
  employeeId: 12155,
  companyId: 35108,
  bloodGroup: 'Handmade quantify',
  dateOfBirth: dayjs('2023-06-12'),
  status: 'Diverse',
  lastModified: dayjs('2023-06-11T21:17'),
  lastModifiedBy: 'Jamaican Computers',
};

export const sampleWithNewData: NewPersonalDetails = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
