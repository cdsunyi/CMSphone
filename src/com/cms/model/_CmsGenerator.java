package com.cms.model;

import javax.sql.DataSource;

import com.cms.Config.CmsConfig;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.generator.Generator;
import com.jfinal.plugin.druid.DruidPlugin;

public class _CmsGenerator {
	
	public static DataSource getDataSource() {
		PropKit.use("CmsConfig.txt");
		DruidPlugin druidPlugin = CmsConfig.createDruidPlugin();
		druidPlugin.start();
		return druidPlugin.getDataSource();
	}
	
	public static void main(String[] args){
		System.out.println(PathKit.getWebRootPath());
		String baseModelOutputDir1 = PathKit.getWebRootPath() + "/../src/com/cms/model/base";
		System.out.println(baseModelOutputDir1);
		// base model 所使用的包名
		String baseModelPackageName = "com.cms.model.base";
		// base model 文件保存路径
		String baseModelOutputDir = PathKit.getWebRootPath() + "/../src/com/cms/model/base";
		
		// model 所使用的包名 (MappingKit 默认使用的包名)
		String modelPackageName = "com.cms.model";
		// model 文件保存路径 (MappingKit 与 DataDictionary 文件默认保存路径)
		String modelOutputDir = baseModelOutputDir + "/..";
		
		
		Generator generator = new Generator(getDataSource(), baseModelPackageName, baseModelOutputDir, modelPackageName, modelOutputDir);
	
		// 添加不需要生成的表名
		//generator.addExcludedTable("test1");
		// 设置是否在 Model 中生成 dao 对象
		generator.setGenerateDaoInModel(true);
		// 设置是否生成链式 setter 方法
		generator.setGenerateChainSetter(true);
		// 设置是否生成字典文件
		generator.setGenerateDataDictionary(false);
		// 设置需要被移除的表名前缀用于生成modelName。例如表名 "osc_user"，移除前缀 "osc_"后生成的model名为 "User"而非 OscUser
		generator.setRemovedTableNamePrefixes("cms_");
		// 生成
		generator.generate();
				
	}
	
}
