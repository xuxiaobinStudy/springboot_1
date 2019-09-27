package com.app.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HelloMapper {
    // 获取表中数据量
    public Integer getNumber();

}
