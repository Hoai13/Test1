package com.project.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List; // Import

@Entity
@Table(name = "SINHVIEN")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SINHVIEN {

  @Id
  @Column(name = "SoCMND")
  private String soCMND;

  @Column(name = "HoTen")
  private String hoTen;

  @Column(name = "Email")
  private String email;

  @Column(name = "SoDT")
  private String soDT;

  @Column(name = "DiaChi")
  private String diaChi;

  // --- Cập nhật: Thêm quan hệ ---

  // Một sinh viên có thể có nhiều bản ghi tốt nghiệp
  // "mappedBy = "sinhVien"" : trỏ tới tên trường "sinhVien" trong TotNghiep.java
  @OneToMany(mappedBy = "sinhVien", fetch = FetchType.LAZY)
  private List<TotNghiep> dsTotNghiep;

  // Một sinh viên có thể có nhiều công việc
  // "mappedBy = "sinhVien"" : trỏ tới tên trường "sinhVien" trong CongViec.java
  @OneToMany(mappedBy = "sinhVien", fetch = FetchType.LAZY)
  private List<CongViec> dsCongViec;
}
