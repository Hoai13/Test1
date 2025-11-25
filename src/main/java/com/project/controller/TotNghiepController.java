package com.project.controller;

import com.project.dto.TotNghiepForm;
import com.project.model.Nganh;
import com.project.model.TRUONG;
import com.project.service.QuanLyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/sinh-vien") // Tiền tố chung cho các request
public class TotNghiepController {

  @Autowired
  private QuanLyService quanLyService;

  /**
   * Chuẩn bị dữ liệu cho ComboBox (Yêu cầu 2.2)
   * Các hàm @ModelAttribute này sẽ tự động chạy và thêm
   * "dsTruong", "dsNganh" vào Model cho TẤT CẢ các request
   * trong Controller này.
   */
  @ModelAttribute("dsTruong")
  public List<TRUONG> getDanhSachTruong() {
    return quanLyService.getAllTruong();
  }

  @ModelAttribute("dsNganh")
  public List<Nganh> getDanhSachNganh() {
    return quanLyService.getAllNganh();
  }

  /**
   * Hiển thị form nhập thông tin tốt nghiệp (Yêu cầu 2)
   */
  @GetMapping("/nhap-thong-tin")
  public String showForm(Model model) {
    // Tạo một đối tượng form rỗng để binding dữ liệu
    model.addAttribute("totNghiepForm", new TotNghiepForm());
    return "form-tot-nghiep"; // Trả về tên file HTML (form-tot-nghiep.html)
  }

  /**
   * Xử lý lưu dữ liệu từ form (Yêu cầu 2.1, 2.3, 2.4)
   *
   * @Valid: Kích hoạt việc kiểm tra validation đã định nghĩa trong TotNghiepForm
   * BindingResult: Chứa kết quả của việc validation
   */
  @PostMapping("/luu-thong-tin")
  public String saveForm(
    @Valid @ModelAttribute("totNghiepForm") TotNghiepForm form,
    BindingResult bindingResult,
    RedirectAttributes redirectAttributes,
    Model model // Cần Model để load lại ComboBox nếu có lỗi
  ) {
    // Yêu cầu 2.3 & 2.4: Kiểm tra validation
    if (bindingResult.hasErrors()) {
      // Nếu có lỗi, quay lại trang form và hiển thị lỗi
      // (dsTruong và dsNganh đã tự động được thêm vào model
      // nhờ @ModelAttribute)
      return "form-tot-nghiep";
    }

    // Yêu cầu 2.1: Lưu dữ liệu
    try {
      quanLyService.saveTotNghiep(form);
      // Thêm thông báo thành công để hiển thị ở trang sau khi redirect
      redirectAttributes.addFlashAttribute("message_success", "Khai báo thông tin tốt nghiệp thành công!");
      return "redirect:/sinh-vien/nhap-thong-tin"; // Quay lại form
    } catch (Exception e) {
      // Nếu có lỗi lúc lưu (ví dụ trùng khóa chính)
      model.addAttribute("message_error", "Lỗi: " + e.getMessage());
      return "form-tot-nghiep"; // Ở lại form và báo lỗi
    }
  }
}
