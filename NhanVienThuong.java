
public class NhanVienThuong extends NhanVien{
	protected String MaTruongPhong;
	
	public NhanVienThuong(String MaNV, String HoTen, String Sdt, int NgayLamViec, int LuongNgay, String MaTruongPhong) {
		super(MaNV, HoTen, Sdt, NgayLamViec, LuongNgay);
		this.MaTruongPhong = MaTruongPhong;
	}

	public String getMaTruongPhong() {
		return MaTruongPhong;
	}

	public void setMaTruongPhong(String maTruongPhong) {
		MaTruongPhong = maTruongPhong;
	}
	@Override
	public void tinhLuong() {
		this.TongLuong = this.LuongNgay*this.NgayLamViec;
	}
}
