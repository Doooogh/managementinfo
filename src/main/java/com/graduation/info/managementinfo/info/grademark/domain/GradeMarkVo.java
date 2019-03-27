package com.graduation.info.managementinfo.info.grademark.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class GradeMarkVo implements Serializable {
    private static final long serialVersionUID = 1L;
    //
    private Integer id;
    //学校id
    private Integer scId;
    //专业id
    private String  major;
    //分数线
    private Integer grade;
    //备用字段
    private String year;
    //备用字段
    private String jljljl;

    public GradeMarkVo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScId() {
        return scId;
    }

    public void setScId(Integer scId) {
        this.scId = scId;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getJljljl() {
        return jljljl;
    }

    public void setJljljl(String jljljl) {
        this.jljljl = jljljl;
    }
}
