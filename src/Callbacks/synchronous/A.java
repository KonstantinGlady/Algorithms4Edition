package Callbacks.synchronous;

public class A implements OnEventListener {
    @Override
    public void onEvent() {
        System.out.println("perfoming callback after synchronous task");
    }
    //some methods class A
}
