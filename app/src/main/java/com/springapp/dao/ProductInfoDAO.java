package com.springapp.dao;

import com.springapp.dateModel.ProductInfoDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by yimingwym on 15/9/23.
 */
public interface ProductInfoDAO {
    @Insert("insert into product_info(id,batch,color,sequence,season,order_num) values(#{id},#{batch},#{color},#{sequence},#{season},#{orderNum})")
    public int insertProductInfo(ProductInfoDO productInfoDO);

    @Select("select * from product_info where id = #{id}")
    public ProductInfoDO get(@Param("id")String id);
}
