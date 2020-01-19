package com.yidao.jdbc.test.servlet;

import com.alibaba.fastjson.JSON;
import com.yidao.jdbc.bean.News;
import com.yidao.jdbc.uitls.Ulog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/NewsListServlet")
public class NewsListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("t");
        Ulog.i("type", type);
        List<News> list = null;
        if (type != null && type.equals("pypl")) {
            list = getNews(type);
        } else {
            list = getNews("未填写");
        }


        String json = JSON.toJSONString(list);
        response.setContentType("text/html;charset=utf-8");                    //HTML格式
        response.getWriter().write(json);

    }

    private List<News> getNews(String type) {
        List<News> list = new ArrayList<>();
        list.add(new News(type, type + "2020年1月19日15:34:13", "新华社", type + "新华社 aaaaaaaa"));
        list.add(new News(type, type + "2020年1月19日15:34:13", "人民日报", type + "人民日报 bbbaaaaaaa"));
        list.add(new News(type, type + "2020年1月19日15:34:13", "环球日报", type + "环球日报 cccaaaaaaa"));
        return list;
    }
}
