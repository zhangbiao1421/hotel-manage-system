package com.imooc.jxc.service.member;

import com.imooc.jxc.common.PageInfo;
import com.imooc.jxc.entity.HmMember;

/**
 * Created by IntelliJ IDEA.
 * User: zhangbiao
 * Date: 2019/11/30
 * Time: 9:20
 * To change this template use File | Settings | File Templates.
 */
public interface HmMemberScoreService {

    /**
     * 会员积分列表查询
     * @param pageNumber
     * @param pageSize
     * @param name
     * @param phone
     * @return
     */
    PageInfo<HmMember> queryPageInfo(int pageNumber, int pageSize, String name, String phone );

    /**
     * 通过手机号查询会员信息
     * @param phone
     * @return
     */
    HmMember getHmMemberByPhone(String phone);

    /**
     * 修改会员积分信息
     * @param hmMember
     */
    int updateHmMemberByPhone(HmMember hmMember);

    /**
     * 增加会员积分信息
     * @param hmMember
     * @return
     */
    int insertHmMember(HmMember hmMember);

}
