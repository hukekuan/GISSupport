package com.gis3c.common.bean;

/**
 * Created by hukekuan on 2018/4/2.
 */
public interface IntEnum<E extends Enum<E>> {
    Integer getIntValue();
}
