import { ModuleWithProviders }        from '@angular/core';
import { Routes, RouterModule }       from '@angular/router';
import { LoggedInGuard }              from './logged-in.guard';

/*components*/
import { WorkerSearchComponent }      from './worker-search.component';
import { LoginComponent }             from './login.component';
import { SignupComponent }            from './signup.component';
import { ProfileComponent }           from './profile.component';
import { ScheduleComponent }          from './schedule.component';
import { PaymentsComponent }          from './payments.component';

const appRoutes: Routes = [
  {
    path: 'signin',
    component: LoginComponent
  },
  {
    path: 'signup',
    component: SignupComponent
  },
  {
    path: 'dashboard',
    component: WorkerSearchComponent
    //canActivate: [LoggedInGuard]
  },
  {
    path: 'profile',
    component: ProfileComponent
  },
  {
    path: 'schedule',
    component: ScheduleComponent
  },
  {
    path: 'payments',
    component: PaymentsComponent
  },
  {
    path: '',
    redirectTo: 'dashboard',
    pathMatch: 'full'
  },

];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);