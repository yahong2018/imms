package com.zhxh.core.data.converter;

import com.zhxh.core.utils.Logger;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public abstract class BaseDateConverter<T> implements Converter<String, T> {
    private   PartternConfig partternConfig;

    public PartternConfig getPartternConfig() {
        return partternConfig;
    }

    public void setPartternConfig(PartternConfig partternConfig) {
        this.partternConfig = partternConfig;
    }

    public T convert(String source) {
        for (String parttern : this.partternConfig.getPartternList()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat(parttern);
            dateFormat.setLenient(false);
            try {
                return doConvert(dateFormat,source);
            } catch (ParseException e) {
                Logger.debug("日期格式解析错误:" + parttern);
            }
        }
        return null;
    }

    protected abstract T doConvert(SimpleDateFormat dateFormat, String source) throws ParseException;
}
