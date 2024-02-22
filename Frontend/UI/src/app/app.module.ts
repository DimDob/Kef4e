import { NgModule } from "@angular/core";
import { AppComponent } from "./app.component";
import { BrowserModule } from "@angular/platform-browser";
import { CardComponent } from "../card/card.component";
import { LikeButtonComponent } from "../card/like-button/like-button.component";

@NgModule({
    declarations: [
        AppComponent,
        CardComponent,
        LikeButtonComponent
    ],
    imports: [BrowserModule],
    providers:[],
    bootstrap:[AppComponent]
})

export class AppModule{}