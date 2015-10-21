package com.springapp.dao;

import com.springapp.dateModel.ProductRelationDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by yimingwym on 15/10/22.
 */
public interface ProductRelationDAO {
    @Insert("insert into product_relation(product_id,material_unique_id) values(#{productId},#{uniqueId})")
    public int addProductMaterial(@Param("productId")String productId,@Param("uniqueId")String uniqueId);

    @Insert("insert into product_relation(product_id,accessory_unique_id) values(#{productId},#{uniqueId})")
    public int addProductAccessory(@Param("productId")String productId,@Param("uniqueId")String uniqueId);

    @Select("select * from product_relation where product_id = #{productId}")
    public List<ProductRelationDO> query(@Param("productId")String productId);
}
