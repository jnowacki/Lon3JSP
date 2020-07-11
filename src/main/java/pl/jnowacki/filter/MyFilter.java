package pl.jnowacki.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.logging.Logger;

@WebFilter(filterName = "MyFilter", servletNames = {"Album"})
public class MyFilter implements Filter {

    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) request;

        LOGGER.info("Request: " + httpReq.getMethod() + ", made at: " + OffsetDateTime.now(ZoneOffset.UTC));

        chain.doFilter(request, response);
    }
}
