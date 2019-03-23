package com.graduation.info.managementinfo.info.ueditor;

import com.alibaba.fastjson.JSONException;
import com.baidu.ueditor.ActionEnter;
import com.graduation.info.managementinfo.info.enrollmentguide.domain.EnrollmentGuideDO;
import com.graduation.info.managementinfo.info.enrollmentguide.service.EnrollmentGuideService;
import com.graduation.info.managementinfo.info.sce.domain.ScEDO;
import com.graduation.info.managementinfo.info.sce.service.ScEService;
import com.graduation.info.managementinfo.info.school.service.SchoolService;
import com.graduation.info.managementinfo.system.comment.Constant;
import com.graduation.info.managementinfo.system.utils.FileUtil;
import com.graduation.info.managementinfo.system.utils.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/uedito")
public class UeditorController {

    @Autowired
    private ScEService scEService;

    @Autowired
    private EnrollmentGuideService enrollmentGuideService;

    @Autowired
    private SchoolService schoolService;

    @RequestMapping(value = "/config")
    @ResponseBody
    public String config(HttpServletRequest request, HttpServletResponse response) throws JSONException {
        String s = "{\n" +
                "            \"imageActionName\": \"uploadimage\",\n" +
                "                \"imageFieldName\": \"file\", \n" +
                "                \"imageMaxSize\": 2048000, \n" +
                "                \"imageAllowFiles\": [\".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\"], \n" +
                "                \"imageCompressEnable\": true, \n" +
                "                \"imageCompressBorder\": 1600, \n" +
                "                \"imageInsertAlign\": \"none\", \n" +
                "                \"imageUrlPrefix\": \"\",\n" +
                "                \"imagePathFormat\": \"/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\" }";
        return s;
    }

    @PostMapping("/postData")
    @ResponseBody
    public R postData(String content,Integer id) {
             R r=null;
             String url=null;
            EnrollmentGuideDO eGuide= schoolService.getEGuideBySchool(id);
            if(eGuide!=null) {
                url = eGuide.getUrl();
                if(StringUtils.isNotBlank(url)){
                    FileUtil.deleteFile(url);
                    try {
                        r=FileUtil.saveEGuide(content,id);
                        EnrollmentGuideDO enrollmentGuide=new EnrollmentGuideDO();
                        Integer eId=eGuide.getId();
                        enrollmentGuide.setId(eId);
                        enrollmentGuide.setUrl((String)(r.get("msg")));
                        int a=  enrollmentGuideService.update(enrollmentGuide);
                        if(a>0){
                            return R.ok();
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }else{
                try {
                    r = FileUtil.saveEGuide(content,id);
                    System.out.println(r.get("msg"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if((Integer)(r.get("code"))!=0){
                    return R.error();
                }else{
                    EnrollmentGuideDO enrollmentGuide=new EnrollmentGuideDO();
                    enrollmentGuide.setUrl((String)(r.get("msg")));
                    enrollmentGuide.setCreatetime(new Date());
                    int a=  enrollmentGuideService.save(enrollmentGuide);
                    Integer eId=enrollmentGuide.getId();
                    ScEDO sc=new ScEDO();
                    sc.setScId(id);
                    sc.setEId(eId);
                    int b= scEService.save(sc);
                    if(a>0&&b>0){
                        return R.ok();
                    }
                }
            }

        return R.error();
    }

    @RequestMapping(value = "/imgUpdate")
    @ResponseBody
    public Map<String,Object> imgUpdate(MultipartFile file) {
        Map<String, Object> params = new HashMap<String, Object>();

        if (file.isEmpty()) {
            return R.error();
        }
        String fileName = file.getOriginalFilename();
        fileName = FileUtil.renameToUUID(fileName);
        try {
            FileUtil.uploadFile(file.getBytes(), Constant.FILEPATH, fileName);
            params.put("code",0);
            params.put("state", "SUCCESS");
            params.put("url", Constant.VIRTUALPATH+fileName);
            params.put("size", file.getSize());
            params.put("original", fileName);
            params.put("type", file.getContentType());
            return params;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return R.error();
    }
}
