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
}
