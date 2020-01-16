package com.javanes.framework.model;





public class ReqBase extends Base {

	private static final long serialVersionUID = 1L;
	
	private String param = "";
	private Integer paramInt;

	public Integer getParamInt() {
		return paramInt;
	}

	public void setParamInt(Integer paramInt) {
		this.paramInt = paramInt;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
