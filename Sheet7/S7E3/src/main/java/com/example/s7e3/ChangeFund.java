package com.example.s7e3;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "changeFund", value = "/change-fund")
public class ChangeFund extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String fund_name = request.getParameter("fund_name");
        HttpSession session = request.getSession(true);
        session.setAttribute("selected", fund_name);
        PrintWriter out = response.getWriter();
        out.println("<HTML>\n" +
                    "<HEAD><TITLE>Choose Action</TITLE></HEAD>\n" +
                    "<BODY>\n" +
                    "<h1>Fund Management</h1>" +
                    "<h2>Fund \"" + fund_name + "\" selected</h2>" +
                    "<a href=\"form_create_fund.jsp\">1. Create a new equity fund</a><br/>\n" +
                    "<a href=\"form_choose_fund.jsp\">2. Change the current equity fund</a><br/>\n" +
                    "<a href=\"form_search_stock.jsp\">3. Search for a stock with a particular name in the current equity fund</a><br/>\n" +
                    "<a href=\"form_add_stock.jsp\">4. Add a new stock to the current equity fund</a><br/>\n" +
                    "<a href=\"show-stocks\">5. Show all stock-objects of the current equity fund</a><br/>\n" +
                    "<a href=\"form_change_quantity.jsp\">6. Change the quantity of a stock of the current equity fund</a><br/>" +
                    "</BODY></HTML>");
    }

    public void destroy() {

    }

}
