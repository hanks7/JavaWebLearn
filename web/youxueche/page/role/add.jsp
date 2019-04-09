<%@page import="java.util.*"%>
<%@page import="com.ahjtpx.www.youxueche.entity.JsFunction"%>
<%@page import="com.ahjtpx.www.youxueche.entity.JsManage" %>
<%@page import="com.ahjtpx.www.youxueche.action.Keys"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=utf-8" buffer="none" %>
<%
	response.setHeader("Pragma","No-cache"); 
	response.setHeader("Cache-Control","no-cache"); 
	response.setDateHeader("Expires", 0); 
	Map<String,JsFunction> map=(Map)request.getSession().getAttribute(Keys.FUN_MAP);//权限
	JsManage manage = (JsManage)request.getSession().getAttribute(Keys.LOING_USER);//登录的用户
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>增加角色信息</title>
	<script type="text/javascript" src="../../js/jquery.min.js"></script>
    <script type="text/javascript" src="../../js/jquery.pagination.js"></script>
	<script type="text/javascript" src="../../js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../../js/public.js"></script>
	<script type="text/javascript" src="../../js/alert.js"></script>
	<script type="text/javascript" src="../../js/loadSchoolGrade.js"></script>
	<script type="text/javascript" src="../../js/jquery-ui/jquery-ui.min.js"></script>
	<link rel="stylesheet" type="text/css" href="../../js/jquery-ui/jquery-ui.css">
	<link rel="stylesheet" type="text/css" href="../../css/bootstrap.css">
</head>
<body>
 	<form id="form1" >
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
				     if(fun != null && fun.getChilFunctions() != null && fun.getChilFunctions().size() > 0){//有子菜单的
				     %>
				     	<input type="hidden" name="school" id="school" value="<%=manage.getSchool()==null?"":manage.getSchool().getId()%>"/>
				     	<%if(fun.getLink() == null || fun.getLink().equals("") || fun.getLink() != ""){%>
				     		
			     				<label onclick="clickParent('<%=fun.getId()%>');"><input type="checkbox" class="minimal-red" name="functions_<%=fun.getId() %>" id="fun_<%=fun.getId() %>" value="<%=fun.getMenuOrder() %>" /><%=fun.getName() %></label>
				     		
			     			<%
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
							
							<label onclick="clickChild('<%=fun.getId()%>');" style="margin:0 0 0 20px; display:inline-block;"><input type="checkbox" class="minimal-red" name="function_<%=fun.getId() %>" id="fun_<%=f.getId() %>" value="<%=f.getMenuOrder()%>" /><%=f.getName()%></label>
							<% }%>
							
							</div>
							
			     		<%} %>
				     <% } } %>
			</div>
	       </td>
         </tr>
       </table>
       <div style="text-align: center;">
       		<a href="javascript:void(0);" onclick="addRoleInfoSubmit();" class="btn btn-info">添加</a>
       </div>
    </form>
	
    <script type="text/javascript">
    	//child用于判断是一级菜单控制二级菜单还是二级菜单控制一级菜单
    	var child = "";
  		//点击一级菜单
		function clickParent(id){
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
    
		//点击二级菜单
		function clickChild(id){
			child = id;
			var checkbox = "";
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
				child = "";//执行结束后将child重置
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
		
		//添加角色信息
    	function addRoleInfoSubmit(){
   			if(confirm("你确定要添加吗？")){
         		var ids = "";
         		$("input[type='checkbox']").each(function(){
 	           		if($(this).prop("checked") == true){
 	           			var idTemp = $(this).attr("id").split("_");
 	           			var id = idTemp[1];
 	           			ids += id+",";
 	           		}	
         		});
 	      		$.ajax({
 	      			url : "../../role/add.ao",
 	      			type : 'POST',
 	      			data : {
 	      				"name" : $("#name").val(),
 	      				"description" : $("#description").val(),
 	      				"ids" : ids,
 	      				"schoolId" : $("#school").val()
 	      			},
 	      			beforeSend : ajaxstar,
 	      			complete : ajaxend,
 	      			cache : false,
 	      			dataType : "json",
 	      			success : function(data) {
 	      				if (data["state"] == "success") {
 	      					alert("添加成功");
 	      					//window.parent.exitRoleInfoDiv();
 	      					window.parent.location.reload();
 	      				} else {
 	      					alert(data["result"]);
 	      				}
 	      			}
 	      	    });
      	     }
    	 }
      	
    </script>
</body>
</html>