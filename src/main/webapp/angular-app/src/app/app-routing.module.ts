import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {ContentComponent} from './content/content.component';

const routes: Routes = [
  {path: '', redirectTo: '/library', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)

  ],
  exports: [RouterModule]
})

export class AppRoutingModule {
}
