# Web Glasses Store – Software Testing Project

*Dự án kiểm thử phần mềm dành cho học phần Software Testing (4 tuần, 4 thành viên).*

---

## 📌 Tổng quan dự án

Hệ thống Web Glasses Store là một cửa hàng kính trực tuyến đơn giản.
Nhóm thực hiện nhiệm vụ kiểm thử chức năng và một số khía cạnh
phi chức năng, nhằm đảm bảo chất lượng trước khi giao cho người dùng cuối.

**Mục tiêu kiểm thử**
- Đánh giá tính hợp lệ và độ ổn định của 5 module chính.
- Áp dụng quy trình kiểm thử chuẩn (STLC) trong môi trường nhóm nhỏ.

**Phạm vi dự án**
- Chức năng đăng ký, đăng nhập, giỏ hàng, đặt hàng, quản lý danh mục.
- Kiểm thử chức năng, tích hợp cơ bản, kiểm thử hiệu năng nhỏ,
  kiểm tra bảo mật đơn giản và hồi quy.
- Không bao gồm automation, kiểm thử hiệu suất với lượng lớn người dùng
  hay bảo mật chuyên sâu.

---

## 🧩 Các module hệ thống

1. Đăng ký tài khoản
2. Đăng nhập / Đăng xuất
3. Giỏ hàng
4. Đặt hàng
5. Quản lý danh mục (Admin)

Mỗi module có thiết kế test case riêng và chịu trách nhiệm thực thi bởi
1 thành viên.

---

## 🛠 Phạm vi kiểm thử

- **Functional testing**: các tình huống hợp lệ/không hợp lệ,
  ranh giới, trạng thái lỗi.
- **Integration testing**: luồng dữ liệu qua nhiều module (E2E).
- **Performance cơ bản**: mô phỏng 10‑20 người dùng bằng JMeter/Locust,
  đo thời gian tải trang.
- **Security validation cơ bản**: kiểm tra đầu vào, thử SQL‑i và XSS
  trên vài trường quan trọng.
- **Regression testing**: chạy lại các test case chính khi có sửa lỗi.

---

## 🧪 Quy trình kiểm thử (STLC)

1. **Phân tích yêu cầu**
   - Đọc tài liệu, xác định chức năng và điều kiện kiểm thử.
2. **Lập kế hoạch kiểm thử**
   - Xác định phạm vi, công cụ, thời gian, phân công.
3. **Thiết kế test case**
   - Viết kịch bản theo kỹ thuật Equivalence, BVA, negative, happy path.
4. **Thực thi kiểm thử**
   - Ghi nhận kết quả, ảnh chụp, trạng thái pass/fail.
5. **Theo dõi lỗi**
   - Log bug vào GitHub, phân loại mức độ, theo dõi trạng thái.
6. **Báo cáo**
   - Tổng hợp số lượng test case, tỷ lệ qua, phân tích lỗi, kết luận chất lượng.

---

## 📊 Cấu trúc dự án

- Quản lý công việc bằng **GitHub Issues**.
- 4 giai đoạn tương ứng với 4 milestones:
  1. Yêu cầu & lập kế hoạch
  2. Thiết kế test case
  3. Thực thi kiểm thử
  4. Báo cáo & đánh giá
- Phụ thuộc tuyến tính giữa các issue giúp nhóm tiến độ rõ ràng.

---

## 📈 Chỉ số chính

* **Tổng test case**: khoảng 130‑155
* **Tỷ lệ bao phủ**: 85–92 % so với yêu cầu chức năng
* **Phân loại lỗi**: Critical / High / Medium / Low
* **Mục tiêu pass rate**: 80‑90 %

Các chỉ số này đủ để minh chứng khả năng tổ chức và thực hiện kiểm thử
mà không quá tham vọng.

---

## 👥 Vai trò trong nhóm

- **Test Lead**: điều phối, kiểm tra tài liệu, báo cáo.
- **Tester**: thiết kế và thực thi test case.
- **Quản lý lỗi & thực thi**: cập nhật GitHub Issues, theo dõi tình trạng lỗi.

Mỗi thành viên đảm nhận ít nhất một module và hỗ trợ nhau.

---

## 📂 Cấu trúc thư mục

```
/ docs          # Test plan, test cases, traceability
/ test-cases    # biểu mẫu test case hoặc script
/ reports       # báo cáo kiểm thử, log, screenshot
/ scripts       # tùy có (ví dụ: JMeter plan)
README.md       # tài liệu này
```

---

## 🎯 Giá trị mô phỏng thực tế

Dự án thể hiện năng lực sau:

* Phân tích yêu cầu rõ ràng
* Tư duy kiểm thử có cấu trúc
* Quản lý lỗi và theo dõi tiến độ
* Làm việc nhóm qua GitHub
* Thực hiện quy trình QA gần với môi trường doanh nghiệp

Các kết quả này phù hợp để trình bày trong portfolio của một
QA Engineer mới ra trường.

---

## 🚀 Kết luận

Trong 4 tuần, nhóm đã hoàn thành một chu kỳ kiểm thử đầy đủ, từ
phân tích đến báo cáo, với phạm vi thực tế và áp lực vừa phải.
Dự án giúp học viên hiểu rõ công việc QA hàng ngày và có sản phẩm
chứng minh kỹ năng khi xin việc.

*— Nhóm Kiểm thử Web Glasses Store, 2026.*
