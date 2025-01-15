package com.example.Api.user.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;
// 전체 데이터 조회할 때 사용
public class UserListDto {

    private Integer id;
    private String user_nm;
    private String user_id;
    private String pw;
    private Date regi_dt;
    private String regi_user;
    private Date upda_dt;
    private String upda_user;
    private String use_yn = "Y";

    public UserListDto(Integer id, String user_nm, String user_id, String pw, Date regi_dt, String regi_user, String upda_user, Date upda_dt, String use_yn) {
        this.id = id;
        this.user_nm = user_nm;
        this.user_id = user_id;
        this.pw = pw;
        this.regi_dt = regi_dt;
        this.regi_user = regi_user;
        this.upda_user = upda_user;
        this.upda_dt = upda_dt;
        this.use_yn = use_yn;
    }
    // getter
    public Integer getId() {
        return id;
    }

    public String getUser_nm() {
        return user_nm;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getPw() {
        return pw;
    }

    public Date getRegi_dt() {
        return regi_dt;
    }

    public String getRegi_user() {
        return regi_user;
    }

    public Date getUpda_dt() {
        return upda_dt;
    }

    public String getUpda_user() {
        return upda_user;
    }

    public String getUse_yn() {
        return use_yn;
    }

}
