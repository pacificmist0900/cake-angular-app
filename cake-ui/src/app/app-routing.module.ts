import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ViewComponent } from './components/view/view.component';
import { CreateComponent } from './components/create/create.component';

const routes: Routes = [{
  path: '',
  component: ViewComponent
},
{
  path: 'create',
  component: CreateComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
