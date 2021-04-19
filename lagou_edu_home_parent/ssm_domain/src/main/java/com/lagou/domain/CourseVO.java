package com.lagou.domain;
/*
*定义接收课程分页的实体类
* */
public class CourseVO {
    private Integer currentPage;
    private Integer pageSize;
    private String courseName;
    private Integer status;

    @Override
    public String toString() {
        return "CourseVO{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", courseName='" + courseName + '\'' +
                ", status=" + status +
                '}';
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
