package com.springapp.dao;

import com.springapp.dateModel.ProductionDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.mapping.StatementType;

/**
 * Created by yimingwym on 15/12/6.
 */
public interface ProductionDAO {
    @Insert("insert into production(production_transaction,num,gmt_create,product_id,memo)"
            + " values(#{productionTransaction},#{num},#{gmtCreate},#{productId},#{memo}) ")
    @SelectKey(before = false, keyProperty = "id", resultType = Integer.class, statementType = StatementType.STATEMENT, statement = "SELECT LAST_INSERT_ID() AS id")
    public int add(ProductionDO productionDO);

    @Select("select sum(num) from production where product_id = #{productId}")
    public Integer getTotalNumByProduct(@Param("productId") String productId);
}
