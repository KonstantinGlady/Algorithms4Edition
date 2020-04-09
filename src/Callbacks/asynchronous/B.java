package Callbacks.asynchronous;

public class B {
    OnEvenListener mListener;
    public void registerOnEventListener(OnEvenListener mListener){
        this.mListener = mListener;
    }

    public void doStuff(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Performing operation in async Task");
                if (mListener != null) {
                    mListener.onEvent();
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        B obj = new B();
        OnEvenListener listener = new A();
        obj.registerOnEventListener(listener);
        obj.doStuff();
    }
}
