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
 * @since 2022-05-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_hr_resume_user")
public class HrResumeUser implements Serializable {

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
     * 逻辑删除字段
     */
    @TableLogic
    private Integer isDeleted;

    /**
     * hrid 
     */
    private String hrId;

    /**
     * 职位无用id
     */
    private Long postIduseless;

    /**
     * 简历id
     */
    private String resumeId;

    /**
     * 简历状态1-已投递待审核20-审核未通过21-审核通过等待hr消息
     */
    private String resumeStatus;


}
