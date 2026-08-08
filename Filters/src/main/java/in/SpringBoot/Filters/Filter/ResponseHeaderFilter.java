package in.SpringBoot.Filters.Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
@Order(3)
public class ResponseHeaderFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        // Type Casting request to httpServlet request
        HttpServletRequest httpServletRequest =
                (HttpServletRequest) request;

        HttpServletResponse httpServletResponse =
                (HttpServletResponse) response;

        String requestId = UUID.randomUUID().toString();
        // Changing header
        httpServletResponse.setHeader("X-Request-id", requestId);// Key value pair

        chain.doFilter(request, response);

        // what if we add Header Here during the response coming
        // Problem --> in the notes the response is not committable/ non-changeable



    }
}
