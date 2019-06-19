package com.util;

import lombok.Data;

import java.util.List;

/**
 * @author leiwenxue
 * @version 1.0
 * @ClassName SystemSpeciesList
 * @desc SystemSpeciesList
 * @date 2019/4/20 下午3:08
 */
@Data
public class SystemSpeciesList {
    /**
     * 支出
     */
    public static String[] spendingNames = {"餐饮","购物","日用","交通","娱乐","通讯","服饰","美容","医疗","住房","旅行","其他"};

    /**
     * 收入
     */
    public static String[] incomeNames = {"工资","理财","兼职","礼金","其他"};

}
