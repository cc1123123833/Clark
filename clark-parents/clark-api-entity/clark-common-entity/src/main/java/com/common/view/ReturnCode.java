package com.common.view;

public enum ReturnCode {

    /** 操作成功 */
    SUCCESS("200","操作成功"),
    /** 操作失败 */
    FAIL("500","操作失败");

    private ReturnCode(String value,String msg){
        this.val = value;
        this.msg = msg;
    }
    public String val() {
        return val;
    }
    public String msg() {
        return msg;
    }
    private String val;
    private String msg;
}
