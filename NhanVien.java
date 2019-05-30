public class NhanVien {
	public NhanVien(String MaNV, String HoTen, String Sdt, int NgayLamViec, int LuongNgay) {
		super();
		this.MaNV = MaNV;
		this.HoTen = HoTen;
		this.Sdt = Sdt;
		this.NgayLamViec = NgayLamViec;
		this.LuongNgay = LuongNgay;
	}
	
	protected String MaNV;
	protected String HoTen;
	protected String Sdt;
	protected int NgayLamViec;
	protected int LuongNgay;
	protected double TongLuong;
	
	public String getMaNV() {
		return MaNV;
	}

	public void setMaNV(String maNV) {
		MaNV = maNV;
	}

	public String getHoTen() {
		return HoTen;
	}

	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}

	public String getSdt() {
		return Sdt;
	}

	public void setSdt(String sdt) {
		Sdt = sdt;
	}

	public int getNgayLamViec() {
		return NgayLamViec;
	}

	public void setNgayLamViec(int ngayLamViec) {
		NgayLamViec = ngayLamViec;
	}

	public int getLuongNgay() {
		return LuongNgay;
	}

	public void setLuongNgay(int luongNgay) {
		LuongNgay = luongNgay;
	}

	public double getTongLuong() {
		return TongLuong;
	}

	public void setTongLuong(int tongLuong) {
		TongLuong = tongLuong;
	}
	
	public void tinhLuong() {}
}
