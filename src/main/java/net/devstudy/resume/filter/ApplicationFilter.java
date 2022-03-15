package net.devstudy.resume.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class ApplicationFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationFilter.class);


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        LOGGER.debug("Before URL processing: {}", req.getRequestURI());
        chain.doFilter(req, response);
        LOGGER.debug("After URL processing: {}", req.getRequestURI());
    }

    @Override
    public void destroy() {

    }
}
