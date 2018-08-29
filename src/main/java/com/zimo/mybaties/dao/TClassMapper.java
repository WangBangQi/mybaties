package com.zimo.mybaties.dao;

import com.zimo.mybaties.model.TClass;
import org.apache.ibatis.annotations.Param;

public interface TClassMapper {
    void insert(TClass tClass);

    TClass searchByClassNum(@Param("classNum")String classNum);

    TClass searchById(@Param("classId")Integer classId);
}

