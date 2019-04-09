<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.ahjtpx.www.youxueche.action.Keys" %>
<%@ page import="com.ahjtpx.www.youxueche.entity.JsManage" %>
<%@ page import="com.ahjtpx.www.youxueche.entity.JsFunction" %>
<%
	JsManage loginUser = (JsManage)request.getSession().getAttribute(Keys.LOING_USER);//当前登录用户
	Map<String, JsFunction> map = (Map<String, JsFunction>)request.getSession().getAttribute(Keys.FUN_MAP);//权限
	
%>
	
	
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=8; IE=8; IE=7; IE=EDGE">
<meta charset="utf-8">
<title>安徽机动车驾驶员计时培训管理系统</title>
<link rel="stylesheet" type="text/css" href="../css/index.css">
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/jtree.js"></script>
<script type="text/javascript" src="../js/uitool.js"></script>
<script type="text/javascript" src="../js/index.js"></script>
<script type="text/javascript" src="../js/loadSchoolGrade.js"></script>
<script type="text/javascript">
	//iframe自适应屏幕
	function iFrameHeight() {
	    var ifm= document.getElementById("mainIframepage");
	    var subWeb = document.frames ? document.frames["mainIframepage"].document : ifm.contentDocument;
	    //var subWebHeight = subWeb.body.scrollHeight;
	    var subWebHeight = subWeb.body.scrollHeight;
	    if(subWebHeight < 700){
	    	subWebHeight = 700;
	    }
		if(ifm != null && subWeb != null) {
			ifm.height = subWebHeight;
		}
	}

	//跳转
	function gotoLink(link){
	    var ifm= document.getElementById("mainIframepage");
		$(ifm).attr("src","../"+link);
	}
     
</script>
</head>
<body>
	<div>
		<iframe id="headIframepage" src="../head.html" style="width:100%;max-height: 100px; heigth:100px;" frameborder="no" marginwidth="0" marginheight="0" scrolling="no" allowtransparency="yes"></iframe>
	</div>
	<div class="navTab-panel tabsPageContent layoutBox" style="width:220px;z-index:1000px;position: absolute;">
		<div class="page unitBox">	
			<div class="pageFormContent">
				<div id="leftside">
					<!-- jtree模板 -->
					<div id="sidebar">
						<div class="toggleCollapse">
							<div class="navigationbar">
								<div id="searchMenu">
									<input id="searchTree" type="text" class="span2"
										data-autofocus="autofocus" x-webkit-speech="" lang="zh-CN"
										x-webkit-grammar="builtin:translate"
										onwebkitspeechchange="$('#searchTreeBtn').trigger('click')" />
									<a id="searchTreeClose" title="清除条件" class="treeclosebtn hide"><i
										class="myicons iconfont icon-close tree-close"></i></a> <a
										id="searchTreeBtn" title="搜索菜单" class="treesearchbtn"><i
										class="myicons iconfont icon-search tree-search"></i>搜索</a>
								</div>
								<div id="searchMenuBar" style="line-height: 30px">
									<a title="折叠全部"
										onClick="$('ul.tree').colExpAll({clickType:'expAll'})"
										id="expandBtn" class="treebar">折叠<i
										class="myicons iconfont icon-zhedie collapse-all"></i></a> <a
										title="展开全部"
										onClick="$('ul.tree').colExpAll({clickType:'colAll'})"
										id="collapseBtn" class="treebar">展开<i
										class="myicons iconfont icon-1 expand-all"></i></a>
								</div>
							</div>
						</div>
						<div class="accordion" fillSpace="sidebar">
							<div class="accordionContent">
							
								<%
									Iterator it=map.keySet().iterator();   
									while(it.hasNext()){
									     String key;   
									     JsFunction fun;   
									     key = it.next().toString();   
									     fun = map.get(key);
										if(fun.getChilFunctions() != null && fun.getChilFunctions().size() > 0){//有子菜单的
											%>
											<ul id="<%=fun.getId() %>" class="tree treeFolder collapse">
												<li>
													<a autobypy="<%=fun.getId() %>" dataType="topmenu" childMneu="bzmenus" keyboard="<%=fun.getId() %>"><%=fun.getName() %></a>
													<ul id="bzmenus" class="bzmenus_sub">
														<%

														List<JsFunction> chiles = new ArrayList<JsFunction>(fun.getChilFunctions());
														Collections.sort(chiles, new Comparator() {
															public int compare(Object a, Object b) {
																int one = ((JsFunction) a).getMenuOrder();
																int two = ((JsFunction) b).getMenuOrder();
																return one - two;
															}
														});
														for(JsFunction f : chiles){
															%>
															<li><a autobypy="dh" onclick="gotoLink('<%=f.getLink() %>');" href="javascript:void(0);"><span class="font_pos"><i class="external_small"></i></span><%=f.getName() %></a></li>
															<%
														}
														
														%>
													</ul>
												</li>
											</ul>
											
											<%
										}else{
											
											
										}
									}
								%>
								
								
								
								
								
								<!-- <ul id="a" class="tree treeFolder collapse">
									<li>
										<a autobypy="bz" dataType="topmenu" childMneu="bzmenus" keyboard="A">帮助</a>
										<ul id="bzmenus" class="bzmenus_sub">
											<li class="layouthelp"><a autobypy="bj" href="#"><span class="font_pos"><i class="external_small"></i></span>布局</a></li>
											<li><a autobypy="dh" href="#"><span class="font_pos"><i class="external_small"></i></span>导航栏|工具栏</a></li>
											<li><a autobypy="yjcd" href="#"><span class="font_pos"><i class="external_small"></i></span>右键菜单</a></li>
											<li><a autobypy="djdhbq" href="#"><span class="font_pos"><i class="external_small"></i></span>顶级导航标签</a></li>
											<li><a autobypy="nbdbq|tab" href="#"><span class="font_pos"><i class="external_small"></i></span>内部多标签|tab</a></li>
											<li><a autobypy="dialog" href="#"><span class="font_pos"><i class="external_small"></i></span>提示框</a></li>
										</ul>
									</li>
								</ul>
								<ul id="b" class="tree treeFolder collapse">
									<li>
										<a autobypy="sl" dataType="topmenu" childMneu="slmenus" keyboard="A">
										示例
										</a>
										<ul id="slmenus" class="slmenus_sub">
											<li><a autobypy="rcgl" href="#"><span class="font_pos"><i class="external_small"></i></span>日程管理</a></li>
											<li><a autobypy="tpsc" href="#"><span class="font_pos"><i class="external_small"></i></span>上传</a></li>
											<li><a autobypy="jyrlsj" href="#"><span class="font_pos"><i class="external_small"></i></span>交易日历设计</a></li>
											<li><a autobypy="kjpzsj" href="#"><span class="font_pos"><i class="external_small"></i></span>会计凭证设计</a></li>
										</ul>
									</li>
								</ul> -->
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="navTab-panel tabsPageContent layoutBox" style="width: auto; margin-left: 250px;border:1px solid #5290cb;">
		<iframe id="mainIframepage" src="students/index.html" style="width:98%;min-height: 500px;padding:10px;" onload="iFrameHeight();" frameborder="no" marginwidth="0" marginheight="0" scrolling="no" allowtransparency="yes"></iframe>
	</div>
	
	<div>
		<iframe id="footIframepage" src="../foot.html" style="width:100%" frameborder="no" marginwidth="0" marginheight="0" scrolling="no" allowtransparency="yes"></iframe>
	</div>
	
	<script type="text/javascript">
		$(function(){
			loadSchool();//加载权限对应的培训机构
			loadNation();//加载国家
			loadCity();//加载城市
			loadDriver();//加载教练员
			loadStudent();//加载学员
		});
	</script>
</body>
</html>
