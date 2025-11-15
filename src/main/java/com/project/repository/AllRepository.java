package com.project.repository;

import com.project.model.Truong;
import com.project.model.Nganh;
import com.project.model.SINHVIEN;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository cho bảng TRUONG
public interface TruongRepository extends JpaRepository<Truong, String> {
  // String là kiểu dữ liệu của Khóa chính (MaTruong)
}

// Repository cho bảng NGANH
public interface NganhRepository extends JpaRepository<Nganh, String> {
  // String là kiểu dữ liệu của Khóa chính (MaNganh)
}

// Repository cho bảng SINHVIEN
public interface SinhVienRepository extends JpaRepository<SINHVIEN, String> {
  // String là kiểu dữ liệu của Khóa chính (SoCMND)
}
