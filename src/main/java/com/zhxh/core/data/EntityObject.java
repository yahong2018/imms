package com.zhxh.core.data;

import com.zhxh.core.utils.BeanUtils;
import com.zhxh.core.utils.ClassUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public abstract class EntityObject implements Serializable {
    private static final long serialVersionUID = 1L;

    public static void copy(Object from,Object dest){
        if(from==null || dest==null){
            return;
        }
        Class<?> fromClass = from.getClass();
        Class<?> destClass = dest.getClass();

        Field[] fields = ClassUtils.getPublicFields(fromClass);
        Set<String> fns = new HashSet<String>();

        for (Field field : fields) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            try {
                field.set(dest, field.get(from));
                fns.add(field.getName());
            } catch (Exception e) {
                e.printStackTrace();
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
