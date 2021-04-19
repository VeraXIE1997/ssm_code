package com.lagou.dao;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVO2;
import com.lagou.domain.Teacher;

import java.util.List;

public interface CourseMapper {
    /**
     * 分页获取课程列表数据&多条件查询
     * @param course
     * @return
     */
    List<Course> findAllCourse(Course course);

    /**
     * 添加课程
     * @param course
     */
    void saveCourse(Course course);

    /**
     * 添加教师信息
     * @param teacher
     */
    void saveTeacher(Teacher teacher);

    /**
     * 根据课程id获取课程信息
     * @param id
     * @return
     */
    CourseVO2 findCourseById(Integer id);

    /**
     * 修改课程信息
     * @param course
     */
    void updateCourse(Course course);

    /**
     * 修改教师信息
     * @param teacher
     */
    void updateTeacher(Teacher teacher);

    /**
     * 状态管理
     * @param course
     */
    public void updateCourseStatus(Course course);
}
