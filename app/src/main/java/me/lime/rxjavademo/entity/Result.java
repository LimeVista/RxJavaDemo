package me.lime.rxjavademo.entity;

public class Result<T> {
	
	private int status;
	private T data;
	private String message;
	
	public Result() {
		super();
	}
	
	public Result(int status, T data, String message) {
		super();
		this.status = status;
		this.data = data;
		this.message = message;
	}


	public int getStatus() {
		return status;
	}
	public Result<T> setStatus(int status) {
		this.status = status;
		return this;
	}
	
	public T getData() {
		return data;
	}
	
	public Result<T> setData(T data) {
		this.data = data;
		return this;
	}
	
	public String getMessage() {
		return message;
	}
	
	public Result<T> setMessage(String message) {
		this.message = message;
		return this;
	}
	
	@Override
	public String toString() {
		return "Result [status=" + status + ", data=" + data + ", message=" + message + "]";
	}
}
