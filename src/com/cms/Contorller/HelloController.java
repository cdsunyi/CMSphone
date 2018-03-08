package com.cms.Contorller;

import com.cms.Reoutes.MyRoutes;
import com.jfinal.config.Routes;
import com.jfinal.config.Routes.Route;
import com.jfinal.core.Controller;

public class HelloController extends Controller{
	public void index() {
		String a =  getPara(0);
		String b =  getPara(1);
		//renderText("Hello JFinal World."+a+b);
		render("index.html");

	}
	
	public void test(){
		renderText("niaho");
	}
	
}
