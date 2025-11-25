package com.project.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "CONG_VIEC")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CongViec {

  @EmbeddedId
  private CongViecId id;

  // --- Mối quan hệ ---

  // Nối với SINHVIEN (qua trường 'soCMND' trong id)
  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("soCMND") // Ánh xạ trường 'soCMND' trong CongViecId
  @JoinColumn(name = "SoCMND", insertable = false, updatable = false)
  private SINHVIEN sinhVien;

  // Nối với NGANH (Mã ngành của công ty)
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "MaNganh") // Đây là cột MaNganh của CONG_VIEC
  private Nganh nganh;

  // --- Các trường thông tin khác ---

  @Column(name = "TenCongViec")
  private String tenCongViec;

  @Column(name = "TenCongTy")
  private String tenCongTy;

  @Column(name = "DiaChiCongTy")
  private String diaChiCongTy;

  @Column(name = "ThoiGianLamViec")
  private Integer thoiGianLamViec; // (Số tháng)

  // Helper để lấy ngayVaoCongTy từ Id
  @Transient
  public LocalDate getNgayVaoCongTy() {
    return id != null ? id.getNgayVaoCongTy() : null;
  }
}
