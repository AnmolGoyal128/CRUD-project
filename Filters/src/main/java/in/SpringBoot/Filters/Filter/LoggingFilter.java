package in.SpringBoot.Filters.Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

//@Component
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response
                        , FilterChain chain)
            throws IOException, ServletException {

        long startTime = System.currentTimeMillis();

        HttpServletRequest httpServletRequest =
                            (HttpServletRequest) request;

        HttpServletResponse httpServletResponse =
                    (HttpServletResponse) response;

        String requestId = UUID.randomUUID().toString();
        httpServletResponse.setHeader("X-Request-ID", requestId);

        //Request Log
        System.out.println("Incoming Request: "
                + httpServletRequest.getMethod() +" "
                + httpServletRequest.getRequestURI());
        try {
            chain.doFilter(request, response);
        }
        finally {

            long duration = System.currentTimeMillis() - startTime;

            // Response log

            System.out.println("Response Status: "
                    + httpServletResponse.getStatus());

            System.out.println("API Response Time: " + duration);

        }





//        System.out.println("Request Entered in Logging Filter");
//
//        chain.doFilter(request, response);
//
//        //Response
//        System.out.println("Request Exiting in Logging Filter");

    }
}
