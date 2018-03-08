package com.cms.Reoutes;


import com.cms.Contorller.HelloController;
import com.jfinal.config.Routes;
import com.jfinal.core.Controller;

public class MyRoutes extends Routes{

	@Override
	public void config() {
		// TODO Auto-generated method stub
			setBaseViewPath("/app/cms");
			add("/hello", HelloController.class);
		}

	public void getPath(){
		
		System.out.println(getBaseViewPath());
	}
	
}
