package com.imooc.jxc.entity;

import java.util.Date;

public class SysUserInfo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_userinfo.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_userinfo.username
     *
     * @mbg.generated
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_userinfo.password
     *
     * @mbg.generated
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_userinfo.email
     *
     * @mbg.generated
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_userinfo.phone
     *
     * @mbg.generated
     */
    private String phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_userinfo.bitthday
     *
     * @mbg.generated
     */
    private String bitthday;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_userinfo.createtime
     *
     * @mbg.generated
     */
    private Date createtime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_userinfo.updatetime
     *
     * @mbg.generated
     */
    private Date updatetime;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_userinfo
     *
     * @mbg.generated
     */
    public SysUserInfo(Integer id, String username, String password, String email, String phone, String bitthday, Date createtime, Date updatetime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.bitthday = bitthday;
        this.createtime = createtime;
        this.updatetime = updatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_userinfo
     *
     * @mbg.generated
     */
    public SysUserInfo() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_userinfo.id
     *
     * @return the value of sys_userinfo.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_userinfo.id
     *
     * @param id the value for sys_userinfo.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_userinfo.username
     *
     * @return the value of sys_userinfo.username
     *
     * @mbg.generated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_userinfo.username
     *
     * @param username the value for sys_userinfo.username
     *
     * @mbg.generated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_userinfo.password
     *
     * @return the value of sys_userinfo.password
     *
     * @mbg.generated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_userinfo.password
     *
     * @param password the value for sys_userinfo.password
     *
     * @mbg.generated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_userinfo.email
     *
     * @return the value of sys_userinfo.email
     *
     * @mbg.generated
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_userinfo.email
     *
     * @param email the value for sys_userinfo.email
     *
     * @mbg.generated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_userinfo.phone
     *
     * @return the value of sys_userinfo.phone
     *
     * @mbg.generated
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_userinfo.phone
     *
     * @param phone the value for sys_userinfo.phone
     *
     * @mbg.generated
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_userinfo.bitthday
     *
     * @return the value of sys_userinfo.bitthday
     *
     * @mbg.generated
     */
    public String getBitthday() {
        return bitthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_userinfo.bitthday
     *
     * @param bitthday the value for sys_userinfo.bitthday
     *
     * @mbg.generated
     */
    public void setBitthday(String bitthday) {
        this.bitthday = bitthday == null ? null : bitthday.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_userinfo.createtime
     *
     * @return the value of sys_userinfo.createtime
     *
     * @mbg.generated
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_userinfo.createtime
     *
     * @param createtime the value for sys_userinfo.createtime
     *
     * @mbg.generated
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_userinfo.updatetime
     *
     * @return the value of sys_userinfo.updatetime
     *
     * @mbg.generated
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_userinfo.updatetime
     *
     * @param updatetime the value for sys_userinfo.updatetime
     *
     * @mbg.generated
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}