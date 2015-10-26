package com.springapp.dao;

import com.springapp.dateModel.MaterialDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;

/**
 * Created by yimingwym on 15/10/21.
 */
public interface MaterialDAO {
    @Insert("insert into material(unique_id,price,factory,width,component,num,type) "
            + "values(#{uniqueId},#{price},#{factory},#{width},#{component},#{num},#{type}) ")
    @SelectKey(before = false, keyProperty = "id", resultType = Integer.class, statementType = StatementType.STATEMENT, statement = "SELECT LAST_INSERT_ID() AS id")
    public int insert(MaterialDO materialDO);

    @Select("select * from material where unique_id = #{uniqueId}")
    public MaterialDO get(@Param("uniqueId") String uniqueId);

    @Select("select * from material where 1=1")
    public List<MaterialDO> queryAll();
}
