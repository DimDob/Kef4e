import { Component, Inject, OnInit, PLATFORM_ID } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { HttpClient } from '@angular/common/http';
import { CommonModule, isPlatformBrowser } from '@angular/common';
import { MatTooltipModule } from '@angular/material/tooltip';
import { ActivatedRoute } from '@angular/router';
import { MatIconModule } from '@angular/material/icon';
import { LikeButtonComponent } from './like-button/like-button.component';

@Component({
  selector: 'app-card',
  standalone: true,
  imports: [MatCardModule, CommonModule, MatTooltipModule, LikeButtonComponent, MatIconModule],
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {

  responseData: any; 
  games: any[] = [];  
  pageNumber: number | undefined;

  constructor(private http: HttpClient, private route: ActivatedRoute, @Inject(PLATFORM_ID) private platformId: Object) {}

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.pageNumber = +params['pageNumber'] || 1;
   
      if (isPlatformBrowser(this.platformId)) {
        console.log(`Platform Id -> ${this.platformId}`);
        console.log(`Platform Id -> ${this.platformId}`);
        
        console.log(`Platform Id -> ${this.platformId}`); 
        
        this.fetchGames();
      }
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
