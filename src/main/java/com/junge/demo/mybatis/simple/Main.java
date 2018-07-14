package com.junge.demo.mybatis.simple;

import java.math.BigDecimal;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.alibaba.fastjson.JSONObject;
import com.junge.demo.mybatis.simple.dao.GoodsInfoMapper;
import com.junge.demo.mybatis.simple.model.GoodsInfo;

public class Main {

	public static void main(String[] args) throws Exception {
		SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getInstance();

		GoodsInfo goodsInfo1 = new GoodsInfo();
		goodsInfo1.setGoodsname("荣耀畅玩7X 全网通标配版（极光蓝）");
		goodsInfo1.setBarcode("2601010005802");
		goodsInfo1.setPrice(BigDecimal.valueOf(1900.00));
		goodsInfo1.setUnitname("台");
		goodsInfo1.setBrandid(33);
		goodsInfo1.setColor("极光蓝");
		
		GoodsInfo goodsInfo2 = new GoodsInfo();
		goodsInfo2.setGoodsname("HUAWEI Mate 10 Pro 6GB+128GB 全网通版（银钻灰）");
		goodsInfo2.setBarcode("2601010009806");
		goodsInfo2.setPrice(BigDecimal.valueOf(4499.00));
		goodsInfo2.setUnitname("台");
		goodsInfo2.setBrandid(33);
		goodsInfo2.setColor("银钻灰");
		
		
		//addGoodsBySql(sqlSessionFactory);
		
		addGoodsByMapper(sqlSessionFactory, goodsInfo2);
		System.out.println(goodsInfo2.getGoodsid());
		
		queryGoodsById(sqlSessionFactory, 5385L);
	}

	public static void addGoodsBySql(SqlSessionFactory sqlSessionFactory, GoodsInfo goodsInfo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			
			
			sqlSession.insert("com.junge.demo.mybatis.simple.dao.GoodsInfoMapper.insertSelective", goodsInfo);
			
			sqlSession.commit(true);
			
		} finally {
			sqlSession.close();
		}
	}
	
	public static void queryGoodsById(SqlSessionFactory sqlSessionFactory, Long goodsId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			
			GoodsInfo result = sqlSession.selectOne("com.junge.demo.mybatis.simple.dao.GoodsInfoMapper.selectByPrimaryKey", goodsId);
			System.out.println(JSONObject.toJSONString(result));
			
		} finally {
			sqlSession.close();
		}
	}
	
	public static void addGoodsByMapper(SqlSessionFactory sqlSessionFactory, GoodsInfo goodsInfo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			GoodsInfoMapper goodsInfoMapper = sqlSession.getMapper(GoodsInfoMapper.class);
			
			goodsInfoMapper.insertSelective(goodsInfo);
			
			sqlSession.commit(true);
			
		} finally {
			sqlSession.close();
		}
	}
}
