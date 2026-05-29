
public abstract class NhanVien {
    protected String maso;
    protected String hoten;
    protected double luongCB;
    protected ITTienThuong phuongthucTinhthuong;

    public NhanVien(String maso, String hoten, double luongCB) {
        this.maso = maso;
        this.hoten = hoten;
        this.luongCB = luongCB;
    }

    public NhanVien() {

    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "hoten='" + hoten + '\'' +
                ", maso='" + maso + '\'' +
                ", luongCB=" + luongCB +
                '}';
    }
    public double getTienthuong(){
        return luongCB;
    }

    public String getHoten() {
        return hoten;
    }

    public double getLuongCB() {
        return luongCB;
    }

    public ITTienThuong getPhuongthucTinhthuong() {
        return phuongthucTinhthuong;
    }

    public String getMaso() {
        return maso;
    }

    public void setMaso(String maso) {
        this.maso = maso;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public void setLuongCB(double luongCB) {
        this.luongCB = luongCB;
    }

    public void setPhuongthucTinhthuong(ITTienThuong phuongthucTinhthuong) {
        this.phuongthucTinhthuong = phuongthucTinhthuong;
    }
}
