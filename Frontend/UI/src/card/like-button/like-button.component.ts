import {Component} from '@angular/core';
import {MatIconModule} from '@angular/material/icon';
import {MatDividerModule} from '@angular/material/divider';
import {MatButtonModule} from '@angular/material/button';
import {MatButtonToggleModule} from '@angular/material/button-toggle';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'like-button',
  standalone: true,
  imports: [MatButtonModule, MatDividerModule, MatIconModule,MatButtonToggleModule, FormsModule ],
  templateUrl: './like-button.component.html',
  styleUrl: './like-button.component.css',
})
export class LikeButtonComponent {

  liked: boolean = false;
  
  toggleLike(event: MouseEvent) {
    const selectedGameTitle = this.getSelectedGameTitle(event)
    
    //TODO Send API Call to the BE that the game with game title {{selectedGameTitle}} has been liked and update the database.
    //For this use case create a method like gameLiked(gameTitle: string) {}

    console.log(`Game with title ${selectedGameTitle} has been liked!`);
    
    this.liked = true
    
  }

  getSelectedGameTitle(event:Event) {
    let parentElement = (event.target as HTMLElement).parentElement;
    
    while (parentElement && !parentElement.classList.contains('card-container')) {
      parentElement = parentElement.parentElement;
    }
    const selectedGameTitle = parentElement?.children[1].querySelectorAll("p")[1].textContent;
    return selectedGameTitle;
  }

  isLiked(event: MouseEvent) {
    const currentSelectedGameTitle = this.getSelectedGameTitle(event) //I use the same here so i can get the game title which is hovered on 
    console.log(`${currentSelectedGameTitle} has been liked or not ? `); //TODO After i save the status of the game in the BE 
    //i will want to make HTTP calls to the postgreSQL db to get the status and after that if it is liked and the button is clicked again
    //i will uprate the status of liked property to "false" and so on
    
  }
}
