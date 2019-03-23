package com.graduation.info.managementinfo.system.utils;

import com.graduation.info.managementinfo.system.comment.Constant;

import java.io.*;
import java.util.UUID;

public class FileUtil {

	public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
		File targetFile = new File(filePath);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		FileOutputStream out = new FileOutputStream(filePath + fileName);
		out.write(file);
		out.flush();
		out.close();
	}

	public static boolean deleteFile(String fileName) {
		File file = new File(fileName);
		// 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
		if (file.exists() && file.isFile()) {
			if (file.delete()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public static String renameToUUID(String fileName) {
		return UUID.randomUUID() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
	}

	public static R  saveEGuide(String content,Integer id) throws IOException {
		File fileDir=new File(Constant.EGUIDEPATH);
		if(!fileDir.exists()){
			fileDir.mkdirs();
		}
		String fileName=UUID.randomUUID().toString();
		File file=new File(Constant.EGUIDEPATH+fileName+String.valueOf(id)+".txt");
		System.out.println(file);
		if(file.exists()){
			return R.error("文件已经存在");
		}else{
			file.createNewFile();
			try {
				PrintWriter out= new PrintWriter(file,"utf-8");
				out.print(content);
				out.close();
				return  R.ok(Constant.EGUIDEPATH+fileName+String.valueOf(id)+".txt");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return R.error();
	}

	public static String getEGuide(String url) throws IOException {
		File file=new File(url);
		StringBuilder result = new StringBuilder();
		try{
			InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
			BufferedReader br = new BufferedReader(isr);//构造一个BufferedReader类来读取文件
			String s = null;
			while((s = br.readLine())!=null){//使用readLine方法，一次读一行
				result.append(System.lineSeparator()+s);
			}
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result.toString();
	}
}
