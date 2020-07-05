package pl.jnowacki.servlet;

import pl.jnowacki.Album;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/albumServlet", name = "Album")
public class AlbumsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("hello from servlet");

        if (req.getSession().getAttribute("albums") == null) {
            req.getSession().setAttribute("albums", new ArrayList<Album>());
        }

        getServletContext().getRequestDispatcher("/album.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String author = req.getParameter("author");
        String year = req.getParameter("year");

        Album album = new Album(name, author, year);

        if (album.isValid()) {
            List<Album> albums = (List<Album>) req.getSession().getAttribute("albums");
            albums.add(album);
        } else {
            req.setAttribute("hasError", true);
        }

        getServletContext().getRequestDispatcher("/album.jsp").forward(req, resp);
    }
}
