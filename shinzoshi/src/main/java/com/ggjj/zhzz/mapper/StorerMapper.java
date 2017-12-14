package com.ggjj.zhzz.mapper;

import com.ggjj.zhzz.pojo.Storer;
import com.ggjj.zhzz.pojo.StorerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StorerMapper {
    int countByExample(StorerExample example);

    int deleteByExample(StorerExample example);

    int deleteByPrimaryKey(Integer storerkey);

    int insert(Storer record);

    int insertSelective(Storer record);

    List<Storer> selectByExample(StorerExample example);

    Storer selectByPrimaryKey(Integer storerkey);

    int updateByExampleSelective(@Param("record") Storer record, @Param("example") StorerExample example);

    int updateByExample(@Param("record") Storer record, @Param("example") StorerExample example);

    int updateByPrimaryKeySelective(Storer record);

    int updateByPrimaryKey(Storer record);
}