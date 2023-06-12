import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { finalize } from 'rxjs/operators';

import { BanksDetailsFormService, BanksDetailsFormGroup } from './banks-details-form.service';
import { IBanksDetails } from '../banks-details.model';
import { BanksDetailsService } from '../service/banks-details.service';

@Component({
  selector: 'jhi-banks-details-update',
  templateUrl: './banks-details-update.component.html',
})
export class BanksDetailsUpdateComponent implements OnInit {
  isSaving = false;
  banksDetails: IBanksDetails | null = null;

  editForm: BanksDetailsFormGroup = this.banksDetailsFormService.createBanksDetailsFormGroup();

  constructor(
    protected banksDetailsService: BanksDetailsService,
    protected banksDetailsFormService: BanksDetailsFormService,
    protected activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ banksDetails }) => {
      this.banksDetails = banksDetails;
      if (banksDetails) {
        this.updateForm(banksDetails);
      }
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const banksDetails = this.banksDetailsFormService.getBanksDetails(this.editForm);
    if (banksDetails.id !== null) {
      this.subscribeToSaveResponse(this.banksDetailsService.update(banksDetails));
    } else {
      this.subscribeToSaveResponse(this.banksDetailsService.create(banksDetails));
    }
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IBanksDetails>>): void {
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

  protected updateForm(banksDetails: IBanksDetails): void {
    this.banksDetails = banksDetails;
    this.banksDetailsFormService.resetForm(this.editForm, banksDetails);
  }
}
