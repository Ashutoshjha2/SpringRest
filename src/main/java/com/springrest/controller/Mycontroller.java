package com.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.entity.Course;
import com.springrest.services.CourseService;

@RestController
public class Mycontroller {
	@Autowired
	private CourseService courseService;

	@GetMapping("/home")
	public String home() {
		return "This is home page";
	}

//Get All Courses
	@GetMapping("/courses")
	public List<Course> getCourses() {
		return this.courseService.getCourses();
	}

	// Get only single course
	@GetMapping(value = "/courses/{courseId}")
	public Course getCourse(@PathVariable ("courseId") long courseId) {
		return this.courseService.getCourse(courseId);
	}

	// Add Courses
	@PostMapping(path = "/courses", consumes = "application/json",produces = {"application/json"})
	public ResponseEntity<Course> addCourse(@RequestBody Course course) {
		//return this.courseService.addCourse(course);
		this.courseService.addCourse(course);
		return new ResponseEntity<Course>(course,HttpStatus.CREATED);
	}

	// Update Courses
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseService.updateCourse(course);
	}
	// Delete Courses
	@DeleteMapping("/courses/{courseId}")
     public ResponseEntity<String> deleteCourse(@PathVariable String courseId){
    	 try {
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<String>("DELETED DONE",HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
     }
	
}
