import { NgModule } from "@angular/core";
import { AppComponent } from "./app.component";
import { BrowserModule } from "@angular/platform-browser";
import { CardComponent } from "../card/card.component";
import { LikeButtonModalComponent } from "../card/like-button-modal/like-button-modal.component";

@NgModule({
    declarations: [
        AppComponent,
        CardComponent,
        LikeButtonModalComponent
    ],
    imports: [BrowserModule],
    providers:[],
    bootstrap:[AppComponent]
})

export class AppModule{}