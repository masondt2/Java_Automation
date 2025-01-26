package Homework;

public class NhanVien extends CanBo{
    private String congViec;

    public NhanVien(String hoTen, int tuoi, String gioiTinh, String diaChi, String congViec) {
        super(hoTen, tuoi, gioiTinh, diaChi);
        this.congViec = congViec;
    }

    public String getCongViec() {
        return congViec;
    }

    public void showInfor(){
        super.showInfor();
        System.out.println("--Nhân viên "+congViec);
    }
}
