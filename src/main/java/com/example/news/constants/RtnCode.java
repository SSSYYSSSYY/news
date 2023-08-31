package com.example.news.constants;

public enum RtnCode {

	SUCCESSFUL("200", "successful!"),//�`�N�O�γr���걵
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

	//�`�N�L���غc�l�O�p����
	private RtnCode(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	
}
