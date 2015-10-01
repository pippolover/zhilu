package com.springapp.dao;

import com.springapp.dao.provider.UpdateProductProvider;
import com.springapp.dateModel.ProductInfoDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

/**
 * Created by yimingwym on 15/9/23.
 */
public interface ProductInfoDAO {
    @Insert("insert into product_info(id,batch,color,sequence,season,order_num) values(#{id},#{batch},#{color},#{sequence},#{season},#{orderNum})")
    public int insertProductInfo(ProductInfoDO productInfoDO);

    //查询指定id的款式
    @Select("select * from product_info where id = #{id}")
    public ProductInfoDO get(@Param("id")String id);

    //模糊查询相似id的款式
    @Select("select * from product_info where id like '%#{idPrefix}%'")
    public List<ProductInfoDO> query(@Param("idPrefix") String idPrefix);


    @UpdateProvider(type = UpdateProductProvider.class,method = "update")
    public int update(ProductInfoDO productInfoDO);

}
