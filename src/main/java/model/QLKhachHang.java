package model;

import java.util.ArrayList;
import util.FileHelper;
import java.util.Collections;
import java.util.Comparator;
/*
  Tác giả: NGUYỄN PHI LONG
*/
public class QLKhachHang {

    private ArrayList<KhachHang> dsKhachHang;

    public QLKhachHang() {
        dsKhachHang = new ArrayList<>();
    }

    public QLKhachHang(ArrayList<KhachHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
    }

    public ArrayList<KhachHang> getDsKhachHang() {
        return dsKhachHang;
    }

    public void setDsKhachHang(ArrayList<KhachHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
    }

    //sinh viên cải đặt cho các phương thức xử lý sau
   
    public void DocKhachHang(String filename) {
        ArrayList<String> input = FileHelper.readFileText(filename);
        dsKhachHang.clear();
        for (String item : input) {
            String[] arr = item.split(";");
            KhachHang kh = new KhachHang();
            kh.setMaso(arr[0]);
            kh.setHoten(arr[1]);
            kh.setLoai(Integer.parseInt(arr[2]));
            kh.setChisocu(Double.parseDouble(arr[3]));
            kh.setChisomoi(Double.parseDouble(arr[4]));            
            dsKhachHang.add(kh);
        }
    }

    public boolean GhiHoaDon(String filename) {
        ArrayList<String> output = new ArrayList<>();
        for (KhachHang kh : dsKhachHang) {
            String info = kh.getMaso() + ";" + kh.getHoten() + ";" + kh.getLoai() + ";" + kh.getChisocu() + ";" + kh.getChisomoi() + ";" + kh.getTienTra() + ";" + kh.getTieuThu();
            output.add(info);
        }
       return FileHelper.writeFileText(filename, output);
    }
   
    public void sapXepTheoLoaiHinh() {
        Comparator<KhachHang> cmp = (kh1, kh2) -> {
            return Double.compare(kh1.getTienTra(), kh2.getTienTra());
        };
        Collections.sort(dsKhachHang, cmp);
    }
    
    public double getTieuThuCaoNhat()
    {
      return 0;    
    }
    
    public double getTieuThuThapNhat()
    {
       return 0;  
    }
    
    public double getTieuThuTrungBinh()
    {
      return 0;   
    }
}
