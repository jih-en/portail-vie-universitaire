import {Component, Inject} from '@angular/core';
import {CourseService} from "../../services/course.service";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {MatLabel} from "@angular/material/form-field";

@Component({
  selector: 'app-add-course',
  templateUrl: './add-course.component.html',
  styleUrl: './add-course.component.css'
})
export class AddCourseComponent {
  constructor(
    private courseService:CourseService,
    public dialogRef: MatDialogRef<AddCourseComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
  ) {}
  selectedFile:any
  descrip:any;
  name:any;
extension:any
  onFileSelected(event:any): void {
    this.data.file = event.target.files[0];
    console.log(this.data.file)
    console.log(this.data.file.name)
    const tab =this.data.file.name.split('.');
    this.extension=tab[1];
    console.log(this.extension)
  }
  add(){
    console.log("data",this.data)
    const filename=this.data.name+"."+this.extension
    const formData = new FormData();
    formData.append('descrip', this.data.description);
    formData.append('name', filename);
    formData.append('file', this.data.file);
    formData.append('createur',this.data.createur)
    this.courseService.add(formData).subscribe((result)=>{
      console.log(result)
    })

  }
  onNoClick(): void {
    this.dialogRef.close();
  }

}
