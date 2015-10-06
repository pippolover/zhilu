package com.springapp.dao;

import com.springapp.dateModel.AccessoryDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;

/**
 * Created by yimingwym on 15/10/6.
 */
public interface AccessoryDAO {
    @Insert("insert into accessory(type,num,specs,factory,product_id,price,memo) "
            + "values(#{type},#{num},#{specs},#{factory},#{productId},#{price},#{memo})")
    @SelectKey(before = false, keyProperty = "id", resultType = Integer.class, statementType = StatementType.STATEMENT, statement = "SELECT LAST_INSERT_ID() AS id")
    public int insert(AccessoryDO accessoryDO);

    @Select("select * from accessory where product_id = #{productId}")
    public List<AccessoryDO> getByProduct(@Param("productId") String productId);
}
