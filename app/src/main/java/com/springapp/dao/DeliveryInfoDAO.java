package com.springapp.dao;

import com.springapp.dateModel.DeliveryInfoDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by yimingwym on 15/12/13.
 */
public interface DeliveryInfoDAO {

    @Insert("insert into delivery_info(delivery_id,product_id,num,vender_id,memo,gmt_create,gmt_modified)"
            + " values(#{deliveryId},#{productId},#{num},#{venderId},#{memo},#{gmtCreate},#{gmtModified})")
    public int addDeliveryInfo(DeliveryInfoDO deliveryInfoDO);

    @Select("select sum(num) from delivery_info where product_id = #{productId}")
    public Integer getTotalDeliveriedByProduct(@Param("productId")String productId);

    @Select("select sum(num) from delivery_info where vender_id = #{venderId}")
    public Integer getTotalDeliveriedByVender(@Param("venderId") String venderId);
}
