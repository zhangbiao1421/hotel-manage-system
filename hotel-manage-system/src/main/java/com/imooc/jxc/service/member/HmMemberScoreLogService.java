package com.imooc.jxc.service.member;

import com.imooc.jxc.common.PageInfo;
import com.imooc.jxc.entity.HmMember;
import com.imooc.jxc.entity.HmMemberScoreLog;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: zhangbiao
 * Date: 2019/11/30
 * Time: 9:20
 * To change this template use File | Settings | File Templates.
 */
public interface HmMemberScoreLogService {

    /**
     * 会员积分历史列表查询
     * @param pageNumber
     * @param pageSize
     * @param name
     * @param phone
     * @return
     */
    PageInfo<Map> queryPageInfo(int pageNumber, int pageSize, String name, String phone );

    /**
     * 增加会员积分日志信息
     * @param scoreLog
     * @return
     */
    int insertHmMemberScoreLog(HmMemberScoreLog scoreLog);
}
