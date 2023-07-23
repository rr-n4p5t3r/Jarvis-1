package co.com.spn.cun3.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorInfo {
	
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("status_code")
	private int statusCode;
	
	@JsonProperty("uri")
	private String uriRequested;

	public ErrorInfo(int statusCode, String message, String uriRequested) {
		this.message = message;
		this.statusCode = statusCode;
		this.uriRequested = uriRequested;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getUriRequested() {
		return uriRequested;
	}

	public void setUriRequested(String uriRequested) {
		this.uriRequested = uriRequested;
	}

	@Override
	public String toString() {
		return "ErrorInfo [message=" + message + ", statusCode=" + statusCode + ", uriRequested=" + uriRequested + "]";
	}
	
	

}
