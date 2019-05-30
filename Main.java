import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		String choose = "";
		Boolean exit = false;
		List<NhanVienThuong> dsnv = new ArrayList<NhanVienThuong>();
		List<TruongPhong> dstp = new ArrayList<TruongPhong>();
		List<GiamDoc> dsgd = new ArrayList<GiamDoc>();

		CongTy cty = new CongTy("default", "911911", 10000000);
		dsnv.add(new NhanVienThuong("001", "thanh", "123", 20, 100, "002"));
		dsnv.add(new NhanVienThuong("003", "truongPhong", "1123", 30, 100, "002"));
		dsnv.add(new NhanVienThuong("004", "hoa", "169", 22, 100, "002"));
		dstp.add(new TruongPhong("002","boss1","113",3,300,3));
		dstp.add(new TruongPhong("005","boss2","113",10,300,0));
		dstp.add(new TruongPhong("006","boss3","113",30,300,0));
		dsgd.add(new GiamDoc("099", "Giau the", "12908", 12, 1000, 10));
		dsgd.add(new GiamDoc("100", "Giau qua", "12908", 22, 2000, 20));
		
		while(!exit) {		
			choose = menu();
			switch (choose) {
			case "1":
				System.out.println("1. Nhap thong tin cty");
				System.out.println("2. Sua thong tin cty");
				choose = scan.nextLine();
				if(choose.equals("1")) {
					cty = NhapThongTinCty();
				}
				if(choose.equals("2")) {					
					SuaThongTinCty(cty);
				}
				exit = thoat();
				break;
			case "2":
				System.out.println("1. Nhap nhan vien");
				System.out.println("2. Sua nhan vien");
				System.out.println("3. Xoa nhan vien");
				String chon = scan.nextLine();
				switch (chon) {
				case "1":
					NhanVien nvMoi = themNhanVien();
					System.out.println("Nhap ma truong phong:");
					String maTP = scan.nextLine();
					System.out.println("Nhap co phan:");
					String coPhan = scan.nextLine();
					if(!coPhan.equals(null)) {
						dsgd.add(new GiamDoc(nvMoi.getMaNV(),nvMoi.getHoTen(),nvMoi.getSdt(),nvMoi.getNgayLamViec(),nvMoi.getLuongNgay(), Integer.parseInt(coPhan)));
					}else {
						if(maTP.equals(null)) {		
							dsnv.add(new NhanVienThuong(nvMoi.getMaNV(),nvMoi.getHoTen(),nvMoi.getSdt(),nvMoi.getNgayLamViec(),nvMoi.getLuongNgay(), "-1"));
						}else {
							dsnv.add(new NhanVienThuong(nvMoi.getMaNV(),nvMoi.getHoTen(),nvMoi.getSdt(),nvMoi.getNgayLamViec(),nvMoi.getLuongNgay(), maTP));
						}
						//loc ra truongphong trong dsnv;
						locDanhSachTP(dsnv,dstp);
					}
					
					break;
				case "2":
					System.out.println("Nhap vao ma nhan vien can sua: ");
					String id = scan.nextLine();
					for(int i=0;i<dsnv.size();i++) {
						if(dsnv.get(i).MaNV.equals(id)) {
							dsnv.set(i,suaNhanVien(dsnv.get(i)));
							break;
						}
					}
					break;
				default:
					break;
				}
				exit = thoat();
				break;
			case "3":
				System.out.println("Danh sach nhan vien trong cty la:");
				xuatDSNV(dsnv);
				xuatDSTP(dstp);
				xuatDSGD(dsgd);
				exit = thoat();
				break;
			case "4":
				double TongLuongNV = 0;
				for(NhanVienThuong nv: dsnv) {
					nv.tinhLuong();
					TongLuongNV += nv.getTongLuong();
				}
				for(TruongPhong tp: dstp) {
					tp.tinhLuong();
					TongLuongNV += tp.getTongLuong();
				}
				System.out.println("Tong luong toan cty: "+ TongLuongNV);
				cty.setLuongNhanVien(TongLuongNV);
				exit = thoat();
				break;
			case "5":
				TruongPhong bossLuongCao = dstp.get(0);
				bossLuongCao.tinhLuong();
				for(TruongPhong tp: dstp) {
					tp.tinhLuong();
					if(bossLuongCao.getTongLuong() < tp.getTongLuong()) {
						bossLuongCao = tp;
					}
				}
				System.out.println("Truong phong co tong luong cao nhat: " + bossLuongCao.getHoTen() + ", Ma so nhan vien: " + bossLuongCao.getMaNV());
				exit = thoat();
				break;
			case "6":
				TruongPhong bossNhieuLinh = dstp.get(0);
				for(TruongPhong tp: dstp) {	
					if(bossNhieuLinh.getSoNhanVien() < tp.getSoNhanVien()) {
						bossNhieuLinh = tp;
					}
				}
				System.out.println("Truong phong co tong luong cao nhat: " + bossNhieuLinh.getHoTen() + 
						", Ma so nhan vien: " + bossNhieuLinh.getMaNV()+
						", So luong nhan vien: " + bossNhieuLinh.getSoNhanVien());
				exit = thoat();
				break;
			case "7":
				GiamDoc giamDoc = dsgd.get(0);
				for(GiamDoc gd: dsgd) {	
					if( giamDoc.getCoPhan() < gd.getCoPhan()) {
						giamDoc = gd;
					}
				}
				System.out.println("Giam doc co co phan cao nhat: " + giamDoc.getHoTen() + 
						", Ma so nhan vien: " + giamDoc.getMaNV()+
						", Co phan: " + giamDoc.getCoPhan());
				exit = thoat();
				break;
			case "8":
				System.out.println("Danh sach luong giam doc: ");
				tinhLuongGD(dsgd,cty);
				for(GiamDoc gd: dsgd) {	
					System.out.println("Giam doc: " + gd.getHoTen() + ", Ma nhan vien: "+ gd.getMaNV() + ", Luong: " + gd.TongLuong);
				}
				exit = thoat();
				break;
			default:
				exit = thoat();
				break;
			}
		}
		System.out.println("!Da thoat chuong trinh");
	}
	
	private static void locDanhSachTP(List<NhanVienThuong> dsnv, List<TruongPhong> dstp) {
		//tim id truong phong trong dsnv, thay thi lay ra
		//tim id truong phong trong dstp, ko thay thi bo vo
		boolean existTP = false;
		for(NhanVienThuong nhanvien: dsnv) {
			existTP = false;
			if(!nhanvien.getMaTruongPhong().equals("-1")) {				
				for(TruongPhong tphong: dstp) {
					if(nhanvien.getMaTruongPhong().equals(tphong.getMaNV())) {
						existTP = true;
					}
				}
				if(existTP) {
					
				}else {		
					dstp.add(new TruongPhong(nhanvien.getMaNV(), nhanvien.getHoTen(), 
							nhanvien.getSdt(), nhanvien.getNgayLamViec(), nhanvien.getLuongNgay(), 1));
				}
			}
		}
		//loop trong dstp, loop trong dsnv, dem so luong nv co maTP do set tp.soluongnv
	}

	private static void tinhLuongGD(List<GiamDoc> dsgd, CongTy cty) {
		for(GiamDoc gd: dsgd) {
			gd.TongLuong = gd.NgayLamViec*gd.LuongNgay + (gd.getCoPhan())/100*(cty.DoanhThuThang - cty.LuongNhanVien);
		}
	}
	
	private static void xuatDSGD(List<GiamDoc> dsgd) {
		for(GiamDoc gd: dsgd) {
			System.out.println("Ma so nv: " + gd.getMaNV() + ", ten nv: " + gd.getHoTen() + ", so dien thoai: " + gd.getSdt() +
				", co phan: " + gd.getCoPhan() + ", ngay cong: " + gd.getNgayLamViec() + ", tien cong mot ngay: " +gd.getLuongNgay());
		}
		
	}
	public static void xuatDSNV(List<NhanVienThuong> dsnv) {
		for(NhanVienThuong nv: dsnv) {
			System.out.println("Ma so nv: " + nv.getMaNV() + ", ten nv: " + nv.getHoTen() + ", so dien thoai: " + nv.getSdt() +
				", ma truong phong: " + nv.getMaTruongPhong() + ", ngay cong: " + nv.getNgayLamViec() + ", tien cong mot ngay: " +nv.getLuongNgay());
		}
	}
	public static void xuatDSTP(List<TruongPhong> dstp) {
		for(TruongPhong nv: dstp) {
			System.out.println("Ma so nv: " + nv.getMaNV() + ", ten nv: " + nv.getHoTen() + ", so dien thoai: " + nv.getSdt() +
				", nhan vien duoi quyen: " + nv.getSoNhanVien() + ", ngay cong: " + nv.getNgayLamViec() + ", tien cong mot ngay: " +nv.getLuongNgay());
		}
	}
	public static NhanVien themNhanVien() {
		System.out.println("Nhap ma so nhan vien: ");
		String maNV = scan.nextLine();
		System.out.println("Nhap ten nhan vien: ");
		String hoten = scan.nextLine();
		System.out.println("Nhap so dien thoai: ");
		String sdt = scan.nextLine();
		System.out.println("Nhap so ngay lam viec: ");
		int ngaylam = Integer.parseInt(scan.nextLine());
		System.out.println("Nhap tien cong mot ngay: ");
		int luongNgay = Integer.parseInt(scan.nextLine());
		return new NhanVien(maNV, hoten, sdt, ngaylam, luongNgay);
	}
	
	public static NhanVienThuong suaNhanVien(NhanVienThuong NV) {
		System.out.println("Nhap ten moi: ");
		String hoten = scan.nextLine();
		System.out.println("Nhap so dien thoai moi: ");
		String sdt = scan.nextLine();
		System.out.println("Nhap so ngay lam viec moi: ");
		int ngaylam = Integer.parseInt(scan.nextLine());
		System.out.println("Nhap tien cong mot ngay moi: ");
		int luongNgay = Integer.parseInt(scan.nextLine());
		System.out.println("Nhap ma truong phong moi");
		String maTP = scan.nextLine();
		return new NhanVienThuong(NV.getMaNV(), hoten, sdt, ngaylam, luongNgay, maTP);
	}
	public static boolean thoat() {
		System.out.println("Chon 1 de tro ve, phim bat ki de thoat");
		String choose = scan.nextLine();
		if(choose.equals("1"))
			return false;
		else
			return true;
	}

	public static CongTy NhapThongTinCty() {
		System.out.println("Nhap ten cty: ");
		String tenCty = scan.nextLine();
		System.out.println("Nhap ma so thue: ");
		String msThue = scan.nextLine();
		System.out.println("Nhap loi nhuan thang: ");
		double loiNhuanThang = Double.parseDouble(scan.nextLine());
		return new CongTy(tenCty, msThue, loiNhuanThang);
	}

	public static void SuaThongTinCty(CongTy congTy) {
		System.out.println("Nhap ten cty moi: ");
		String tenCty = scan.nextLine();
		congTy.setTenCty(tenCty);
	}

	public static String menu() {
		System.out.println("1. Nhập, sửa thông tin công ty");
		System.out.println("2. Thêm, xóa, sửa thông tin nhân viên");
		System.out.println("3. Xuất ra thông tin toàn bộ người trong cty");
		System.out.println("4. Tính và xuất tổng lương cho toàn cty");
		System.out.println("5. Tìm trưởng phòng có lương cao nhất");
		System.out.println("6. Tìm trưởng phòng có số lượng nhân viên dưới quyền cao nhất");
		System.out.println("7. Tìm giám đốc có lượng cổ phần cao nhất");
		System.out.println("8. Tìm và xuất thu nhập của từng giám đốc trong tháng");
		String choose = scan.nextLine();
		return choose;
	}

}
