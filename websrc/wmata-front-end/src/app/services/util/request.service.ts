import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

@Injectable({providedIn: 'root'})
export class RequestService {
    constructor(private http: HttpClient) {}

    public get(endpoint: string) {
        this.http.get(endpoint).subscribe(test => {
            return test;
        })
    }
}