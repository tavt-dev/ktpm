# Workflow đề tài kiểm thử Website bán kính mắt

## 1. Tổng quan đề tài

* **Đề tài:** Kiểm thử website bán kính mắt
* **Nhóm:** Nhóm 9
* **Website kiểm thử:** `hauiproj.somee.com`
* **Mục tiêu:** Thực hiện đầy đủ quy trình kiểm thử thủ công cho website bán kính mắt, từ phân tích yêu cầu đến lập báo cáo kiểm thử.

## 2. Phạm vi kiểm thử

Nhóm tập trung kiểm thử 5 chức năng chính:

1. Đăng ký tài khoản
2. Quản lý giỏ hàng
3. Đặt mua
4. Đăng nhập / Đăng xuất
5. Bảo trì danh mục

## 3. Tài khoản sử dụng

### Front End

* Username: `abc`
* Password: `abc`

### Back End

* Username: `admin`
* Password: `1234`

## 4. Mục tiêu của workflow

Workflow này giúp nhóm triển khai đề tài theo đúng trình tự, dễ phân công công việc, dễ theo dõi tiến độ và đảm bảo tạo ra đầy đủ bộ tài liệu cần nộp.

---

# 5. Workflow thực hiện đề tài

## Giai đoạn 1: Phân tích yêu cầu

### Mục tiêu

Hiểu rõ hệ thống, yêu cầu nghiệp vụ và xác định chính xác phạm vi kiểm thử.

### Công việc cần làm

* Đọc kỹ đề bài, tài liệu đặc tả hệ thống và mẫu Test Plan.
* Xác định đúng 5 chức năng bắt buộc cần kiểm thử.
* Phân tích từng chức năng theo các nội dung:

  * Mục tiêu chức năng
  * Tiền điều kiện
  * Luồng chính
  * Luồng thay thế
  * Luồng ngoại lệ
  * Dữ liệu vào
  * Kết quả mong đợi
  * Quy tắc nghiệp vụ

### Kết quả đầu ra

* Danh sách yêu cầu kiểm thử cho từng chức năng
* Ghi chú phân tích nghiệp vụ

---

## Giai đoạn 2: Lập Test Plan

### Mục tiêu

Xây dựng kế hoạch kiểm thử tổng thể cho đề tài.

### Nội dung Test Plan cần có

* Mục tiêu kiểm thử
* Phạm vi kiểm thử
* Phạm vi không kiểm thử
* Tài liệu tham chiếu
* Chiến lược kiểm thử
* Môi trường kiểm thử
* Tiêu chí bắt đầu / tạm dừng / kết thúc
* Nguồn lực
* Lịch trình thực hiện
* Sản phẩm bàn giao

### Định hướng cho đề tài này

* Hình thức kiểm thử: **Manual Testing**
* Kỹ thuật chính: **Black-box Testing**
* Tập trung test **functional, negative, boundary**
* Không đi sâu vào performance test và security test chuyên sâu

### Kết quả đầu ra

* File `TestPlan.docx`

---

## Giai đoạn 3: Thiết kế Test Scenario và Test Case

### Mục tiêu

Chuyển yêu cầu thành các tình huống kiểm thử và test case cụ thể.

### Công việc cần làm

* Liệt kê test scenario cho từng chức năng
* Viết test case theo các nhóm:

  * Positive test
  * Negative test
  * Boundary test
* Viết đầy đủ:

  * Test Case ID
  * Test Item
  * Preconditions
  * Test Steps
  * Test Data
  * Expected Result
  * Priority
* Tạo **Traceability Matrix** để liên kết yêu cầu với test case

### Nguyên tắc

* Mỗi yêu cầu phải được bao phủ bởi ít nhất 1 test case
* Mỗi chức năng phải có case hợp lệ, không hợp lệ và dữ liệu biên

### Kết quả đầu ra

* File `TestCases.xlsx`

---

## Giai đoạn 4: Chuẩn bị dữ liệu kiểm thử

### Mục tiêu

Chuẩn bị đầy đủ dữ liệu để thực thi test.

### Dữ liệu cần chuẩn bị

* Tài khoản hợp lệ
* Tài khoản không hợp lệ
* Dữ liệu đăng ký mới
* Sản phẩm có sẵn để thêm vào giỏ
* Danh mục trống
* Danh mục có chứa sản phẩm
* Giỏ hàng rỗng
* Giỏ hàng có 1 sản phẩm
* Giỏ hàng có nhiều sản phẩm
* Thông tin đặt hàng hợp lệ / không hợp lệ

### Lưu ý

* Thống nhất tài khoản dùng chung trong nhóm
* Tránh 2 người cùng thao tác trên cùng một dữ liệu gây sai lệch kết quả

### Kết quả đầu ra

* Danh sách test data phục vụ chạy test

---

## Giai đoạn 5: Thực thi kiểm thử

### Mục tiêu

Chạy test case trên hệ thống thật và ghi nhận kết quả.

### Thứ tự chạy khuyến nghị

1. Đăng ký tài khoản
2. Đăng nhập / Đăng xuất
3. Quản lý giỏ hàng
4. Đặt mua
5. Bảo trì danh mục

### Công việc cần làm

* Mở test case theo từng module
* Thực hiện đúng các bước trong test case
* So sánh kết quả thực tế với expected result
* Ghi kết quả vào Test Log:

  * Pass
  * Fail
  * Blocked
* Chụp màn hình làm bằng chứng

### Kết quả đầu ra

* Test Log
* Thư mục screenshot bằng chứng

---

## Giai đoạn 6: Ghi nhận và quản lý lỗi

### Mục tiêu

Theo dõi tất cả lỗi được phát hiện trong quá trình kiểm thử.

### Thông tin cần có trong Defect Report

* Defect ID
* Module
* Tên lỗi
* Mô tả lỗi
* Bước tái hiện
* Expected Result
* Actual Result
* Severity
* Priority
* Status
* Người phát hiện
* Ngày phát hiện
* Ảnh minh chứng

### Một số lỗi có thể gặp

* Đăng ký thiếu dữ liệu nhưng vẫn lưu thành công
* Đăng nhập sai nhưng vẫn vào hệ thống
* Giỏ hàng không cập nhật tổng tiền khi đổi số lượng
* Giỏ hàng rỗng vẫn cho thanh toán
* User thường truy cập được chức năng quản trị
* Xóa danh mục có chứa sản phẩm nhưng hệ thống vẫn cho xóa

### Kết quả đầu ra

* File `DefectReport.xlsx`

---

## Giai đoạn 7: Tổng hợp Test Report

### Mục tiêu

Đánh giá chất lượng hệ thống sau khi kiểm thử.

### Nội dung cần có

* Tổng số test case đã thiết kế
* Tổng số test case đã thực thi
* Số lượng Pass / Fail / Blocked
* Tỷ lệ pass rate
* Tổng số lỗi phát hiện
* Phân loại lỗi theo severity
* Đánh giá mức độ ổn định của hệ thống
* Kết luận và kiến nghị

### Kết quả đầu ra

* File `TestReport.pdf`

---

# 6. Workflow chi tiết theo bước làm việc của nhóm

## Bước 1. Nhận đề tài

* Đọc đề bài
* Đọc tài liệu đặc tả
* Đọc mẫu Test Plan
* Xác định chức năng được giao

## Bước 2. Phân tích chức năng

* Mỗi thành viên nhận 1 hoặc nhiều chức năng
* Tóm tắt nghiệp vụ
* Xác định input, output, điều kiện và ràng buộc

## Bước 3. Phân công module

Gợi ý phân công:

* Thành viên 1: Đăng ký tài khoản
* Thành viên 2: Đăng nhập / Đăng xuất
* Thành viên 3: Quản lý giỏ hàng
* Thành viên 4: Đặt mua
* Thành viên 5: Bảo trì danh mục
* Trưởng nhóm: Tổng hợp tài liệu, review, báo cáo

## Bước 4. Viết Test Plan

* Trưởng nhóm tạo khung tài liệu
* Các thành viên góp nội dung
* Cả nhóm review và chốt

## Bước 5. Thiết kế Test Scenario

* Liệt kê toàn bộ tình huống kiểm thử cấp cao
* Gom nhóm theo chức năng

## Bước 6. Viết Test Cases và Traceability Matrix

* Viết test case chi tiết trong file Excel
* Đảm bảo bao phủ đủ yêu cầu

## Bước 7. Review nội bộ

* Kiểm tra thiếu case
* Kiểm tra trùng case
* Kiểm tra expected result có rõ ràng không
* Kiểm tra có đủ positive / negative / boundary chưa

## Bước 8. Chuẩn bị test data

* Chuẩn bị tài khoản
* Chuẩn bị dữ liệu sản phẩm, danh mục, giỏ hàng
* Chuẩn bị dữ liệu sai để test negative case

## Bước 9. Thực thi test

* Chạy test theo module
* Ghi log
* Chụp ảnh bằng chứng

## Bước 10. Ghi Defect Report

* Mỗi lỗi ghi riêng
* Mô tả rõ ràng, dễ tái hiện
* Đính kèm ảnh chụp màn hình

## Bước 11. Re-test nếu cần

* Chạy lại các case fail sau khi sửa lỗi hoặc thay đổi dữ liệu

## Bước 12. Viết Test Report

* Tổng hợp kết quả cuối cùng
* Đánh giá chất lượng phần mềm
* Chuẩn bị nộp bài

---

# 7. Workflow theo tiến độ gợi ý

## Buổi 1

* Đọc đề tài
* Phân tích yêu cầu
* Phân công chức năng

## Buổi 2

* Hoàn thành Test Plan
* Liệt kê Test Scenario

## Buổi 3

* Viết Test Case
* Hoàn thiện Traceability Matrix

## Buổi 4

* Chạy test vòng 1
* Ghi Test Log
* Ghi lỗi

## Buổi 5

* Bổ sung test case còn thiếu
* Chạy test vòng 2
* Hoàn thiện Defect Report

## Buổi 6

* Tổng hợp kết quả
* Viết Test Report
* Sắp xếp thư mục nộp bài

---

# 8. Bộ tài liệu cần nộp

Nhóm cần chuẩn bị đầy đủ:

* `TestPlan.docx`
* `TestCases.xlsx`
* `DefectReport.xlsx`
* `TestReport.pdf`
* `Thu_muc_Screenshot/`
* Phần mềm còn lỗi để minh chứng quá trình kiểm thử

---

# 9. Kết luận

Đây là đề tài kiểm thử theo quy trình tương đối đầy đủ, yêu cầu nhóm phải thể hiện được toàn bộ vòng đời kiểm thử cơ bản:

1. Phân tích yêu cầu
2. Lập kế hoạch kiểm thử
3. Thiết kế test case
4. Thực thi kiểm thử
5. Ghi nhận lỗi
6. Tổng hợp báo cáo

Nếu thực hiện đúng workflow trên, nhóm sẽ dễ kiểm soát tiến độ, tránh thiếu tài liệu và tăng chất lượng bài nộp.
