package com.recruitment.controller;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
/**
 * 分页结果类
 * @author Administrator
 *pageResult中四个属性由service层封装，通过构造函数进行封装，剩余5个属性通过内部封装。直接使用即可。
 */
public class PageResult implements Serializable {

    private long total;//总记录数
    private List rows;//当前页记录
    private int pageCurrent;//当前页码
    private int size;//页面显示消息数


    private int totalPage;//总页数
    private int beg;//首页
    private int end;//尾页
    private int pre;//上一页
    private int next;//下一页
    private Object qurreyValue;// 条件构造的语句
    private static int DEFAULT_PAGE_RANGE=4;


    public PageResult(){}
///该四个属性是外部获得
    public PageResult(long total, List rows, int pageCurrent, int size) {
        super();
        this.total = total;
        this.rows = rows;
        this.pageCurrent = pageCurrent;
        this.size = size;
        // 计算
        this.totalPage = (int) (total % size == 0 ? (total/size): (total/size+1));
        // 获取显示起始页码
        calcPage(pageCurrent,totalPage,2);
        this.pre = pageCurrent == 1 ? 1: pageCurrent-1;
        this.next = pageCurrent == totalPage ? totalPage:pageCurrent+1;
    }

    public void calcPage(int pageNum,int pageCount,int sideNum){
        int startNum = 0;
        int endNum = 0;

        if(pageCount<=sideNum){
            endNum = pageCount;
        }else{
            if((sideNum+pageNum)>=pageCount){
                endNum = pageCount;
            }else{
                endNum = sideNum+pageNum;
                if((sideNum+pageNum)<=(2*sideNum+1)){
                    if((2*sideNum+1)>=pageCount){
                        endNum = pageCount;
                    }else{
                        endNum = 2*sideNum+1;
                    }
                }else{
                    endNum = sideNum + pageNum;
                }
            }
        }
        if(pageNum<=sideNum){
            startNum = 1;
        }else{
            if((pageNum+sideNum)>=pageCount){
                if((2*sideNum+1)>=pageCount){
                    if((pageCount - 2*sideNum)>=1){
                        startNum = pageCount - 2*sideNum;
                    }else{
                        startNum = 1;
                    }
                }else{
                    startNum = pageCount - 2*sideNum;
                }
            }else{
                if((pageNum-sideNum)>=1){
                    startNum = pageNum - sideNum;
                }else{
                    startNum = 1;
                }
            }
        }
        this.beg = startNum;
        this.end = endNum;
    }

    public long getTotal() {
        return total;
    }
    public void setTotal(long total) {
        this.total = total;
    }
    public List getRows() {
        return rows;
    }
    public void setRows(List rows) {
        this.rows = rows;
    }

    public int getPageCurrent() {
        return pageCurrent;
    }

    public void setPage(int pageCurrent) {
        this.pageCurrent = pageCurrent;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getBeg() {
        return beg;
    }

    public void setBeg(int beg) {
        this.beg = beg;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getPre() {
        return pre;
    }

    public void setPre(int pre) {
        this.pre = pre;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }
}