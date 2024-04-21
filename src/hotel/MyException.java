package hotel;

public class MyException extends Exception {

    private static final long serialVersionUID = 1L;
	String msg;

    public MyException() {
        msg="";
    }

    MyException(String m) {
        this.msg=m;
    }

    @Override
    public String toString() {
        return msg;
    }
}
