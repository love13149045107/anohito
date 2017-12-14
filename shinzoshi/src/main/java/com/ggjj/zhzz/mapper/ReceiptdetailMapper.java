package com.ggjj.zhzz.mapper;

import com.ggjj.zhzz.pojo.Receiptdetail;
import com.ggjj.zhzz.pojo.ReceiptdetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReceiptdetailMapper {
    int countByExample(ReceiptdetailExample example);

    int deleteByExample(ReceiptdetailExample example);

    int deleteByPrimaryKey(Integer receiptdetailId);

    int insert(Receiptdetail record);

    int insertSelective(Receiptdetail record);

    List<Receiptdetail> selectByExample(ReceiptdetailExample example);

    Receiptdetail selectByPrimaryKey(Integer receiptdetailId);

    int updateByExampleSelective(@Param("record") Receiptdetail record, @Param("example") ReceiptdetailExample example);

    int updateByExample(@Param("record") Receiptdetail record, @Param("example") ReceiptdetailExample example);

    int updateByPrimaryKeySelective(Receiptdetail record);

    int updateByPrimaryKey(Receiptdetail record);
}