package Homework;

public class KySu extends CanBo {
    private String nganhDT;


    public KySu(String hoTen, int tuoi, String gioiTinh, String diaChi, String nganhDT) {
        super(hoTen, tuoi, gioiTinh, diaChi);
        this.nganhDT = nganhDT;
    }

    public String getNganhDT() {
        return nganhDT;
    }

    public void showInfor() {
        super.showInfor();
        System.out.println("--Kỹ Sư " + nganhDT);
    }
}
