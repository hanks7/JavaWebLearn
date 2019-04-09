function sAlert(str,url) {
	$("#msgDiv").remove();
	var msgw, msgh, bordercolor;
	msgw = 220;// Width
	msgh = 140;// Height
	bordercolor = "#33CCFF";// boder color
	titlecolor = "#77DDFF";// title color

	sWidth = document.body.offsetWidth;
	sHeight = screen.height;

	var msgObj = document.createElement("div");
	msgObj.setAttribute("id", "msgDiv");
	msgObj.style = "border-radius:5px;color:red;";
	msgObj.setAttribute("align", "center");
	msgObj.style.background = "white";
	msgObj.style.border = "1px solid " + bordercolor;
	msgObj.style.position = "fixed";
	msgObj.style.top = "50%";
	msgObj.style.font = "16px/1.6em Verdana, Geneva, Arial, Helvetica, sans-serif";

	msgObj.style.marginLeft = ((document.body.clientWidth - msgw) / 2)
			/ document.body.clientWidth * 100 + "%";
	msgObj.style.marginTop = (document.documentElement.scrollTop - msgh) / 2
			+ "px";
	msgObj.style.width = msgw + "px";
	msgObj.style.height = msgh + "px";
	msgObj.style.textAlign = "center";
	msgObj.style.lineHeight = "28px";
	msgObj.style.zIndex = "10001";
	msgObj.style.align = "center";

	var title = document.createElement("h4");
	title.setAttribute("id", "msgTitle");
	title.setAttribute("align", "right");
	title.style.margin = "0";
	title.style.padding = "3px";
	title.style.background = bordercolor;
	title.style.filter = "progid:DXImageTransform.Microsoft.Alpha(startX=20, startY=20, finishX=100, finishY=100,style=1,opacity=75,finishOpacity=100);";
	title.style.opacity = "0.75";
	title.style.border = "1px solid " + bordercolor;
	title.style.height = "28px";
	title.style.font = "16px Verdana, Geneva, Arial, Helvetica, sans-serif";
	title.style.color = "white";
	title.style.cursor = "pointer";
	title.innerHTML = "关闭";
	title.onclick = function() {
		document.getElementById("msgDiv").removeChild(title);
		document.body.removeChild(msgObj);
	};
	document.body.appendChild(msgObj);
	document.getElementById("msgDiv").appendChild(title);
	var txt = document.createElement("p");
	txt.style.margin = "1.5em 0";
	txt.setAttribute("id", "msgTxt");
	txt.innerHTML = str;
	document.getElementById("msgDiv").appendChild(txt);

	$(msgObj).fadeOut(3500);
}
jQuery.divselect = function(divselectid, inputselectid) {
	var inputselect = $(inputselectid);
	$(divselectid + " cite").click(function() {
		var ul = $(divselectid + " ul");
		if (ul.css("display") == "none") {
			ul.slideDown("fast");
		} else {
			ul.slideUp("fast");
		}
	});
	$(divselectid + " ul li a").click(function() {
		var txt = $(this).text();
		$(divselectid + " cite").html(txt);
		var value = $(this).attr("selectid");
		inputselect.val(value);
		$(divselectid + " ul").hide();

	});
	$(document).click(function() {
		$(divselectid + " ul").hide();
	});
};
