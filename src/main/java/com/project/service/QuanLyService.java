package com.project.service;

import com.project.dto.TotNghiepForm;
import com.project.model.Nganh;
import com.project.model.TRUONG;

import java.util.List;

public interface QuanLyService {

  /**
   * Lấy tất cả danh sách Trường để hiển thị lên ComboBox
   * (Yêu cầu 2.2)
   */
  List<TRUONG> getAllTruong();

  /**
   * Lấy tất cả danh sách Ngành để hiển thị lên ComboBox
   * (Yêu cầu 2.2)
   */
  List<Nganh> getAllNganh();

  /**
   * Lưu thông tin sinh viên tốt nghiệp từ form
   * (Yêu cầu 2.1)
   * @param form DTO chứa thông tin từ form
   */
  void saveTotNghiep(TotNghiepForm form) throws Exception;
}
