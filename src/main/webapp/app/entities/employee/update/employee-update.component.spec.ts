import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';
import { of, Subject, from } from 'rxjs';

import { EmployeeFormService } from './employee-form.service';
import { EmployeeService } from '../service/employee.service';
import { IEmployee } from '../employee.model';
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

import { EmployeeUpdateComponent } from './employee-update.component';

describe('Employee Management Update Component', () => {
  let comp: EmployeeUpdateComponent;
  let fixture: ComponentFixture<EmployeeUpdateComponent>;
  let activatedRoute: ActivatedRoute;
  let employeeFormService: EmployeeFormService;
  let employeeService: EmployeeService;
  let designationService: DesignationService;
  let departmentService: DepartmentService;
  let personalDetailsService: PersonalDetailsService;
  let addressService: AddressService;
  let contactsService: ContactsService;
  let banksDetailsService: BanksDetailsService;
  let familyInfoService: FamilyInfoService;
  let workExperienceService: WorkExperienceService;
  let educationService: EducationService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, RouterTestingModule.withRoutes([])],
      declarations: [EmployeeUpdateComponent],
      providers: [
        FormBuilder,
        {
          provide: ActivatedRoute,
          useValue: {
            params: from([{}]),
          },
        },
      ],
    })
      .overrideTemplate(EmployeeUpdateComponent, '')
      .compileComponents();

    fixture = TestBed.createComponent(EmployeeUpdateComponent);
    activatedRoute = TestBed.inject(ActivatedRoute);
    employeeFormService = TestBed.inject(EmployeeFormService);
    employeeService = TestBed.inject(EmployeeService);
    designationService = TestBed.inject(DesignationService);
    departmentService = TestBed.inject(DepartmentService);
    personalDetailsService = TestBed.inject(PersonalDetailsService);
    addressService = TestBed.inject(AddressService);
    contactsService = TestBed.inject(ContactsService);
    banksDetailsService = TestBed.inject(BanksDetailsService);
    familyInfoService = TestBed.inject(FamilyInfoService);
    workExperienceService = TestBed.inject(WorkExperienceService);
    educationService = TestBed.inject(EducationService);

    comp = fixture.componentInstance;
  });

  describe('ngOnInit', () => {
    it('Should call Designation query and add missing value', () => {
      const employee: IEmployee = { id: 456 };
      const designation: IDesignation = { id: 96982 };
      employee.designation = designation;

      const designationCollection: IDesignation[] = [{ id: 66817 }];
      jest.spyOn(designationService, 'query').mockReturnValue(of(new HttpResponse({ body: designationCollection })));
      const additionalDesignations = [designation];
      const expectedCollection: IDesignation[] = [...additionalDesignations, ...designationCollection];
      jest.spyOn(designationService, 'addDesignationToCollectionIfMissing').mockReturnValue(expectedCollection);

      activatedRoute.data = of({ employee });
      comp.ngOnInit();

      expect(designationService.query).toHaveBeenCalled();
      expect(designationService.addDesignationToCollectionIfMissing).toHaveBeenCalledWith(
        designationCollection,
        ...additionalDesignations.map(expect.objectContaining)
      );
      expect(comp.designationsSharedCollection).toEqual(expectedCollection);
    });

    it('Should call Department query and add missing value', () => {
      const employee: IEmployee = { id: 456 };
      const department: IDepartment = { id: 35363 };
      employee.department = department;

      const departmentCollection: IDepartment[] = [{ id: 78278 }];
      jest.spyOn(departmentService, 'query').mockReturnValue(of(new HttpResponse({ body: departmentCollection })));
      const additionalDepartments = [department];
      const expectedCollection: IDepartment[] = [...additionalDepartments, ...departmentCollection];
      jest.spyOn(departmentService, 'addDepartmentToCollectionIfMissing').mockReturnValue(expectedCollection);

      activatedRoute.data = of({ employee });
      comp.ngOnInit();

      expect(departmentService.query).toHaveBeenCalled();
      expect(departmentService.addDepartmentToCollectionIfMissing).toHaveBeenCalledWith(
        departmentCollection,
        ...additionalDepartments.map(expect.objectContaining)
      );
      expect(comp.departmentsSharedCollection).toEqual(expectedCollection);
    });

    it('Should call PersonalDetails query and add missing value', () => {
      const employee: IEmployee = { id: 456 };
      const personaldetails: IPersonalDetails = { id: 52365 };
      employee.personaldetails = personaldetails;

      const personalDetailsCollection: IPersonalDetails[] = [{ id: 2764 }];
      jest.spyOn(personalDetailsService, 'query').mockReturnValue(of(new HttpResponse({ body: personalDetailsCollection })));
      const additionalPersonalDetails = [personaldetails];
      const expectedCollection: IPersonalDetails[] = [...additionalPersonalDetails, ...personalDetailsCollection];
      jest.spyOn(personalDetailsService, 'addPersonalDetailsToCollectionIfMissing').mockReturnValue(expectedCollection);

      activatedRoute.data = of({ employee });
      comp.ngOnInit();

      expect(personalDetailsService.query).toHaveBeenCalled();
      expect(personalDetailsService.addPersonalDetailsToCollectionIfMissing).toHaveBeenCalledWith(
        personalDetailsCollection,
        ...additionalPersonalDetails.map(expect.objectContaining)
      );
      expect(comp.personalDetailsSharedCollection).toEqual(expectedCollection);
    });

    it('Should call Address query and add missing value', () => {
      const employee: IEmployee = { id: 456 };
      const address: IAddress = { id: 13224 };
      employee.address = address;

      const addressCollection: IAddress[] = [{ id: 57883 }];
      jest.spyOn(addressService, 'query').mockReturnValue(of(new HttpResponse({ body: addressCollection })));
      const additionalAddresses = [address];
      const expectedCollection: IAddress[] = [...additionalAddresses, ...addressCollection];
      jest.spyOn(addressService, 'addAddressToCollectionIfMissing').mockReturnValue(expectedCollection);

      activatedRoute.data = of({ employee });
      comp.ngOnInit();

      expect(addressService.query).toHaveBeenCalled();
      expect(addressService.addAddressToCollectionIfMissing).toHaveBeenCalledWith(
        addressCollection,
        ...additionalAddresses.map(expect.objectContaining)
      );
      expect(comp.addressesSharedCollection).toEqual(expectedCollection);
    });

    it('Should call Contacts query and add missing value', () => {
      const employee: IEmployee = { id: 456 };
      const contacts: IContacts = { id: 40775 };
      employee.contacts = contacts;

      const contactsCollection: IContacts[] = [{ id: 27783 }];
      jest.spyOn(contactsService, 'query').mockReturnValue(of(new HttpResponse({ body: contactsCollection })));
      const additionalContacts = [contacts];
      const expectedCollection: IContacts[] = [...additionalContacts, ...contactsCollection];
      jest.spyOn(contactsService, 'addContactsToCollectionIfMissing').mockReturnValue(expectedCollection);

      activatedRoute.data = of({ employee });
      comp.ngOnInit();

      expect(contactsService.query).toHaveBeenCalled();
      expect(contactsService.addContactsToCollectionIfMissing).toHaveBeenCalledWith(
        contactsCollection,
        ...additionalContacts.map(expect.objectContaining)
      );
      expect(comp.contactsSharedCollection).toEqual(expectedCollection);
    });

    it('Should call BanksDetails query and add missing value', () => {
      const employee: IEmployee = { id: 456 };
      const bankdetails: IBanksDetails = { id: 66652 };
      employee.bankdetails = bankdetails;

      const banksDetailsCollection: IBanksDetails[] = [{ id: 81111 }];
      jest.spyOn(banksDetailsService, 'query').mockReturnValue(of(new HttpResponse({ body: banksDetailsCollection })));
      const additionalBanksDetails = [bankdetails];
      const expectedCollection: IBanksDetails[] = [...additionalBanksDetails, ...banksDetailsCollection];
      jest.spyOn(banksDetailsService, 'addBanksDetailsToCollectionIfMissing').mockReturnValue(expectedCollection);

      activatedRoute.data = of({ employee });
      comp.ngOnInit();

      expect(banksDetailsService.query).toHaveBeenCalled();
      expect(banksDetailsService.addBanksDetailsToCollectionIfMissing).toHaveBeenCalledWith(
        banksDetailsCollection,
        ...additionalBanksDetails.map(expect.objectContaining)
      );
      expect(comp.banksDetailsSharedCollection).toEqual(expectedCollection);
    });

    it('Should call FamilyInfo query and add missing value', () => {
      const employee: IEmployee = { id: 456 };
      const familyinfo: IFamilyInfo = { id: 43852 };
      employee.familyinfo = familyinfo;

      const familyInfoCollection: IFamilyInfo[] = [{ id: 28668 }];
      jest.spyOn(familyInfoService, 'query').mockReturnValue(of(new HttpResponse({ body: familyInfoCollection })));
      const additionalFamilyInfos = [familyinfo];
      const expectedCollection: IFamilyInfo[] = [...additionalFamilyInfos, ...familyInfoCollection];
      jest.spyOn(familyInfoService, 'addFamilyInfoToCollectionIfMissing').mockReturnValue(expectedCollection);

      activatedRoute.data = of({ employee });
      comp.ngOnInit();

      expect(familyInfoService.query).toHaveBeenCalled();
      expect(familyInfoService.addFamilyInfoToCollectionIfMissing).toHaveBeenCalledWith(
        familyInfoCollection,
        ...additionalFamilyInfos.map(expect.objectContaining)
      );
      expect(comp.familyInfosSharedCollection).toEqual(expectedCollection);
    });

    it('Should call WorkExperience query and add missing value', () => {
      const employee: IEmployee = { id: 456 };
      const workexperience: IWorkExperience = { id: 24684 };
      employee.workexperience = workexperience;

      const workExperienceCollection: IWorkExperience[] = [{ id: 63979 }];
      jest.spyOn(workExperienceService, 'query').mockReturnValue(of(new HttpResponse({ body: workExperienceCollection })));
      const additionalWorkExperiences = [workexperience];
      const expectedCollection: IWorkExperience[] = [...additionalWorkExperiences, ...workExperienceCollection];
      jest.spyOn(workExperienceService, 'addWorkExperienceToCollectionIfMissing').mockReturnValue(expectedCollection);

      activatedRoute.data = of({ employee });
      comp.ngOnInit();

      expect(workExperienceService.query).toHaveBeenCalled();
      expect(workExperienceService.addWorkExperienceToCollectionIfMissing).toHaveBeenCalledWith(
        workExperienceCollection,
        ...additionalWorkExperiences.map(expect.objectContaining)
      );
      expect(comp.workExperiencesSharedCollection).toEqual(expectedCollection);
    });

    it('Should call Education query and add missing value', () => {
      const employee: IEmployee = { id: 456 };
      const education: IEducation = { id: 38605 };
      employee.education = education;

      const educationCollection: IEducation[] = [{ id: 88242 }];
      jest.spyOn(educationService, 'query').mockReturnValue(of(new HttpResponse({ body: educationCollection })));
      const additionalEducations = [education];
      const expectedCollection: IEducation[] = [...additionalEducations, ...educationCollection];
      jest.spyOn(educationService, 'addEducationToCollectionIfMissing').mockReturnValue(expectedCollection);

      activatedRoute.data = of({ employee });
      comp.ngOnInit();

      expect(educationService.query).toHaveBeenCalled();
      expect(educationService.addEducationToCollectionIfMissing).toHaveBeenCalledWith(
        educationCollection,
        ...additionalEducations.map(expect.objectContaining)
      );
      expect(comp.educationsSharedCollection).toEqual(expectedCollection);
    });

    it('Should update editForm', () => {
      const employee: IEmployee = { id: 456 };
      const designation: IDesignation = { id: 92741 };
      employee.designation = designation;
      const department: IDepartment = { id: 60127 };
      employee.department = department;
      const personaldetails: IPersonalDetails = { id: 452 };
      employee.personaldetails = personaldetails;
      const address: IAddress = { id: 74055 };
      employee.address = address;
      const contacts: IContacts = { id: 86209 };
      employee.contacts = contacts;
      const bankdetails: IBanksDetails = { id: 99038 };
      employee.bankdetails = bankdetails;
      const familyinfo: IFamilyInfo = { id: 90043 };
      employee.familyinfo = familyinfo;
      const workexperience: IWorkExperience = { id: 5596 };
      employee.workexperience = workexperience;
      const education: IEducation = { id: 18220 };
      employee.education = education;

      activatedRoute.data = of({ employee });
      comp.ngOnInit();

      expect(comp.designationsSharedCollection).toContain(designation);
      expect(comp.departmentsSharedCollection).toContain(department);
      expect(comp.personalDetailsSharedCollection).toContain(personaldetails);
      expect(comp.addressesSharedCollection).toContain(address);
      expect(comp.contactsSharedCollection).toContain(contacts);
      expect(comp.banksDetailsSharedCollection).toContain(bankdetails);
      expect(comp.familyInfosSharedCollection).toContain(familyinfo);
      expect(comp.workExperiencesSharedCollection).toContain(workexperience);
      expect(comp.educationsSharedCollection).toContain(education);
      expect(comp.employee).toEqual(employee);
    });
  });

  describe('save', () => {
    it('Should call update service on save for existing entity', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<IEmployee>>();
      const employee = { id: 123 };
      jest.spyOn(employeeFormService, 'getEmployee').mockReturnValue(employee);
      jest.spyOn(employeeService, 'update').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ employee });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.next(new HttpResponse({ body: employee }));
      saveSubject.complete();

      // THEN
      expect(employeeFormService.getEmployee).toHaveBeenCalled();
      expect(comp.previousState).toHaveBeenCalled();
      expect(employeeService.update).toHaveBeenCalledWith(expect.objectContaining(employee));
      expect(comp.isSaving).toEqual(false);
    });

    it('Should call create service on save for new entity', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<IEmployee>>();
      const employee = { id: 123 };
      jest.spyOn(employeeFormService, 'getEmployee').mockReturnValue({ id: null });
      jest.spyOn(employeeService, 'create').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ employee: null });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.next(new HttpResponse({ body: employee }));
      saveSubject.complete();

      // THEN
      expect(employeeFormService.getEmployee).toHaveBeenCalled();
      expect(employeeService.create).toHaveBeenCalled();
      expect(comp.isSaving).toEqual(false);
      expect(comp.previousState).toHaveBeenCalled();
    });

    it('Should set isSaving to false on error', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<IEmployee>>();
      const employee = { id: 123 };
      jest.spyOn(employeeService, 'update').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ employee });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.error('This is an error!');

      // THEN
      expect(employeeService.update).toHaveBeenCalled();
      expect(comp.isSaving).toEqual(false);
      expect(comp.previousState).not.toHaveBeenCalled();
    });
  });

  describe('Compare relationships', () => {
    describe('compareDesignation', () => {
      it('Should forward to designationService', () => {
        const entity = { id: 123 };
        const entity2 = { id: 456 };
        jest.spyOn(designationService, 'compareDesignation');
        comp.compareDesignation(entity, entity2);
        expect(designationService.compareDesignation).toHaveBeenCalledWith(entity, entity2);
      });
    });

    describe('compareDepartment', () => {
      it('Should forward to departmentService', () => {
        const entity = { id: 123 };
        const entity2 = { id: 456 };
        jest.spyOn(departmentService, 'compareDepartment');
        comp.compareDepartment(entity, entity2);
        expect(departmentService.compareDepartment).toHaveBeenCalledWith(entity, entity2);
      });
    });

    describe('comparePersonalDetails', () => {
      it('Should forward to personalDetailsService', () => {
        const entity = { id: 123 };
        const entity2 = { id: 456 };
        jest.spyOn(personalDetailsService, 'comparePersonalDetails');
        comp.comparePersonalDetails(entity, entity2);
        expect(personalDetailsService.comparePersonalDetails).toHaveBeenCalledWith(entity, entity2);
      });
    });

    describe('compareAddress', () => {
      it('Should forward to addressService', () => {
        const entity = { id: 123 };
        const entity2 = { id: 456 };
        jest.spyOn(addressService, 'compareAddress');
        comp.compareAddress(entity, entity2);
        expect(addressService.compareAddress).toHaveBeenCalledWith(entity, entity2);
      });
    });

    describe('compareContacts', () => {
      it('Should forward to contactsService', () => {
        const entity = { id: 123 };
        const entity2 = { id: 456 };
        jest.spyOn(contactsService, 'compareContacts');
        comp.compareContacts(entity, entity2);
        expect(contactsService.compareContacts).toHaveBeenCalledWith(entity, entity2);
      });
    });

    describe('compareBanksDetails', () => {
      it('Should forward to banksDetailsService', () => {
        const entity = { id: 123 };
        const entity2 = { id: 456 };
        jest.spyOn(banksDetailsService, 'compareBanksDetails');
        comp.compareBanksDetails(entity, entity2);
        expect(banksDetailsService.compareBanksDetails).toHaveBeenCalledWith(entity, entity2);
      });
    });

    describe('compareFamilyInfo', () => {
      it('Should forward to familyInfoService', () => {
        const entity = { id: 123 };
        const entity2 = { id: 456 };
        jest.spyOn(familyInfoService, 'compareFamilyInfo');
        comp.compareFamilyInfo(entity, entity2);
        expect(familyInfoService.compareFamilyInfo).toHaveBeenCalledWith(entity, entity2);
      });
    });

    describe('compareWorkExperience', () => {
      it('Should forward to workExperienceService', () => {
        const entity = { id: 123 };
        const entity2 = { id: 456 };
        jest.spyOn(workExperienceService, 'compareWorkExperience');
        comp.compareWorkExperience(entity, entity2);
        expect(workExperienceService.compareWorkExperience).toHaveBeenCalledWith(entity, entity2);
      });
    });

    describe('compareEducation', () => {
      it('Should forward to educationService', () => {
        const entity = { id: 123 };
        const entity2 = { id: 456 };
        jest.spyOn(educationService, 'compareEducation');
        comp.compareEducation(entity, entity2);
        expect(educationService.compareEducation).toHaveBeenCalledWith(entity, entity2);
      });
    });
  });
});
