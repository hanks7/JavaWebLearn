package com.yidao.jdbc.test.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class ChannelServlet
 */
@WebServlet("/channel")
public class ChannelServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String level = request.getParameter("level");
        String parent = request.getParameter("parent");
        List chlist = new ArrayList();
        if (level.equals("1")) {
            chlist.add(new Channel("ai", "前沿/区块链/人工智能"));
            chlist.add(new Channel("web", "前端/小程序/JS"));
        } else if (level.equals("2")) {
            if (parent.equals("ai")) {
                chlist.add(new Channel("micro", "微服务"));
                chlist.add(new Channel("blockchain", "区块链"));
                chlist.add(new Channel("other", "..."));
            } else if (parent.equals("web")) {
                chlist.add(new Channel("html", "HTML"));
                chlist.add(new Channel("css", "CSS"));
                chlist.add(new Channel("other", "..."));
            }
        }
        String json = JSON.toJSONString(chlist);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(json);
    }

    static class Channel {
        private String code;
        private String name;

        public Channel() {

        }

        public Channel(String code, String name) {
            super();
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
