package com.springapp.dao;

import com.springapp.dao.provider.VenderProvider;
import com.springapp.dateModel.VenderDO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;

/**
 * Created by yimingwym on 15/10/23.
 */
public interface VenderDAO {

    @Insert("insert into vender(district,contacter,mobile,address) values(#{district},#{contacter},#{mobile},#{address})")
    @SelectKey(before = false, keyProperty = "id", resultType = Integer.class, statementType = StatementType.STATEMENT, statement = "SELECT LAST_INSERT_ID() AS id")
    public int insert(VenderDO venderDO);

    @UpdateProvider(type = VenderProvider.class,method = "update")
    public int update(VenderDO venderDO);

    @Select("select * from vender where id = #{id}")
    public VenderDO get(@Param("id") int id);

    @Select("select * from vender where 1=1")
    public List<VenderDO> queryAll();
}
