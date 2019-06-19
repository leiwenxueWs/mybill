/**
 * Baijiahulian.com Inc.
 * Copyright (c) 2014-2017 All Rights Reserved.
 */
package com.util;

import lombok.Data;

/**
 * @title Pager
 * @desc description
 * @author macrohuang
 * @date Nov 7, 2017
 * @version version
 */
@Data
public class Pager {
    public static final int DEFAULT_PAGE_NUM = 1;
    public static final int DEFAULT_PAGE_SIZE = 20;

    private int pageSize;
    private int pageNum;
    private int count;

    public static Pager defaultPager() {
        Pager pager = new Pager();
        pager.pageNum = DEFAULT_PAGE_NUM;
        pager.pageSize = DEFAULT_PAGE_SIZE;
        return pager;
    }
}
