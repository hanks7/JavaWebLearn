package com.yidao.jdbc.imooc.day6Register;

import com.yidao.jdbc.uitls.Ulog;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 正则表达式
 */
@WebServlet("/servlet/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    /**
     *
     * https://tool.oschina.net/regex 正则表达式在线测试工具
     *
     * 如果你不加^$ 全字匹配话   AAAA  正则表达式为A 那么 也会匹配成功  会匹配出4个A
     *
     *  第一章 字符范围匹配
     *
     * A 基准匹配单个字符                               true  A
     * x|y  允许出现两个字符                            true  x        false n
     * [xyz] 字符集合,允许出现集合内任意单个字符        true  x        false a
     * [a-z] 字符范围     true  a        false A
     * [A-Z] 字符范围     true  A        false a
     * [0-9] 字符范围     true  0        false a
     * [0-9abc] 字符范围有0-9的数字还有abc     true  0        false d
     * [^xyz]  不允许出现集合内字符    true  A       false x
     * [^0-9]  不允许出现集合内字符    true  A       false 0
     * <p>
     * eg:hello hallo 都匹配的 正则表达式为 h[ea]llo
     * eg: 被选答案 ABCD 正则表达式为 [A-D] 或者 [ABCD]
     *
     *第二章 元字符
     *
     * \d   匹配任意单个数字                       就是0-9 中任何一个数字
     * \D   匹配除单个数字以外的单个字符           就是不匹配数字
     * \w   匹配单个字母 数字 下划线(_)  注意      也就是不匹配标点符号 但是下划线(_)还是能匹配的
     * \W   匹配标点符号                           但是下划线(_)还是不匹配的
     * \s   匹配单个 空格
     * \n   匹配单个换行符                         我还不知道如何表达换行符
     * .    匹配任意单个字符(换行符除外)           不匹配换行符
     * \.   只匹配这个小数点 .                     就是这个. 要注意   假设匹配 32.1 错误的表达式为 \d\d.\d   因为 . 匹配任意单个字符(换行符除外) 所以要写成\d\d\.\d
     *
     * 第三章 多次重复匹配
     *
     * a{3}    必须3次                    aaa
     * a{3,}   至少3次                    最少出现3个a   下面都是一样的套路,我不想写了,如果你不是白痴的话,应该可以看的懂的
     * a{3,5}  至少出现3次 至多5次
     * a*      不限次数  0次 到无限次 , 相当于{0,}
     * a+      至少一次, 相当于{1,}
     * a?      至多一次, 相当于{0,1}
     * <p>
     * 6位数字密码  如果不使用重复匹配符那么 表达式为\d \d \d \d \d \d   使用后为\d{6}
     * 匹配全国座机号(区号3或4位-电话号码7位或者8位) \d{3,4}-\d{7,8}  中间的 这个- 就是表示为一个 -
     * 匹配英文名字 比如 Michael Jackson (注意姓可以只匹配第一个大写字母的)  [A-Z]  [a-z]{1,}  \s  [A-Z]   [a-z]{0,}
     *                                                                       [A-Z]  [a-z]+     \s  [A-Z]   [a-z]*
     *
     * 第四章 定位匹配
     *
     * ^a  bcd              头匹配 是否已a开头      abcd
     *  bcd  a$             尾匹配 是否已a结尾      bcda
     * ^a  bcd  c$          以为a开头 以为c结尾     abcdc
     * ^a$                  整个文本参与正则判断,而不是只要有匹配的就可以了
     *
     *
     *
     * 第五章 定位匹配贪婪模式
     *          假设只匹配<>中间的内容 <www>wwwccc<bbb> 正则表达式就是<.*> 匹配的结果就为<www>wwwccc<bbb>而并不是<www>和<bbb>
     *              使用贪婪模式就要改为<.*?>  注意:必须放在表述数量的格式符的后面 也就是* 后面
     *
     * 第六章 表达式分组   ababab cdcdcd  表达式为 (ab){3}(cd){3}
     *              四位或者6位的数字验证码 假设为777799  正则表达式为(^\d{4}$)|(^\d{6}$)
     *              车牌匹配     皖A-8898G    规则为第一位是"鄂豫皖"中的一个 第二位A-Z 后面5位随意(但必须是大写) [xyz][A-Z]-[A-Z0-9]{5}
     *
     * 第七章 中文匹配    采用Unicode码  所有的中文都在[\u4e00-\u9fa5] 之间 所有的英文都在[a-zA-Z]
     *
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        //对获取的参数信息进行校验
        //		用户名只能为字母，长度为6-12位：[a-zA-Z]{6,12}
        String usernameRegex = "[a-zA-Z]{6,12}";
        //matches方法的含义是将获取过来的username和usernameRegex这个规则进行比对，如果满足要求则返回true，否则返回false
        boolean flag1 = username.matches(usernameRegex);
        //		密码只能为数字，长度至少为6位：[0-9]{6,}，\\d{6}
        String passRegex = "[0-9]{6,}";
        boolean flag2 = password.matches(passRegex);
        //		手机号校验：[1][3578]\\d{9}
        String phoneRegex = "[1][3578][0-9]{9}";
        boolean flag3 = phone.matches(phoneRegex);
        //		邮箱校验：[a-zA-Z_0-9]{3,}@([a-zA-Z]+|\\d+)(\\.[a-zA-Z]+)+
        String emialRegex = "[a-zA-Z_0-9]{3,}@([a-zA-Z]+|\\d+)(\\.[a-zA-Z]+)+";
        boolean flag4 = email.matches(emialRegex);
        //如果username、password、email、phone同时满足格式要求的话才打印数据,否则提示数据不满足格式要求
        if (flag1 && flag2 && flag3 && flag4) {
            //然后打印参数
            Ulog.i("username=" + username);
            Ulog.i("password=" + password);
            Ulog.i("phone=" + phone);
            Ulog.i("email=" + email);
        } else {
            Ulog.i("亲，您输入的注册信息数据不满足格式要求，请检查仔细后在输入");
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}

