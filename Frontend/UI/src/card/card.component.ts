import { Component, OnInit } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { MatTooltipModule } from '@angular/material/tooltip';

@Component({
  selector: 'app-card',
  standalone: true,
  imports: [MatCardModule, CommonModule, MatTooltipModule],
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {

  responseData: any; 
  games: any[] = [];  

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.http.get("http://localhost:8080/games?page=1").subscribe((resp: any) => {
      this.responseData = resp; 
      this.extractGames();
    });
  }

  extractGames() {
    this.games = this.responseData?.content.map((game: any) => game);
  }

  onOpenDescription(game: any) {
    return game.short_description
  }
}
