package com.zimo.mybaties.model;

import java.io.Serializable;

/**
 * 辅导员
 */
public class Assistant implements Serializable{
    private Integer assistantId;
    private String assistantNum;    //辅导员编号
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAssistantId() {
        return assistantId;
    }

    public void setAssistantId(Integer assistantId) {
        this.assistantId = assistantId;
    }

    public String getAssistantNum() {
        return assistantNum;
    }

    public void setAssistantNum(String assistantNum) {
        this.assistantNum = assistantNum;
    }
}
