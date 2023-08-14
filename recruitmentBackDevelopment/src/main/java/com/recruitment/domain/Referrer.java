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
 * @since 2022-06-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_referrer")
public class Referrer implements Serializable {

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
     * 总积分
     */
    private Integer totalCash;

    /**
     * 被推荐岗位iduseless
     */
    private String recommendedPostiduseless;

    /**
     * 被推荐人openid
     */
    private String recommendedMemberId;

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
     * 已经体现的金额
     */
    private Integer withdrawCash;


}
