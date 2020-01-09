package com.imooc.jxc.service.system;

import com.imooc.jxc.common.ResponseResult;
import com.imooc.jxc.entity.SysUserInfo;

import java.util.List;

/**
 * createtime: 2019/11/28  21:22
 * author: zhangbiao
 */
public interface SysUserInfoService {
    /**
     * 通过用户名密码查询用户信息
     * @param name
     * @param password
     * @return
     */
    SysUserInfo  getUserInfoByNameAndPwd(String name, String password);

    /**
     * 注册用户
     * @param userInfo
     * @return
     */
    ResponseResult  registerUser(SysUserInfo userInfo);

    /**
     * 通过姓名查找用户
     * @param name
     * @return
     */
    SysUserInfo  queryUserInfoByName(String name);
    /**
     * 通过手机查找用户
     * @param phone
     * @return
     */
    SysUserInfo  queryUserInfoByPhone(String phone);

    /**
     * 通过邮箱查找用户
     * @param email
     * @return
     */
    SysUserInfo  queryUserInfoByEamil(String email);

    /**
     * 通过用户id 删除用户信息
     * @param id
     * @return
     */
    ResponseResult deleteUserInfoById(int id);



}
