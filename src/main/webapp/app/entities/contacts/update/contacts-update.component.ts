import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { finalize } from 'rxjs/operators';

import { ContactsFormService, ContactsFormGroup } from './contacts-form.service';
import { IContacts } from '../contacts.model';
import { ContactsService } from '../service/contacts.service';

@Component({
  selector: 'jhi-contacts-update',
  templateUrl: './contacts-update.component.html',
})
export class ContactsUpdateComponent implements OnInit {
  isSaving = false;
  contacts: IContacts | null = null;

  editForm: ContactsFormGroup = this.contactsFormService.createContactsFormGroup();

  constructor(
    protected contactsService: ContactsService,
    protected contactsFormService: ContactsFormService,
    protected activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ contacts }) => {
      this.contacts = contacts;
      if (contacts) {
        this.updateForm(contacts);
      }
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const contacts = this.contactsFormService.getContacts(this.editForm);
    if (contacts.id !== null) {
      this.subscribeToSaveResponse(this.contactsService.update(contacts));
    } else {
      this.subscribeToSaveResponse(this.contactsService.create(contacts));
    }
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IContacts>>): void {
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

  protected updateForm(contacts: IContacts): void {
    this.contacts = contacts;
    this.contactsFormService.resetForm(this.editForm, contacts);
  }
}
