package Callbacks.synchronous;

public class B {
    private OnEventListener mListener;
    public void registerOnEventListener(OnEventListener mListener){
        this.mListener = mListener;
    }
    public void doStuff(){
        System.out.println("Performing callback before synchronous task");
        if (mListener != null) {
            this.mListener.onEvent();
        }
    }

    public static void main(String[] args) {
        B obj = new B();
        OnEventListener listener = new A();
        obj.registerOnEventListener(listener);
        obj.doStuff();
    }

}
