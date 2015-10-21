package com.springapp.dao;

import com.springapp.dateModel.MaterialDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by yimingwym on 15/10/21.
 */
public interface MaterialDAO {
    @Insert("insert into material(unique_id,price,factory,width,component,num,type) "
            + "values(#{uniqueId},#{price},#{factory},#{width},#{component},#{num},#{type}) ")
    public int insert(MaterialDO materialDO);

    @Select("select * from material where unique_id = #{uniqueId}")
    public MaterialDO get(@Param("uniqueId") String uniqueId);
}
