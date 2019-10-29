/**
 * 初始化
 * @type {null}
 */
var timer = null,//计时器
    pics = byId("banner").getElementsByTagName("div"),
    dots = byId("dots").getElementsByTagName("span"),//小圆点
    size = pics.length,
    prev = byId("prev"),
    next = byId("next"),
    menuItems = byId("menu-content").getElementsByTagName("div"),
    subMenu = byId("sub-menu"),
    subItems = subMenu.getElementsByClassName("inner-box");

/**
 *工具方法
 * @param id
 * @returns {HTMLElement}
 */
function byId(id) {
    return typeof(id) === "string" ? document.getElementById(id) : id;
}

/**
 * 播放标记
 * @type {number}
 */
var index = 0;

/**
 * 添加定时器,图片自动轮播
 */
function startAutoPlay() {
    timer = setInterval(function () {
        index++;
        if (index >= size) {
            index = 0;
        }
        changeImg();
    }, 800)
}

/**
 * 清除定时器,停止自动播放
 */
function stopAutoPlay() {
    if (timer) {
        clearInterval(timer);//清除定时
    }
}

/**
 * 去除dots的className
 * banner图片设置为不可见
 */
function clearClassName() {
    for (var i = 0; i < dots.length; i++) {
        dots[i].className = "";
        pics[i].style.display = "none";
    }
}

/**
 * 只显示对应的dots和banner图片
 */
function changeImg() {
    clearClassName();
    //index是全局变量
    dots[index].className = "active";//让导航的小点成为已经激活的样式
    pics[index].style.display = "block";//banner图片可见显示为可见
}

function slideImg() {
    var main = byId("main");
    var menuContent = byId("menu-content");
    main.onmouseover = function () {//鼠标放在main布局上 停止轮播
        stopAutoPlay();
    }
    main.onmouseout = function () {//鼠标离开main布局上 开始轮播
        startAutoPlay();
    }
    startAutoPlay();//开始轮播


    /**
     * 给每个点 添加点击事件 执行切换图片
     */
    for (var i = 0, len = dots.length; i < len; i++) {
        dots[i].id = i;
        dots[i].onclick = function () {
            index = this.id;
            changeImg();
        }
    }

    // 下一张
    next.onclick = function () {
        index++;
        if (index >= size) index = 0;
        changeImg();
    }

    // 上一张
    prev.onclick = function () {
        index--;
        if (index < 0) index = size - 1;
        changeImg();
    }

    // 菜单
    for (var m = 0, mlen = menuItems.length; m < mlen; m++) {
        menuItems[m].setAttribute("data-index", m);//给所有的菜单列表添加下标属性
        //注意这个控件的鼠标事件,不注意的话,你会产生迷惑
        menuItems[m].onmouseover = function () {
            subMenu.className = "sub-menu";// 鼠标悬浮到菜单列表时 显示详情界面
            var idx = this.getAttribute("data-index");//得到下标数值
            //所有的详情,全都隐藏
            //所有的菜单列表都去除背景颜色
            //这是一个偷懒的写法,本应该是写if - else的
            for (var j = 0; j < subItems.length; j++) {
                subItems[j].style.display = 'none';
                menuItems[j].style.background = "none";
            }
            //指让对应悬浮的菜单列表的详情显示
            subItems[idx].style.display = "block";
            //指让对应悬浮的菜单列表背景更改颜色.
            menuItems[idx].style.background = "#2f4956";
        }

    }

    subMenu.onmouseover = function () {
        this.className = "sub-menu";//鼠标悬浮菜单时显示详情
    }

    subMenu.onmouseout = function () {
        this.className = "sub-menu hide";//鼠标离开菜单隐藏详情
    }

    menuContent.onmouseout = function () {
        subMenu.className = "sub-menu hide";//鼠标离开详情隐藏详情
    }
}

slideImg();