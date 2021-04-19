package com.lagou.domain;

import java.util.Date;

public class CourseVO2 {

    //讲师姓名
    private String teacherName;

    //讲师职务
    private String position;

    //介绍
    private String description;

    //主键
    private Integer id;

    //课程名称
    private String courseName;

    //课程一句话简介
    private String brief;

    //课程预览第一个字段
    private String previewFirstField;

    //课程预览第二个字段
    private String previewSecondField;

    //原价
    private double price;

    //售卖价格
    private double discounts;

    //优惠价标签
    private String discountsTag;

    //课程分享图片url
    private String courseImgUrl;

    //课程列表展示图片
    private String courseListImg;

    //课程排序
    private int sortNum;

    //课程描述
    private String courseDescriptionMarkDown;

    //销量
    private int sales;

    @Override
    public String toString() {
        return "CourseVO2{" +
                "teacherName='" + teacherName + '\'' +
                ", position='" + position + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", courseName='" + courseName + '\'' +
                ", brief='" + brief + '\'' +
                ", previewFirstField='" + previewFirstField + '\'' +
                ", previewSecondField='" + previewSecondField + '\'' +
                ", price=" + price +
                ", discounts=" + discounts +
                ", discountsTag='" + discountsTag + '\'' +
                ", courseImgUrl='" + courseImgUrl + '\'' +
                ", courseListImg='" + courseListImg + '\'' +
                ", sortNum=" + sortNum +
                ", course_description_mark_down='" + courseDescriptionMarkDown + '\'' +
                ", sales=" + sales +
                '}';
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getPreviewFirstField() {
        return previewFirstField;
    }

    public void setPreviewFirstField(String previewFirstField) {
        this.previewFirstField = previewFirstField;
    }

    public String getPreviewSecondField() {
        return previewSecondField;
    }

    public void setPreviewSecondField(String previewSecondField) {
        this.previewSecondField = previewSecondField;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscounts() {
        return discounts;
    }

    public void setDiscounts(double discounts) {
        this.discounts = discounts;
    }

    public String getDiscountsTag() {
        return discountsTag;
    }

    public void setDiscountsTag(String discountsTag) {
        this.discountsTag = discountsTag;
    }

    public String getCourseImgUrl() {
        return courseImgUrl;
    }

    public void setCourseImgUrl(String courseImgUrl) {
        this.courseImgUrl = courseImgUrl;
    }

    public String getCourseListImg() {
        return courseListImg;
    }

    public void setCourseListImg(String courseListImg) {
        this.courseListImg = courseListImg;
    }

    public int getSortNum() {
        return sortNum;
    }

    public void setSortNum(int sortNum) {
        this.sortNum = sortNum;
    }

    public String getCourseDescriptionMarkDown() {
        return courseDescriptionMarkDown;
    }

    public void setCourseDescriptionMarkDown(String courseDescriptionMarkDown) {
        this.courseDescriptionMarkDown = courseDescriptionMarkDown;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }
}
