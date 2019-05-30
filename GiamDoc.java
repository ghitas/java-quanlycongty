
public class GiamDoc extends NhanVien {
	private int CoPhan;
	public GiamDoc(String MaNV, String HoTen, String Sdt, int NgayLamViec, int LuongNgay, int CoPhan) {
		super(MaNV, HoTen, Sdt, NgayLamViec, LuongNgay);
		this.CoPhan = CoPhan;
	}
	public int getCoPhan() {
		return CoPhan;
	}
	public void setCoPhan(int coPhan) {
		CoPhan = coPhan;
	}
	
	@Override
	public void tinhLuong() {
		this.TongLuong = this.NgayLamViec*this.LuongNgay;
	}
}
