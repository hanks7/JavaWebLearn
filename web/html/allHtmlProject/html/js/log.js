var TAG = "输出";

function log(tag, content) {
    console.log(TAG + ":" + tag, content);
}

function log2(content) {
    log("", content)
}

function GetDate()
{
    var date = new Date();
    this.year = date.getFullYear();
    this.month = date.getMonth() + 1;
    this.date = date.getDate();
    this.day = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六")[date.getDay()];
    this.hour = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
    this.minute = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
    this.second = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
    var currentTime = this.year + "/" + this.month + "/" + this.date + " " + this.hour + ":" + this.minute + ":" + this.second //+ " " + this.day;
    return currentTime

}