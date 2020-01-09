package com.imooc.jxc.service.member.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import com.imooc.jxc.common.PageInfo;
import com.imooc.jxc.dao.HmMemberMapper;
import com.imooc.jxc.entity.HmMember;
import com.imooc.jxc.entity.HmMemberExample;
import com.imooc.jxc.service.member.HmMemberScoreService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zhangbiao
 * Date: 2019/11/30
 * Time: 9:30
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class HmMemberScoreServiceImpl implements HmMemberScoreService {

    @Resource
    private HmMemberMapper hmMemberMapper;

    @Override
    public PageInfo<HmMember> queryPageInfo(int pageNumber, int pageSize, String name, String phone ){
        HmMemberExample example = new HmMemberExample();
        HmMemberExample.Criteria criteria = example.createCriteria();
        if(StringUtil.isNotEmpty(name)){
            criteria = criteria.andMembernameLike("%" + name + "%");
        }
        if(StringUtil.isNotEmpty(phone)){
            criteria= criteria.andMemberphoneLike(phone +"%");
        }
        example.setOrderByClause( " updatetime desc");
        PageHelper.startPage(pageNumber, pageSize);
        return new PageInfo<HmMember>(hmMemberMapper.selectByExample(example));
    }

    @Override
    public HmMember getHmMemberByPhone(String phone) {
        HmMemberExample example = new HmMemberExample();
        if(StringUtils.isEmpty(phone)){
            return null;
        }
        example.createCriteria().andMemberphoneEqualTo(phone);
        List<HmMember> list = hmMemberMapper.selectByExample(example);
        if(list != null && list.size() > 0){
            return list.get(0);
        }

        return null;
    }

    @Override
    public int updateHmMemberByPhone(HmMember hmMember) {
        hmMember.setUpdatetime(new Date());
        HmMemberExample example = new HmMemberExample();
        example.createCriteria().andMemberphoneEqualTo(hmMember.getMemberphone());
        return hmMemberMapper.updateByExampleSelective(hmMember,example);
    }

    @Override
    public int insertHmMember(HmMember hmMember) {
        hmMember.setCreatetime(new Date());
        hmMember.setUpdatetime(new Date());
        return  hmMemberMapper.insertSelective(hmMember);
    }

}
