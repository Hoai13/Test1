package com.project.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

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
}
