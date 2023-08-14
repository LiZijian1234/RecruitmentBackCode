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
 * @since 2022-06-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_front")
public class Front implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 无用ID
     */
    @TableId(value = "id_useless", type = IdType.AUTO)
    private Long idUseless;

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
     * 轮播图1
     */
    private String slideshow1;

    /**
     * 轮播图2
     */
    private String slideshow2;

    /**
     * 轮播图3
     */
    private String slideshow3;

    /**
     * 轮播图4
     */
    private String slideshow4;

    /**
     * 客服微信图片 
     */
    private String customerServiceWechat;

    /**
     * 轮播图1链接
     */
    private String slideshowLink1;

    /**
     * 轮播图2链接
     */
    private String slideshowLink2;

    /**
     * 轮播图3链接
     */
    private String slideshowLink3;

    /**
     * 轮播图4链接
     */
    private String slideshowLink4;

    /**
     * 简历辅导
     */
    private String resumeCounsel;

    /**
     * 技能培训
     */
    private String skillTraining;

    /**
     * 防诈宣传
     */
    private String fraudPrevention;

    /**
     * 法律咨询
     */
    private String lawConsult;


}
