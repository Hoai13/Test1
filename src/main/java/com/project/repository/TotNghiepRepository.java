package com.project.repository;

import com.project.model.TotNghiep;
import com.project.model.TotNghiepId;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository cho bảng TOT_NGHIEP (sử dụng lớp TotNghiepId làm kiểu dữ liệu của Khóa chính)
public interface TotNghiepRepository extends JpaRepository<TotNghiep, TotNghiepId> {
  void save(TotNghiep totNghiep);
}
