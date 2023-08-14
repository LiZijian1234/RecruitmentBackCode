package com.recruitment.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 使用者
 * </p>
 *
 * @author 王磊
 * @since 2022-06-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_corporation")
public class Corporation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 无用ID
     */

    private Long idUseless;

    /**
     * hrID
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
     * 公司名称
     */
    private String corporationName;

    /**
     * 公司地理位置编码
     */
    private String corporationLocationDecode;

    /**
     *  公司总部地址
     */
    private String corporationHeadquarters;

    /**
     * 地址补充说明
     */
    private String addressSupplement;

    /**
     *  公司介绍
     */
    private String corporationIntroduction;

    /**
     *  公司图片1
     */
    private String corporationPicture1;

    /**
     *  公司图片2
     */
    private String corporationPicture2;

    /**
     *  公司图片3
     */
    private String corporationPicture3;

    /**
     * 公司图片4
     */
    private String corporationPicture4;

    /**
     *  公司图片5
     */
    private String corporationPicture5;

    /**
     *  公司图片6
     */
    private String corporationPicture6;

    /**
     * 公司联系电话
     */
    private String corporationConnectionPhone;

    /**
     * 公司标签1
     */
    private String corporationTag1;

    /**
     * 公司标签2
     */
    private String corporationTag2;

    /**
     * 公司标签3
     */
    private String corporationTag3;

    /**
     * 公司标签4
     */
    private String corporationTag4;

    /**
     * 公司标签5
     */
    private String corporationTag5;

    /**
     * 公司标签6
     */
    private String corporationTag6;

    /**
     * 公司工商信息URL
     */
    private String corporationRegisterMessage;

    /**
     * 公司推荐值
     */
    private String corporationRecommendValue;

    /**
     * 公司在职人数/员工规模
     */
    private String corporationEmployees;

    /**
     * 公司性质
     */
    private String corporationNature;

    /**
     * 公司行业
     */
    private String corporationIndustry;

    /**
     * 公司图标
     */
    private String corporationLogo;

    /**
     * 行业图标
     */
    private String industryLogo;


}
