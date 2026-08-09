package in.SpringBot.LaptopApplication.Filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;

@Component
@Order(5)
public class RequestFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletResponse httpServletResponse =
                (HttpServletResponse) response;

        HttpServletRequest httpServletRequest =
                (HttpServletRequest) request;

//        httpServletRequest.getInputStream();
        BufferedReader reader = httpServletRequest.getReader();

        StringBuilder sb = new StringBuilder();
        String line = reader.readLine();

        while (line != null) {
            sb.append(line);
            line = reader.readLine();
        }

        System.out.println(sb);


//        String token = httpServletRequest.getHeader("token");
//
        chain.doFilter(request, response);

        // throws exception illegal



    }
}
