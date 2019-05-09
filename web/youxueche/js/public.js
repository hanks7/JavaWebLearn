/**
 * 
 */
var pickerProjectAdd = "http://localhost/cjImg/";

/**
 * 颜色代码  共171个
 */
var colorArray = new Array(
		'#000000','#000033','#0033CC','#000066','#000099','#0000CC',
		'#003300','#0000FF','#0066CC','#003333','#003366','#003399',
		'#006600','#0033FF','#0099CC','#006633','#006666','#006699',
		'#009900','#0066FF','#00CCFF','#009933','#009966','#009999',
		'#00CC33','#0099FF','#00FFCC','#00CC66','#00CC99','#00CCCC',
		'#00FF00','#99FF99','#3300CC','#00FF33','#00FF66','#00FF99',
		'#330000','#00FFFF','#3333CC','#330033','#330066','#330099',
		'#333300','#3300FF','#3366CC','#333333','#333366','#333399',
		'#336600','#3333FF','#3399CC','#336633','#336666','#336699',
		'#339900','#3366FF','#33CCCC','#339933','#339966','#339999',
		'#33CC00','#3399FF','#33FFCC','#33CC33','#33CC66','#33CC99',
		'#33FF00','#33CCFF','#6600CC','#33FF33','#33FF66','#33FF99',
		'#660000','#33FFFF','#6633CC','#660033','#660066','#660099',
		'#663300','#6600FF','#6666CC','#663333','#663366','#663399',
		'#666600','#6633FF','#6699CC','#666633','#666666','#666699',
		'#669900','#6666FF','#66CCCC','#669933','#669966','#669999',
		'#66CC00','#6699FF','#66FFCC','#66CC33','#66CC66','#66CC99',
		'#66FF00','#66CCFF','#9900CC','#66FF33','#66FF66','#66FF99',
		'#990000','#66FFFF','#9933CC','#990033','#990066','#990099',
		'#993300','#9900FF','#9966CC','#993333','#993366','#993399',
		'#996600','#9933FF','#9999CC','#996633','#996666','#996699',
		'#999900','#9966FF','#99CCCC','#999933','#999966','#999999',
		'#99CC00','#9999FF','#CCFF33','#99CC33','#99CC66','#99CC99',
		'#99FF00','#99CCFF','#CC00CC','#99FF33','#99FF66','#CCFF00',
		'#CC0000','#CCFF66','#CC33CC','#CC0033','#CC0066','#CC0099',
		'#CC3300','#CC00FF','#CC66CC','#CC3333','#CC3366','#CC3399',
		'#CC6600','#CC33FF','#CC99CC','#CC6633','#CC6666','#CC6699',
		'#CC9900','#CC66FF','#CCCCCC','#CC9933','#CC9966','#CC9999',
		'#CCCC00','#CC99FF','#FF00CC','#CCCC33','#CCCC66','#CCCC99',
		'#FF0000','#CCCCFF','#FF33CC','#FF0033','#FF0066','#FF0099',
		'#FF3300','#FF00FF','#FF66CC','#FF3333','#FF3366','#FF3399',
		'#FF6600','#FF33FF','#FF99CC','#FF6633','#FF6666','#FF6699',
		'#FF9900','#FF66FF','#FFCCCC','#FF9933','#FF9966','#FF9999',
		'#FFCC00','#FF99FF','#FFCC33','#FFCC66','#FFCC99',
		'#FFFF00','#FFCCFF','#FFFF33');

/**
 * Map
 */
function HashMap(){
    this.map = {};
}
HashMap.prototype = {
    put : function(key , value){
        this.map[key] = value;
    },
    get : function(key){
        if(this.map.hasOwnProperty(key)){
            return this.map[key];
        }
        return null;
    },
    remove : function(key){
        if(this.map.hasOwnProperty(key)){
            return delete this.map[key];
        }
        return false;
    },
    removeAll : function(){
        this.map = {};
    },
    keySet : function(){
        var _keys = [];
        for(var i in this.map){
            _keys.push(i);
        }
        return _keys;
    }
};
HashMap.prototype.constructor = HashMap;


var TERMINAL_HPONE =function()
{
	return parent.document.getElementById('TERMINALPHONE').innerText;
}
function getFormData(obj){

	var retValue="";
	for( var i = 0 ; i < obj.length ;i++){
		if( obj[i].type=="radio"){
			if( obj[i].checked==true){
			 retValue+=+obj[i].name == "" ? obj[i].id:obj[i].name +"="+obj[i].value+"&";
			}
		}else{
			if(obj[i].name=="" && obj[i].id==""){continue;}
			retValue+=( obj[i].name == ""  ?obj[i].id:obj[i].name)+"="+obj[i].value+"&";
		}
	}
	
	return retValue;
}

function getDateByString(strs){
	var year = strs.substring(0,4);
	var month = strs.substring(4,6);
	var day = strs.substring(6,8);
	var hour = strs.substring(8,10);
	var min = strs.substring(10,12);
	return year+"-"+month+"-"+day+" " + hour+":"+min;
}

//清空表单
function clearTable(formId){
	location.reload();
	$('#'+formId)[0].reset();
}

//判断字符串是否为空
function isNull(str){
	if(str != null && str != "" && typeof(str) != "undefined" && str != "请选择"){
		return true;
	}else{
		return false;
	}
}

var chars = ['0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'];

//获得一个15位的名字
function generateMixed(n) {
     var res = "";
     for(var i = 0; i < n ; i ++) {
         var id = Math.ceil(Math.random()*35);
         res += chars[id];
     }
     return res;
}

//创建补0函数
function p(s) {
   return s < 10 ? '0' + s: s;
}

//取得当前时间
function nowdate(){
	var now = new Date();
	var year=now.getFullYear();     
	var month=now.getMonth()+1;     
	var day=now.getDate();     
	var hour=now.getHours();     
	var minute=now.getMinutes();     
	var second=now.getSeconds(); 
	//var nowdates=year+"-"+p(month)+"-"+p(day)+" "+p(hour)+":"+p(minute)+":"+p(second);//带时分秒
	var nowdates2=year+"-"+p(month)+"-"+p(day);//不带时分秒
	return nowdates2;
}

//取得当前日期的前十天的日期
function getDateC10(){
	var now = new Date();
	now.setDate(now.getDate() - 10); // 系统会自动转换
	var year=now.getFullYear();     
	var month=now.getMonth()+1;     
	var day=now.getDate()+1;
	
	//var nowdates=year+"-"+p(month)+"-"+p(day)+" "+p(hour)+":"+p(minute)+":"+p(second);//带时分秒
	var nowdates2=year+"-"+p(month)+"-"+p(day);//不带时分秒
	return nowdates2;
}


//js日期比较(yyyy-mm-dd)
function biJiaoDate(a, b) {
   var arr = a.split("-");
   var starttime = new Date(arr[0], arr[1], arr[2]);
   var starttimes = starttime.getTime();

   var arrs = b.split("-");
   var lktime = new Date(arrs[0], arrs[1], arrs[2]);
   var lktimes = lktime.getTime();

   if (starttimes > lktimes) {
       return 1;
   }else{
       return -1;
   }
}

//js时间比较(yyyy-mm-dd hh:mi:ss)
function comptime() {
   var beginTime = "2009-09-21 00:00:00";
   var endTime = "2009-09-21 00:00:01";
   var beginTimes = beginTime.substring(0, 10).split('-');
   var endTimes = endTime.substring(0, 10).split('-');

   beginTime = beginTimes[1] + '-' + beginTimes[2] + '-' + beginTimes[0] + ' ' + beginTime.substring(10, 19);
   endTime = endTimes[1] + '-' + endTimes[2] + '-' + endTimes[0] + ' ' + endTime.substring(10, 19);

   alert(beginTime + "aaa" + endTime);
   alert(Date.parse(endTime));
   alert(Date.parse(beginTime));
   var a = (Date.parse(endTime) - Date.parse(beginTime)) / 3600 / 1000;
   if (a < 0) {
       alert("endTime小!");
   } else if (a > 0) {
       alert("endTime大!");
   } else if (a == 0) {
       alert("时间相等!");
   } else {
       return 'exception';
   }
}

//默认的填充数据方法
function insertTr(data,eqCount){
	if(data["pageNo"] <= 1){//只有在第一页的时候才会初始化分页控件
	    $(".pager").pagination({
	        recordCount: data["recordTotalCount"],       //总记录数
	        pageSize: data["pageSize"],           		//一页记录数
	        onPageChange: function (pageIndex) {
	        	searchPage(pageIndex,data["pageSize"]);
	        }
	    });
	}
	var result = data["result"];
	var trs = $("#datas tr");
	for(var i = eqCount+1;i < trs.length;i++){
		$(trs[i]).remove();
	}

	if(result.length > 0){
		for(var i = 0; i < result.length; i++){
	        var tr = $("#datas tr").eq(eqCount).clone();
	        tr.removeClass("trW");
			tr.appendTo("#datas");
			var td = $(tr).find("td");
			td.each(function(){
				var recodeName = $(this).attr("name");
				$(this).html("");
				var txt = "";
				/**
				 * class="glyphicon glyphicon-download-alt"	下载
				 * class="glyphicon glyphicon-pencil"		修改
				 * class="glyphicon glyphicon-refresh"		刷新
				 * class="glyphicon glyphicon-print" 		打印
				 * class="glyphicon glyphicon-print" 		图片
				 * class="glyphicon glyphicon-retweet"		转发
				 * class="glyphicon glyphicon-transfer"		转移
				 * class="glyphicon glyphicon-eye-open"		眼睛
				 * 更多图标参考  http://v3.bootcss.com/components/#glyphicons
				 */
				if(recodeName == "id"){
					var otherAttr = $(this).attr("other");
					var id = $(result[i]).attr(recodeName);
					
					txt = '<span onclick="look('+id+');" class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;&nbsp;';
					txt += '<span onclick="del('+id+');" class="glyphicon glyphicon-remove" aria-hidden="true"></span>';
					var flow = $(result[i]).attr("flowBa");//备案流程
					if(otherAttr){
						if(otherAttr == "studentIndex"){
							if(flow != 99){//99为备案成功后的流程
								var funPath = "..\\\\..\\\\http_student\\\\addStudentPutOnRecord.ao"; 
								txt += '&nbsp;&nbsp;<span onclick="baAn(\''+funPath+'\','+id+');" class="glyphicon glyphicon-transfer" aria-hidden="true"></span>';
							}
						}else if(otherAttr == "regionIndex"){
							if(flow != 99){//99为备案成功后的流程
								var funPath = "..\\\\..\\\\http_region\\\\addRegionPutOnRecord.ao"; 
								txt += '&nbsp;&nbsp;<span onclick="baAn(\''+funPath+'\','+id+');" class="glyphicon glyphicon-transfer" aria-hidden="true"></span>';
							}else if(flow == 99){
								var funPath = "..\\\\..\\\\http_region\\\\reviewRegionPutOnRecord.ao"; //备案查询
								txt += '&nbsp;&nbsp;<span onclick="baAnLook(\''+funPath+'\','+id+');" class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>';
							}
						}else if(otherAttr == "driverIndex"){
							if(flow != 99){//99为备案成功后的流程
								var funPath = "..\\\\..\\\\http_coach\\\\addCoachPutOnRecord.ao"; 
								txt += '&nbsp;&nbsp;<span onclick="baAn(\''+funPath+'\','+id+');" class="glyphicon glyphicon-transfer" aria-hidden="true"></span>';
							}
						}else if(otherAttr == "checkPerIndex"){
							if(flow != 99){//99为备案成功后的流程
								var funPath = "..\\\\..\\\\http_checkPer\\\\addExaminerPutOnRecord.ao"; 
								txt += '&nbsp;&nbsp;<span onclick="baAn(\''+funPath+'\','+id+');" class="glyphicon glyphicon-transfer" aria-hidden="true"></span>';
							}
						}else if(otherAttr == "safetyIndex"){
							if(flow != 99){//99为备案成功后的流程
								var funPath = "..\\\\..\\\\http_safetyPer\\\\addSecurityguardPutOnRecord.ao"; 
								txt += '&nbsp;&nbsp;<span onclick="baAn(\''+funPath+'\','+id+');" class="glyphicon glyphicon-transfer" aria-hidden="true"></span>';
							}
						}else if(otherAttr == "carIndex"){
							if(flow != 99){//99为备案成功后的流程
								var funPath = "..\\\\..\\\\http_car\\\\addTrainingcarPutOnRecord.ao"; 
								txt += '&nbsp;&nbsp;<span onclick="baAn(\''+funPath+'\','+id+');" class="glyphicon glyphicon-transfer" aria-hidden="true"></span>';
							}
						}else if(otherAttr == "gradeIndex"){
							if(flow != 99){//99为备案成功后的流程
								var funPath = "..\\\\..\\\\http_grade\\\\addGradePutOnRecord.ao"; 
								txt += '&nbsp;&nbsp;<span onclick="baAn(\''+funPath+'\','+id+');" class="glyphicon glyphicon-transfer" aria-hidden="true"></span>';
							}
						}else if(otherAttr == "cheZaiIndex"){
							if(flow != 99){//99为备案成功后的流程
								var funPath = "..\\\\..\\\\http_device\\\\addDevicePutOnRecord.ao"; 
								txt += '&nbsp;&nbsp;<span onclick="baAn(\''+funPath+'\','+id+');" class="glyphicon glyphicon-transfer" aria-hidden="true"></span>';
							}
						}else if(otherAttr == "recharge"){//glyphicon glyphicon-plus 
							txt = '<span onclick="look('+id+');" class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;&nbsp;';
							txt += '<span onclick="add('+id+');" class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;&nbsp;';
						}else if(otherAttr == "driverTimes"){
							if(result[i]["dictionaryTimes"] == 0){//教练员未绑定时间模板
								txt = '<span onclick="add('+id+');" class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;&nbsp;';
							}else if(result[i]["dictionaryTimes"] > 0){
								txt = '<span onclick="look('+id+');" class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;&nbsp;';
							}
						}else if(otherAttr == "times"){
							txt = '<span onclick="look('+id+');" class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;&nbsp;';
						}else if(otherAttr == "tcpLog"){
							txt = '<span onclick="look('+id+');" class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;&nbsp;';
						}else if(otherAttr == "xueShiModel"){
							txt = '<span onclick="look('+id+');" class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;&nbsp;';
						}else if(otherAttr == "takeOrder"){
							txt = '<span onclick="look('+id+');" class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;&nbsp;';
						}else if(otherAttr == "stuProcess"){
							txt = '<span onclick="look('+id+');" class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;&nbsp;';
						}else if(otherAttr == "appSet"){
							if(result[i]["isHave"] == 0){
								txt = '<span onclick="add('+id+');" class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;&nbsp;';
							}else{
								txt = '<span onclick="look('+id+');" class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;&nbsp;';
							}
						}else if(otherAttr == "shenHeSet"){
							if(result[i]["isShenHeSet"] == 0){
								txt = '<span onclick="add('+id+');" class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;&nbsp;';
							}else{
								txt = '<span onclick="look('+id+');" class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;&nbsp;';
							}
						}else if(otherAttr == "effectTime"){
							if(result[i]["isUse"] == 0){
								txt = '<span onclick="add('+id+');" class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;&nbsp;';
							}else{
								txt = '<span onclick="look('+id+');" class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;&nbsp;';
							}
						}else if(otherAttr == "leaveSchool"){
							txt = '<span onclick="leaveSchool('+id+');" class="glyphicon glyphicon-minus" aria-hidden="true"></span>&nbsp;&nbsp;';
						}else if(otherAttr == "returnMoney"){
							txt = '<span onclick="returnMoney('+id+');" class="glyphicon glyphicon-remove" aria-hidden="true"></span>&nbsp;&nbsp;';
						}else if(otherAttr == "dailyBill"){
							txt = '<span onclick="look('+id+',"'+result[i]["date"]+'");" class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;&nbsp;';
						}
					}
					$(this).html(txt);
				}else{
					var a = $(result[i]).attr(recodeName);
					if(a != null){
						$(this).html(a);
					}
				}
			});
		}
	}else{
	    var tr = $("#datas tr").eq(eqCount).clone();
		tr.appendTo("#datas");
		var tttd = $(tr).find("td");
		$(tr).html("<td colspan='"+tttd.length+"' style='text-align:center;color:blue;'>无搜索结果</td>");
	}
}

//学员余额收支明细的填充数据方法
function insertRecordsTr(data,eqCount){
	$(".recordCount3").html(data["recordCount"]);
	var totalPages = Math.ceil(parseInt(data["recordCount"])/$(".pageSize3").val());
	$(".totalPages3").html(totalPages==0?1:totalPages);
	$(".currentIndex3").html(data["pageNo"]);
	var result = data["result"];
	var trs = $("#datasRecords tr");
	for(var i = eqCount+1;i < trs.length;i++){
		$(trs[i]).remove();
	}
	if(result.length > 0){
		for(var i = 0; i < result.length; i++){
	        var tr = $("#datasRecords tr").eq(eqCount).clone();
	        tr.removeClass("trW");
			tr.appendTo("#datasRecords");
			var td = $(tr).find("td");
			td.each(function(){
				var recodeName = $(this).attr("name");
				$(this).html("");
				var txt = "";
				if(recodeName == "ids"){
					var otherAttr = $(this).attr("other");
					var id = $(result[i]).attr(recodeName);
					if(otherAttr){
						if(otherAttr == "blackList"){
							txt = '<a href="javascript:updateBlackList('+id+');" class="btn btn-success">修改</a>&nbsp;&nbsp;';
							txt += '<a href="javascript:deleteBlackList('+id+');" class="btn btn-success">删除</a>&nbsp;&nbsp;';
					    }
					}
					$(this).html(txt);
				}else{
					var a = $(result[i]).attr(recodeName);
					if(a != null){
						$(this).html(a);
					}
				}
			});
		}
	}else{
		    var tr = $("#datasRecords tr").eq(eqCount).clone();
			tr.appendTo("#datasRecords");
			var tttd = $(tr).find("td");
			$(tr).html("<td colspan='"+tttd.length+"' style='text-align:center;color:blue;'>无搜索结果</td>");
	}
}

//学员学习记录按科目分类的填充方法
function insertStudyLogTr(data,divId){
	var result = data[divId]["list"];
	var trs = $("#"+divId+" tr:last");
	for(var i = 1;i < trs.length;i++){
		$(trs[i]).remove();
	}

	if(result.length > 0){
		for(var i = 0; i < result.length; i++){
	        var tr = $("#"+divId+" tr").eq(2).clone();
			tr.appendTo("#" + divId);
			var td = $(tr).find("td");
			td.each(function(){
				var recodeName = $(this).attr("name");
				$(this).html("");
				var txt = "";
				if(recodeName == "id"){
					var otherAttr = $(this).attr("other");
					var id = $(result[i]).attr(recodeName);
					if(otherAttr){
						if(otherAttr == "driving"){
							txt = '<input id="btnSearch" type="button" class="btnSearch" value="查看" onclick="lookDriving('+id+');"><input id="btnSearch" type="button" class="btnSearch" value="查看账号" onclick="searchAccount('+id+');" style="margin-left: 5px;">';
						}
					}
					$(this).html(txt);
				}else{
					var a = $(result[i]).attr(recodeName);
					if(a != null){
						$(this).html(a);
					}
				}
			});
		}
		
	}else{
		var tr = $("#"+divId+" tr:last").eq(0).clone();
		tr.appendTo("#"+divId);
		var tttd = $(tr).find("td");
		$(tr).html("<td colspan='"+tttd.length+"' style='text-align:center;color:blue;'>无搜索结果</td>");
	}
}

function getCookieVal(offset) {
    var endstr = document.cookie.indexOf(";", offset);
    if (endstr == -1) {
        endstr = document.cookie.length;
    }
    return unescape(document.cookie.substring(offset, endstr));
}

function getCookie(name) {
	var arr = document.cookie.match(new RegExp("(^| )" + name + "=([^;]*)(;|$)"));
	if (arr != null)
		return unescape(arr[2]);
	return null;
}


//设置cookie
function setCookie(name, value, seconds)// 两个参数，一个是cookie的名子，一个是值
{
	if (typeof (seconds) == "undifined") {
		document.cookie = name + "=" + escape(value) + ";";
	} else {
		var exp = new Date(); // new Date("December 31, 9998");
		exp.setTime(exp.getTime() + seconds * 60 * 1000);
		document.cookie = name + "=" + escape(value) + ";expires="
				+ exp.toGMTString();
	}
}

//删除cookie
function delCookie(name)// 删除cookie
{
	var exp = new Date();
	exp.setTime(exp.getTime() - 1);
	var cval = getCookie(name);
	if (cval != null)
		document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
}

//获得浏览器版本
function getOs(){  
   var OsObject = "";  
   if(navigator.userAgent.indexOf("MSIE")>0) {  
        return "MSIE";  
   }  
   if(isFirefox=navigator.userAgent.indexOf("Firefox")>0){  
        return "Firefox";  
   }  
   if(isSafari=navigator.userAgent.indexOf("Safari")>0) {  
        return "Safari";  
   }   
   if(isCamino=navigator.userAgent.indexOf("Camino")>0){  
        return "Camino";  
   }  
   if(isMozilla=navigator.userAgent.indexOf("Gecko/")>0){  
        return "Gecko";  
   }  
}


//设置网页打印的页眉页脚为空
function PageSetup_Null()
{
	var HKEY_Root,HKEY_Path,HKEY_Key;
	HKEY_Root="HKEY_CURRENT_USER";
	HKEY_Path="\\Software\\Microsoft\\Internet Explorer\\PageSetup\\";
		
	var Wsh=new ActiveXObject("WScript.Shell");
	HKEY_Key="header";
	Wsh.RegWrite(HKEY_Root+HKEY_Path+HKEY_Key,"");
	HKEY_Key="footer";
	Wsh.RegWrite(HKEY_Root+HKEY_Path+HKEY_Key,"");
	HKEY_Key="margin_left"
	Wsh.RegWrite(HKEY_Root+HKEY_Path+HKEY_Key,"0.7"); //键值设定--左边边界
	
	HKEY_Key="margin_top"
	Wsh.RegWrite(HKEY_Root+HKEY_Path+HKEY_Key,"0.4"); //键值设定--上边边界
	
	HKEY_Key="margin_right"
	Wsh.RegWrite(HKEY_Root+HKEY_Path+HKEY_Key,"0.7"); //键值设定--右边边界
	
	HKEY_Key="margin_bottom"
	Wsh.RegWrite(HKEY_Root+HKEY_Path+HKEY_Key,"0.4"); //键值设定--下边边界
}


function print2(onfinish){
	printFrame(printHiddenFrame.printMe, onfinish);
}

//打印
function printHidden(url) {
	document.body.insertAdjacentHTML("beforeEnd",
	"<iframe name=printHiddenFrame width=0 height=0></iframe>");
	var doc = printHiddenFrame.document;
	doc.open();
	doc.write("<body onload=\"parent.onprintHiddenFrame()\">");
	doc.write("<iframe name=printMe width=0 height=0 src=\"" +
	url + "\"></iframe>");
	doc.write("</body>");
	doc.close();
	}
	function onprintHiddenFrame() {
	function onfinish() {
		printHiddenFrame.outerHTML = "";
		if ( window.onprintcomplete ) window.onprintcomplete();
	}

	window.setTimeout("print2("+onfinish+")", 1000);
} 


function printFrame(frame, onfinish) {
	if (!frame) frame = window;

	function execOnFinish() {
	switch ( typeof(onfinish) ) {
	case "string": execScript(onfinish); break;
	case "function": onfinish();
	}
	if ( focused && !focused.disabled ) focused.focus();
	}
	if (( frame.document.readyState !== "complete") &&( !frame.document.confirm("The document to print is not downloaded yet! Continue with printing?") ))
	{
	execOnFinish();
	return;
	} 
	var eventScope = printGetEventScope(frame);
	var focused = document.activeElement;
	
	window.printHelper = function() {
	execScript("on error resume next: printWB.ExecWB 6, 1", "VBScript");
	printFireEvent(frame, eventScope, "onafterprint");
	printWB.outerHTML = "";
	execOnFinish();
	window.printHelper = null;
	} 

	document.body.insertAdjacentHTML("beforeEnd",
	"<object id=\"printWB\" width=0 height=0 \
	classid=\"clsid:8856F961-340A-11D0-A96B-00C04FD705A2\">");
	printFireEvent(frame, eventScope, "onbeforeprint");
	frame.focus();
	window.printHelper = printHelper;
	setTimeout("window.printHelper()", 0);
}
	
// helpers
function printIsNativeSupport() {
	var agent = window.navigator.userAgent;
	var i = agent.indexOf("MSIE ")+5;
	return parseInt(agent.substr(i)) >= 5 && agent.indexOf("5.0b1") < 0;
}
function printFireEvent(frame, obj, name) {
	var handler = obj[name];
	switch ( typeof(handler) ) {
	case "string": frame.execScript(handler); break;
	case "function": handler();
	}
}
function printGetEventScope(frame) {
	var frameset = frame.document.all.tags("FRAMESET");
	if ( frameset.length ) return frameset[0];
	return frame.document.body;
}

//JS日期系列：根据出生日期 得到周岁年龄               
//参数strBirthday已经是正确格式的2007.02.09这样的日期字符串
//后续再增加相关的如日期判断等JS关于日期处理的相关方法
function jsGetAge(strBirthday){
    var returnAge;
    var strBirthdayArr=strBirthday.split(".");
    var birthYear = strBirthdayArr[0];
    var birthMonth = strBirthdayArr[1];
    var birthDay = strBirthdayArr[2];
    
    var d = new Date();
    var nowYear = d.getFullYear();
    var nowMonth = d.getMonth() + 1;
    var nowDay = d.getDate();
    
    if(nowYear == birthYear){
        returnAge = 0;//同年 则为0岁
    }else{
        var ageDiff = nowYear - birthYear; //年之差
        if(ageDiff > 0){
            if(nowMonth == birthMonth){
                var dayDiff = nowDay - birthDay;//日之差
                if(dayDiff < 0){
                    returnAge = ageDiff - 1;
                }else{
                    returnAge = ageDiff ;
                }
            }else{
                var monthDiff = nowMonth - birthMonth;//月之差
                if(monthDiff < 0){
                    returnAge = ageDiff - 1;
                }else{
                    returnAge = ageDiff ;
                }
            }
        }else{
            returnAge = -1;//返回-1 表示出生日期输入错误 晚于今天
        }
    }
    return returnAge;//返回周岁年龄
}
function ajaxstar(){
	$("body").append("<div class='loading'></div>");
}
function ajaxend(){
	$("body").find(".loading").remove();
}