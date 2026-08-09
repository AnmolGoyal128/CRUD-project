package in.SpringBoot.Interceptors.Interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.function.DoubleToIntFunction;

@Component  //  IOC controller handle it, but it is not in used directly without config
public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {


//        if(handler instanceof HandlerMethod handlerMethod){
//
//        HandlerMethod handlerMethod = (HandlerMethod) handler;
//        String controllerName = handlerMethod.getBeanType().getSimpleName();
//        String methodName = handlerMethod.getMethod().getName();
//
//        System.out.println("LoggingInterceptor preHandle called");
//        System.out.println("controllerName: " + controllerName);
//        System.out.println("methodName: " + methodName);
//        }
        // LOGGING
        System.out.println("Incoming request:------- ");
        System.out.println("HTTP Method: " + request.getMethod());
        System.out.println("HTTP URI: " + request.getRequestURI());
        System.out.println("Request parameters: " + request.getQueryString());
        System.out.println("Client IP: " + request.getRemoteAddr());
        System.out.println("Token Header: " + request.getHeader("token"));

        if (handler instanceof HandlerMethod handlerMethod){
            System.out.println("Controller: " + handlerMethod.getBeanType().getSimpleName());
            System.out.println("Method: " + handlerMethod.getMethod().getName());
        }
        return true;
    }

    //@Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception{

    System.out.println("LoggingInterceptor postHandle called");

    }
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler,
                                 @Nullable Exception ex) throws Exception {

        System.out.println("LoggingInterceptor afterCompletion called");

        if(ex != null){      // Useful when exception is not handling inseparate class
            System.out.println("Exception: " + ex.getMessage());
        }
        else {
            System.out.println("Success");
        }

        System.out.println("Response status: " + response.getStatus());
    }
}
