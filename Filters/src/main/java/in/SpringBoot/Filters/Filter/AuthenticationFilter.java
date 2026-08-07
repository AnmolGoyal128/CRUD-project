package in.SpringBoot.Filters.Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response
            , FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest =
                (HttpServletRequest) request;

        HttpServletResponse httpServletResponse =
                (HttpServletResponse) response;

        String token = httpServletRequest.getHeader("token");

        String apiKey = httpServletRequest.getHeader("X-api-Key");

        if(apiKey == null || !apiKey.equals("secret123")){

            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            httpServletResponse.setContentType("application/json");
            httpServletResponse.getWriter().write(
                    "{\n"+
                            "   \"status\":\"Invalid or missing Api key\"\n"+
                    "}"
            );

            return;
        }

        if(token == null || !token.equals("12345")) {
            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        chain.doFilter(httpServletRequest, httpServletResponse);
    }

}
