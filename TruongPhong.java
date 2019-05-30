
public class TruongPhong extends NhanVien{
	protected int SoNhanVien;
	public TruongPhong(String MaNV, String HoTen, String Sdt, int NgayLamViec, int LuongNgay, int SoNhanVien) {
		super(MaNV, HoTen, Sdt, NgayLamViec, LuongNgay);
		this.SoNhanVien = SoNhanVien;
	}
	
	public int getSoNhanVien() {
		return SoNhanVien;
	}
	public void setSoNhanVien(int soNhanVien) {
		SoNhanVien = soNhanVien;
	}
	@Override
	public void tinhLuong() {
		this.TongLuong = this.LuongNgay*this.NgayLamViec + this.SoNhanVien*100;
	}
}
