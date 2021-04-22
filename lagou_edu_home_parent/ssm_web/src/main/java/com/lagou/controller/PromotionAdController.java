package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVO;
import com.lagou.domain.ResponseResult;
import com.lagou.service.PromotionAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/PromotionAd")
public class PromotionAdController {
    @Autowired
    private PromotionAdService promotionAdService;

    /**
     * 分页查询广告列表
     * @param adVo
     * @return
     */
    @RequestMapping("/findAllPromotionAdByPage")
    public ResponseResult findAllPromotionAdByPage(PromotionAdVO adVo) {
        PageInfo<PromotionAd> pageInfo = promotionAdService.findAllAdByPage(adVo);
        return new ResponseResult(true,200,"分页查询成功",pageInfo);
    }

    /**
     * 广告文件上传
     * @param file
     * @param request
     * @return
     */
    @RequestMapping("/PromotionAdUpload")
    public ResponseResult PromotionAdUpload(MultipartFile file, HttpServletRequest request){
        if(file.isEmpty()){
            throw new RuntimeException();
        }
        String originalFilename = file.getOriginalFilename();
        String newFileName= UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
        String realPath = request.getServletContext().getRealPath("/");

        System.out.println(realPath);
        String webapps=realPath.substring(0,realPath.indexOf("ssm_web"));

        System.out.println(webapps);
        File file1=new File(webapps,"upload/"+newFileName);
        if(!file1.getParentFile().exists()) file1.getParentFile().mkdirs();
        try {
            file.transferTo(file1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, String> map = new HashMap<>();
        map.put("fileName", newFileName);
        map.put("filePath", "http://localhost:8080/upload/" + newFileName);
        return new ResponseResult(true,200,"上传广告图片成功",map);
    }

    /**
     * 添加or修改广告
     * @param promotionAd
     * @return
     */
    @RequestMapping("/saveOrUpdatePromotionAd")
    public ResponseResult saveOrUpdatePromotionAd(@RequestBody PromotionAd promotionAd){
        try {
            if (promotionAd.getId() == null) {
                Date date = new Date();
                promotionAd.setCreateTime(date);
                promotionAd.setUpdateTime(date);
                promotionAdService.savePromotionAd(promotionAd);
                return new ResponseResult(true, 200, "添加成功", null);
            } else {
                Date date = new Date();
                promotionAd.setUpdateTime(date);
                promotionAdService.updatePromotionAd(promotionAd);
                return new ResponseResult(true, 200, "修改成功", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * 广告动态上下线
     * @param id
     * @param status
     * @return
     */
    @RequestMapping("/updatePromotionAdStatus")
    public ResponseResult updatePromotionStatus(Integer id,Integer status){

        promotionAdService.updatePromotionAdStatus(id,status);

        return new ResponseResult(true, 200, "广告动态上下线成功", null);

    }

    /**
     * 根据id查询广告信息
     * @param id
     * @return
     */
    @RequestMapping("/findPromotionAdById")
    public ResponseResult findPromotionAdById(@RequestParam int id){
        PromotionAd promotionAd = promotionAdService.findPromotionAdById(id);
        return new ResponseResult(true,200,"查询成功",promotionAd);

    }

}
