import { Component } from '@angular/core';
import { LessonsListService } from './lessons-list.service';
import { NgFor } from '@angular/common';
import { Lesson } from './lessons-list.interface';

@Component({
  selector: 'app-lessons-list',
  standalone: true,
  imports: [NgFor],
  templateUrl: './lessons-list.component.html',
  styleUrl: './lessons-list.component.css'
})
export class LessonsListComponent {
  lessons: Lesson[] = [];
  constructor(private service : LessonsListService){}

  ngOnInit(){
    console.log('yolo')
    this.service.getList().subscribe(lessons => {
      this.lessons = lessons;
      console.log(lessons)
    })
  }
}
