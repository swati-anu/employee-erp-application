import dayjs from 'dayjs/esm';

export interface IDesignation {
  id: number;
  name?: string | null;
  departmentId?: number | null;
  status?: string | null;
  companyId?: number | null;
  lastModified?: dayjs.Dayjs | null;
  lastModifiedBy?: string | null;
}

export type NewDesignation = Omit<IDesignation, 'id'> & { id: null };
