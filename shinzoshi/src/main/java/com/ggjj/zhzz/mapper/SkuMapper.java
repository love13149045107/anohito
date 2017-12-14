package com.ggjj.zhzz.mapper;

import com.ggjj.zhzz.pojo.Sku;
import com.ggjj.zhzz.pojo.SkuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SkuMapper {
    int countByExample(SkuExample example);

    int deleteByExample(SkuExample example);

    int deleteByPrimaryKey(Integer sku);

    int insert(Sku record);

    int insertSelective(Sku record);

    List<Sku> selectByExample(SkuExample example);

    Sku selectByPrimaryKey(Integer sku);

    int updateByExampleSelective(@Param("record") Sku record, @Param("example") SkuExample example);

    int updateByExample(@Param("record") Sku record, @Param("example") SkuExample example);

    int updateByPrimaryKeySelective(Sku record);

    int updateByPrimaryKey(Sku record);
}