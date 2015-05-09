package kechengsheji;

import java.io.File;
public class Test {
    public static void main(String[] args) {
        System.out.println("outside");
        
        ImageViewer frame = ImageViewer.getInstance();
        System.out.println("123outside");

        String st =FileManage.getFloder(false);
        File test = new File(st);
        System.out.println(123);
        if(test!=null){
        	System.out.println(123);
        frame.open(test);
        }
        //Direction是File类型的
    }
}
