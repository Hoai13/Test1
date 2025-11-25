package com.project.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "TOT_NGHIEP")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TotNghiep {

  // Khai báo khóa chính composite
  @EmbeddedId
  private TotNghiepId id;

  // Thiết lập mối quan hệ Khóa ngoại (FK) với các Entity khác
  // Chúng ta sử dụng @MapsId để ánh xạ các trường của ID composite

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("soCMND") // Ánh xạ trường 'soCMND' trong TotNghiepId
  @JoinColumn(name = "SoCMND", insertable = false, updatable = false)
  private SINHVIEN sinhVien;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("maTruong") // Ánh xạ trường 'maTruong' trong TotNghiepId
  @JoinColumn(name = "MaTruong", insertable = false, updatable = false)
  private TRUONG truong;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("maNganh") // Ánh xạ trường 'maNganh' trong TotNghiepId
  @JoinColumn(name = "MaNganh", insertable = false, updatable = false)
  private Nganh nganh;

  @Column(name = "HeTN")
  private String heTN;

  @Column(name = "NgayTN")
  private LocalDate ngayTN; // Sử dụng LocalDate cho kiểu DATE

  @Column(name = "LoaiTN")
  private String loaiTN;
}
