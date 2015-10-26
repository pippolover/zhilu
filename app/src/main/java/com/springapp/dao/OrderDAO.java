package com.springapp.dao;

import com.springapp.dateModel.OrderDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;

/**
 * Created by yimingwym on 15/10/26.
 */
public interface OrderDAO {
    @Insert("insert into orders(vendor_id,product_id,num,gmt_create)"
            + "values(#{vendorId},#{productId},#{num},#{gmtCreate})")
    @SelectKey(before = false, keyProperty = "id", resultType = Integer.class, statementType = StatementType.STATEMENT, statement = "SELECT LAST_INSERT_ID() AS id")
    public int insert(OrderDO orderDO);

    @Select("select sum(num) as num ,product_id from orders group by product_id")
    public List<OrderDO> getProductNum();

    @Select("select sum(num) as num ,vendor_id ,product_id from orders  where product_id = #{productId} group by vendor_id")
    public List<OrderDO> getProductNumByVendor(@Param("productId")String productId);

    @Select("select * from orders where product_id = #{productId}")
    public List<OrderDO> getOrderTransaction(@Param("productId") String productId);

    @Select("select * from orders where vendor_id = #{vendorId}")
    public List<OrderDO> getOrderTransactionByVendor(@Param("vendorId") int vendorId);
}
