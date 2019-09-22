package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by alexm on 10.09.2019.
 */
@WebServlet("/taxi")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String path = request.getServletPath();
//        if (path.equals("/request")) {
//            request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
//        } else if (path.equals("/servlet")) {
//            request.getRequestDispatcher("/WEB-INF/view/headers.jsp").forward(request, response);
//        }

        String one = request.getParameter("one");
        String two = request.getParameter("two");
        response.getWriter().write("<html>" +
                "<head></head>"+
                "<body>"+
                "one = "+ one+
                " two = "+ two+
                "<form action = 'taxi' method = 'post'>"+
                "<input type = 'text' name = 'one'/>"+
                "<input type = 'text' name = 'two'/>"+
                "<input type = 'submit' name = 'submit'/>"+
                "</form>"+
                "</body>"+
                "</html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

}
