import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { mergeMap } from 'rxjs/operators';

import { IPersonalDetails } from '../personal-details.model';
import { PersonalDetailsService } from '../service/personal-details.service';

@Injectable({ providedIn: 'root' })
export class PersonalDetailsRoutingResolveService implements Resolve<IPersonalDetails | null> {
  constructor(protected service: PersonalDetailsService, protected router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IPersonalDetails | null | never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        mergeMap((personalDetails: HttpResponse<IPersonalDetails>) => {
          if (personalDetails.body) {
            return of(personalDetails.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(null);
  }
}
