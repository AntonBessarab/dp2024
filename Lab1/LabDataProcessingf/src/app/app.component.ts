import { Component } from '@angular/core'; 
import { Service1Service } from './services/service1.service';
import { Entity } from './interfaces/entity';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'Lab_1f';
  entityList: Entity[] = [];

  constructor(private service: Service1Service) { }

  getEntities(): void {
    this.service.getEntities().subscribe(
      (entities) => {
        this.entityList = entities;
      }
    )
  }
}