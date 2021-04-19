package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;
import com.lagou.domain.CourseVO2;
import com.lagou.domain.ResponseResult;
import com.lagou.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    /**
     * 分页获取课程列表数据&多条件查询
     * @param
     * @return
     */
    @RequestMapping("/findAllCourse")
    public ResponseResult findAllCourse(@RequestBody CourseVO courseVO){
        PageInfo<Course> pageInfo = courseService.findAllCourse(courseVO);
        return new ResponseResult(true,200,"响应成功",pageInfo);
    }

    /**
     * 课程模块图片上传
     * @param file
     * @return
     */
    @RequestMapping("/courseUpload")
    public ResponseResult courseUpload(MultipartFile file, HttpServletRequest request) throws IOException {
        //获得原始文件名
        String originalFilename = file.getOriginalFilename();

        //拼接新的文件名
        String newFileName = UUID.randomUUID().toString() + originalFilename;

        //获得项目在服务器中的完整路径
        //D:\apache-tomcat-8.5.55\webapps\ssm_web\
        String realPath = request.getServletContext().getRealPath("/");
        String webPath = realPath.substring(0, realPath.indexOf("ssm_web"));
        String upload=webPath+"upload\\";

        //创建File对象，并生成该路径
        File file2 =new File(upload,newFileName);
        if (!file2.getParentFile().exists()){
            file2.getParentFile().mkdirs();
        }

        //将文件内容保存到该路径上
        file.transferTo(file2);

        //响应结果
        Map<String,Object> map=new HashMap<>();
        map.put("fileName",newFileName);
        map.put("filePath","http://localhost:8080/upload/"+newFileName);
        return new ResponseResult(true,200,"图片上传成功",map);
    }

    /**
     * 新建课程或修改课程
     * @param courseVO2
     * @return
     */
    @RequestMapping("/saveOrUpdateCourse")
    public ResponseResult saveOrUpdateCourse(@RequestBody CourseVO2 courseVO2){
        if(courseVO2.getId()==null){
            courseService.saveCourse(courseVO2);
            return new ResponseResult(true,200,"新建课程成功",null);
        }
        else {
            courseService.updateCourse(courseVO2);
            return new ResponseResult(true,200,"修改课程成功",null);
        }
    }

    /**
     * 根据id获取课程信息
     * @param id
     * @return
     */
    @RequestMapping("/findCourseById")
    public ResponseResult findCourseById(Integer id){
        CourseVO2 courseById = courseService.findCourseById(id);
        return new ResponseResult(true,200,"根据ID查询课程信息成功",courseById);
    }

    /**
     * 课程状态管理
     * @param id
     * @param status
     * @return
     */
    @RequestMapping("/updateCourseStatus")
    public ResponseResult updateCourseStatus(Integer id,Integer status){

        //调用service,传递参数，完成课程状态的变更
        courseService.updateCourseStatus(id,status);

        // 响应数据
        Map<String, Object> map = new HashMap<>();
        map.put("status",status);

        return new ResponseResult(true, 200, "课程状态变更成功", map);

    }

}
