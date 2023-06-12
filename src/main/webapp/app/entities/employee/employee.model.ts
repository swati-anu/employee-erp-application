import dayjs from 'dayjs/esm';
import { IDesignation } from 'app/entities/designation/designation.model';
import { IDepartment } from 'app/entities/department/department.model';
import { IPersonalDetails } from 'app/entities/personal-details/personal-details.model';
import { IAddress } from 'app/entities/address/address.model';
import { IContacts } from 'app/entities/contacts/contacts.model';
import { IBanksDetails } from 'app/entities/banks-details/banks-details.model';
import { IFamilyInfo } from 'app/entities/family-info/family-info.model';
import { IWorkExperience } from 'app/entities/work-experience/work-experience.model';
import { IEducation } from 'app/entities/education/education.model';

export interface IEmployee {
  id: number;
  firstName?: string | null;
  middleName?: string | null;
  lastName?: string | null;
  gender?: string | null;
  empUniqueId?: string | null;
  joindate?: dayjs.Dayjs | null;
  status?: string | null;
  emailId?: string | null;
  employmentTypeId?: number | null;
  reportingEmpId?: number | null;
  companyId?: number | null;
  lastModified?: dayjs.Dayjs | null;
  lastModifiedBy?: string | null;
  designation?: Pick<IDesignation, 'id' | 'name'> | null;
  department?: Pick<IDepartment, 'id' | 'name'> | null;
  personaldetails?: Pick<IPersonalDetails, 'id'> | null;
  address?: Pick<IAddress, 'id'> | null;
  contacts?: Pick<IContacts, 'id'> | null;
  bankdetails?: Pick<IBanksDetails, 'id'> | null;
  familyinfo?: Pick<IFamilyInfo, 'id'> | null;
  workexperience?: Pick<IWorkExperience, 'id'> | null;
  education?: Pick<IEducation, 'id'> | null;
}

export type NewEmployee = Omit<IEmployee, 'id'> & { id: null };
