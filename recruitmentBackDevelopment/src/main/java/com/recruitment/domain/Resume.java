package com.recruitment.domain;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 简历
 * </p>
 *
 * @author 王磊
 * @since 2022-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_resume")
public class Resume implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 名义ID 没有用
     */

    private Long idUseless;

    /**
     * 简历 所属用户ID
     */
    private String id;

    /**
     * 简历真实姓名
     */
    @TableField("realName")
    private String realname;

    /**
     * 性别
     */
    private String sex;

    /**
     * 简历创建时间
     */
    @TableField("createdTime")
    private LocalDateTime createdtime;

    /**
     * 电话
     */
    private String telephone;

    /**
     * email
     */
    private String email;

    /**
     * 教育程度
     */
    private String education;

    /**
     * 文件简历的地址
     */
    private String resumeFile;

    /**
     *  出生年份
     */
    private String bornYear;

    /**
     * 专业
     */
    private String profession;

    /**
     * 毕业院校
     */
    private String graduationSchool;

    /**
     * 逻辑删除字段
     */
    @TableLogic
    private Integer isDeleted;

    /**
     * 更新时间
     */
    private LocalDateTime updatetime;

    /**
     * 工作时间
     */
    private String workTime;

    /**
     * 真实头像URL
     */
    private String headPortrait;

    /**
     * 简历所处状态：0--未投；1--已投待HR审核；2--HR审核通过；3--HR审核未通过；
     */
    private Integer status;

    /**
     * 期望职位
     */
    private String expectedPost;

    /**
     * 期望薪资
     */
    private BigDecimal expectedSalary;

    /**
     * 期望工作地点
     */
    private String expectedWorkCity;

    /**
     * 技能和工作经历
     */
    private String skillAndWorkExperience;


}
