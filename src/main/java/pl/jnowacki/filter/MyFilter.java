package pl.jnowacki.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.logging.Logger;

@WebFilter(filterName = "MyFilter", servletNames = {"Album"})
public class MyFilter extends HttpFilter {

    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        LOGGER.info("Request: " + req.getMethod() + ", made at: " + OffsetDateTime.now(ZoneOffset.UTC));

        chain.doFilter(req, res);
    }
}
