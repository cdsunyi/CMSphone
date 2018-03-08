package com.cms.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseOption<M extends BaseOption<M>> extends Model<M> implements IBean {

	public M setId(java.math.BigInteger id) {
		set("id", id);
		return (M)this;
	}

	public java.math.BigInteger getId() {
		return get("id");
	}

	public M setOptionKey(java.lang.String optionKey) {
		set("option_key", optionKey);
		return (M)this;
	}

	public java.lang.String getOptionKey() {
		return getStr("option_key");
	}

	public M setOptionValue(java.lang.String optionValue) {
		set("option_value", optionValue);
		return (M)this;
	}

	public java.lang.String getOptionValue() {
		return getStr("option_value");
	}

}