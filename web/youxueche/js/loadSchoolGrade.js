/**
 * 加载培训机构和班级
 */

//加载培训机构
function loadSchool(){
	var storage = window.sessionStorage;
	storage.clear();
    
	$.ajax({
		url : "../school/find.ao",
		type : 'POST',
		data : {
			"pageNo" : 1,
			"pageSize" : 10000,
			"findResult" : "simple"
		},
		cache : false,
		dataType : "json",
		success : function(data) {
			if (data["state"] == "success") {
				var schools = data["result"];
				var schoolHtml = "";//驾校
				if(schools.length > 1){
					schoolHtml += "<option value='请选择'>请选择</option>";
					for(var i = 0; i < schools.length; i++){
						schoolHtml += "<option value='"+schools[i]["id"]+"'>"+schools[i]["name"]+"</option>";
					}
					storage.setItem("schools", schoolHtml);//将数据存入会话数据库
				}else{
					loadGrades(schools[0]["id"],"..");//加载班级
					loadBranches(schools[0]["id"],"..");//加载分支机构
				}
			} else {
				sAlert(data["result"]);
			}
		}
	});
}

//加载培训机构
function loadSchools(areaId, path){
	var storage = window.sessionStorage;
	storage.clear();
    
	$.ajax({
		url : path + "/school/find.ao",
		type : 'POST',
		data : {
			"pageNo" : 1,
			"pageSize" : 10000,
			"findResult" : "simple",
			"areaId" : areaId
		},
		cache : false,
		dataType : "json",
		success : function(data) {
			if (data["state"] == "success") {
				var schools = data["result"];
				var schoolHtml = "";//驾校
				if(schools.length > 0){
					schoolHtml += "<option value='请选择'>请选择</option>";
					for(var i = 0; i < schools.length; i++){
						schoolHtml += "<option value='"+schools[i]["id"]+"'>"+schools[i]["name"]+"</option>";
					}
					storage.setItem("schools", schoolHtml);//将数据存入会话数据库
				}
			} else {
				sAlert(data["result"]);
			}
		}
	});
}
//加载班级
function loadGrades(schoolId,path){
	var storage = window.sessionStorage;
	storage.removeItem("grades");
	$.ajax({
		url : path + "/grade/find.ao",
		type : 'POST',
		data : {
			"pageNo" : 1,
			"pageSize" : 10000,
			"schoolId" : schoolId
		},
		cache : false,
		dataType : "json",
		success : function(data) {
			if (data["state"] == "success") {
				var grades = data["result"];
				var gradeHtml = "";//驾校
				for(var i = 0; i < grades.length; i++){
					gradeHtml += "<option value='"+grades[i]["id"]+"'>"+grades[i]["classcurr"]+"</option>";
				}
				storage.setItem("grades", gradeHtml);//将数据存入会话数据库
			} else {
				sAlert(data["result"]);
			}
		}
	});
}

//加载分支机构信息
function loadBranches(schoolId,path){
	var storage = window.sessionStorage;
	storage.removeItem("branches");
	$.ajax({
		url : path + "/branches/find.ao",
		type : 'POST',
		data : {
			"pageNo" : 1,
			"pageSize" : 10000,
			"schoolId" : schoolId
		},
		cache : false,
		dataType : "json",
		success : function(data) {
			if (data["state"] == "success") {
				var branches = data["result"];
				var branchesHtml = "";//驾校
				for(var i = 0; i < branches.length; i++){
					branchesHtml += "<option value='"+branches[i]["id"]+"'>"+branches[i]["name"]+"</option>";
				}
				storage.setItem("branches", branchesHtml);//将数据存入会话数据库
			} else {
				sAlert(data["result"]);
			}
		}
	});
}
/**
*当选择驾校时
*班级会根据选择的驾校进行改变
*/
function changeSchool(){
	var storage = window.sessionStorage;
	
	var schoolId = $("#school").val();//先获取驾校ID
	loadGrades(schoolId,"../..");//根据驾校加载班级
	loadBranches(schoolId,"../..");//根据驾校加载分支机构
	setTimeout(function(){
    	var grades = storage.getItem("grades");//获取存在sessionStorage里的班级数据
    	if(grades != null){
    		$("#grades").html(grades);
    	}
    	var branches = storage.getItem("branches");//获取存在sessionStorage里的分支机构数据
    	if(branches != null){
    		$("#branches").html(branches);
    	}
	},500);//延迟500毫秒获取会话里的班级数据 ,因为通过sql获取到数据再存入会话中需要一定的时候   立即执行会获取不到数据
}


//加载国家
function loadNation(){
	var storage = window.sessionStorage;
	storage.removeItem("nations");
	$.ajax({
		url : "../nation/find.ao",
		type : 'POST',
		data : {
			"pageNo" : 1,
			"pageSize" : 10000
		},
		cache : false,
		dataType : "json",
		success : function(data) {
			if (data["state"] == "success") {
				var nations = data["result"];
				var nationHtml = "";//驾校
				if(nations.length > 1){
					nationHtml += "<option value='请选择国家'>请选择国家</option>";
					for(var i = 0; i < nations.length; i++){
						nationHtml += "<option value='"+nations[i]["id"]+"'>"+nations[i]["name"]+"</option>";
					}
					storage.setItem("nations", nationHtml);//将数据存入会话数据库
				}else{
					loadProvinces(nations[0]["id"],"..");//加载省份信息
				}
			} else {
				sAlert(data["result"]);
			}
		}
	});
}
//加载省份信息
function loadProvinces(nationId,path){
	var storage = window.sessionStorage;
	storage.removeItem("provinces");
	$.ajax({
		url : path + "/province/find.ao",
		type : 'POST',
		data : {
			"pageNo" : 1,
			"pageSize" : 10000,
			"nationId" : nationId
		},
		cache : false,
		dataType : "json",
		success : function(data) {
			if (data["state"] == "success") {
				var provinces = data["result"];
				var provincesHtml = "";//驾校
				for(var i = 0; i < provinces.length; i++){
					provincesHtml += "<option value='"+provinces[i]["id"]+"'>"+provinces[i]["name"]+"</option>";
				}
				storage.setItem("provinces", provincesHtml);//将数据存入会话数据库
			} else {
				sAlert(data["result"]);
			}
		}
	});
}

//加载城市信息
function loadCity(){
	var storage = window.sessionStorage;
	storage.clear();
	$.ajax({
		url : "../city/find.ao",
		type : 'POST',
		data : {
			"pageNo" : 1,
			"pageSize" : 10000
		},
		cache : false,
		dataType : "json",
		success : function(data) {
			if (data["state"] == "success") {
				var citys = data["result"];
				var cityHtml = "";//城市
				if(citys.length >= 1){
					cityHtml += "<option value='请选择'>请选择</option>";
					for(var i = 0; i < citys.length; i++){
						cityHtml += "<option value='"+citys[i]["id"]+"'>"+citys[i]["name"]+"</option>";
					}
					storage.setItem("citys", cityHtml);//将数据存入会话数据库
				}else{
					loadArea(citys[0]["id"],"..");//加载地区信息
				}
			} else {
				sAlert(data["result"]);
			}
		}
	});
}

//加载地区信息
function loadArea(cityId,path){
	var storage = window.sessionStorage;
	storage.removeItem("areas");
	$.ajax({
		url : path + "/area/find.ao",
		type : 'POST',
		data : {
			"pageNo" : 1,
			"pageSize" : 10000,
			"cityId" : cityId
		},
		cache : false,
		dataType : "json",
		success : function(data) {
			if(data["state"] == "success"){
				var areas = data["result"];
				var areaHtml = "";
				areaHtml += "<option value='请选择'>请选择</option>";
				if(areas.length > 0){
					for(var i = 0; i < areas.length; i++){
						areaHtml += "<option value='"+areas[i]["id"]+"'>"+areas[i]["name"]+"</option>";
					}
					storage.setItem("areas", areaHtml);//将数据存入会话数据库
				}else{
					loadArea(areas[0]["id"],"..");//加载地区信息
				}
			}else{
				sAlert(data["result"]);
			}
		}	
	});
}

/*
 * 当选择国家时省份会跟着变化
 */
function changenation(){
	var storage = window.sessionStorage;
	var nations = $("#nation").val();//先获取驾校ID
	loadProvinces(nations,"../..");//根据驾校加载班级
	setTimeout(function(){
    	var provinces = storage.getItem("provinces");//获取存在sessionStorage里的班级数据
    	if(provinces != null){
    		$("#province").html(provinces);
    	}
	},500);//延迟500毫秒获取会话里的班级数据 ,因为通过sql获取到数据再存入会话中需要一定的时候   立即执行会获取不到数据
}

/*
 * 当选择城市时地区会跟着变化
 */
function changeCity(){
	var storage = window.sessionStorage;
	var cityId = $("#city").val();//先获取城市ID
	loadArea(cityId,"../..");//根据城市加载地区
	setTimeout(function(){
    	var areas = storage.getItem("areas");//获取存在sessionStorage里的班级数据
    	if(areas != null){
    		$("#areas").html(areas);
    	}
	},500);//延迟500毫秒获取会话里的班级数据 ,因为通过sql获取到数据再存入会话中需要一定的时候   立即执行会获取不到数据
}

function changeArea(){
	var storage = window.sessionStorage;
	var areaId = $("#areas").val();//先获取城市ID
	loadSchools(areaId,"../..");//根据城市加载地区
	setTimeout(function(){
    	var schools = storage.getItem("schools");//获取存在sessionStorage里的班级数据
    	if(schools != null){
    		$("#schools").html(schools);
    	}
	},500);//延迟500毫秒获取会话里的班级数据 ,因为通过sql获取到数据再存入会话中需要一定的时候   立即执行会获取不到数据
}


//加载教练员信息
function loadDriver(){
	var storage = window.sessionStorage;
	storage.clear();
	$.ajax({
		url : "../driver/find.ao",
		type : 'POST',
		data : {
			"pageNo" : 1,
			"pageSize" : 10000
		},
		cache : false,
		dataType : "json",
		success : function(data) {
			if(data["state"] == "success"){
				var drivers = data["result"];
				var driverHtml = "";
				driverHtml += "<option value='请选择'>请选择</option>";
				if(drivers.length > 0){
					for(var i = 0; i < drivers.length; i++){
						driverHtml += "<option value='"+data["result"][i]["id"]+"'>"+data["result"][i]["names"]+"</option>";
					}
					storage.setItem("drivers", driverHtml);
				}
			}else{
				sAlert(data["result"]);
			}
		}
	});
}

//加载学员信息
function loadStudent(){
	var storage = window.sessionStorage;
	storage.clear();
	
	$.ajax({
		url : "../student/find.ao",
		type : 'POST',
		data : {
			"pageNo" : 1,
			"pageSize" : 10000
		},
		cache : false,
		dataType : "json",
		success : function(data){
			if(data["state"] == "success"){
				var students = data["result"];
				var studentHtml = "";
				studentHtml +="<option value='请选择'>请选择</option>";
				if(students.length >= 1){
					for(var i = 0; i < students.length; i++){
						studentHtml += "<option value='"+data["result"][i]["id"]+"'>"+data["result"][i]["names"]+"</option>";
					}
					storage.setItem("students", studentHtml);
				}
			}else{
				sAlert(data["result"]);
			}
		}
	});
}
