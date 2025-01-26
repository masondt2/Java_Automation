package Homework;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QLCB qlcb = new QLCB();
        Scanner sc = new Scanner(System.in);
        int check = 0;
        while (check == 0) {
            System.out.println("Chương Trình Quản Lý Cán Bộ");
            System.out.println("===========================");
            System.out.println("1. Thêm mới cán bộ.");
            System.out.println("2. Tìm kiếm theo họ tên.");
            System.out.println("3. Hiện thị danh sách cán bộ.");
            System.out.println("4. Thoát khỏi chương trình.");
            System.out.println("Chọn chức năng: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    qlcb.themMoiCanBo();
                    break;
                case 2:
                    System.out.print("Nhập họ tên cần tìm: ");
                    String hoTenCanTim = sc.nextLine();
                    qlcb.TimKiemTheoHoTen(hoTenCanTim);
                    break;
                case 3:
                    qlcb.HienThiDanhSach();
                    break;
                case 4:
                    check = 1;
                    System.out.println("Good bye!!!");
                    break;
                default:
                    System.out.println("Bạn hãy chọn lại chức năng!!!");
            }
        }

    }


}
