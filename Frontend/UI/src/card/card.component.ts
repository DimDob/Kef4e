import { Component, OnInit } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { MatTooltipModule } from '@angular/material/tooltip';
import { ActivatedRoute } from '@angular/router';

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
  pageNumber: number | undefined;

  constructor(private http: HttpClient, private route: ActivatedRoute) {}

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.pageNumber = +params['pageNumber'] || 1;
      this.fetchGames();
    });
  }

  fetchGames() {
    const regexResult = window.location.href.match(/.*?page\/(\d+)/);
    if (regexResult) {
      this.pageNumber = +regexResult[1];
    } else {
      this.pageNumber = 1;
    }

    this.http.get(`http://localhost:8080/games?page=${this.pageNumber}`).subscribe((resp: any) => {
      this.responseData = resp; 
      this.extractGames();
    });
  }

  extractGames() {
    this.games = this.responseData?.content.map((game: any) => game);
  }

  onOpenDescription(game: any) {
    return `${game.title} - ${game.short_description}` 
  }
}
