package com.imooc.jxc.entity;

public class SysMenu {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.identify
     *
     * @mbg.generated
     */
    private String identify;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.url
     *
     * @mbg.generated
     */
    private String url;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.iconCls
     *
     * @mbg.generated
     */
    private String iconcls;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.parentid
     *
     * @mbg.generated
     */
    private Integer parentid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.order
     *
     * @mbg.generated
     */
    private Integer order;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_menu
     *
     * @mbg.generated
     */
    public SysMenu(Integer id, String identify, String name, String url, String iconcls, Integer parentid, Integer order) {
        this.id = id;
        this.identify = identify;
        this.name = name;
        this.url = url;
        this.iconcls = iconcls;
        this.parentid = parentid;
        this.order = order;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_menu
     *
     * @mbg.generated
     */
    public SysMenu() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.id
     *
     * @return the value of sys_menu.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.id
     *
     * @param id the value for sys_menu.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.identify
     *
     * @return the value of sys_menu.identify
     *
     * @mbg.generated
     */
    public String getIdentify() {
        return identify;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.identify
     *
     * @param identify the value for sys_menu.identify
     *
     * @mbg.generated
     */
    public void setIdentify(String identify) {
        this.identify = identify == null ? null : identify.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.name
     *
     * @return the value of sys_menu.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.name
     *
     * @param name the value for sys_menu.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.url
     *
     * @return the value of sys_menu.url
     *
     * @mbg.generated
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.url
     *
     * @param url the value for sys_menu.url
     *
     * @mbg.generated
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.iconCls
     *
     * @return the value of sys_menu.iconCls
     *
     * @mbg.generated
     */
    public String getIconcls() {
        return iconcls;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.iconCls
     *
     * @param iconcls the value for sys_menu.iconCls
     *
     * @mbg.generated
     */
    public void setIconcls(String iconcls) {
        this.iconcls = iconcls == null ? null : iconcls.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.parentid
     *
     * @return the value of sys_menu.parentid
     *
     * @mbg.generated
     */
    public Integer getParentid() {
        return parentid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.parentid
     *
     * @param parentid the value for sys_menu.parentid
     *
     * @mbg.generated
     */
    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.order
     *
     * @return the value of sys_menu.order
     *
     * @mbg.generated
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.order
     *
     * @param order the value for sys_menu.order
     *
     * @mbg.generated
     */
    public void setOrder(Integer order) {
        this.order = order;
    }
}