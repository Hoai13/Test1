package com.project.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "NGANH")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Nganh {

  @Id
  @Column(name = "MaNganh")
  private String maNganh;

  @Column(name = "TenNganh")
  private String tenNganh;

  @Column(name = "LoaiNganh")
  private String loaiNganh;
}
