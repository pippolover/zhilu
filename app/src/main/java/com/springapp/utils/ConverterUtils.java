package com.springapp.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.util.Assert;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jiadong on 15/5/19.
 */
public class ConverterUtils {

    public static <T> T covert(Object source, Class<T> targetClass) {
        if (source == null) {
            return null;
        }
        T target = BeanUtils.instantiate(targetClass);
        copyProperties(source, target);
        return target;
    }

    @SuppressWarnings("rawtypes")
    public static <T> List<T> convertList(List sources, Class<T> targetClass) {
        if (sources == null) {
            return null;
        }
        List<T> list = new ArrayList<>();
        for (Object source : sources) {
            if (source!= null) {
                list.add(covert(source, targetClass));
            }
        }
        return list;
    }

    public static void copyProperties(Object source, Object target) {
        copyProperties(source, target, null);
    }

    /**
     * 复制属性时，考虑枚举和字符串的转换。
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void copyProperties(Object source, Object target, String[] ignoreProperties)
                                                                                              throws BeansException {
        Assert.notNull(source, "Source must not be null");
        Assert.notNull(target, "Target must not be null");

        Class<?> actualEditable = target.getClass();

        PropertyDescriptor[] targetPds = BeanUtils.getPropertyDescriptors(actualEditable);
        List<String> ignoreList = (ignoreProperties != null) ? Arrays.asList(ignoreProperties)
            : null;

        for (PropertyDescriptor targetPd : targetPds) {
            if (targetPd.getWriteMethod() != null
                && (ignoreProperties == null || (!ignoreList.contains(targetPd.getName())))) {
                PropertyDescriptor sourcePd = BeanUtils.getPropertyDescriptor(source.getClass(),
                    targetPd.getName());
                if (sourcePd != null && sourcePd.getReadMethod() != null) {
                    try {
                        Class sourcePropertyClass = sourcePd.getPropertyType();
                        Class targetPropertyClass = targetPd.getPropertyType();

                        Method readMethod = sourcePd.getReadMethod();
                        if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
                            readMethod.setAccessible(true);
                        }
                        Object value = readMethod.invoke(source);

                        if (value != null) {
                            //copy enum
                            if (targetPropertyClass == String.class && sourcePropertyClass.isEnum()) {
                                value = ((Enum<?>) value).name();
                            } else if (targetPropertyClass.isEnum()
                                       && sourcePropertyClass == String.class) {
                                value = Enum.valueOf(targetPropertyClass, (String) value);
                            }
                        }

                        Method writeMethod = targetPd.getWriteMethod();
                        if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                            writeMethod.setAccessible(true);
                        }
                        writeMethod.invoke(target, value);

                    } catch (Throwable ex) {
                        throw new FatalBeanException(
                            "Could not copy properties from source to target", ex);
                    }
                }
            }
        }
    }

}
