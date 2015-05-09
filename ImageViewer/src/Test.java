import java.io.File;
public class Test {
    public static void main(String[] args) {
        System.out.println("outside");
        ImageViewer frame = ImageViewer.getInstance();
        File Test = new File("I:\\Users\\Administrator\\Pictures\\03bd91a2-aafc-11e4-848d-ed0abaecf4a1.jpg");
        frame.open(Test);              //Direction是File类型的
    }
}
