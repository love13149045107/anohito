package com.ggjj.zhzz.mapper;

import com.ggjj.zhzz.pojo.Loc;
import com.ggjj.zhzz.pojo.LocExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LocMapper {
    int countByExample(LocExample example);

    int deleteByExample(LocExample example);

    int deleteByPrimaryKey(Integer loc);

    int insert(Loc record);

    int insertSelective(Loc record);

    List<Loc> selectByExample(LocExample example);

    Loc selectByPrimaryKey(Integer loc);

    int updateByExampleSelective(@Param("record") Loc record, @Param("example") LocExample example);

    int updateByExample(@Param("record") Loc record, @Param("example") LocExample example);

    int updateByPrimaryKeySelective(Loc record);

    int updateByPrimaryKey(Loc record);
}