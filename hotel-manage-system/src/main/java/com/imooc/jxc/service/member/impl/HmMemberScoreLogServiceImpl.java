package com.imooc.jxc.service.member.impl;

import com.github.pagehelper.PageHelper;
import com.imooc.jxc.common.PageInfo;
import com.imooc.jxc.dao.HmMemberScoreLogMapper;
import com.imooc.jxc.entity.HmMemberScoreLog;
import com.imooc.jxc.service.member.HmMemberScoreLogService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: zhangbiao
 * Date: 2019/11/30
 * Time: 14:42
 * To change this template use File | Settings | File Templates.
 */
@Transactional
@Service
public class HmMemberScoreLogServiceImpl implements HmMemberScoreLogService {
    @Resource
    private HmMemberScoreLogMapper hmMemberScoreLogMapper;

    @Override
    public PageInfo<Map> queryPageInfo(int pageNumber, int pageSize, String name, String phone) {
        Map param = new HashMap();
        if(StringUtils.isNotEmpty(name)){
            param.put("name", name);
        }
        if(StringUtils.isNotEmpty(phone)){
            param.put("phone", phone);
        }
        List<Map> list = hmMemberScoreLogMapper.queryHmMemberScoreLog(param);
        PageHelper.startPage(pageNumber, pageSize);
        return new PageInfo<>(list);
    }

    @Override
    public int insertHmMemberScoreLog(HmMemberScoreLog scoreLog) {
        scoreLog.setCreatetime(new Date());
        scoreLog.setUpaatetime(new Date());
        return hmMemberScoreLogMapper.insertSelective(scoreLog);
    }
}
