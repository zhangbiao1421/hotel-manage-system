package com.imooc.jxc.controller.member;

import com.imooc.jxc.common.PageInfo;
import com.imooc.jxc.common.ResponseResult;
import com.imooc.jxc.entity.HmMember;
import com.imooc.jxc.entity.HmMemberScoreLog;
import com.imooc.jxc.service.member.HmMemberScoreLogService;
import com.imooc.jxc.service.member.HmMemberScoreService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 会员积分控制层
 * Created by IntelliJ IDEA.
 * User: zhangbiao
 * Date: 2019/11/30
 * Time: 7:19
 * To change this template use File | Settings | File Templates.
 */
@RequestMapping("member")
@Controller
public class MemberScoreController {
    @Autowired
    private HmMemberScoreService memberScoreService;
    @Autowired
    private HmMemberScoreLogService memberScoreLogService;

    @RequestMapping("list")
    public String index(){
//        return "member/memberlist";
        return "member-list";
    }

    @RequestMapping("pageQuery")
    @ResponseBody
    public Map<String, Object> pageQuery(int pageIndex, PageInfo pageInfos, String name, String phone) {
        Map<String,Object> map = new HashMap<>();
        pageInfos.setPageNum(pageIndex + 1);
        PageInfo<HmMember> pageInfo = memberScoreService.queryPageInfo(pageInfos.getPageNum(),pageInfos.getPageSize(),name, phone);
        map.put("total", pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        return map;
    }

    @RequestMapping("insertHmMember")
    @ResponseBody
    public ResponseResult insertHmMember(HmMember hmMember){
        ResponseResult response = new ResponseResult();
        if(hmMember == null){
            response.setCode("99999");
            response.setMessage("未获取到会员信息，请联系管理员");
            return response;
        }
        String phone = hmMember.getMemberphone();
        if(StringUtils.isNotEmpty(phone)){
            if(!validatePhone(phone)){
                response.setCode("90099");
                response.setMessage("手机号格式错误，请输入11位手机号");
                return response;
            }
            HmMember member = memberScoreService.getHmMemberByPhone(phone);
            if(member != null){
                response.setCode("99999");
                response.setMessage("手机号【" + hmMember.getMemberphone() + "】。已被" + hmMember.getMembername() +"注册，请更换手机号，重新注册");
                return response;
            }
        }
        hmMember.setMemberbirthday(hmMember.getMemberbirthday().substring(0,10));
        try {
            int i = memberScoreService.insertHmMember(hmMember);
            if(i <= 0){
                response.setCode("99999");
                response.setMessage("增加失败，请联系管理员");
                return response;
            }
            // 增加日志信息
            HmMemberScoreLog scoreLog = new HmMemberScoreLog();
            // 1 增加 2 删除
            scoreLog.setStatus(1);
            scoreLog.setPhone(hmMember.getMemberphone());
            scoreLog.setMemberscore(hmMember.getMemberscore());
            memberScoreLogService.insertHmMemberScoreLog(scoreLog);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode("99999");
            response.setMessage("增加失败，请联系管理员");
            return response;
        }
        return response;
    }

    /**
     * 更新积分信息
     * @param hmMember
     * @return
     */
    @RequestMapping("updateHmMember")
    @ResponseBody
    public ResponseResult updateHmMember(HmMember hmMember, double addScore){
        ResponseResult response = new ResponseResult();
        if(hmMember == null){
            response.setCode("99999");
            response.setMessage("未获取到会员信息，请联系管理员");
            return response;
        }
        if(StringUtils.isEmpty(hmMember.getMemberphone())){
            response.setCode("99999");
            response.setMessage("未获取到会员手机号，请联系管理员");
            return response;
        }
        hmMember.setMemberbirthday(hmMember.getMemberbirthday().substring(0,10));
        hmMember.setMemberscore(hmMember.getMemberscore() + addScore);
        int i = 0;
        try {
            i = memberScoreService.updateHmMemberByPhone(hmMember);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode("99999");
            response.setMessage("更新失败，请联系管理员");
            return response;
        }
        if(i <= 0){
            response.setCode("99999");
            response.setMessage("增加失败，请联系管理员");
            return response;
        }
        // 增加日志信息
        HmMemberScoreLog scoreLog = new HmMemberScoreLog();
        // 1 增加 2 删除
        scoreLog.setStatus(1);
        scoreLog.setPhone(hmMember.getMemberphone());
        scoreLog.setMemberscore(addScore);
        memberScoreLogService.insertHmMemberScoreLog(scoreLog);
        return response;
    }



    public boolean validatePhone(String phone){

        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(phone);
        boolean isMatch = m.matches();
        return isMatch;
    }


}
