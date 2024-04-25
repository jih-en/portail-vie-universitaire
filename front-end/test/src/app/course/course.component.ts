import { Component } from '@angular/core';
import {MatButton} from "@angular/material/button";
import {
  MatCell,
  MatCellDef,
  MatColumnDef,
  MatHeaderCell, MatHeaderCellDef,
  MatHeaderRow,
  MatHeaderRowDef,
  MatRow, MatRowDef, MatTable
} from "@angular/material/table";
import {MatDialog} from "@angular/material/dialog";
import {CourseService} from "../services/course.service";
import {AddCourseComponent} from "./add-course/add-course.component";
import {EditCourseComponent} from "./edit-course/edit-course.component";

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrl: './course.component.css'
})
export class CourseComponent {
  animal: string | undefined;
  name: string | undefined;
  ELEMENT_DATA:any
  dataSource:any
  ngOnInit(){
    this.courseService.getCources().subscribe((result)=>{
      this.ELEMENT_DATA=result
      console.log(this.ELEMENT_DATA)
      this.dataSource=this.ELEMENT_DATA

    })
  }
  constructor(public dialog: MatDialog,private courseService:CourseService) {
  }
  openDialog(): void {
    const dialogRef = this.dialog.open(AddCourseComponent, {
      data: {name: this.name, animal: this.animal},
      width:"700px",
      height:"500px"
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.courseService.getCources().subscribe((result)=>{
        this.ELEMENT_DATA=result
        console.log(this.ELEMENT_DATA)
        this.dataSource=this.ELEMENT_DATA

      })
    });
  }

  // @ts-ignore
  displayedColumns: string[] = [ 'demo-name','createur', 'descr','demo-weight', 'demo-symbol',];
  update(url:any,name:any,descrip:any,createur:any){
    const tab = url.split('/');
    const id=tab[4]
    console.log(id)
    const dialogRef = this.dialog.open(EditCourseComponent, {
      data: {id: id,name:name,descrip:descrip,createur:createur},
      width:"700px",
      height:"500px"
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.courseService.getCources().subscribe((result)=>{
        this.ELEMENT_DATA=result
        console.log(this.ELEMENT_DATA)
        this.dataSource=this.ELEMENT_DATA

      })
    });
  }

  delete(url:any){
    const tab = url.split('/');
    const id=tab[4]
    console.log(id)
    this.courseService.delete(id).subscribe((result)=>{
      this.courseService.getCources().subscribe((result)=>{
        this.ELEMENT_DATA=result
        console.log(this.ELEMENT_DATA)
        this.dataSource=this.ELEMENT_DATA

      })
    })
  }
}
