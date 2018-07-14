package com.junge.demo.mybatis.simple.dao;

import com.junge.demo.mybatis.simple.model.GoodsInfo;

public interface GoodsInfoMapper {
    int deleteByPrimaryKey(Long goodsid);

    int insert(GoodsInfo record);

    int insertSelective(GoodsInfo record);

    GoodsInfo selectByPrimaryKey(Long goodsid);

    int updateByPrimaryKeySelective(GoodsInfo record);

    int updateByPrimaryKey(GoodsInfo record);
}