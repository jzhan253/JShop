package com.jincreation.JShop.util;

public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";
    private static final String DEFAULT_FAILURE_MESSAGE = "FAIL";
    private static final int RESULT_SUCCESS_CODE = 200;
    private static final int RESULT_FAILURE_CODE = 500;

    public static Result genSuccessResult(){
        Result result =  new Result();
        result.setResultCode(RESULT_SUCCESS_CODE);
        result.setMessage(DEFAULT_SUCCESS_MESSAGE);
        return result;
    }

    public static Result genSuccessResult(String message){
        Result result = new Result();
        result.setResultCode(RESULT_SUCCESS_CODE);
        if(message == null || message.length() == 0) result.setMessage(DEFAULT_SUCCESS_MESSAGE);
        else result.setMessage(message);
        return result;
    }

    public static Result genSuccessResult(Object data){
        Result result = new Result();
        result.setResultCode(RESULT_SUCCESS_CODE);
        result.setMessage(DEFAULT_SUCCESS_MESSAGE);
        result.setData(data);
        return result;
    }

    public static Result genFailureResult(String message){
        Result result = new Result();
        result.setResultCode(RESULT_FAILURE_CODE);
        if(message == null || message.length() == 0) result.setMessage(DEFAULT_FAILURE_MESSAGE);
        else result.setMessage(message);
        return  result;
    }

    public static Result genErrorResult(int code, String message){
        Result result = new Result();
        result.setResultCode(code);
        result.setMessage(message);
        return result;
    }

}
