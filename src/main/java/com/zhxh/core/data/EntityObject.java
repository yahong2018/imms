package com.zhxh.core.data;

import com.zhxh.core.utils.BeanUtils;
import com.zhxh.core.utils.ClassUtils;
import com.zhxh.core.utils.Logger;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public interface EntityObject extends Serializable {
    long serialVersionUID = 1L;

    static void copy(Object from, Object dest) {
        if (from == null || dest == null) {
            return;
        }
        Class<?> fromClass = from.getClass();
        Class<?> destClass = dest.getClass();

        Field[] fromFields = ClassUtils.getPublicFields(fromClass);
        Field[] destFields = ClassUtils.getPublicFields(destClass);
        Set<String> fns = new HashSet<String>();

        for (Field field : fromFields) {
            if (Arrays.stream(destFields).filter(x -> x.getName().equalsIgnoreCase(field.getName())).count() == 0) {
                continue;
            }

            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            try {
                field.set(dest, field.get(from));
                fns.add(field.getName());
            } catch (Exception e) {
                Logger.error("EntityObject.copy出现错误:" + e.getMessage());
            }
        }

        String[] props = BeanUtils.getPropertyNames(fromClass);
        for (String prop : props) {
            if (!fns.contains(prop)) {
                Object value = BeanUtils.getValue(from, prop);
                BeanUtils.setValue(dest, prop, value);
            }
        }
        fns.clear();
    }
}
