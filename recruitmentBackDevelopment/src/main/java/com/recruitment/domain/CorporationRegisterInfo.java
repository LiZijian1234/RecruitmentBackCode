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
 * @since 2022-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_corporation_register_info")
public class CorporationRegisterInfo implements Serializable {

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

    private String corporationPhone;

    private String corporationMail;

    private String corporationName;

    /**
     * 存储URL
     */
    private String corporationBusinessLicense;

    private String socialUnicodeCreditCode;

    /**
     * 0-待审核；1-审核通过
     */
    private Integer status;


}
