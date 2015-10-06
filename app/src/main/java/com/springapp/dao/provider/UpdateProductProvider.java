package com.springapp.dao.provider;

import com.springapp.dateModel.ProductInfoDO;
import org.springframework.util.StringUtils;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

/**
 * Created by yimingwym on 15/10/1.
 */
public class UpdateProductProvider {
    //更新
    public String update(ProductInfoDO productInfoDO){
        BEGIN();
        UPDATE("product_info");
        if(!StringUtils.isEmpty(productInfoDO.getColor())) {
            SET("color = #{color}");
        }
        if (!StringUtils.isEmpty(productInfoDO.getOrderNum())){
            SET("order_num = #{orderNum}");
        }
        WHERE("id = #{id}");
        return SQL();
    }
}
