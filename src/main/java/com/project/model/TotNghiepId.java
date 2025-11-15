package com.project.model;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.io.Serializable;

// Đánh dấu lớp này là một phần của khóa chính composite
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class TotNghiepId implements Serializable {

  // Lưu ý: Tên trường trong lớp này phải khớp với tên cột trong Entity TOT_NGHIEP
  // và tham chiếu cột trong Entity TOT_NGHIEP sẽ sử dụng @MapsId
  private String soCMND;
  private String maTruong;
  private String maNganh;
}
