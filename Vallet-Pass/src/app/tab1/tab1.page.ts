import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NavController } from '@ionic/angular';
import { Observable } from 'rxjs';
import { valet } from '../models/valet';
@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss']
})
export class Tab1Page {

  valetRequest: Observable<any>;
  valet: valet = new valet()
  constructor(public navCtrl: NavController, public httpClient: HttpClient) {
    this.valetRequest = this.httpClient.get('https://fakerapi.it/api/v1/users?_quantity=2&_gender=male');


    this.valetRequest
      .subscribe(data => {
        this.valet = data
        console.log(data)
        console.log(this.valet)
      })
  }
}
