/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.springapp.mvc.api;

import java.lang.String; /**
 * Common result of REST API response
 * 
 * @author midang
 * @version $Id: APIResult.java, v 0.1 2014年12月18日 下午3:36:49 midang Exp $
 */
public class APIResult<T> {

    private boolean success;
    private String  errorMessage;
    private T       result;

    public APIResult() {
    }

    public APIResult(boolean success, String errorMessage) {
        this.success = success;
        this.errorMessage = errorMessage;
    }

    public APIResult(T result) {
        this.success = true;
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

}
