package com.student.demo.util;

import java.io.Serializable;
import java.util.List;

/**统一响应对象
 * @author SMILE
 */
public class MyResult implements Serializable{
	//响应码，1代表正常，0表示错误
	private Integer code;
	//响应的文字消息，一般用于错误是的文字提醒
	private String msg;
	//响应到前台的集合数据
	private List<?> data;
	//响应到前台的对象数据（单条）
	private Object obj;
	
	/**
	  * 成功。没有携带响应数据，仅仅只是告诉前端，数据成功了（一般用于更新、删除等操作）
	 */
	public static MyResult SUCCESS = new MyResult();
	
	/**失败
	 * @param message
	 * @return
	 */
	public static MyResult FAILURE(String message) {
		return new MyResult(message);
	}
	
	/** 成功并携带集合数据
	 * @param list
	 * @return
	 */
	public static MyResult SUCCESS_DATA(List<?> list) {
		return new MyResult(list);
	}
	
	/** 成功并携带单个对象数据
	 * @param obj
	 * @return
	 */
	public static MyResult SUCCESS_Object(Object obj) {
		return new MyResult(obj);
	}
	
	public MyResult(List<?> list) {
		this.code=1;
		setData(list);
	}
	
	public MyResult(Object obj) {
		this.code=1;
		setObj(obj);
	}
	
	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	public Object getObj() {
		return obj;
	}
	
	
	public MyResult() {
		this.code=1;
	}


	public MyResult(String msg) {
		this.code = 0;
		this.msg = msg;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<?> getData() {
		return data;
	}
	public void setData(List<?> data) {
		this.data = data;
	}
	
	
}
