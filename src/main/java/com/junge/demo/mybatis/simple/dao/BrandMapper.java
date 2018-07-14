package com.junge.demo.mybatis.simple.dao;

import com.junge.demo.mybatis.simple.model.Brand;

public interface BrandMapper {
    int deleteByPrimaryKey(Long brandid);

    int insert(Brand record);

    int insertSelective(Brand record);

    Brand selectByPrimaryKey(Long brandid);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);
}