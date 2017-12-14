package com.ggjj.zhzz.mapper;

import com.ggjj.zhzz.pojo.Receipt;
import com.ggjj.zhzz.pojo.ReceiptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReceiptMapper {
    int countByExample(ReceiptExample example);

    int deleteByExample(ReceiptExample example);

    int deleteByPrimaryKey(Integer storerkey);

    int insert(Receipt record);

    int insertSelective(Receipt record);

    List<Receipt> selectByExample(ReceiptExample example);

    Receipt selectByPrimaryKey(Integer storerkey);

    int updateByExampleSelective(@Param("record") Receipt record, @Param("example") ReceiptExample example);

    int updateByExample(@Param("record") Receipt record, @Param("example") ReceiptExample example);

    int updateByPrimaryKeySelective(Receipt record);

    int updateByPrimaryKey(Receipt record);
}