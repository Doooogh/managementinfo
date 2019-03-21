package com.graduation.info.managementinfo.info.permission.domain;


import com.graduation.info.managementinfo.info.common.entity.Tree1;
import lombok.Data;

import java.util.List;

@Data
public class MenuItem {

    private List<Tree1<PermissionDO>> contentManagement;
    private List<Tree1<PermissionDO>>memberCenter;
    private List<Tree1<PermissionDO>>systemeSttings;
    private List<Tree1<PermissionDO>> seraphApi;
}
