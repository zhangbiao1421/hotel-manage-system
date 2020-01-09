package com.imooc.jxc.controller.member;

import com.imooc.jxc.common.PageInfo;
import com.imooc.jxc.entity.HmMember;
import com.imooc.jxc.service.member.HmMemberScoreLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: zhangbiao
 * Date: 2019/12/1
 * Time: 21:52
 * To change this template use File | Settings | File Templates.
 */
@RequestMapping("memberlog")
@Controller
public class MemberScoreLogController {

    @Autowired
    private HmMemberScoreLogService hmMemberScoreLogService;

    @RequestMapping("pageQuery")
    @ResponseBody
    public Map<String, Object> pageQuery(int pageIndex, PageInfo pageInfos, String name, String phone) {
        Map<String,Object> map = new HashMap<>();
        pageInfos.setPageNum(pageIndex + 1);
        PageInfo<Map> pageInfo = hmMemberScoreLogService.queryPageInfo(pageInfos.getPageNum(),pageInfos.getPageSize(),name, phone);
        map.put("total", pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        return map;
    }
}
