import dayjs from 'dayjs/esm';

export interface IDepartment {
  id: number;
  name?: string | null;
  status?: string | null;
  companyId?: number | null;
  lastModified?: dayjs.Dayjs | null;
  lastModifiedBy?: string | null;
}

export type NewDepartment = Omit<IDepartment, 'id'> & { id: null };
