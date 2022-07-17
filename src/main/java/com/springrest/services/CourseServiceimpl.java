package com.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.dao.CourseDao;
import com.springrest.entity.Course;

@Service
public class CourseServiceimpl implements CourseService {
@Autowired
	private CourseDao courseDao;
//	List<Course> list;

	public CourseServiceimpl() {
//		list = new ArrayList<>();
//		list.add(new Course(145, "java", "this is the course"));
//		list.add(new Course(146, "python", "this is the course"));

	}

	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return courseDao.findAll();
	}

	@Override
	public Course getCourse(long courseId) {
//		
   Object findById = courseDao.findById(courseId);
   return (Course) findById;
	}

	@Override
	public Course addCourse(Course course) {
//		list.add(course);
		courseDao.save(course);
		// TODO Auto-generated method stub
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
//		list.forEach(e -> {
//			if (e.getId() == course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDiscription(course.getDiscription());
//			}
//		});
		courseDao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
//		// TODO Auto-generated method stub
//		list=this.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList())deleteCourse(parseLong);
		Course entity=courseDao.getOne(parseLong);
		courseDao.delete(entity);
	}
	
}
