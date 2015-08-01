package com.action;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.interfaces.PersonalInformationService;
import com.tablebean.PersonalInformation;
import com.tablebean.UserInfo;

public class PersonalInformationAction extends ActionSupport {
	private PersonalInformation PI;
	@Resource
	private PersonalInformationService personalInformationService;
	
	//文件上传的变量
	private File upload;  
	private String uploadContentType;  
	private String uploadFileName; 
	
	public PersonalInformation getPI() {
		return PI;
	}
	public void setPI(PersonalInformation pI) {
		PI = pI;
	}
	public PersonalInformationService getPersonalInformationService() {
		return personalInformationService;
	}
	public void setPersonalInformationService(
			PersonalInformationService personalInformationService) {
		this.personalInformationService = personalInformationService;
	}
	
	
	
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getUserPI()//获取用户个人信息
	{
		HttpSession session= ServletActionContext.getRequest().getSession();
		UserInfo user=(UserInfo) session.getAttribute("user");
		//从session 中获取用户编号
		 PI=personalInformationService.getUserPI(user.getOid());
		
		if(PI==null)
		{
			addFieldError("error", "获取失败，没用记录");
			return "error";
		}
	
		
		//session.setAttribute("userPI", PI);
		
		return "success";
		
	}

	public void validateGetUserPI() {
		
		HttpSession session= ServletActionContext.getRequest().getSession();
		if(session.getAttribute("user")==null)
		{
			addFieldError("error", "请登录");
		}	
	}
	public String updateUserPI()
	{
		//加载其他信息
		PersonalInformation nowPI=personalInformationService.loadUserPI(PI.getOid());
		
		//更新信息
		nowPI.setUserAddress(PI.getUserAddress());
		nowPI.setUserBirthday(PI.getUserBirthday());
		nowPI.setUserName(PI.getUserName());
		nowPI.setUserPhone(PI.getUserPhone());
		nowPI.setUserSex(PI.getUserSex());
		System.out.println(" "+PI.getUserSex());
		
		personalInformationService.updatePI(nowPI);
		
		
		return "success";
	}
	
	public String uploadLogo()
	{
		//System.out.println("uploadFileName="+uploadFileName);
		HttpSession session= ServletActionContext.getRequest().getSession();
		UserInfo user=(UserInfo) session.getAttribute("user");
		PersonalInformation PI=(PersonalInformation) session.getAttribute("userPI");
		//获取最新的用户个人信息
		PI=personalInformationService.loadUserPI(PI.getOid());
		
		
		
		//获取路径 构建文件夹
		String  path = ServletActionContext.getServletContext().getRealPath("/userLogo/"+user.getOid());
		File file = new File(path);
		
		if(!file.exists())//生成文件夹
		{
			file.mkdirs();
		}
		//保存头像文件
		try {
			
			FileUtils.copyFile(upload, new File(file,uploadFileName));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		//删除以前的文件记录
		delFile(PI.getUserLogo());
		
		//更新用户个人信息记录
		PI.setUserLogo("userLogo/"+user.getOid()+"/"+uploadFileName);
		//数据更新到数据库
		personalInformationService.updatePI(PI);
		//数据更新到session
		session.setAttribute("userPI",PI);
		
		
		
		
		
		return "success";
	}
	
	//文件检验
	public void validateUploadLogo() {
		HttpSession session= ServletActionContext.getRequest().getSession();
		if(session.getAttribute("user")==null||session.getAttribute("userPI")==null)
		{
			addFieldError("error", "请登录");
		}
		try
		{
			if(!upload.exists()||upload==null)
			{
				addFieldError("error","文件不能为空");
			}
			if(checkFileTypes()==false)
			{
				addFieldError("error","该文件类型不是（jpg/jpeg/png/gif）类型");
			}
		}
		catch(Exception e)
		{
			addFieldError("upload","文件不能为空");
		}
		
		
		
	}
	//图片格式检验
	public boolean checkFileTypes()
	{
		//image/pjpeg image/bmp image/gif image/x-png
		//image/jpeg image/bmp image/gif image/png
		String []filetype={"image/pjpeg","image/bmp","image/gif","image/jpeg","image/png","image/x-png"};
		
		
		for(String ft:filetype)
		{
			if(uploadContentType.equals(ft))
			{
				return true;
			}
		}
		
		return false;
	}
	
	private boolean delFile(String fileName){
		String re=ServletActionContext.getServletContext().getRealPath("");
		System.out.println("删除文件路径："+re+fileName);
		File file=new File(re+fileName);  
        if(file.exists()){  
            return file.delete();  
        }  
        return false;  
    } 
	
	
	
	
	
	

}
