package com.imooc.jxc.service.system.impl;

import com.imooc.jxc.common.ResponseResult;
import com.imooc.jxc.dao.SysUserInfoMapper;
import com.imooc.jxc.entity.SysUserInfo;
import com.imooc.jxc.entity.SysUserInfoExample;
import com.imooc.jxc.service.system.SysUserInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * createtime: 2019/11/28  21:23
 * author: zhangbiao
 */
@Service
@Transactional
public class SysUserInfoServiceImpl  implements SysUserInfoService {
    @Resource
    private SysUserInfoMapper sysUserInfoMapper;

    @Override
    public SysUserInfo  getUserInfoByNameAndPwd(String name, String password) {
        SysUserInfoExample example = new SysUserInfoExample();
        example.createCriteria().andUsernameEqualTo(name).andPasswordEqualTo(password);
        List<SysUserInfo> list = sysUserInfoMapper.selectByExample(example);
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public ResponseResult registerUser(SysUserInfo userInfo) {
        ResponseResult response = new ResponseResult();
        if(userInfo == null){
            response.setCode("99999");
            response.setMessage("未获取到用户信息，保存失败");
            return response;
        }
        int i = sysUserInfoMapper.insertSelective(userInfo);
        if(i < 1){
            response.setCode("99989");
            response.setMessage("用户信息，保存失败");
            return response;
        }
        return response;
    }

    @Override
    public SysUserInfo queryUserInfoByName(String name) {
        SysUserInfoExample example = new SysUserInfoExample();
        example.createCriteria().andUsernameEqualTo(name);
        List<SysUserInfo> list = sysUserInfoMapper.selectByExample(example);
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public SysUserInfo queryUserInfoByPhone(String phone) {
        SysUserInfoExample example = new SysUserInfoExample();
        example.createCriteria().andPhoneEqualTo(phone);
        List<SysUserInfo> list = sysUserInfoMapper.selectByExample(example);
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public SysUserInfo queryUserInfoByEamil(String email) {
        SysUserInfoExample example = new SysUserInfoExample();
        example.createCriteria().andEmailEqualTo(email);
        List<SysUserInfo> list = sysUserInfoMapper.selectByExample(example);
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public ResponseResult deleteUserInfoById(int id) {
        ResponseResult response = new ResponseResult();
        if(id > 0 ){
            int count = sysUserInfoMapper.deleteByPrimaryKey(id);
            if(count == 1){
                return response;
            }
        }
        response.setCode("99999");
        response.setMessage("删除失败");
        return response;
    }
}
