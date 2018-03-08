package com.cms.directive;

import java.io.Writer;

import com.jfinal.template.Directive;
import com.jfinal.template.Env;
import com.jfinal.template.expr.ast.Expr;
import com.jfinal.template.stat.Scope;

public class Item_YF extends Directive{

	@Override
	public void exec(Env env, Scope scope, Writer writer) {
		// TODO Auto-generated method stub
		//Expr idstr = exprList.getExpr(0);
		
		System.out.println(exprList.eval(scope));
		//write(writer, idstr.toString());
	}

}
