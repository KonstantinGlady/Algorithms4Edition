package Callbacks.asynchronous;

public class A implements OnEvenListener{

    @Override
    public void onEvent() {
        System.out.println("performing after callback");
    }
}
