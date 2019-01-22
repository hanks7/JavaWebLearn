/**
 * 工具库
 * author: tianyuan
 * date: 2016/11/21
 */

var tool = (function() {
	var _pub = {
		//接口访问根路径
		//API_HOST: 'http://192.168.0.29:8080',//徐正杰
		API_HOST: 'http://192.168.3.93:8080', //马子建
		API_IMGURL: 'http://192.168.3.93:8080/cloud/uploadfiles/activity/', //活动
		API_CHANGGUAN: 'http://192.168.3.93:8080/cloud/uploadfiles/institution/', //活动http://localhost:8080/cloud/uploadfiles/institution
		USER_IMG: 'http://192.168.3.93:8080/cloud/',
		//获取ID为str的元素
		$: function(str) {
			return document.getElementById(str);
		},
		//获取当前页面路径携带的参数值

		Parames: function() {
			var url = location.search; //获取url中"?"符后的字串
			var theRequest = new Object();
			if(url.indexOf("?") != -1) {
				var str = url.substr(1);
				strs = str.split("&");
				for(var i = 0; i < strs.length; i++) {
					theRequest[strs[i].split("=")[0]] = decodeURIComponent(strs[i].split("=")[1]);
				}
			}
			return theRequest;
		},
		getURLComponent: function(flag, src) {
			src = src || loc;
			if(flag === 'search') {
				return src.search;
			} else if(flag === 'path') {
				return src.path;
			} else if(flag === 'host') {
				return src.host;
			} else if(flag === 'primary') {
				return src.protocol + "//" + src.host;
			} else {
				return null;
			}
		},
		//转换手机号码中间四位为星号
		transPhone: function(val) {
			return val.substring(0, 3) + "****" + val.substring(7, 11);
		},
		//根据data-url跳转页面
		goToUrl: function(url) {
			var str = url.split("/"),
				strSplit = str[str.length - 1],
				myid = strSplit.split(".")[0];
			mui.openWindow({
				url: url,
				id: myid
			});
		},
        //根据data-url跳转页面
        test: function(url) {
            console.log(url);
        },
		//unicode 转码
		decToHex: function(str) {
			var res = [];
			for(var i = 0; i < str.length; i++)
				res[i] = ("00" + str.charCodeAt(i).toString(16)).slice(-4);
			return "\\u" + res.join("\\u");
		},
		//unicode 逆转码
		hexToDec: function(str) {
			str = str.replace(/\\/g, "%");
			return unescape(str);
		},
		//动态设置页面文字大小
		getSize: function() {
			var screenWidth = oHtml.clientWidth;
			oHtml.style.fontSize = screenWidth / (750 / 24) + 'px'; //  /100*2
		},
		//辨别浏览器是安卓还是ios
		browserType: function(funca, funcb, funcc) {
			var ua = navigator.userAgent.toLowerCase();
			if(/iphone|ipad|ipod/.test(ua)) {
				funca && funca();
			} else if(/android/.test(ua)) {
				funcb && funcb();
			} else { //PC端
				funcc && funcc();
			}
		},
		//判断是否有网络连接
		judgeNet: function(dom, successcallback) {
			if(window.navigator.onLine == true) {
				successcallback && successcallback();
			} else {
				//无网络,在页面展示
				document.body.innerHTML = '<div class="no-content">' +
					'<img src="../../images/no_data/judge.png" />' +
					'</div>' +
					'<div class="render_res font_center">暂无网络</div>';
			}
		},
		//判断是否有网络连接
		getData: function(obj$, url, successcallback) {
			//无网络,在页面展示
			obj$.ajax({
				url: url,
				type: "get",
				dataType: "json",
				success: function(data) {
					//alert(JSON.stringify(data.data));
					successcallback(data);
				},
				error: function(XMLHttpRequest, textStatus, errorThrown) {
					console.log("ERROR!!!!");
				}
			});
		},
		getLocation: function(callback) {
			var mylocation = localStorage.getItem("mylocation");
			var longitude = localStorage.getItem("longitude");
			var latitude = localStorage.getItem("latitude");
			if(mylocation == undefined || mylocation == null) {
				if(navigator.geolocation) {
					navigator.geolocation.getCurrentPosition(
						function(position) {
							//console.log(navigator.geolocation);
							var longitude = position.coords.longitude;
							var latitude = position.coords.latitude;
							localStorage.setItem("mylocation", "true");
							localStorage.setItem("longitude", longitude);
							localStorage.setItem("latitude", latitude);
							console.log(longitude)
							console.log(latitude)
							callback(longitude, latitude);
						},
						function(e) {
							//console.log(navigator.geolocation);
							var msg = e.code;
							var dd = e.message;
							console.log("请通过网络ip获得地理位置！");
							console.log(msg)
							console.log(dd)
						}
					)
				}
			} else {
				callback(longitude, latitude);
				console.log("经度：" + longitude + "纬度：" + latitude);
			}
		},
		/*
		 * author yangjie
		 * blog: http://www.cnblogs.com/ready-Yang/p/4168095.html
		 */
		tppl: function(tpl, data, fast) {
			var fn = function(d, f) {
				if(f) {
					fn.$$ = fn.$$ || new Function(fn.$);
					return fn.$$.apply(d);
				} else {
					var i, k = [],
						v = [];
					for(i in d) {
						k.push(i);
						v.push(d[i]);
					};
					return(new Function(k, fn.$)).apply(d, v);
				}
			};
			if(!fn.$) {
				fn.$ = 'var $="";';
				var tpls = tpl.replace(/[\r\t\n]/g, " ").replace(/\'/g, "\\'").split('[:'),
					i = 0
				while(i < tpls.length) {
					var p = tpls[i];
					if(i) {
						var x = p.indexOf(':]');
						fn.$ += p.substr(0, x);
						p = p.substr(x + 2);
					}
					fn.$ += "$+='" + p.replace(/\[\=\:(.*?)\:\]/g, "'+$1+'") + "';";
					i++;
				}
				fn.$ += "return $";
			}
			return data ? fn(data, fast) : fn;
		}
	};
	return {
		init: _pub
	};
})();