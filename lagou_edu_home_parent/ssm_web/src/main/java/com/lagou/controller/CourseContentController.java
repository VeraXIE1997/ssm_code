package com.lagou.controller;

import com.lagou.domain.Course;
import com.lagou.domain.CourseLesson;
import com.lagou.domain.CourseSection;
import com.lagou.domain.ResponseResult;
import com.lagou.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/courseContent")
public class CourseContentController {
    @Autowired
    private CourseContentService courseContentService;

    /**
     * 查询章节和课时信息
     * @param courseId
     * @return
     */
    @RequestMapping("/findSectionAndLesson")
    public ResponseResult findSectionAndLesson(Integer courseId){
        List<CourseSection> sectionList = courseContentService.findSectionAndLessonByCourseId(courseId);
        return new ResponseResult(true,200,"查询课程内容成功",sectionList);
    }

    /**
     * 回显章节对应的课程信息
     * @param courseId
     * @return
     */
    @RequestMapping("/findCourseByCourseId")
    public ResponseResult findCourseByCourseId(Integer courseId){
        Course course = courseContentService.findCourseByCourseId(courseId);
        Map<String,Object> map=new HashMap<>();
        map.put("id",course.getId());
        map.put("courseName",course.getCourseName());
        return new ResponseResult(true,200,"回显章节对应课程信息成功",map);
    }

    /**保存or修改章节
     * @param courseSection
     * @return
     */
    @RequestMapping("/saveOrUpdateSection")
    public ResponseResult saveOrUpdateSection(@RequestBody CourseSection courseSection){
        if(courseSection.getId()!=null){
            courseContentService.updateSection(courseSection);
            return new ResponseResult(true,200,"保存章节成功",null);
        }
        else {
            courseContentService.saveSection(courseSection);
            return new ResponseResult(true,200,"修改章节成功",null);
        }
    }
    /**
     * 修改章节状态
     * 状态，0:隐藏；1：待更新；2：已发布
     * */
    @RequestMapping("/updateSectionStatus")
    public ResponseResult updateSectionStatus(int id, int status){
        courseContentService.updateSectionStatus(id,status);
        //封装最新的状态信息
        Map<String,Integer> map = new HashMap<>();
        map.put("status",status);
        return new ResponseResult(true,200,"响应成功",map);

    }

    /**
     * 保存or修改课时
     * @param courseLesson
     */
    @RequestMapping("/saveOrUpdateLesson")
    public ResponseResult saveOrUpdateLesson(@RequestBody CourseLesson courseLesson){
        if(courseLesson.getId()==null){
            courseContentService.saveLesson(courseLesson);
            return new ResponseResult(true,200,"添加课时成功",null);
        }
        else {
            courseContentService.updateLesson(courseLesson);
            return new ResponseResult(true,200,"修改课时成功",null);
        }
    }
}
