/**
 * Baijiahulian.com Inc. Copyright (c) 2014-2017 All Rights Reserved.
 */
package com.util;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @title RestResponse
 * @desc description
 * @author macrohuang
 * @date Nov 7, 2017
 * @version version
 */
@ToString
public class RestResponse<T> implements Serializable{

    private static final long serialVersionUID = 605544666575940834L;
    public static final int SUCCESS = 0;
    public static final int FAIL = 1;
    @Getter
    private final int code;
    @Getter
    private final T data;
    @Getter
    private final String msg;
    @Getter
    @Setter
    private Pager pager;

    private RestResponse(final int code, final T result, final String msg, final Pager pager) {
        this.code = code;
        this.data = result;
        this.msg = msg;
        this.pager = pager;
    }


    public static <T> RestResponse<T> success(final T result) {
        return new RestResponse<T>(SUCCESS, result, "成功", null);
    }

    public static <T> RestResponse<T> successMsg(final T result, final String msg) {
        return new RestResponse<T>(SUCCESS, result, msg, null);
    }

    public static <T> RestResponse<T> success(final T result, final Pager pager) {
        return new RestResponse<T>(SUCCESS, result, null, pager);
    }

    public static <T> RestResponse<T> fail(final T result, final String msg, final Pager pager) {
        return new RestResponse<T>(FAIL, result, msg, pager);
    }

    public static <T> RestResponse<T> fail(final String msg, final Pager pager) {
        return new RestResponse<T>(FAIL, null, msg, pager);
    }

    public static <T> RestResponse<T> fail(final String msg) {
        return new RestResponse<T>(FAIL, null, msg, null);
    }

}
