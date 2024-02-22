import { NgModule } from "@angular/core";
import { AppComponent } from "./app.component";
import { BrowserModule } from "@angular/platform-browser";
import { CardComponent } from "../card/card.component";
import { LikeButtonComponent } from "../card/like-button/like-button.component";
import {MatButtonToggleModule} from '@angular/material/button-toggle';
import { FormsModule } from "@angular/forms";

@NgModule({
    declarations: [
        AppComponent,
        CardComponent,
        LikeButtonComponent,
    ],
    imports: [BrowserModule, MatButtonToggleModule, FormsModule],
    providers:[],
    bootstrap:[AppComponent]
})

export class AppModule{}