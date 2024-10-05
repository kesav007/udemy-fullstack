import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { API_URL_RL } from '../../constants/url';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class RestaurantListingService {
  private apiUrl = API_URL_RL + '/restaurant/fetchAllRestaurants';

  constructor(private httpClient: HttpClient) {}

  getAllRestaurants(): Observable<any> {
    return this.httpClient
      .get<any>(`${this.apiUrl}`)
      .pipe(catchError(this.handleError));
  }

  private handleError(error: any) {
    return throwError(error.message || error);
  }
}
