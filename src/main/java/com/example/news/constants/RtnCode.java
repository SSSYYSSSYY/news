package com.example.news.constants;

public enum RtnCode {

	SUCCESSFUL("200", "successful!"),//注意是用逗號串接
	DATA_ERROR("400", "data error!"),
	NOT_FOUNT("404", "not found!");
	
	private String code;
	
	private String msg;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	//注意他的建構子是私有的
	private RtnCode(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	
}
