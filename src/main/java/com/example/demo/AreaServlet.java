package com.example.demo;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

import beans.DotTable;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "AreaServlet", value = "/area-servlet")
public class AreaServlet extends HttpServlet {

    private final String PROLOGUE = "<table id='output-table'></table>\n" +
            "            <tr>\n" +
            "                <th>x</th>\n" +
            "                <th>y</th>\n" +
            "                <th>Дата</th>\n" +
            "                <th>Статус</th>\n" +
            "            </tr>\"";

    @Override
    public void init() {}

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        double x = Double.parseDouble(request.getParameter("x_absolute"));
        double y = Double.parseDouble(request.getParameter("y_absolute"));

        HttpSession session = request.getSession();
        DotTable table = (DotTable) session.getAttribute("outputTable");
        table.addDot(new Dot(x,y,validate(x,y)));

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(PROLOGUE + table.getList());

    }

    @Override
    public void destroy() {
    }

    public String validate(double x,double y) {
        if (y <= (Math.sin(x/120)*20 + 600) && y >= (Math.sin(x/100)*50 + 200)) return "Входит в область определения";
        else return "Не входит в область определения";
    }

}




















