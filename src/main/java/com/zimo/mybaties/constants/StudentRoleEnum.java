package com.zimo.mybaties.constants;

public enum  StudentRoleEnum {
    NORMAL(1),
    MONITOR(2),    //班长
    CHAIRMAN (3);   //主席

    Integer value;

    StudentRoleEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
