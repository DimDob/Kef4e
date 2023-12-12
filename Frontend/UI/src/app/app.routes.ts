import { Routes } from '@angular/router';
import { CardComponent } from '../card/card.component';

export const routes: Routes = [
    { path: '', redirectTo: 'page/1', pathMatch: 'full' },
    { path: 'page/:pageNumber', component: CardComponent },
];
