public class NhanvienFactory extends NhanVien implements INhanvienFactory{

    @Override
    public NhanVien createNhanvien(String loaiNV, String hoten, String maso, double luongCB) {
        NhanVien nv;
        switch(loaiNV){
            case "LTV":
            nv = new Laptrinhvien(maso, hoten, luongCB);
            break;
            case "KTV":
            nv = new Ketoanvien(maso, hoten, luongCB);
            break;
            case "NVKT":
            nv = new Nhanvienkimthu(maso, hoten, luongCB);
            break;
            default:
                nv = new Chuyenvienphantich(maso, hoten, luongCB);
                break;
        }
        return nv;
    }

    @Override
    public NhanVien createNhanvien(String loaiNV) {
        NhanVien nv;
        switch(loaiNV){
            case "LTV":
                nv = new Laptrinhvien();
                break;
            case "KTV":
                nv = new Ketoanvien();
                break;
            case "NVKT":
                nv = new Nhanvienkimthu();
                break;
            default:
                nv = new Chuyenvienphantich();
                break;
        }
        return nv;
    }
}
