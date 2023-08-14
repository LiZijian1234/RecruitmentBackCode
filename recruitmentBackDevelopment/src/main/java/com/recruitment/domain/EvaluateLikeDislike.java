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
 * @since 2022-06-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_evaluate_like_dislike")
public class EvaluateLikeDislike implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 无用ID
     */
    @TableId(value = "id_useless", type = IdType.AUTO)
    private Long idUseless;

    /**
     * OpenId识别用户唯一ID
     */
    private String evaluateOwner;

    /**
     * 点赞 踩 的用户唯一ID
     */
    private String oprationer;

    /**
     * 1：不喜欢  0：取消不喜欢
     */
    private Integer dislike;

    /**
     * 1:喜欢 0：取消喜欢
     */
    private Integer lile;

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
     * 所评论的公司
     */
    private String evaluateCorporation;


}
