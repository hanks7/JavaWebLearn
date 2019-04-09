/**
 * @author zfp
 * 验证框架v1.0
 * 必填字段在input Class 中加上required
 * 限制字段长度最大为多少input Class 中加上maxlength:??	冒号后面加上长度
 * 限制字段长度必须为多少input Class 中加上conlength:??	冒号后面加上长度
 * 限制字段必须为yyyy-MM-dd类型的时间格式  input Class 中加上date
 * 限制字段为全是数字input Class 中加上onlyNum
 * 限制字段为手机号input Class 中加上phone
 * 
 * class可以累加  所有需要验证的字段必须加上required   
 * 如:验证一个input必须为数字<input type="text" class="required onlyNum"/>
 * 如:验证一个input必须为一个6位数的数字<input type="text" class="required onlyNum conlength:6"/>
 */
var required = "必填字段";
var remote = "请修正该字段";
var email = "请输入正确格式的电子邮件";
var url = "请输入合法的网址";
var date = "请输入yyyy-MM-dd的日期";
var number = "请输入数字";
var digits = "只能输入整数";
var equalTo = "请再次输入相同的值";
var accept = "请输入拥有合法后缀名的字符串";
var phone = "请输入正确的手机号";
var carNum = "请输入正确的车牌号,如{皖A1111学}";
function maxlength(len){
	return "输入值的长度最多是" + len;
};
function conlength(len){
	return "输入值的长度必须是" + len;
};

/**
 * 验证
 * @param form 表单ID
 * @returns {Boolean}
 */
function validata(form){
	/**
	 * 必填字段
	 */
	$("#"+form).find("[class*='required']").each(function(){
		var a = $(this).val();//输入的值
		if(a == null || a == "" || a == "请选择" || typeof(a) == "undefined"){
			$(this).parent().find("span[class='errorBt']").remove();
			var span = "<span class='errorBt'>"+required+"</span>";
			$(this).parent().append(span);
		}else{
			$(this).parent().find("span[class='errorBt']").remove();
		}
	});
	
	/**
	 * 限制字段长度最大为多少
	 */
	$("#"+form).find("input[class*='maxlength']").each(function(){
		var a = $(this).val();//输入的值
		var cla = $(this).attr("class");
		var clas = cla.split(" ");
		var len;//限制字段的长度
		for(var i = 0; i < clas.length; i++){
			if(clas[i].indexOf("maxlength") != -1){
				len = Number(clas[i].split(":")[1]);
				break;
			}
		}
		
		if(a != null && a != "" && typeof(a) != "undefined" && a.length > len){
			$(this).parent().find("span[class='errorXzCd']").remove();
			var span = "<span class='errorXzCd'>"+maxlength(len)+"</span>";
			$(this).parent().append(span);
		}else{
			$(this).parent().find("span[class='errorXzCd']").remove();
		}
	});

	/**
	 * 限制字段长度必须为多少
	 */
	$("#"+form).find("input[class*='conlength']").each(function(){
		var a = $(this).val();//输入的值
		var cla = $(this).attr("class");
		var clas = cla.split(" ");
		var len;//限制字段的长度
		for(var i = 0; i < clas.length; i++){
			if(clas[i].indexOf("conlength") != -1){
				len = Number(clas[i].split(":")[1]);
				break;
			}
		}
		
		if(a != null && a != "" && typeof(a) != "undefined" && a.length != len){
			$(this).parent().find("span[class='errorConlength']").remove();
			var span = "<span class='errorConlength'>"+conlength(len)+"</span>";
			$(this).parent().append(span);
		}else{
			$(this).parent().find("span[class='errorConlength']").remove();
		}
	});
	
	/**
	 * 检查是否是一个yyyy-MM-dd的时间类型
	 */
	$("#"+form).find("input[class*='date']").each(function(){
		var a = $(this).val();//输入的值
		
		if(a != null && a != "" && typeof(a) != "undefined"){
			$(this).parent().find("span[class='errorXzCd']").remove();
			var patrn = /^[1-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]$/;
			if (!patrn.exec(a)){//不满足表达式
				var span = "<span class='errorXzCd'>"+date+"</span>";
				$(this).parent().append(span);
			}
		}else{
			$(this).parent().find("span[class='errorXzCd']").remove();
		}
	});

	/**
	 * 检查值是否都是数字
	 */
	$("#"+form).find("input[class*='onlyNum']").each(function(){
		var a = $(this).val();//输入的值
		if(a != null && a != "" && typeof(a) != "undefined"){
			$(this).parent().find("span[class='errorNumber']").remove();
			var patrn = /^[0-9]{1,20}$/;
			if (!patrn.exec(a)){//不满足表达式
				var span = "<span class='errorNumber'>"+number+"</span>";
				$(this).parent().append(span);
			}
		}else{
			$(this).parent().find("span[class='errorNumber']").remove();
		}
	});

	/**
	 * 检查值是否是手机号
	 */
	$("#"+form).find("input[class*='phone']").each(function(){
		var a = $(this).val();//输入的值
		if(a != null && a != "" && typeof(a) != "undefined"){
			$(this).parent().find("span[class='errorPhone']").remove();
			var patrn = /^[1-9][0-9]{10}$/;
			if (!patrn.exec(a)){//不满足表达式
				var span = "<span class='errorPhone'>"+phone+"</span>";
				$(this).parent().append(span);
			}
		}else{
			$(this).parent().find("span[class='errorPhone']").remove();
		}
	});

	/**
	 * 检查值是否是车牌号
	 */
	$("#"+form).find("input[class*='carNum']").each(function(){
		var a = $(this).val();//输入的值
		if(a != null && a != "" && typeof(a) != "undefined"){
			$(this).parent().find("span[class='errorCarNum']").remove();
			var patrn = /^[京津渝沪冀晋辽吉黑苏浙皖闽赣鲁豫鄂湘粤琼川蜀贵黔云滇陕秦甘陇青台桂宁新藏港澳蒙][A-Z][0-9]{4}[学]$/;
			if (!patrn.exec(a)){//不满足表达式
				var span = "<span class='errorCarNum'>"+carNum+"</span>";
				$(this).parent().append(span);
			}
		}else{
			$(this).parent().find("span[class='errorCarNum']").remove();
		}
	});
	
	/**
	 * 在验证结束的时候返回Boolean值
	 * true说明验证成功可以做下一步操作
	 * false说明验证失败
	 */
	var spans = $("#"+form).find("span[class^='error']");
	if(spans.length == 0){
		return true;
	}else{
		return false;
	}
}