package com.junge.demo.mybatis.simple.dao;

import java.util.List;

import com.junge.demo.mybatis.simple.model.GoodsInfo;

public interface GoodsInfoMapper {
    int deleteByPrimaryKey(Long goodsid);

    int insert(GoodsInfo record);

    int insertSelective(GoodsInfo record);

    GoodsInfo selectByPrimaryKey(Long goodsid);

    int updateByPrimaryKeySelective(GoodsInfo record);

    int updateByPrimaryKey(GoodsInfo record);
    
    /**
     * 根据商品ID查询商品
     * 
     * @param goodsid
     * @return
     */
    GoodsInfo queryGoodsById(Long goodsid);

    /**
     * 查询所有商品
     * 
     */
	List<GoodsInfo> queryAllGoods();
}