/**
 * @author ZFP
 * 备案
 */

/**
 * 备案
 * path为请求地址
 * id为实体ID
 */
function baAn(path,id){
	$.ajax({
		url : path,
		type : 'POST',
		data :{
			'id' : id
		},
		cache : false,
		beforeSend : ajaxstar,
		complete : ajaxend,
		dataType : "json",
		success : function(data) {
			sAlert(data["result"]);
			if(data["state"] == "success"){
				
			}
		}
	});
}

/**
 * 备案信息查询
 * path为请求地址
 * id为实体ID
 */
function baAnLook(path,id){
	$.ajax({
		url : path,
		type : 'POST',
		data :{
			'id' : id
		},
		cache : false,
		beforeSend : ajaxstar,
		complete : ajaxend,
		dataType : "json",
		success : function(data) {
			sAlert(data["result"]);
			if(data["state"] == "success"){
				
			}
		}
	});
}