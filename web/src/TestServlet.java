
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "Test", urlPatterns = "/test")
public class TestServlet extends HttpServlet{

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


            String name = req.getParameter("Name");

            name = "guy";
            resp.setContentType("text/plain");

            resp.getWriter().println("Hello " + name);
        }


}
