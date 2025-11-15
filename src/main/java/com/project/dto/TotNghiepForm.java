package com.project.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data; // Nếu bạn dùng Lombok

@Data // Tự động tạo getters/setters
public class TotNghiepForm {

  // ---------------------- Thông tin SINHVIEN ----------------------

  // Yêu cầu 2.3: Kiểm tra bắt buộc nhập SoCMND
  @NotBlank(message = "Số CMND không được để trống")
  @Size(min = 9, max = 12, message = "Số CMND phải có từ 9 đến 12 ký tự")
  private String soCMND;

  @NotBlank(message = "Họ Tên không được để trống")
  private String hoTen;

  // Các trường còn lại của SINHVIEN
  private String email;
  private String soDT;
  private String diaChi;

  // ---------------------- Thông tin TOT_NGHIEP ----------------------

  // Yêu cầu 2.3: Kiểm tra bắt buộc nhập MaTruong
  @NotBlank(message = "Mã Trường không được để trống")
  private String maTruong;

  // Yêu cầu 2.3: Kiểm tra bắt buộc nhập MaNganh
  @NotBlank(message = "Mã Ngành không được để trống")
  private String maNganh;

  private String heTN;

  // Yêu cầu 2.4: Kiểm tra dữ liệu hợp lệ cho Ngày tốt nghiệp
  @NotNull(message = "Ngày tốt nghiệp không được để trống")
  @PastOrPresent(message = "Ngày tốt nghiệp không thể là ngày trong tương lai") // Đảm bảo ngày không phải tương lai
  @DateTimeFormat(pattern = "yyyy-MM-dd") // Định dạng cho việc binding từ Form
  private LocalDate ngayTN;

  private String loaiTN;
}
