package com.imooc.jxc.controller.system;

import com.imooc.jxc.common.ResponseResult;
import com.imooc.jxc.entity.SysUserInfo;
import com.imooc.jxc.service.system.SysUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * createtime: 2019/11/29  21:47
 * author: zhangbiao
 */
@Controller
@RequestMapping("sys")
public class LogonController {

    @Autowired
    private SysUserInfoService sysUserInfoService;

    /**
     * 用户登陆
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("logon")
    @ResponseBody
    public ResponseResult  logon(String username, String password){
        ResponseResult response = new ResponseResult();
        if(StringUtils.isEmpty(username)){
            response.setMessage("用户名不能为空");
            response.setCode("99999");
            return response;
        }
        if(StringUtils.isEmpty(password)){
            response.setMessage("密码不能为空");
            response.setCode("99999");
            return response;
        }
        SysUserInfo userInfo = sysUserInfoService.getUserInfoByNameAndPwd(username, password);
        if(userInfo == null){
            response.setCode("99999");
            response.setMessage("用户名/密码错误，请重新登陆");
            return response;
        }
        response.setData(userInfo);

        return  response;
    }

    @RequestMapping("index")
    public String initHtml(){
        return "member/index-2";
    }

    public String successHtml(){
        return "first";
    }
}
