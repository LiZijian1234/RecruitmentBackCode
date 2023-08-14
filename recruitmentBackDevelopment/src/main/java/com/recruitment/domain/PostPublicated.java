package com.recruitment.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.json.JSONObject;

/**
 * <p>
 * 使用者
 * </p>
 *
 * @author 王磊
 * @since 2022-06-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_post_publicated")
public class PostPublicated implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 无用ID
     */

    private Long idUseless;

    /**
     * OpenId识别用户唯一ID
     */
    private String id;

    /**
     * 创建时间
     */
    private LocalDateTime addtime;

    /**
     * 修改时间
     */
    private LocalDateTime updatetime;

    /**
     * 逻辑删除字段
     */
    @TableLogic
    private Integer isDeleted;

    /**
     * 职位名称
     */
    private String postName;

    /**
     * 日均薪水
     */
    private String daySalary;

    /**
     * 月新
     */
    private String monthSalary;

    /**
     * 职位城市
     */
    private String postLocationCity;

    /**
     * 雇佣时间
     */
    private String hiringTime;

    /**
     * 每周工作几天
     */
    private String workdayEachweek;

    /**
     * 每月休息几天
     */
    private String sapareDayMonth;

    /**
     * 学历要求
     */
    private String educationRequirement;

    /**
     * 职位工作任务
     */
    private String postTask;

    /**
     * 公司信息访问公司获得
     */
    private String corporationInfo;

    /**
     * 技能要求
     */
    private String skillRequirement;

    /**
     * 具体地址
     */
    private String specificLocation;

    /**
     * 地址补充说明
     */
    private String addressSupplement;

    /**
     * 地理编码 经纬度
     */
    private String locationDecode;

    /**
     * 投递要求
     */
    private String deliveryRequiement;

    /**
     * 职位福利
     */

    private String postWelfare;

    /**
     *  公司名称
     */
    private String corporationName;

    /**
     * 岗位联系电话
     */
    private String postConnectionPhone;

    /**
     * 工作经验要求
     */
    private String workExperienceRequirement;

    /**
     * 剩余招聘人数
     */
    private String remainRecruitmentMember;

    /**
     * 招聘人数
     */
    private String recruitmentMember;

    /**
     *  岗位类型
     */
    private String postType;

    /**
     *  岗位标签1
     */
    private String postTag1;

    /**
     * 剩余招聘人数	
     */
    private String postTag2;

    /**
     *  岗位标签3
     */
    private String postTag3;

    /**
     *  岗位标签4
     */
    private String postTag4;

    /**
     *  岗位标签5
     */
    private String postTag5;

    /**
     *  岗位标签6
     */
    private String postTag6;

    /**
     * 岗位推荐数值	
     */
    private String postRecommendValue;


}
