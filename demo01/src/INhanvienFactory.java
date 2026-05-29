public interface INhanvienFactory {
    public NhanVien createNhanvien(String loaiNV, String hoten, String maso, double luongCB);
    public NhanVien createNhanvien(String loaiNV);
}
