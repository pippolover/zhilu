package com.springapp.dao.provider;

import com.springapp.dateModel.VenderDO;
import org.springframework.util.StringUtils;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

/**
 * Created by yimingwym on 15/10/23.
 */
public class VenderProvider {
    //更新
    public String update(VenderDO venderDO){
        BEGIN();
        UPDATE("vendor");
        if(!StringUtils.isEmpty(venderDO.getDistrict())) {
            SET("distinct = #{distinct}");
        }
        if (!StringUtils.isEmpty(venderDO.getContacter())){
            SET("contacter = #{contacter}");
        }
        if(!StringUtils.isEmpty(venderDO.getMobile())){
            SET("mobile = #{mobile}");
        }
        if (!StringUtils.isEmpty(venderDO.getAddress())){
            SET("address = #{address}");
        }
        WHERE("id = #{id}");
        return SQL();
    }
}
