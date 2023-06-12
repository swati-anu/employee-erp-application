import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { finalize, map } from 'rxjs/operators';

import { EmployeeFormService, EmployeeFormGroup } from './employee-form.service';
import { IEmployee } from '../employee.model';
import { EmployeeService } from '../service/employee.service';
import { IDesignation } from 'app/entities/designation/designation.model';
import { DesignationService } from 'app/entities/designation/service/designation.service';
import { IDepartment } from 'app/entities/department/department.model';
import { DepartmentService } from 'app/entities/department/service/department.service';
import { IPersonalDetails } from 'app/entities/personal-details/personal-details.model';
import { PersonalDetailsService } from 'app/entities/personal-details/service/personal-details.service';
import { IAddress } from 'app/entities/address/address.model';
import { AddressService } from 'app/entities/address/service/address.service';
import { IContacts } from 'app/entities/contacts/contacts.model';
import { ContactsService } from 'app/entities/contacts/service/contacts.service';
import { IBanksDetails } from 'app/entities/banks-details/banks-details.model';
import { BanksDetailsService } from 'app/entities/banks-details/service/banks-details.service';
import { IFamilyInfo } from 'app/entities/family-info/family-info.model';
import { FamilyInfoService } from 'app/entities/family-info/service/family-info.service';
import { IWorkExperience } from 'app/entities/work-experience/work-experience.model';
import { WorkExperienceService } from 'app/entities/work-experience/service/work-experience.service';
import { IEducation } from 'app/entities/education/education.model';
import { EducationService } from 'app/entities/education/service/education.service';

@Component({
  selector: 'jhi-employee-update',
  templateUrl: './employee-update.component.html',
})
export class EmployeeUpdateComponent implements OnInit {
  isSaving = false;
  employee: IEmployee | null = null;

  designationsSharedCollection: IDesignation[] = [];
  departmentsSharedCollection: IDepartment[] = [];
  personalDetailsSharedCollection: IPersonalDetails[] = [];
  addressesSharedCollection: IAddress[] = [];
  contactsSharedCollection: IContacts[] = [];
  banksDetailsSharedCollection: IBanksDetails[] = [];
  familyInfosSharedCollection: IFamilyInfo[] = [];
  workExperiencesSharedCollection: IWorkExperience[] = [];
  educationsSharedCollection: IEducation[] = [];

  editForm: EmployeeFormGroup = this.employeeFormService.createEmployeeFormGroup();

  constructor(
    protected employeeService: EmployeeService,
    protected employeeFormService: EmployeeFormService,
    protected designationService: DesignationService,
    protected departmentService: DepartmentService,
    protected personalDetailsService: PersonalDetailsService,
    protected addressService: AddressService,
    protected contactsService: ContactsService,
    protected banksDetailsService: BanksDetailsService,
    protected familyInfoService: FamilyInfoService,
    protected workExperienceService: WorkExperienceService,
    protected educationService: EducationService,
    protected activatedRoute: ActivatedRoute
  ) {}

  compareDesignation = (o1: IDesignation | null, o2: IDesignation | null): boolean => this.designationService.compareDesignation(o1, o2);

  compareDepartment = (o1: IDepartment | null, o2: IDepartment | null): boolean => this.departmentService.compareDepartment(o1, o2);

  comparePersonalDetails = (o1: IPersonalDetails | null, o2: IPersonalDetails | null): boolean =>
    this.personalDetailsService.comparePersonalDetails(o1, o2);

  compareAddress = (o1: IAddress | null, o2: IAddress | null): boolean => this.addressService.compareAddress(o1, o2);

  compareContacts = (o1: IContacts | null, o2: IContacts | null): boolean => this.contactsService.compareContacts(o1, o2);

  compareBanksDetails = (o1: IBanksDetails | null, o2: IBanksDetails | null): boolean =>
    this.banksDetailsService.compareBanksDetails(o1, o2);

  compareFamilyInfo = (o1: IFamilyInfo | null, o2: IFamilyInfo | null): boolean => this.familyInfoService.compareFamilyInfo(o1, o2);

  compareWorkExperience = (o1: IWorkExperience | null, o2: IWorkExperience | null): boolean =>
    this.workExperienceService.compareWorkExperience(o1, o2);

  compareEducation = (o1: IEducation | null, o2: IEducation | null): boolean => this.educationService.compareEducation(o1, o2);

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ employee }) => {
      this.employee = employee;
      if (employee) {
        this.updateForm(employee);
      }

      this.loadRelationshipsOptions();
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const employee = this.employeeFormService.getEmployee(this.editForm);
    if (employee.id !== null) {
      this.subscribeToSaveResponse(this.employeeService.update(employee));
    } else {
      this.subscribeToSaveResponse(this.employeeService.create(employee));
    }
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IEmployee>>): void {
    result.pipe(finalize(() => this.onSaveFinalize())).subscribe({
      next: () => this.onSaveSuccess(),
      error: () => this.onSaveError(),
    });
  }

  protected onSaveSuccess(): void {
    this.previousState();
  }

  protected onSaveError(): void {
    // Api for inheritance.
  }

  protected onSaveFinalize(): void {
    this.isSaving = false;
  }

  protected updateForm(employee: IEmployee): void {
    this.employee = employee;
    this.employeeFormService.resetForm(this.editForm, employee);

    this.designationsSharedCollection = this.designationService.addDesignationToCollectionIfMissing<IDesignation>(
      this.designationsSharedCollection,
      employee.designation
    );
    this.departmentsSharedCollection = this.departmentService.addDepartmentToCollectionIfMissing<IDepartment>(
      this.departmentsSharedCollection,
      employee.department
    );
    this.personalDetailsSharedCollection = this.personalDetailsService.addPersonalDetailsToCollectionIfMissing<IPersonalDetails>(
      this.personalDetailsSharedCollection,
      employee.personaldetails
    );
    this.addressesSharedCollection = this.addressService.addAddressToCollectionIfMissing<IAddress>(
      this.addressesSharedCollection,
      employee.address
    );
    this.contactsSharedCollection = this.contactsService.addContactsToCollectionIfMissing<IContacts>(
      this.contactsSharedCollection,
      employee.contacts
    );
    this.banksDetailsSharedCollection = this.banksDetailsService.addBanksDetailsToCollectionIfMissing<IBanksDetails>(
      this.banksDetailsSharedCollection,
      employee.bankdetails
    );
    this.familyInfosSharedCollection = this.familyInfoService.addFamilyInfoToCollectionIfMissing<IFamilyInfo>(
      this.familyInfosSharedCollection,
      employee.familyinfo
    );
    this.workExperiencesSharedCollection = this.workExperienceService.addWorkExperienceToCollectionIfMissing<IWorkExperience>(
      this.workExperiencesSharedCollection,
      employee.workexperience
    );
    this.educationsSharedCollection = this.educationService.addEducationToCollectionIfMissing<IEducation>(
      this.educationsSharedCollection,
      employee.education
    );
  }

  protected loadRelationshipsOptions(): void {
    this.designationService
      .query()
      .pipe(map((res: HttpResponse<IDesignation[]>) => res.body ?? []))
      .pipe(
        map((designations: IDesignation[]) =>
          this.designationService.addDesignationToCollectionIfMissing<IDesignation>(designations, this.employee?.designation)
        )
      )
      .subscribe((designations: IDesignation[]) => (this.designationsSharedCollection = designations));

    this.departmentService
      .query()
      .pipe(map((res: HttpResponse<IDepartment[]>) => res.body ?? []))
      .pipe(
        map((departments: IDepartment[]) =>
          this.departmentService.addDepartmentToCollectionIfMissing<IDepartment>(departments, this.employee?.department)
        )
      )
      .subscribe((departments: IDepartment[]) => (this.departmentsSharedCollection = departments));

    this.personalDetailsService
      .query()
      .pipe(map((res: HttpResponse<IPersonalDetails[]>) => res.body ?? []))
      .pipe(
        map((personalDetails: IPersonalDetails[]) =>
          this.personalDetailsService.addPersonalDetailsToCollectionIfMissing<IPersonalDetails>(
            personalDetails,
            this.employee?.personaldetails
          )
        )
      )
      .subscribe((personalDetails: IPersonalDetails[]) => (this.personalDetailsSharedCollection = personalDetails));

    this.addressService
      .query()
      .pipe(map((res: HttpResponse<IAddress[]>) => res.body ?? []))
      .pipe(
        map((addresses: IAddress[]) => this.addressService.addAddressToCollectionIfMissing<IAddress>(addresses, this.employee?.address))
      )
      .subscribe((addresses: IAddress[]) => (this.addressesSharedCollection = addresses));

    this.contactsService
      .query()
      .pipe(map((res: HttpResponse<IContacts[]>) => res.body ?? []))
      .pipe(
        map((contacts: IContacts[]) => this.contactsService.addContactsToCollectionIfMissing<IContacts>(contacts, this.employee?.contacts))
      )
      .subscribe((contacts: IContacts[]) => (this.contactsSharedCollection = contacts));

    this.banksDetailsService
      .query()
      .pipe(map((res: HttpResponse<IBanksDetails[]>) => res.body ?? []))
      .pipe(
        map((banksDetails: IBanksDetails[]) =>
          this.banksDetailsService.addBanksDetailsToCollectionIfMissing<IBanksDetails>(banksDetails, this.employee?.bankdetails)
        )
      )
      .subscribe((banksDetails: IBanksDetails[]) => (this.banksDetailsSharedCollection = banksDetails));

    this.familyInfoService
      .query()
      .pipe(map((res: HttpResponse<IFamilyInfo[]>) => res.body ?? []))
      .pipe(
        map((familyInfos: IFamilyInfo[]) =>
          this.familyInfoService.addFamilyInfoToCollectionIfMissing<IFamilyInfo>(familyInfos, this.employee?.familyinfo)
        )
      )
      .subscribe((familyInfos: IFamilyInfo[]) => (this.familyInfosSharedCollection = familyInfos));

    this.workExperienceService
      .query()
      .pipe(map((res: HttpResponse<IWorkExperience[]>) => res.body ?? []))
      .pipe(
        map((workExperiences: IWorkExperience[]) =>
          this.workExperienceService.addWorkExperienceToCollectionIfMissing<IWorkExperience>(workExperiences, this.employee?.workexperience)
        )
      )
      .subscribe((workExperiences: IWorkExperience[]) => (this.workExperiencesSharedCollection = workExperiences));

    this.educationService
      .query()
      .pipe(map((res: HttpResponse<IEducation[]>) => res.body ?? []))
      .pipe(
        map((educations: IEducation[]) =>
          this.educationService.addEducationToCollectionIfMissing<IEducation>(educations, this.employee?.education)
        )
      )
      .subscribe((educations: IEducation[]) => (this.educationsSharedCollection = educations));
  }
}
