package com.graduation.info.managementinfo.info.testquestion.controller;

import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.graduation.info.managementinfo.system.comment.Constant;
import com.graduation.info.managementinfo.system.utils.FileUtil;
import com.graduation.info.managementinfo.system.utils.PageUtils;
import com.graduation.info.managementinfo.system.utils.Query;
import com.graduation.info.managementinfo.system.utils.R;
import io.swagger.models.auth.In;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.graduation.info.managementinfo.info.testquestion.domain.TestQuestionDO;
import com.graduation.info.managementinfo.info.testquestion.service.TestQuestionService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 
 * @author Li
 * @email 1083460362@qq.com
 * @date 2019-03-25 14:22:48
 */
 
@Controller
@RequestMapping("/testquestion/testQuestion")
public class TestQuestionController {
	@Autowired
	private TestQuestionService testQuestionService;
	
	@GetMapping()
	@RequiresPermissions("testquestion:testQuestion:testQuestion")
	String TestQuestion(){
	    return "testquestion/testQuestion/testQuestion";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("testquestion:testQuestion:testQuestion")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TestQuestionDO> testQuestionList = testQuestionService.list(query);
		int total = testQuestionService.count(query);
		PageUtils pageUtils = new PageUtils(testQuestionList, total);
		return pageUtils;
	}
	
	@GetMapping("/add/{scId}")
	@RequiresPermissions("testquestion:testQuestion:add")
	String add(@PathVariable("scId") Integer scId,Model model){
		model.addAttribute("scId",scId);
	    return "testquestion/testQuestion/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("testquestion:testQuestion:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		TestQuestionDO testQuestion = testQuestionService.get(id);
		model.addAttribute("testQuestion", testQuestion);
	    return "testquestion/testQuestion/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("testquestion:testQuestion:add")
	public R save( TestQuestionDO testQuestion){
		if(testQuestionService.save(testQuestion)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("testquestion:testQuestion:edit")
	public R update( TestQuestionDO testQuestion){
		testQuestionService.update(testQuestion);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("testquestion:testQuestion:remove")
	public R remove( Integer id){
		if(testQuestionService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("testquestion:testQuestion:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		testQuestionService.batchRemove(ids);
		return R.ok();
	}

	@PostMapping("/upload")
	@ResponseBody
	public R upload(@RequestParam("file") MultipartFile file,@RequestParam("scId") Integer scId){
			String fileName = file.getOriginalFilename();
			String fileReName=FileUtil.renameToUUID(fileName);
			try {
				FileUtil.uploadFile(file.getBytes(),Constant.TESTQUESTIONPATH, fileReName);
				TestQuestionDO test=new TestQuestionDO();
				test.setScId(scId);
				test.setTname(fileName);
				test.setCreatetime(new Date());
				test.setUrl(Constant.TESTQUESTIONPATH+fileReName);
				test.setSize(String.format("%.1f", Double.valueOf(file.getSize())/1024)+"M");
				int a=testQuestionService.save(test);
				if(a>0){
					return R.ok();
				}
			}catch (Exception e){
				e.printStackTrace();
				return R.error();
			}

		return  R.error();
	}


	@GetMapping("/download")
	public R download(HttpServletRequest request, HttpServletResponse response, Integer id,String tname){
		TestQuestionDO testQuestion=testQuestionService.get(id);
		String url=testQuestion.getUrl();
		String fileName=tname;
		if (fileName != null) {
			//设置文件路径
			String realPath = "E://onlineinfo//";
			File file = new File(url);
			if (file.exists()) {
				response.setContentType("application/force-download");// 设置强制下载不打开
				response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
				byte[] buffer = new byte[1024];
				FileInputStream fis = null;
				BufferedInputStream bis = null;
				try {
					fis = new FileInputStream(file);
					bis = new BufferedInputStream(fis);
					OutputStream os = response.getOutputStream();
					int i = bis.read(buffer);
					while (i != -1) {
						os.write(buffer, 0, i);
						i = bis.read(buffer);
					}
					os.close();
					System.out.println("success");
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if (bis != null) {
						try {
							bis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (fis != null) {
						try {
							fis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}

		return  R.error();
	}
	
}
