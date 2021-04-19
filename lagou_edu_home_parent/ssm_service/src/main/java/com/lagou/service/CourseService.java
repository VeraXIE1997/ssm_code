package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;
import com.lagou.domain.CourseVO2;

import java.util.List;

public interface CourseService {
    /**
     * 分页获取课程列表数据&多条件查询
     * @param courseVO
     * @return
     */
    PageInfo<Course> findAllCourse(CourseVO courseVO);

    /**
     * 新建课程
     * @param courseVO2
     */
    void saveCourse(CourseVO2 courseVO2);

    /**
     * 根据课程id查询课程信息
     * @param id
     * @return
     */
    CourseVO2 findCourseById(Integer id);

    /**
     * 修改课程
     * @param courseVO2
     */
    void updateCourse(CourseVO2 courseVO2);

    /**
     * 课程状态变更
     * @param courseId
     * @param status
     */
    void updateCourseStatus(int courseId,int status);
}
