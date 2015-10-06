package com.springapp.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by yimingwym on 15/10/6.
 */
public interface SequenceDAO {
    @Select("select current from sequence where name = #{name}")
    public Integer getCurrent(@Param("name")String name);

    @Update("update sequence set current = current+1 where name = #{name}")
    public int updateCurrent(@Param("name") String name);

    @Select("select id from sequence where name = #{name} for update")
    public int lock(@Param("name")String name);

    @Insert("insert into sequence(name,current) values(#{name},1)")
    public int init(@Param("name") String name);
}
