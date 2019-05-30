public class CongTy {
	public CongTy(String TenCty, String MaSoThue, double DoanhThuThang) {
		super();
		this.TenCty = TenCty;
		this.MaSoThue = MaSoThue;
		this.DoanhThuThang = DoanhThuThang;
	}
	protected String TenCty;
	protected String MaSoThue;
	protected double DoanhThuThang;
	protected double LuongNhanVien;
	
	public String getTenCty() {
		return TenCty;
	}
	public void setTenCty(String tenCty) {
		TenCty = tenCty;
	}
	public String getMaSoThue() {
		return MaSoThue;
	}
	public void setMaSoThue(String maSoThue) {
		MaSoThue = maSoThue;
	}
	public double getDoanhThuThang() {
		return DoanhThuThang;
	}
	public void setDoanhThuThang(double doanhThuThang) {
		DoanhThuThang = doanhThuThang;
	}
	public double getLuongNhanVien() {
		return LuongNhanVien;
	}
	public void setLuongNhanVien(double luongNhanVien) {
		LuongNhanVien = luongNhanVien;
	}
	
}
