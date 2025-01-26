package Homework;

import java.util.ArrayList;
import java.util.Scanner;

/*
Một đơn vị sản xuất gồm có các cán bộ là công nhân, kỹ sư, nhân viên.
Mỗi cán bộ cần quản lý các dữ liệu: Họ tên, tuổi, giới tính(name, nữ, khác), địa chỉ.
- Cấp công nhân sẽ có thêm các thuộc tính riêng: Bậc (1 đến 10).
- Cấp kỹ sư có thuộc tính riêng: Nghành đào tạo.
- Các nhân viên có thuộc tính riêng: công việc
Yêu cầu 1: Xây dựng các lớp CongNhan, KySu, NhanVien kế thừa từ lớp CanBo.
Yêu cầu 2: Xây dựng lớp QLCB(quản lý cán bộ) cài đặt các phương thức thực hiện các chức năng sau:
1. Thêm mới cán bộ.
2. Tìm kiếm theo họ tên.
3. Hiện thị thông tin về danh sách các cán bộ.
4. Thoát khỏi chương trình.
 */
public class QLCB {
    private ArrayList<CanBo> listCanbo;
    private Scanner sc = new Scanner(System.in);

    public QLCB(){
        listCanbo = new ArrayList();
        sc = new Scanner(System.in);
    }

    public void themMoiCanBo() {
        System.out.print("Chọn loại cán bộ muốn thêm: 1-Công Nhân , 2-Kỹ Sư, 3-Nhân Viên: ");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Nhập vào Họ và tên: ");
        String hoTen = sc.nextLine();

        System.out.print("Nhập vào tuổi: ");
        int tuoi = sc.nextInt();
        sc.nextLine();

        System.out.print("Nhập vào giới tính (Nam/Nữ/Khác): ");
        String gioiTinh = sc.nextLine();

        System.out.print("Nhập vào địa chỉ: ");
        String diaChi = sc.nextLine();
        int flag = 0;
        while (flag == 0) {
            switch (choice) {
                case 1:
                    flag = 1;
                    System.out.print("Nhập vào Bậc (1~10): ");
                    int bac = sc.nextInt();
                    listCanbo.add(new CongNhan(hoTen, tuoi, gioiTinh, diaChi, bac));
                    break;
                case 2:
                    flag = 1;
                    System.out.print("Nhập vào Ngành đào tạo: ");
                    String nganhDT = sc.nextLine();
                    listCanbo.add(new KySu(hoTen, tuoi, gioiTinh, diaChi, nganhDT));
                    break;
                case 3:
                    flag = 1;
                    System.out.print("Nhập vào Công việc: ");
                    String congViec = sc.nextLine();
                    listCanbo.add(new NhanVien(hoTen, tuoi, gioiTinh, diaChi, congViec));
                    break;
                default:
                    System.out.println("Input Error!!!, please try again");
                    System.out.println("Mời bạn chọn lại: ");
                    System.out.print("Chọn loại cán bộ muốn thêm: 1-Công Nhân , 2-Kỹ Sư, 3-Nhân Viên: ");
                    choice = sc.nextInt();
                    sc.nextLine();
                    break;
            }

        }
        System.out.println("Thêm thành công.");
    }

    public void TimKiemTheoHoTen(String hoTen){
        int check = 0;
        for(CanBo canBo : listCanbo){
            if(canBo.getHoTen().equalsIgnoreCase(hoTen)){
                canBo.showInfor();
                check = 1;
            }
        }
        if (check==0){
            System.out.println("Không có thông tin.");
        }
    }

    public void HienThiDanhSach(){
        System.out.println("Danh Sách các cán bộ: ");
        for(CanBo canBo : listCanbo){
            canBo.showInfor();
        }
    }
}


