//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        List<String> names = new ArrayList<>();
        names.add("huy");
        for(String name: names){
            System.out.println(name);
        }
        Set<String> uniqueNames = new HashSet<>();
        uniqueNames.add("HUY aaa");
        uniqueNames.add("HUY aaa");
        System.out.println(uniqueNames);
        Map<Integer, String> students = new HashMap<>();
        students.put(1,"huy");
        students.put(1,"luyen");
        String maso = "2251120212";
        String hoten = "Quang Huy";
        String loaiNV = "LTV";
        double luongCB = 100;
        INhanvienFactory NhanvienFactory = new NhanvienFactory();
        NhanVien LTV = NhanvienFactory.createNhanvien(loaiNV, maso, hoten,luongCB);
        String thongtin = LTV.toString();
        System.out.println(thongtin);
    }
}