/**
 * 工具库
 * author==== tianyuan
 * date==== 2016/11/21
 */
var tools = (function () {
    var log = {
        i: function (tag, content) {
            if (content === undefined) {
                console.log(tag + "<br/><br/>");
            } else {
                console.log(tag+"==="+ content + "<br/><br/>");
            }
        },
        w: function (tag, content) {
            if (content === undefined) {
                document.writeln(tag + "<br/><br/>");
            } else {
                document.writeln(tag+"==="+ content + "<br/><br/>");
            }
        }
    }
    return {
        Ulog:log
    };
})();