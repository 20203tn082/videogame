package mx.edu.utez.controller;

import mx.edu.utez.modal.games.BeanGames;
import mx.edu.utez.modal.games.DaoGames;
import mx.edu.utez.modal.user.BeanUser;
import mx.edu.utez.modal.user.DaoUser;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletSession", urlPatterns = {"/login", "/logout"})
public class ServletSession extends HttpServlet {
    /**
     * Cierre de la sesión de la aplicación.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("session") != null) {
            request.setAttribute("listGames", new DaoGames().findAll());
            request.getRequestDispatcher("/views/game/games.jsp").forward(request, response);
        } else{
            request.getRequestDispatcher("/").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        BeanUser beanUser = new BeanUser();
        DaoUser daoUser = new DaoUser();

        beanUser.setEmail(request.getParameter("email"));
        beanUser.setPassword(request.getParameter("password"));

        System.out.println(beanUser.getEmail());
        System.out.println(beanUser.getPassword());

        boolean res = daoUser.createSession(
                beanUser.getEmail(),
                beanUser.getPassword()

        );
        if (res){
            session.setAttribute("session", beanUser);
            request.getRequestDispatcher("/views/inicio.jsp").forward(request, response);
        }else {
            request.getRequestDispatcher("/").forward(request, response);
        }
    }
}
