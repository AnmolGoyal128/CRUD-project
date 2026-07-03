package in.Cdependency;

import org.springframework.stereotype.Component;

@Component
public class A {

    B b;
    public A(B b){
        this.b =b;
    }
    //@PostConstruct
    public void setB(){
        b.setA(this);
    }
}
