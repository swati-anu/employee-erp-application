import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'employee',
        data: { pageTitle: 'Employees' },
        loadChildren: () => import('./employee/employee.module').then(m => m.EmployeeModule),
      },
      {
        path: 'personal-details',
        data: { pageTitle: 'PersonalDetails' },
        loadChildren: () => import('./personal-details/personal-details.module').then(m => m.PersonalDetailsModule),
      },
      {
        path: 'family-info',
        data: { pageTitle: 'FamilyInfos' },
        loadChildren: () => import('./family-info/family-info.module').then(m => m.FamilyInfoModule),
      },
      {
        path: 'address',
        data: { pageTitle: 'Addresses' },
        loadChildren: () => import('./address/address.module').then(m => m.AddressModule),
      },
      {
        path: 'contacts',
        data: { pageTitle: 'Contacts' },
        loadChildren: () => import('./contacts/contacts.module').then(m => m.ContactsModule),
      },
      {
        path: 'department',
        data: { pageTitle: 'Departments' },
        loadChildren: () => import('./department/department.module').then(m => m.DepartmentModule),
      },
      {
        path: 'designation',
        data: { pageTitle: 'Designations' },
        loadChildren: () => import('./designation/designation.module').then(m => m.DesignationModule),
      },
      {
        path: 'banks-details',
        data: { pageTitle: 'BanksDetails' },
        loadChildren: () => import('./banks-details/banks-details.module').then(m => m.BanksDetailsModule),
      },
      {
        path: 'education',
        data: { pageTitle: 'Educations' },
        loadChildren: () => import('./education/education.module').then(m => m.EducationModule),
      },
      {
        path: 'work-experience',
        data: { pageTitle: 'WorkExperiences' },
        loadChildren: () => import('./work-experience/work-experience.module').then(m => m.WorkExperienceModule),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class EntityRoutingModule {}
