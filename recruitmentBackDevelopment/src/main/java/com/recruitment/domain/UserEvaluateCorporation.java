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
 * @since 2022-05-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_user_evaluate_corporation")
public class UserEvaluateCorporation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 无用ID
     */
    @TableId(value = "id_useless", type = IdType.AUTO)
    private Long idUseless;

    /**
     * 公司id 
     */
    private String corporationId;

    /**
     * OpenId识别用户唯一ID
     */
    private String userId;

    /**
     * 用户评价
     */
    private String userEvaluate;

    /**
     * 公司获得总分
     */
    private String corporationScoreSum;

    /**
     * 用户评分
     */
    private String userScore;

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
     * 图片URL
     */
    private String picture1;

    private String picture2;

    private String picture3;

    private String picture4;

    private String picture5;

    private String picture6;

    private String picture7;

    private String picture8;

    private String picture9;


}
