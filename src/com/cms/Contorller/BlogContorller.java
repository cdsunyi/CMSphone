package com.cms.Contorller;


import com.cms.service.BlogService;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;

public class BlogContorller extends Controller{
	
	BlogService blogservice = new BlogService();
	
	public void index(){
		
		//setAttr("blogPage", blogservice.paginate(getParaToInt(0, 1), 3));
		
		render("index.html");
	}
	
	public void edit(){
		//setAttr("blog", blogservice.findbyid(getParaToInt()));
		render("edit.html");
	}
	
	public void blog(){
		//Blog blog = getModel(Blog.class)
				
				
		render("index.html");
	}
	
	
	
}
