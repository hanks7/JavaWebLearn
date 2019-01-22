function byid(id) {
    return typeof (id) === "string" ? document.getElementById(id) : id;
}


var index = 0;
var timer = null;
var pics = byid("banner").getElementsByTagName("div");
var len = pics.length;
var dots = byid("dots").getElementsByTagName("span");



function slideImg() {
    var main = byid("main");

    main.onmouseover = function () {
        if (timer) {
            clearInterval(timer);
        }
    }
    main.onmouseout = function () {
        timer = setInterval(function () {

            index++;
            if (index == len) {
                index = 0;
            }
            changeImg();
        }, 3000);
    }
    main.onmouseout();
}

slideImg();

for (var d = 0; d < len; d++) {
    log2(d);
    dots[d].id = d;
    dots[d].onclick = function () {
        index = this.id;
        changeImg();
    }
}
function changeImg() {

    for (var i = 0; i < len; i++) {
        pics[i].style.display = "none";
        dots[i].className="";
    }
    pics[index].style.display = "block";
    dots[index].className="active";


}

byid("prev").onclick=function () {
    index--;
    if (index < 0) {
        index=len-1;
    }
    log("index", index);
    changeImg();

}
byid("next").onclick=function () {
    index++;
    if (index == len) {
        index=0;
    }
    log("index", index);
    changeImg();

}


