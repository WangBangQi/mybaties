package com.zimo.mybaties.dto.student;

import java.io.Serializable;

/**
 * StudentCache缓存对象
 */
public class StudentCacheDto implements Serializable{
    private String access_token;
    private String refresh_token;
    private String studentNum;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }
}
