package com.lagou.service;

import com.lagou.domain.Course;
import com.lagou.domain.CourseLesson;
import com.lagou.domain.CourseSection;

import java.util.List;

public interface CourseContentService {
    /**
     * 查询章节和课时信息
     * @param courseId
     * @return
     */
    List<CourseSection> findSectionAndLessonByCourseId(Integer courseId);

    /**
     * 回显章节对应的课程信息
     * @param courseId
     * @return
     */
    Course findCourseByCourseId(Integer courseId);

    /**
     * 保存章节
     * @param courseSection
     */
    void saveSection(CourseSection courseSection);

    /**
     * 修改章节
     * @param courseSection
     */
    void updateSection(CourseSection courseSection);

    /**
     * 修改章节状态
     * @param id
     * @param status
     */
    void updateSectionStatus(int id,int status);

    /**
     * 保存课时
     * @param courseLesson
     */
    void saveLesson(CourseLesson courseLesson);

    /**
     * 修改课时
     * @param courseLesson
     */
    void updateLesson(CourseLesson courseLesson);
}
