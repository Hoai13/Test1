package com.project.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "TRUONG")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TRUONG {

  @Id
  @Column(name = "MaTruong")
  private String maTruong;

  @Column(name = "TenTruong")
  private String tenTruong;

  @Column(name = "DiaChi")
  private String diaChi;

  @Column(name = "SoDT")
  private String soDT;
}
