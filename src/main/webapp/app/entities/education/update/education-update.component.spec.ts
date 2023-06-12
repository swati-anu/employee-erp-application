import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';
import { of, Subject, from } from 'rxjs';

import { EducationFormService } from './education-form.service';
import { EducationService } from '../service/education.service';
import { IEducation } from '../education.model';

import { EducationUpdateComponent } from './education-update.component';

describe('Education Management Update Component', () => {
  let comp: EducationUpdateComponent;
  let fixture: ComponentFixture<EducationUpdateComponent>;
  let activatedRoute: ActivatedRoute;
  let educationFormService: EducationFormService;
  let educationService: EducationService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, RouterTestingModule.withRoutes([])],
      declarations: [EducationUpdateComponent],
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
      .overrideTemplate(EducationUpdateComponent, '')
      .compileComponents();

    fixture = TestBed.createComponent(EducationUpdateComponent);
    activatedRoute = TestBed.inject(ActivatedRoute);
    educationFormService = TestBed.inject(EducationFormService);
    educationService = TestBed.inject(EducationService);

    comp = fixture.componentInstance;
  });

  describe('ngOnInit', () => {
    it('Should update editForm', () => {
      const education: IEducation = { id: 456 };

      activatedRoute.data = of({ education });
      comp.ngOnInit();

      expect(comp.education).toEqual(education);
    });
  });

  describe('save', () => {
    it('Should call update service on save for existing entity', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<IEducation>>();
      const education = { id: 123 };
      jest.spyOn(educationFormService, 'getEducation').mockReturnValue(education);
      jest.spyOn(educationService, 'update').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ education });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.next(new HttpResponse({ body: education }));
      saveSubject.complete();

      // THEN
      expect(educationFormService.getEducation).toHaveBeenCalled();
      expect(comp.previousState).toHaveBeenCalled();
      expect(educationService.update).toHaveBeenCalledWith(expect.objectContaining(education));
      expect(comp.isSaving).toEqual(false);
    });

    it('Should call create service on save for new entity', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<IEducation>>();
      const education = { id: 123 };
      jest.spyOn(educationFormService, 'getEducation').mockReturnValue({ id: null });
      jest.spyOn(educationService, 'create').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ education: null });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.next(new HttpResponse({ body: education }));
      saveSubject.complete();

      // THEN
      expect(educationFormService.getEducation).toHaveBeenCalled();
      expect(educationService.create).toHaveBeenCalled();
      expect(comp.isSaving).toEqual(false);
      expect(comp.previousState).toHaveBeenCalled();
    });

    it('Should set isSaving to false on error', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<IEducation>>();
      const education = { id: 123 };
      jest.spyOn(educationService, 'update').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ education });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.error('This is an error!');

      // THEN
      expect(educationService.update).toHaveBeenCalled();
      expect(comp.isSaving).toEqual(false);
      expect(comp.previousState).not.toHaveBeenCalled();
    });
  });
});
