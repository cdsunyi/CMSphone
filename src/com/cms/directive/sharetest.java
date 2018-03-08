package com.cms.directive;

public class sharetest {
	private String id = "0";
	public String helloString (String name){
		return "hello "+name+",欢迎你进入王者峡谷！";
	}
	
	public void setName(String id) {
		this.id = id;
	}
	
	public String getName() {
		return id;
	}
	
}
