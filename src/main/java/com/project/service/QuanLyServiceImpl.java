package com.project.service;

import com.project.dto.TotNghiepForm;
import com.project.model.*;
import com.project.repository.NganhRepository;
import com.project.repository.SinhVienRepository;
import com.project.repository.TotNghiepRepository;
import com.project.repository.TruongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuanLyServiceImpl implements QuanLyService {

  @Autowired
  private TruongRepository truongRepository;

  @Autowired
  private NganhRepository nganhRepository;

  @Autowired
  private SinhVienRepository sinhVienRepository;

  @Autowired
  private TotNghiepRepository totNghiepRepository;

  @Override
  public List<Truong> getAllTruong() {
    return truongRepository.findAll();
  }

  @Override
  public List<Nganh> getAllNganh() {
    return nganhRepository.findAll();
  }

  /**
   * Xử lý lưu dữ liệu.
   * Sử dụng @Transactional để đảm bảo cả 2 thao tác (lưu SINHVIEN và lưu TOT_NGHIEP)
   * hoặc cùng thành công, hoặc cùng thất bại.
   */
  @Override
  @Transactional
  public void saveTotNghiep(TotNghiepForm form) throws Exception {
    try {
      // 1. Tạo hoặc cập nhật thông tin SINHVIEN
      // (Giả định: Nếu SV đã tồn tại thì cập nhật, chưa thì tạo mới)
      SINHVIEN sv = new SINHVIEN();
      sv.setSoCMND(form.getSoCMND());
      sv.setHoTen(form.getHoTen());
      sv.setEmail(form.getEmail());
      sv.setSoDT(form.getSoDT());
      sv.setDiaChi(form.getDiaChi());
      sinhVienRepository.save(sv);

      // 2. Tạo đối tượng Khóa chính composite cho TOT_NGHIEP
      TotNghiepId totNghiepId = new TotNghiepId(
        form.getSoCMND(),
        form.getMaTruong(),
        form.getMaNganh()
      );

      // 3. Tạo đối tượng TOT_NGHIEP
      TotNghiep totNghiep = new TotNghiep();
      totNghiep.setId(totNghiepId);
      totNghiep.setHeTN(form.getHeTN());
      totNghiep.setNgayTN(form.getNgayTN());
      totNghiep.setLoaiTN(form.getLoaiTN());

      // (Không cần set sinhVien, truong, nganh vì đã có trong ID và @MapsId)

      totNghiepRepository.save(totNghiep);

    } catch (Exception e) {
      // Có thể log lỗi ở đây
      throw new Exception("Lỗi khi lưu dữ liệu: " + e.getMessage());
    }
  }
}
