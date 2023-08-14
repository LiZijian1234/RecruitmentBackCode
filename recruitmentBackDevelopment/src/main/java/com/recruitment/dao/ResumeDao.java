package com.recruitment.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.recruitment.domain.Resume;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 简历 Mapper 接口
 * </p>
 *
 * @author 王磊
 * @since 2022-05-08
 */
@Mapper
public interface ResumeDao extends BaseMapper<Resume> {}

