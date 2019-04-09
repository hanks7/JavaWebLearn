<%@page import="java.util.*"%>
<%@page import="com.ahjtpx.www.youxueche.entity.JsFunction"%>
<%@page import="com.ahjtpx.www.youxueche.action.Keys"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%
	response.setHeader("Pragma","No-cache"); 
	response.setHeader("Cache-Control","no-cache"); 
	response.setDateHeader("Expires", 0); 
	Map<String,JsFunction> map=(Map)request.getSession().getAttribute(Keys.FUN_MAP);//权限
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>角色权限详情</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script type="text/javascript" src="../../js/jquery.min.js"></script>
	<script type="text/javascript" src="../../js/jquery.pagination.js"></script>
	<script type="text/javascript" src="../../js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../../js/public.js"></script>
	<script type="text/javascript" src="../../js/alert.js"></script>
	<script type="text/javascript" src="../../js/loadSchoolGrade.js"></script>
	<script type="text/javascript" src="../../js/jquery-ui/jquery-ui.min.js"></script>
	<link rel="stylesheet" type="text/css" href="../../js/jquery-ui/jquery-ui.css">
	<link rel="stylesheet" type="text/css" href="../../css/bootstrap.css">
    <style type="text/css"></style>
</head>
<body>
 	<form id="form1">
       <table class="table table-bordered .table-condensed">
      	<tr height="50">
	        <td width="100px;" class="divtz" id="nametd">角色名：</td>
	        <td>
	           <input type="hidden" id="id" name="id"  class="input normal" />
	           <input type="text" id="name" name="name"  class="input normal" />
	        </td>
      	</tr>
        <tr height="50">
            <td class="divtz" id="descriptiontd">角色描述：</td>
              <td>
                  <input type="text" id="description" name="description"  class="input normal" />
               </td>
         </tr>
         <tr>
	       <td id="funstd">权限：</td>
	       <td>
	       	<div id="funs">
				<%
				Iterator it=map.keySet().iterator();   
				while(it.hasNext()){   
				     String key;   
				     JsFunction fun;   
				     key = it.next().toString();   
				     fun = map.get(key);
				     if(fun != null && fun.getChilFunctions() != null && fun.getChilFunctions().size() > 0){
				     %>
				     	<%if(fun.getLink() == null || fun.getLink().equals("") || fun.getLink() != ""){%>
				     		
			     				<label onclick="clickParent('<%=fun.getId()%>');"><input type="checkbox" class="minimal-red"  name="functions_<%=fun.getId() %>" id="fun_<%=fun.getId() %>" value="<%=fun.getMenuOrder() %>" /><%=fun.getName() %></label>
				     		
			     			<%
							if(fun.getChilFunctions() != null && fun.getChilFunctions().size() > 0){
								List<JsFunction> chiles = new ArrayList<JsFunction>(fun.getChilFunctions());
								Collections.sort(chiles, new Comparator() {
									public int compare(Object a, Object b) {
										int one = ((JsFunction) a).getMenuOrder();
										int two = ((JsFunction) b).getMenuOrder();
										return one - two;
									}
								});
								%> 
								<div style="padding:0px 5px 20px 0px;" >
								<%
								for(JsFunction f : chiles){
								%>
								
								<label onclick="clickChild('<%=fun.getId()%>');" style="margin:0 0 0 20px; display:inline-block;"><input type="checkbox" class="minimal-red"  name="function_<%=fun.getId() %>" id="fun_<%=f.getId() %>" value="<%=f.getMenuOrder()%>" /><%=f.getName()%></label>
							<% }%>
							
							</div>
							<%  } %>
			     		<%} %>
				     <% } } %>
			</div>
	       </td>
         </tr>
       </table>
       <div style="text-align: center;">
       		<a href="javascript:void(0);" onclick="updateRoleInfoSubmit();" class="btn btn-info">修改</a>
       </div>
    </form>
	
    <script type="text/javascript">
		var href = location.href;
		href = href.split("=");
		var roleId = href[1];
		getRoleById(roleId);

		//child用于判断是一级菜单控制二级菜单还是二级菜单控制一级菜单
    	var child = "";
		var fill = "";//用于判断填充数据操作还是鼠标点击操作
  		//点击一级菜单
		function clickParent(id){
			if(fill == ""){//不是填充数据时调用的此方法
				$("#form1").find("input[id='fun_"+id+"']").each(function(){
	    			var check = $(this).prop("checked");
	    			if(check == true){//一级菜单被选中
	    				if(child == "" || child != id){//一级菜单控制二级菜单
							$("#form1").find("input[name='function_"+id+"']").each(function(){
								var checks = $(this).prop("checked");
								if(checks == false){
									$(this).click();
								}
							});
	    				}	
	    			}else{//一级菜单未被选中
	    				$("#form1").find("input[name='function_"+id+"']").each(function(){
							var checks = $(this).prop("checked");
							if(checks == true){
								$(this).click();
							}
						});
	    			}
	    		});
			}
		}	
    
		//点击二级菜单
		function clickChild(id){
			child = id;
			var checkbox = "";
			if(fill == ""){//不是填充数据时调用的此方法
				$("#form1").find("input[name='function_"+id+"']").each(function(){
					var check = $(this).prop("checked");
					if(check == true){
						checkbox += "check,";
						return;
					}
				});
				if(checkbox != ""){//有二级菜单被选中
					$("#form1").find("input[id='fun_"+id+"']").each(function(){
						var check = $(this).prop("checked");
						if(check == false){
							$(this).click();
						}
					});
					child = "";
				}else{//无二级菜单被选中
					$("#form1").find("input[id='fun_"+id+"']").each(function(){
						var check = $(this).prop("checked");
						if(check == true){
							$(this).click();
						}
					});
					child = "";
				}
			}	
		}
		
      	//根据id获取角色信息
      	function getRoleById(id){
      	    //修改按钮显示，增加按钮隐藏
      	    $("input[type='checkbox']:checked").click();
		    $.ajax({
	 			url : "../../role/get.ao",
	 			type : 'POST',
	 			cache : false,
	 			data :{
	 				"id" : id
	 			},
	 			dataType : "json",
	 			success : function(data) {
	 				if(data["state"]=="success"){
	 					$("#form1").find("input").each(function(){
	 						var a = $(this).attr("name");
	 						if(a == null || typeof(a) == "undefined"){
	 	 						return;
	 	 					}
	 	 					if(data["result"][a] == null || typeof(data["result"][a]) == "undefined"){
	 	 						return;
	 	 					}
	 	 					if(a == null || typeof(a) == "undefined"){
	 	 						return;
	 	 					}
	 	 					if(data["result"][a] == null || typeof(data["result"][a]) == "undefined"){
	 	 						return;
	 	 					}else{
	 	 						$(this).val(data["result"][a]);
	 	 					}
	 					});
	 				
	 					
	 					var functions = data["functions"];
	 					for(var i = 0;i < functions.length; i++){
	 						fill = id;
	 						$("input[id='fun_"+functions[i]["id"]+"']").parent().click();
	 						if(i == functions.length-1){//填充最后一个数据时，将fill置为空，用于后面的鼠标点击操作
	 							fill = "";
	 						}
	 					}
	 					
	 				}else{
	 					sAlert(data["result"]);
	 				}
	 			}
	 		});
  	     }
      
      	
      	function updateRoleInfoSubmit(){
   			if(confirm("你确定要修改吗？")){
   				var ids = "";
         		$("input[type='checkbox']").each(function(){
 	           		if($(this).prop("checked") == true){
 	           			var idTemp = $(this).attr("id").split("_");
 	           			var id = idTemp[1];
 	           			ids += id+",";
 	           		}	
         		});
  	      		$.ajax({
  	      			url : "../../role/update.ao",
  	      			type : 'POST',
  	      			data : {
  	      				"id" : $("#id").val(),
  	      				"name" : $("#name").val(),
  	      				"description" : $("#description").val(),
  	      				"ids" : ids
  	      			},
  	      			beforeSend : ajaxstar,
  	      			complete : ajaxend,
  	      			cache : false,
  	      			dataType : "json",
  	      			success : function(data) {
	 	      			alert(data["result"]);
		   				if(data["state"] == "success"){
		   					location.reload();
		   				}
  	      			}
  	      	    });
        	}
    	}
      	
    </script>
</body>
</html>