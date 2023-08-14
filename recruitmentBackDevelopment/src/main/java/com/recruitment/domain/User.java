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
 * @since 2022-06-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_user")
public class User implements Serializable {

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
     * 0-学生；1-HR；11-HR 身份待审核；2-管理员；3-园长
     */
    private Integer identity;

    /**
     * 提现金额
     */
    private Integer withdrawCash;

    /**
     * hr 电话
     */
    private String hrPhone;

    /**
     * hr 邮箱
     */
    private String hrMail;

    /**
     * hr 所属公司名称
     */
    private String hrCompanyName;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像URL
     */
    private String headPortrait;


}
