package com.springapp.utils;

import com.springapp.model.ProductInfoVO;

/**
 * Created by yimingwym on 15/10/6.
 */
public class ProductInfoGenerater {
    /**
     * 产生款号
     * 款号的格式
     * 年份（2位）+ 季节（1位）+ 波段（1位）+品类（1位）+流水号（3位）+ 色号(3位)
     * @param productInfoVO
     * @return
     */
    public static String generateId(ProductInfoVO productInfoVO){
        StringBuffer sb = new StringBuffer();
        String year = DateHelper.getCurrentYear();
        //年份
        sb.append(year);
        //季节
        sb.append(productInfoVO.getSeason());
        //波段
        sb.append(productInfoVO.getBatch());
        //品类
        sb.append(productInfoVO.getCategory());
        //流水号
        sb.append(productInfoVO.getSequence());
        //色号
        sb.append(productInfoVO.getColor());
        return sb.toString();
    }

    public static void main(String[] args){
        ProductInfoVO productInfoVO = new ProductInfoVO();
        productInfoVO.setBatch("2");
        productInfoVO.setSeason("2");
        productInfoVO.setCategory("3");
        productInfoVO.setSequence("001");
        productInfoVO.setColor("101");
        System.out.print(generateId(productInfoVO));
    }
}
