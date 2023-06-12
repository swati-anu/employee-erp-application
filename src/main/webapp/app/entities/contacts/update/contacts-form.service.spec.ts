import { TestBed } from '@angular/core/testing';

import { sampleWithRequiredData, sampleWithNewData } from '../contacts.test-samples';

import { ContactsFormService } from './contacts-form.service';

describe('Contacts Form Service', () => {
  let service: ContactsFormService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ContactsFormService);
  });

  describe('Service methods', () => {
    describe('createContactsFormGroup', () => {
      it('should create a new form with FormControl', () => {
        const formGroup = service.createContactsFormGroup();

        expect(formGroup.controls).toEqual(
          expect.objectContaining({
            id: expect.any(Object),
            name: expect.any(Object),
            contactPref: expect.any(Object),
            contactType: expect.any(Object),
            contact: expect.any(Object),
            refTable: expect.any(Object),
            refTableId: expect.any(Object),
            companyId: expect.any(Object),
            status: expect.any(Object),
            lastModified: expect.any(Object),
            lastModifiedBy: expect.any(Object),
            contactReference: expect.any(Object),
          })
        );
      });

      it('passing IContacts should create a new form with FormGroup', () => {
        const formGroup = service.createContactsFormGroup(sampleWithRequiredData);

        expect(formGroup.controls).toEqual(
          expect.objectContaining({
            id: expect.any(Object),
            name: expect.any(Object),
            contactPref: expect.any(Object),
            contactType: expect.any(Object),
            contact: expect.any(Object),
            refTable: expect.any(Object),
            refTableId: expect.any(Object),
            companyId: expect.any(Object),
            status: expect.any(Object),
            lastModified: expect.any(Object),
            lastModifiedBy: expect.any(Object),
            contactReference: expect.any(Object),
          })
        );
      });
    });

    describe('getContacts', () => {
      it('should return NewContacts for default Contacts initial value', () => {
        // eslint-disable-next-line @typescript-eslint/no-unused-vars
        const formGroup = service.createContactsFormGroup(sampleWithNewData);

        const contacts = service.getContacts(formGroup) as any;

        expect(contacts).toMatchObject(sampleWithNewData);
      });

      it('should return NewContacts for empty Contacts initial value', () => {
        const formGroup = service.createContactsFormGroup();

        const contacts = service.getContacts(formGroup) as any;

        expect(contacts).toMatchObject({});
      });

      it('should return IContacts', () => {
        const formGroup = service.createContactsFormGroup(sampleWithRequiredData);

        const contacts = service.getContacts(formGroup) as any;

        expect(contacts).toMatchObject(sampleWithRequiredData);
      });
    });

    describe('resetForm', () => {
      it('passing IContacts should not enable id FormControl', () => {
        const formGroup = service.createContactsFormGroup();
        expect(formGroup.controls.id.disabled).toBe(true);

        service.resetForm(formGroup, sampleWithRequiredData);

        expect(formGroup.controls.id.disabled).toBe(true);
      });

      it('passing NewContacts should disable id FormControl', () => {
        const formGroup = service.createContactsFormGroup(sampleWithRequiredData);
        expect(formGroup.controls.id.disabled).toBe(true);

        service.resetForm(formGroup, { id: null });

        expect(formGroup.controls.id.disabled).toBe(true);
      });
    });
  });
});
