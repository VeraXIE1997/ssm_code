package com.lagou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.CourseMapper;
import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;
import com.lagou.domain.CourseVO2;
import com.lagou.domain.Teacher;
import com.lagou.service.CourseService;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Override
    public PageInfo<Course> findAllCourse(CourseVO courseVO) {
        //创建 course对象
        Course course = new Course();
        course.setCourseName(courseVO.getCourseName());
        course.setStatus(courseVO.getStatus());

        //分页查询
        PageHelper.startPage(courseVO.getCurrentPage(),courseVO.getPageSize());
        List<Course> courseList = courseMapper.findAllCourse(course);

        //将查询到的结果封装到pageInfo中

        return new PageInfo<>(courseList);
    }

    @Override
    public void saveCourse( CourseVO2 courseVO2) {
        try {
            // 创建course对象并封装该实体
            Course course = new Course();
            BeanUtils.copyProperties(course,courseVO2);
            Date date = new Date();
            course.setCreateTime(date);
            course.setUpdateTime(date);

            //添加课程
            courseMapper.saveCourse(course);

            //创建teacher对象并封装该实体
            Teacher teacher = new Teacher();
            BeanUtils.copyProperties(teacher,courseVO2);
            teacher.setCourseId(course.getId());
            teacher.setCreateTime(date);
            teacher.setUpdateTime(date);

            //添加教师信息
            courseMapper.saveTeacher(teacher);

        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    @Override
    public CourseVO2 findCourseById(Integer id) {
        return courseMapper.findCourseById(id);
    }

    @Override
    public void updateCourse(CourseVO2 courseVO2) {
        try {
            // 创建课程对象并封装修改
            Course course = new Course();
            BeanUtils.copyProperties(course,courseVO2);
            Date date = new Date();
            course.setUpdateTime(date);
            courseMapper.updateCourse(course);

            //创建教师对象并封装修改
            Teacher teacher = new Teacher();
            teacher.setUpdateTime(date);
            teacher.setCourseId(course.getId());
            BeanUtils.copyProperties(teacher,courseVO2);
            courseMapper.updateTeacher(teacher);

        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateCourseStatus(int courseId, int status) {
        //1.封装数据
        Course course = new Course();
        course.setId(courseId);
        course.setStatus(status);
        course.setUpdateTime(new Date());

        //2.调用mapper
        courseMapper.updateCourseStatus(course);
    }
}
