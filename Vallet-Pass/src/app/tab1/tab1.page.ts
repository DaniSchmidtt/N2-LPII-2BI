import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NavController } from '@ionic/angular';
import { Observable } from 'rxjs';
import {valet} from '../models/valet';
@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss']
})
export class Tab1Page {

  valetRequest: Observable<any>;
  valet:valet = new valet();
  listavalet: Array<valet> = new Array<valet>();
  constructor(public navCtrl: NavController, public httpClient: HttpClient) { 
    this.valetRequest = this.httpClient.get('http://127.0.0.1:8080/FTT-WEB-091/PasswordApi');

    
    this.valetRequest
    .subscribe(data => {
      this.listavalet = data
    })
  }

}
