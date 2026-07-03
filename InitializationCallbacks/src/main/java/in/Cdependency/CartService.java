package in.Cdependency;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

//@Component
public class CartService implements BeanNameAware , ApplicationContextAware /*DisposableBean/*implements InitializingBean*/ {
    Map<Integer,String> mp;

    public CartService(){
        mp = new HashMap<>();
        System.out.println("Cart Service Constructor called");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean name is " + name);

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContext Name is " + applicationContext.getClass());

    }

//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("Bean is Ready ");
//        mp.put(1,"Aditya");
//        mp.put(2,"Rohit");
//    }

    public void start(){
        System.out.println("Bean is Ready ");
        mp.put(1,"Aditya");
        mp.put(2,"Rohit");

    }
    //@PostConstruct  //Not in Spring library but it is a spring boot library library name is Jakarta Annotation library
    public void Start2(){
        System.out.println("Bean is Ready ");
        mp.put(1,"Aditya");
        mp.put(2,"Rohit");

    }

   public void addToCart(){
        System.out.println("Adding to Cart");
   }
   public String getValue(int key){
        return mp.get(key);
   }


//    @Override
//    public void destroy() throws Exception {
//        mp.clear();
//        System.out.println("Bean is getting destroyes");
//
//    }

    public void stop(){
        mp.clear();
        System.out.println("Bean is getting destroyes");
    }

    //@preDestroy
//    public void Stop() {
//        mp.clear();
//        System.out.println("Bean is getting destroyes");
//
//    }
}
