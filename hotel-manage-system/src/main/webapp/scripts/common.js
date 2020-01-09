//全局参数获取当前页面的URL地址
var urls = location.href.split('#')[0];
// 服务域名
var service_url = getRootPath();

var successCode="00000";

/**
 * 重写ajax方法，处理session超时，页面重定向问题
 * @param $
 */
(function($){
    //备份jquery的ajax方法  
    var _ajax=$.ajax;

    //重写jquery的ajax方法  
    $.ajax=function(opt){
        //备份opt中error和success方法
        var fn = {
            error:function(XMLHttpRequest, textStatus, errorThrown){},
            success:function(data, textStatus){}
        }
        if(opt.error){
            fn.error=opt.error;
        }
        if(opt.success){
            fn.success=opt.success;
        }
        if(opt.beforeSend){
            fn.beforeSend=opt.beforeSend;
        }

        //扩展增强处理
        var i=0;
        var _opt = $.extend(opt,{
            error:function(XMLHttpRequest, textStatus, errorThrown){
                //错误方法增强处理  
                //判断是否session过期，重定向值登录页面
                var returnObj = $("<div>"+XMLHttpRequest.responseText+"</div>");
                var loginBody = $(returnObj).find("#loginformDiv");
                if(typeof(loginBody) != 'undefined' && loginBody.length>0){
                    getTopWinow().location.href=getRootPath() + "/index";
                }else{
                    fn.error(XMLHttpRequest, textStatus, errorThrown);
                }
            },
            success:function(data, textStatus){
                //成功回调方法增强处理  
                //判断是否session过期，重定向值登录页面
                var returnObj = $("<div>"+data+"</div>");
                var loginBody = $(returnObj).find("#loginformDiv");
                if(typeof(loginBody) != 'undefined' && loginBody.length>0){
                    getTopWinow().location.href=getRootPath() + "/index";
                }else{
                    fn.success(data, textStatus);
                }

            }
        });
        _ajax(_opt);
    };
})(jQuery);

/**
 * 在页面中任何嵌套层次的窗口中获取顶层窗口
 * @return 当前页面的顶层窗口对象
 */
function getTopWinow(){
    var p = window;
    while(p != p.parent){
        p = p.parent;
    }
    return p;
}

//js获取项目根路径，如： http://localhost:8080/project_name
function getRootPath() {
    //获取当前网址，如： http://localhost:8080/project_name/share/meun.jsp
    var curWwwPath = window.document.location.href;
    //获取主机地址之后的目录，如： project_name/share/meun.jsp
    var pathName = window.document.location.pathname;
    var pos = curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8080
    var localhostPaht = curWwwPath.substring(0, pos);
    //获取带"/"的项目名，如：/project_name
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);

    if(localhostPaht.indexOf('manager') != -1 || localhostPaht.indexOf('9156.com') != -1){
        return (localhostPaht + "/");

    }else{
        return (localhostPaht + projectName + "/");
    }
}

/**
 * 扩展函数，获取URL参数 eg: $.getUrlParam("name") name为对应有参数名称
 */
(function($) {
    $.getUrlParam = function(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null)
            return decodeURI(r[2]);
        return null;
    };

    // validform的ajaxurl属性加上服务器path
    $("[ajaxurl]").each(function(){
        $(this).attr("ajaxurl",service_url+$(this).attr("ajaxurl"));
    });
})(jQuery);

/**
 * 判断字符串是否以某特定字符串结尾 使用示例：string.endsWith();
 *
 * @param str
 *            要判断的结尾字符串
 */
String.prototype.endsWith = function(str) {
    if (str == null || str == "" || this.length == 0 || str.length > this.length)
        return false;
    if (this.substring(this.length - str.length) == str)
        return true;
    else
        return false;
    return true;
};

/**
 * 判断字符串是否以某特定的字符串结尾 使用示例：string.startWith();
 *
 * @param str
 *            要判断的结尾字符串
 */
String.prototype.startWith = function(str) {
    if (str == null || str == "" || this.length == 0 || str.length > this.length)
        return false;
    if (this.substring(0, str.length) == str)
        return true;
    else
        return false;
    return true;
};

/**
 * 平滑滚动至某锚点的位置
 *
 * @param obj
 *            指定锚点的选择器
 * @param time
 *            要过渡的时间，毫秒
 */
function _scroll(obj, time) {
    $('html,body').animate({
        scrollTop: $(obj).offset().top
    }, time);
}

/*全屏Tab查看新页面*/
function fullscreen_layout(title, url) {
    var index = layer.open({
        type: 2,
        title: title,
        content: url,
    });
    layer.full(index);
}

//详细信息查看缩略页面
function detail_layout(data) {
    layer.open({
        type: 1,
        skin: 'layui-layer-rim', //加上边框
        area: ['450px', '300px'], //宽高
        content: "<div style='padding:0px 20px;'>"+data+"</div>"
    });
}
//时间格式化
function getDateStr(str){
    var strDate = new Date(str);
    var sDate = strDate.toLocaleString().split(' ')[0];
    return sDate.replace(/年|月/g, '-').replace(/日/g, '');
}

//获取当前页面URL参数
function getLocationUrlParams(){
    var url = window.location.href;
    var paramsStr = url.split("?");
    var paramsJson = $.parseJSON("{}");
    var paramsArray = paramsStr[1].split("&");
    for(var i=0;i<paramsArray.length;i++){
        paramsJson[paramsArray[i].split("=")[0]]=paramsArray[i].split("=")[1];
    }
    return paramsJson;
}

/**
 * 获得月的天数
 * @param dStr
 * @returns
 */
function getMonthDayCnt(dStr){
    var year = dStr.substring(0,4);     //年
    var month= dStr.substring(5,7);     //月  
    var d = new Date(year, month, 0);   //Wed Mar 31 00:00:00 UTC+0800 2010  
    var daysCount = d.getDate();            //本月天数  
    return daysCount;
}

//Html编码获取Html转义实体
function htmlEncode(value){
    return $('<div/>').text(value).html();
}
//Html解码获取Html实体
function htmlDecode(value){
    return $('<div/>').html(value).text();
}

function nvl(str){
    if(str == null || str == 'undefined'){
        return "";
    }
    return str;
}
//判断字符串是否为空
function isNotNull(str) {
    if(str != null && str != '' && typeof(str) != 'undefined'){
        return true;
    }else {
        return false;
    }
}
//设置select指定option选中
function setSletcted(labelId,value) {
    var select = document.getElementById(labelId);
    for (var i = 0; i < select.options.length; i++){
        if (select.options[i].value == value){
            select.options[i].selected = true;
            break;
        }
    }
}

/**
 * 重置
 * */
function rest() {
    var input = $("input[type='text']");
    $.each(input,function () {
        this.value="";
    })
    var select = $(".select");
    $.each(select,function () {
        this.options[0].selected = true;
    })
}

/**
 * 获取当前日期 yyyy-MM-dd格式
 * @returns {string}
 */
function getDate(){
    var date = new Date();
    var seperator1 = "-";
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var submitTime = year + month  + strDate;
    return submitTime;
}
