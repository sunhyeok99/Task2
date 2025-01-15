package com.example.Api.user.Entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "TEST_SUNHYEOK99" ,schema = "TEST")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "USER_NM", nullable = false)
    private String user_nm;

    @Column(name = "USER_ID", nullable = false)
    private String user_id;

    @Column(name = "PW", nullable = false)
    private String pw;

    @Column(name = "REGI_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regi_dt;

    @Column(name = "REGI_USER", nullable = false)
    private String regi_user;

    @Column(name = "UPDA_DT")
    private Date upda_dt;

    @Column(name = "UPDA_USER")
    private String upda_user;

    @Column(name = "USE_YN", nullable = false)
    private String use_yn = "Y";

    @PrePersist
    public void prePersist() {
        if (regi_dt == null) {
            regi_dt = new Date();  // 현재 시간을 설정
        }
    }
    // 생성자
    public User() {

    }
    public User(String user_nm, String user_id, String pw, Date regi_dt, String regi_user, String use_yn) {
        this.user_nm = user_nm;
        this.user_id = user_id;
        this.pw = pw;
        this.regi_dt = regi_dt;
        this.regi_user = regi_user;
        this.use_yn = use_yn;
    }
    public User(String user_nm, String user_id, String pw, String regi_user) {
        this.user_nm = user_nm;
        this.user_id = user_id;
        this.pw = pw;
        this.regi_dt = new Date();
        this.regi_user = regi_user;
        this.use_yn = "Y";
    }

    // Getters
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

    // 수정 메서드
    public void update(){
        this.upda_user = this.regi_user;
        this.upda_dt = new Date();
    }

    // 삭제 메서드
    public void delete() {
        this.upda_user = this.regi_user;
        this.upda_dt = new Date();
        this.use_yn = "N";
    }

}
