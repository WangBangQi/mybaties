package com.zimo.mybaties.dao;

import com.zimo.mybaties.model.Assistant;
import org.apache.ibatis.annotations.Param;

public interface AssistantMapper {

    void insert(Assistant assistant);

    Assistant searchByAssId(@Param("assistantId") Integer assistantId);
}
