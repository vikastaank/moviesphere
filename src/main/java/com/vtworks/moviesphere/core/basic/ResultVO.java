package com.vtworks.moviesphere.core.basic;

public class ResultVO<T> {
	private T result;
    private String status;
    private int statusCode;
    private String statusMsg;

    public ResultVO(T t){
        setResult(t);
    }
    public ResultVO(){ }
    
    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
        this.statusCode = HTTPStatus.CODE_SUCCESS;
        this.statusMsg = HTTPStatus.SUCCESS;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }
}
