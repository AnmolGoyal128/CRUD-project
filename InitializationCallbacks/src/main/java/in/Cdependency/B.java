package in.Cdependency;

import org.springframework.stereotype.Component;

@Component
public class B {
    A a;

//    public B(A a) {
//        this.a = a;
//    }

    public void setA(A a) {
        this.a = a;
    }
}
