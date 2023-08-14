package com.recruitment.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.recruitment.domain.Corporation;

import java.util.List;

/**
 * <p>
 * 使用者 服务类
 * </p>
 *
 * @author 王磊
 * @since 2022-05-14
 */
public interface ICorporationService extends IService<Corporation> {
    /**
     * 根据id 增加 公司信息
     */
    Boolean creatCorporationById(Corporation corporation);
    /**
     * 根据ID 修改 公司信息
     */
    Boolean modifyCorporationById(Corporation corporation);

    /**
     * 根据ID 查询 公司信息
     */
    List<Corporation> getCorporationById(String id);
    /**
     * 根据名字 精确查询 公司信息
     */
    Corporation getCorporationByName(String name);
    /**
     * 查询所有    公司信息
     */
    List<Corporation> getAllCorporationInfo();
    /**
     * 判断hr 是否存在公司
     */
    boolean isHavingCorporationById(String id);
    /**
     * 根据输入模糊搜索 公司名称 返回公司名字
     */
    List getCorporationByFuzzyInput(String name);
    /**
     * 查询所有公司的地理位置编码
     */
    List  getAllCorporationAddressDecode();
    /**
     * 根据地理位置编码查询公司
     */
    List getCorporationByAddressDecode(String addressDecode);
    /**
     * 按照行业返回公司信息
     */
    List getCorporationByCorporationIndustry(String corporationIndustry);
    /**
     * 根据ID 删除 公司信息
     */
    Boolean deleteCorporationById(String id);



}
