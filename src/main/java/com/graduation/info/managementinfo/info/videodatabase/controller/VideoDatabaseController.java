package com.graduation.info.managementinfo.info.videodatabase.controller;

import java.io.*;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.graduation.info.managementinfo.info.testquestion.domain.TestQuestionDO;
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

import com.graduation.info.managementinfo.info.videodatabase.domain.VideoDatabaseDO;
import com.graduation.info.managementinfo.info.videodatabase.service.VideoDatabaseService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 
 * 
 * @author Li
 * @email 1083460362@qq.com
 * @date 2019-03-26 15:01:05
 */
 
@Controller
@RequestMapping("/videodatabase/videoDatabase")
public class VideoDatabaseController {
	@Autowired
	private VideoDatabaseService videoDatabaseService;
	
	@GetMapping()
	@RequiresPermissions("videodatabase:videoDatabase:videoDatabase")
	String VideoDatabase(){
	    return "videodatabase/videoDatabase/videoDatabase";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("videodatabase:videoDatabase:videoDatabase")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<VideoDatabaseDO> videoDatabaseList = videoDatabaseService.list(query);
		int total = videoDatabaseService.count(query);
		PageUtils pageUtils = new PageUtils(videoDatabaseList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("videodatabase:videoDatabase:add")
	String add(){
	    return "videodatabase/videoDatabase/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("videodatabase:videoDatabase:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		VideoDatabaseDO videoDatabase = videoDatabaseService.get(id);
		model.addAttribute("videoDatabase", videoDatabase);
	    return "videodatabase/videoDatabase/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("videodatabase:videoDatabase:add")
	public R save( VideoDatabaseDO videoDatabase){
		if(videoDatabaseService.save(videoDatabase)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("videodatabase:videoDatabase:edit")
	public R update( VideoDatabaseDO videoDatabase){
		videoDatabaseService.update(videoDatabase);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("videodatabase:videoDatabase:remove")
	public R remove( Integer id){
		if(videoDatabaseService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("videodatabase:videoDatabase:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		videoDatabaseService.batchRemove(ids);
		return R.ok();
	}


	@GetMapping("/addVideo/{scId}")
	public String addVideo(@PathVariable("scId") Integer scId,Model model){
		model.addAttribute("scId",scId);
		return "videodatabase/videoDatabase/addVideo";
	}

	@PostMapping("/upload")
	@ResponseBody
	public R upload(@RequestParam("file") MultipartFile file, @RequestParam("scId") Integer scId){
		String fileName = file.getOriginalFilename();
		String fileReName=FileUtil.renameToUUID(fileName);
		try {
			FileUtil.uploadFile(file.getBytes(),Constant.VIDEODATABASEPATH, fileReName);
			VideoDatabaseDO video=new VideoDatabaseDO();
			video.setScId(scId);
			video.setVname(fileName);
			video.setCreatetime(new Date());
			video.setUrl(Constant.VIDEODATABASEPATH+fileReName);
			video.setSize(String.format("%.1f", Double.valueOf(file.getSize())/1024)+"M");
			int a=videoDatabaseService.save(video);
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
	public R download(HttpServletRequest request, HttpServletResponse response, Integer id, String vname) throws UnsupportedEncodingException {
		VideoDatabaseDO video=videoDatabaseService.get(id);
		String url=video.getUrl();
		String fileName=vname;
		System.out.println(fileName+"======================");
		String userAgent = request.getHeader("User-Agent");
		if (/* IE 8 至 IE 10 */
				userAgent.toUpperCase().contains("MSIE") ||
						/* IE 11 */
						userAgent.contains("Trident/7.0")) {
			try {
				fileName = URLEncoder.encode(fileName, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		} else if (userAgent.toUpperCase().contains("MOZILLA") ||
				userAgent.toUpperCase().contains("CHROME")) {
			fileName = new String(fileName.getBytes(), "ISO-8859-1");
		} else {
			fileName = URLEncoder.encode(fileName, "UTF-8");
		}
		if (fileName != null) {
			//设置文件路径
			File file = new File(url);
			String  format=url.substring(url.lastIndexOf("."));
			System.out.println(format+"--------------------------------");
			System.out.println(fileName+"--------------------------------");
			if (file.exists()) {
				response.setCharacterEncoding("UTF-8");
				response.setContentType("application/force-download");// 设置强制下载不打开
				response.setHeader("Content-Disposition", "attachment;fileName=" + fileName+format);// 设置文件名
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
