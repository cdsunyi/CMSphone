package com.cms.service;

import java.math.BigInteger;
import java.util.List;

import com.cms.model.Taxonomy;
import com.jfinal.plugin.activerecord.Page;

public class WinXinService {
	private static final Taxonomy dao = Taxonomy.dao;
	private Page<Taxonomy> page;
	private List<Taxonomy> list;
	//private String tablePrefix = "jpress_";
	private String tablePrefix = "cms_";
	
	/*
	 * 查询标题
	 */
	public Page<Taxonomy> paginate(){
		String tableStr = tablePrefix+"taxonomy";
		page = dao.paginate(1, 10, "select *","from "+tableStr+" where parent_id = '2'");		
		return page;
	}
	
	public List<Taxonomy> findFistTitleId(){
		List<Taxonomy> list = page.getList();
		BigInteger id = list.get(0).getId();
		//System.out.println(list.get(0).getId());
		String tableStrmap = tablePrefix+"mapping";
		String tableStrConntent = tablePrefix+"content";
		list = dao.find("select * from "+tableStrConntent+" where id in (select content_id from "+tableStrmap+" where taxonomy_id = ?)",id);
		return list;
	}
	
	public List<Taxonomy> findByTitleId(String titeId){
		String tableStrmap = tablePrefix+"mapping";
		String tableStrConntent = tablePrefix+"content";
		list = dao.find("select * from "+tableStrConntent+" where id in (select content_id from "+tableStrmap+" where taxonomy_id = ?)",titeId);
		return list;
	}
	
	/*
	 * 查找此模块显示部分是否有pic轮播，如果有则返回相关内容
	 */
	public List<Taxonomy> findTitlePic(){
		String tableStrmap = tablePrefix+"mapping";
		String tableStrConntent = tablePrefix+"content";
		list = dao.find("select * from "+tableStrConntent+" where id in (select content_id from "+tableStrmap+" where taxonomy_id = '5')");
		return list;
	}
	
	public List<Taxonomy> findByContentId(String titeId){
		String tableStr = tablePrefix+"content";
		return dao.find("select * from "+tableStr+" where id = ?",titeId);
	}
	
	public List<Taxonomy> getList() {
		
		return list;
	}
	
	
	
}
