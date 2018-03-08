package com.cms.Contorller;

import java.util.List;

import com.cms.directive.sharetest;
import com.cms.model.Taxonomy;
import com.cms.service.WinXinService;
import com.jfinal.core.Controller;
import com.jfinal.kit.Kv;
import com.jfinal.render.RenderManager;
import com.jfinal.template.Engine;

public class WeiXinController extends Controller{
	
	WinXinService weixinservice = new WinXinService();
	public void index(){
			
		setAttr("pagetitle", weixinservice.paginate());
		//setAttr("listitem", weixinservice.find("0"));
		
		//System.out.println("--------"+getParaToInt(0));
		String titleNumberString = getPara(0);
		sharetest sh = new sharetest();
		if(titleNumberString == null){
			setAttr("listitem", weixinservice.findFistTitleId());
			setAttr("titlenumber", 1);
			setAttr("rollpic", weixinservice.findTitlePic());
			
			
			sh.setName(titleNumberString);
			render("edit.html");
		}
		else {
			System.out.println(weixinservice.findByTitleId(titleNumberString));
			
			setAttr("listitem", weixinservice.findByTitleId(titleNumberString));
			setAttr("titlenumber", titleNumberString);
			setAttr("rollpic", weixinservice.findTitlePic());
			sh.setName(titleNumberString);
			//renderTemplate("_test.html");
/*			try {
				Engine engine = RenderManager.me().getEngine();
				
				renderHtml(engine.getTemplateByString("#item_yf").renderToString(Kv.by("val", "haha")));
				//Engine.use().getTemplateByString("item_yf").renderToString(Kv.by("val", "haha"));
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
			*/
			//renderJson();
			render("edit.html");
		}
		

		
		//renderText("nihao"+getPara(0));
	}
	
	public void passage(){
		
		setAttr("contentitem", weixinservice.findByContentId(getPara(0)).get(0));
		render("passage.html");
	}
	
}
