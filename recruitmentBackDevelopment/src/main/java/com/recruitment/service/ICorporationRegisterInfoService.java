package com.recruitment.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.recruitment.domain.CorporationRegisterInfo;


import java.util.List;

/**
 * <p>
 * 使用者 服务类
 * </p>
 *
 * @author 王磊
 * @since 2022-05-20
 */
public interface ICorporationRegisterInfoService extends IService<CorporationRegisterInfo> {
    /**
     * 根据hrId增加
     */
    Boolean registerCorporationById(CorporationRegisterInfo corporationRegisterInfo);
    /**
     * 逻辑删除_根据id删除
     */
    Boolean deleteLogicByID(String id);
    /**
     * 根据Id（批量）查询公司注册信息
     */
    List<CorporationRegisterInfo> getCorporationRegisterInfoById(String id);
    /**
     * 查询所有公司注册信息
     */
    List<CorporationRegisterInfo> getAllCorporationRegisterInfo();

}
