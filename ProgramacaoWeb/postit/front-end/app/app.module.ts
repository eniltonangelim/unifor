import { NgModule }      	            from '@angular/core';
import { BrowserModule }	            from '@angular/platform-browser';
import { FormsModule }   	            from '@angular/forms';
import { HttpModule }    	            from '@angular/http';
//import { ScheduleModule }             from 'primeng/primeng';
import { routing }                    from './app.routing';

/*Teste*/
import { InMemoryWebApiModule }       from 'angular2-in-memory-web-api';
//import { InMemoryDataService }        from './service/in.memory.data-service';

/*Component*/
import { AppComponent }   from './app.component';

/*Service*/

/*Login*/
import { LoggedInGuard }              from './logged-in.guard';

/*Material designer*/
//import {MdCardModule} from '@angular2-material/card';
import {MaterialModule}     from '@angular/material';

@NgModule({
  imports:      [ 
  	BrowserModule, FormsModule,
  	HttpModule, InMemoryWebApiModule.forRoot(InMemoryDataService),
  	routing, //MdCardModule,
    MaterialModule.forRoot()

  ],
  declarations: [ ],
  providers: [  LoggedInGuard ],
  bootstrap: [ AppComponent ]
})

export class AppModule { }