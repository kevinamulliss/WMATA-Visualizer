import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

import { LinesComponent } from './components/rail-station/lines.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, LinesComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'wmata-front-end';
}