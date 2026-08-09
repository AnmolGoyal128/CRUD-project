package in.SpringBot.LaptopApplication.Filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

@Component
@Order(4)
public class ResponseBodyFilter implements Filter {
    //ContentCacheResponseWrapper
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response
            , FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest =
                (HttpServletRequest) request;

        HttpServletResponse httpServletResponse =
                (HttpServletResponse) response;

        ContentCachingResponseWrapper wrapperResponse =
                new ContentCachingResponseWrapper(httpServletResponse);

        chain.doFilter(request, wrapperResponse);

        byte[] originalBodyBites =
                wrapperResponse .getContentAsByteArray();

        String originalBody = new String(originalBodyBites);

        String modifiedBody =
                """
                {
                    "originalResponse" : %s,
                    "appName" : "Student ManageMent System
                }
                """.formatted(originalBody);

        wrapperResponse.resetBuffer();

        wrapperResponse.getWriter().write(modifiedBody);

        wrapperResponse.copyBodyToResponse();



    }
}
