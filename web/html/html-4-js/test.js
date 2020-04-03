/**
 * 工具库
 * author==== 侯建军
 * date==== 2018/12/1
 */
var log = {
    i: function (tag, content) {
        if (content === undefined) {
            console.log(tag);
        } else {
            console.log(tag + "=" + content);
        }
    },
    w: function (tag, content) {
        if (content === undefined) {
            document.writeln(tag + "<br/><br/>");
        } else {
            document.writeln(tag + "=" + content + "<br/><br/>");
        }
    }
}