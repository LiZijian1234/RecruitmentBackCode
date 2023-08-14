package com.recruitment.constCode;

public class ResumeStatusCashCountConstCode {

//    简历状态
    public static final String UNSUBMIT = "0";//未投
    public static final String UNHANDLE = "1";//已投递待审核
    public static final String UNAPPROVED = "20";//已投审核未通过
    public static final String UNINTERVIEW = "21";//已投审核通过 等待面试
    //    简历状态对应的分数
    public static final Integer UNSUBMITCOUNT = 0;//未投 对应的分数
    public static final Integer UNHANDLECOUNT = 10;//已投递待审核 对应的分数
    public static final Integer UNAPPROVEDCOUNT = 10;//已投审核未通过 对应的分数
    public static final Integer UNINTERVIEWCOUNT = 15;//已投审核通过 对应的分数
}
