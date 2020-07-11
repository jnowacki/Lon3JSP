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
import java.util.logging.Logger;

@WebServlet(value = "/albumServlet", name = "Album")
public class AlbumsServlet extends HttpServlet {

    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getSession().getAttribute("albums") == null) {
            req.getSession().setAttribute("albums", new ArrayList<Album>());
        }

        getServletContext().setAttribute("genres", Album.Genre.values());

        getServletContext().getRequestDispatcher("/album.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String author = req.getParameter("author");
        String genreName = req.getParameter("genre");

        Integer year = null;

        try {
            year = Integer.parseInt(req.getParameter("year"));
        } catch (NumberFormatException ex) {
            LOGGER.warning("Year was not parsable");
        }

        Album.Genre genre = genreName == null ? null : Album.Genre.valueOf(genreName);

        Album album = new Album(name, author, year, genre);

        if (album.isValid()) {
            List<Album> albums = (List<Album>) req.getSession().getAttribute("albums");
            albums.add(album);
        } else {
            req.setAttribute("hasError", true);
        }

        getServletContext().getRequestDispatcher("/album.jsp").forward(req, resp);
    }
}
