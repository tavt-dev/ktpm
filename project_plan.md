# Kế hoạch Quản lý Dự án Kiểm thử Website Bán Kính Mắt

## Phần 1: Bảng Milestones

Dự án bắt đầu từ ngày 2026-03-17 (thứ Hai, tuần 1) và kéo dài 8 tuần liên tục.

| Milestone | Mục tiêu | Start Date | Due Date | Deliverables |
|-----------|----------|------------|----------|--------------|
| Tuần 1: Phân tích Yêu cầu | Hoàn thành phân tích yêu cầu và chuẩn bị tài liệu cơ bản | 2026-03-17 | 2026-03-23 | Tài liệu phân tích yêu cầu sơ bộ, danh sách chức năng |
| Tuần 2: Viết Test Plan | Tạo Test Plan chi tiết cho toàn dự án | 2026-03-24 | 2026-03-30 | TestPlan.docx |
| Tuần 3: Thiết kế Test Cases (Phần 1) | Thiết kế test cases cho 2 module đầu | 2026-03-31 | 2026-04-06 | TestCases.xlsx (40+ cases, module đăng ký và giỏ hàng) |
| Tuần 4: Thiết kế Test Cases (Phần 2) và Chuẩn bị Test Data | Hoàn thành test cases còn lại và chuẩn bị dữ liệu test | 2026-04-07 | 2026-04-13 | TestCases.xlsx hoàn chỉnh, tài khoản test và dữ liệu mẫu |
| Tuần 5: Thực thi Kiểm thử (Phần 1) | Thực thi test cho 2 module đầu | 2026-04-14 | 2026-04-20 | Test Log, Screenshot ban đầu |
| Tuần 6: Thực thi Kiểm thử (Phần 2) và Báo lỗi | Hoàn thành execution, ghi defect | 2026-04-21 | 2026-04-27 | DefectReport.xlsx, Screenshot đầy đủ |
| Tuần 7: Retest và Viết Test Report | Retest defects, tạo báo cáo | 2026-04-28 | 2026-05-04 | TestReport.pdf, cập nhật DefectReport |
| Tuần 8: Final Submission và Review | Nộp tài liệu, review toàn bộ | 2026-05-05 | 2026-05-11 | Tất cả deliverables, thư mục Screenshot, phần mềm lỗi |

## Phần 2: Danh sách Issues theo từng Milestone

### Tuần 1: Phân tích Yêu cầu

## Issue: Phân tích chức năng Đăng ký tài khoản

**Milestone:** Tuần 1: Phân tích Yêu cầu  
**Labels:** analysis, module-register, medium-priority  
**Priority:** Medium  
**Assignee:** QA Member 1  
**Start date:** 2026-03-17  
**Due date:** 2026-03-19  
**Estimated effort:** 4 hours  

**Description:**  
Phân tích chi tiết chức năng đăng ký tài khoản trên website hauiproj.somee.com, bao gồm các trường input, validation rules, và flow đăng ký.

**Acceptance Criteria:**
- [ ] Xác định tất cả trường bắt buộc và tùy chọn
- [ ] Liệt kê các validation rules (email format, password strength, etc.)
- [ ] Mô tả flow đăng ký thành công và thất bại
- [ ] Ghi chú các edge cases

**Depends on:**  
None

**Deliverables:**  
- Tài liệu phân tích chức năng đăng ký

## Issue: Phân tích chức năng Quản lý giỏ hàng

**Milestone:** Tuần 1: Phân tích Yêu cầu  
**Labels:** analysis, module-cart, medium-priority  
**Priority:** Medium  
**Assignee:** QA Member 2  
**Start date:** 2026-03-17  
**Due date:** 2026-03-19  
**Estimated effort:** 4 hours  

**Description:**  
Phân tích chức năng thêm/xóa/sửa sản phẩm trong giỏ hàng, tính toán tổng tiền, và các ràng buộc.

**Acceptance Criteria:**
- [ ] Xác định các action: add, remove, update quantity
- [ ] Mô tả logic tính toán giá và thuế
- [ ] Liệt kê validation cho quantity và stock
- [ ] Ghi chú persistence của giỏ hàng

**Depends on:**  
None

**Deliverables:**  
- Tài liệu phân tích chức năng giỏ hàng

## Issue: Phân tích chức năng Đặt mua

**Milestone:** Tuần 1: Phân tích Yêu cầu  
**Labels:** analysis, module-order, medium-priority  
**Priority:** Medium  
**Assignee:** QA Member 3  
**Start date:** 2026-03-20  
**Due date:** 2026-03-21  
**Estimated effort:** 4 hours  

**Description:**  
Phân tích quy trình đặt hàng từ giỏ hàng đến thanh toán, bao gồm các bước và validation.

**Acceptance Criteria:**
- [ ] Mô tả flow đặt hàng đầy đủ
- [ ] Xác định các bước checkout
- [ ] Liệt kê payment methods và validation
- [ ] Ghi chú order confirmation

**Depends on:**  
None

**Deliverables:**  
- Tài liệu phân tích chức năng đặt mua

## Issue: Phân tích chức năng Đăng nhập/Đăng xuất

**Milestone:** Tuần 1: Phân tích Yêu cầu  
**Labels:** analysis, module-auth, medium-priority  
**Priority:** Medium  
**Assignee:** QA Member 4  
**Start date:** 2026-03-20  
**Due date:** 2026-03-21  
**Estimated effort:** 4 hours  

**Description:**  
Phân tích chức năng authentication: login, logout, remember me, password reset.

**Acceptance Criteria:**
- [ ] Xác định login credentials và validation
- [ ] Mô tả session management
- [ ] Liệt kê error messages cho login failed
- [ ] Ghi chú logout behavior

**Depends on:**  
None

**Deliverables:**  
- Tài liệu phân tích chức năng auth

## Issue: Phân tích chức năng Bảo trì danh mục

**Milestone:** Tuần 1: Phân tích Yêu cầu  
**Labels:** analysis, module-category, medium-priority  
**Priority:** Medium  
**Assignee:** QA Member 5  
**Start date:** 2026-03-22  
**Due date:** 2026-03-23  
**Estimated effort:** 4 hours  

**Description:**  
Phân tích chức năng quản lý danh mục sản phẩm (backend), bao gồm CRUD operations.

**Acceptance Criteria:**
- [ ] Xác định permissions cho admin
- [ ] Mô tả CRUD cho categories và products
- [ ] Liệt kê validation rules
- [ ] Ghi chú UI backend

**Depends on:**  
None

**Deliverables:**  
- Tài liệu phân tích chức năng danh mục

## Issue: Tổng hợp và Review Phân tích Yêu cầu

**Milestone:** Tuần 1: Phân tích Yêu cầu  
**Labels:** analysis, planning, high-priority  
**Priority:** High  
**Assignee:** Team Lead  
**Start date:** 2026-03-22  
**Due date:** 2026-03-23  
**Estimated effort:** 2 hours  

**Description:**  
Tổng hợp tất cả tài liệu phân tích, review và phê duyệt.

**Acceptance Criteria:**
- [ ] Kết hợp tất cả analysis docs
- [ ] Review consistency và completeness
- [ ] Phê duyệt bởi team lead
- [ ] Chuẩn bị cho test planning

**Depends on:**  
- Phân tích chức năng Đăng ký tài khoản
- Phân tích chức năng Quản lý giỏ hàng
- Phân tích chức năng Đặt mua
- Phân tích chức năng Đăng nhập/Đăng xuất
- Phân tích chức năng Bảo trì danh mục

**Deliverables:**  
- Tài liệu phân tích yêu cầu hoàn chỉnh

### Tuần 2: Viết Test Plan

## Issue: Viết Test Plan - Phần Planning và Scope

**Milestone:** Tuần 2: Viết Test Plan  
**Labels:** test-plan, planning, high-priority  
**Priority:** High  
**Assignee:** Team Lead  
**Start date:** 2026-03-24  
**Due date:** 2026-03-26  
**Estimated effort:** 6 hours  

**Description:**  
Viết phần introduction, scope, objectives, và assumptions cho Test Plan.

**Acceptance Criteria:**
- [ ] Mô tả project overview
- [ ] Xác định in-scope và out-of-scope
- [ ] Liệt kê test objectives
- [ ] Ghi chú assumptions và constraints

**Depends on:**  
- Tổng hợp và Review Phân tích Yêu cầu

**Deliverables:**  
- Draft TestPlan.docx (phần đầu)

## Issue: Viết Test Plan - Test Strategy và Approach

**Milestone:** Tuần 2: Viết Test Plan  
**Labels:** test-plan, planning, high-priority  
**Priority:** High  
**Assignee:** QA Member 1  
**Start date:** 2026-03-24  
**Due date:** 2026-03-26  
**Estimated effort:** 6 hours  

**Description:**  
Viết phần test strategy, types of testing, test environment, và tools.

**Acceptance Criteria:**
- [ ] Mô tả testing types (functional, negative, boundary)
- [ ] Xác định test environment specs
- [ ] Liệt kê tools và resources
- [ ] Ghi chú entry/exit criteria

**Depends on:**  
- Viết Test Plan - Phần Planning và Scope

**Deliverables:**  
- Cập nhật TestPlan.docx

## Issue: Viết Test Plan - Schedule và Resources

**Milestone:** Tuần 2: Viết Test Plan  
**Labels:** test-plan, planning, medium-priority  
**Priority:** Medium  
**Assignee:** QA Member 2  
**Start date:** 2026-03-27  
**Due date:** 2026-03-28  
**Estimated effort:** 4 hours  

**Description:**  
Viết phần schedule, roles & responsibilities, và deliverables.

**Acceptance Criteria:**
- [ ] Tạo timeline chi tiết
- [ ] Gán roles cho team members
- [ ] Liệt kê tất cả deliverables
- [ ] Ước lượng effort

**Depends on:**  
- Viết Test Plan - Test Strategy và Approach

**Deliverables:**  
- Cập nhật TestPlan.docx

## Issue: Review và Finalize Test Plan

**Milestone:** Tuần 2: Viết Test Plan  
**Labels:** test-plan, documentation, high-priority  
**Priority:** High  
**Assignee:** Team Lead  
**Start date:** 2026-03-29  
**Due date:** 2026-03-30  
**Estimated effort:** 4 hours  

**Description:**  
Review toàn bộ Test Plan, chỉnh sửa và finalize.

**Acceptance Criteria:**
- [ ] Review nội dung và format
- [ ] Chỉnh sửa dựa trên feedback
- [ ] Finalize TestPlan.docx
- [ ] Phê duyệt bởi team

**Depends on:**  
- Viết Test Plan - Schedule và Resources

**Deliverables:**  
- TestPlan.docx hoàn chỉnh

### Tuần 3: Thiết kế Test Cases (Phần 1)

## Issue: Thiết kế Test Cases cho Đăng ký tài khoản

**Milestone:** Tuần 3: Thiết kế Test Cases (Phần 1)  
**Labels:** test-case, module-register, high-priority  
**Priority:** High  
**Assignee:** QA Member 1  
**Start date:** 2026-03-31  
**Due date:** 2026-04-02  
**Estimated effort:** 8 hours  

**Description:**  
Thiết kế >=10 test cases cho chức năng đăng ký, bao gồm functional, negative, boundary.

**Acceptance Criteria:**
- [ ] Tạo ít nhất 10 test cases
- [ ] Bao gồm positive và negative scenarios
- [ ] Có boundary value testing
- [ ] Format chuẩn trong Excel

**Depends on:**  
- Review và Finalize Test Plan

**Deliverables:**  
- TestCases.xlsx (sheet đăng ký)

## Issue: Thiết kế Test Cases cho Quản lý giỏ hàng

**Milestone:** Tuần 3: Thiết kế Test Cases (Phần 1)  
**Labels:** test-case, module-cart, high-priority  
**Priority:** High  
**Assignee:** QA Member 2  
**Start date:** 2026-03-31  
**Due date:** 2026-04-02  
**Estimated effort:** 8 hours  

**Description:**  
Thiết kế >=10 test cases cho chức năng giỏ hàng.

**Acceptance Criteria:**
- [ ] Tạo ít nhất 10 test cases
- [ ] Test add/remove/update items
- [ ] Test calculations và validations
- [ ] Bao gồm edge cases

**Depends on:**  
- Review và Finalize Test Plan

**Deliverables:**  
- TestCases.xlsx (sheet giỏ hàng)

## Issue: Review Test Cases Phần 1

**Milestone:** Tuần 3: Thiết kế Test Cases (Phần 1)  
**Labels:** test-case, documentation, medium-priority  
**Priority:** Medium  
**Assignee:** Team Lead  
**Start date:** 2026-04-03  
**Due date:** 2026-04-04  
**Estimated effort:** 4 hours  

**Description:**  
Review và phê duyệt test cases phần 1.

**Acceptance Criteria:**
- [ ] Kiểm tra completeness và accuracy
- [ ] Đảm bảo coverage đầy đủ
- [ ] Chỉnh sửa nếu cần
- [ ] Phê duyệt

**Depends on:**  
- Thiết kế Test Cases cho Đăng ký tài khoản
- Thiết kế Test Cases cho Quản lý giỏ hàng

**Deliverables:**  
- TestCases.xlsx reviewed

## Issue: Thiết kế Test Cases cho Đặt mua

**Milestone:** Tuần 3: Thiết kế Test Cases (Phần 1)  
**Labels:** test-case, module-order, high-priority  
**Priority:** High  
**Assignee:** QA Member 3  
**Start date:** 2026-04-05  
**Due date:** 2026-04-06  
**Estimated effort:** 8 hours  

**Description:**  
Thiết kế >=10 test cases cho chức năng đặt mua.

**Acceptance Criteria:**
- [ ] Tạo ít nhất 10 test cases
- [ ] Test full order flow
- [ ] Bao gồm payment scenarios
- [ ] Test error handling

**Depends on:**  
- Review Test Cases Phần 1

**Deliverables:**  
- TestCases.xlsx (sheet đặt mua)

### Tuần 4: Thiết kế Test Cases (Phần 2) và Chuẩn bị Test Data

## Issue: Thiết kế Test Cases cho Đăng nhập/Đăng xuất

**Milestone:** Tuần 4: Thiết kế Test Cases (Phần 2) và Chuẩn bị Test Data  
**Labels:** test-case, module-auth, high-priority  
**Priority:** High  
**Assignee:** QA Member 4  
**Start date:** 2026-04-07  
**Due date:** 2026-04-08  
**Estimated effort:** 6 hours  

**Description:**  
Thiết kế >=5 test cases cho auth module.

**Acceptance Criteria:**
- [ ] Tạo ít nhất 5 test cases
- [ ] Test login/logout flows
- [ ] Bao gồm invalid credentials
- [ ] Test session timeout

**Depends on:**  
- Thiết kế Test Cases cho Đặt mua

**Deliverables:**  
- TestCases.xlsx (sheet auth)

## Issue: Thiết kế Test Cases cho Bảo trì danh mục

**Milestone:** Tuần 4: Thiết kế Test Cases (Phần 2) và Chuẩn bị Test Data  
**Labels:** test-case, module-category, backend, high-priority  
**Priority:** High  
**Assignee:** QA Member 5  
**Start date:** 2026-04-07  
**Due date:** 2026-04-08  
**Estimated effort:** 6 hours  

**Description:**  
Thiết kế >=5 test cases cho backend category management.

**Acceptance Criteria:**
- [ ] Tạo ít nhất 5 test cases
- [ ] Test CRUD operations
- [ ] Bao gồm admin permissions
- [ ] Test data validation

**Depends on:**  
- Thiết kế Test Cases cho Đặt mua

**Deliverables:**  
- TestCases.xlsx (sheet category)

## Issue: Chuẩn bị Test Data và Tài khoản

**Milestone:** Tuần 4: Thiết kế Test Cases (Phần 2) và Chuẩn bị Test Data  
**Labels:** test-case, planning, medium-priority  
**Priority:** Medium  
**Assignee:** QA Member 1  
**Start date:** 2026-04-09  
**Due date:** 2026-04-10  
**Estimated effort:** 4 hours  

**Description:**  
Chuẩn bị test data, tài khoản test (abc/abc, admin/1234), và môi trường test.

**Acceptance Criteria:**
- [ ] Tạo test accounts
- [ ] Chuẩn bị sample data cho products
- [ ] Verify access to website
- [ ] Document test data

**Depends on:**  
- Thiết kế Test Cases cho Đăng nhập/Đăng xuất
- Thiết kế Test Cases cho Bảo trì danh mục

**Deliverables:**  
- Tài liệu test data

## Issue: Review và Finalize Test Cases

**Milestone:** Tuần 4: Thiết kế Test Cases (Phần 2) và Chuẩn bị Test Data  
**Labels:** test-case, documentation, high-priority  
**Priority:** High  
**Assignee:** Team Lead  
**Start date:** 2026-04-11  
**Due date:** 2026-04-13  
**Estimated effort:** 6 hours  

**Description:**  
Review toàn bộ test cases, đảm bảo >=40 cases, finalize Excel.

**Acceptance Criteria:**
- [ ] Đếm và verify 40+ test cases
- [ ] Review coverage và quality
- [ ] Finalize TestCases.xlsx
- [ ] Phê duyệt

**Depends on:**  
- Chuẩn bị Test Data và Tài khoản

**Deliverables:**  
- TestCases.xlsx hoàn chỉnh

### Tuần 5: Thực thi Kiểm thử (Phần 1)

## Issue: Thực thi Test Cases cho Đăng ký và Giỏ hàng

**Milestone:** Tuần 5: Thực thi Kiểm thử (Phần 1)  
**Labels:** execution, module-register, module-cart, high-priority  
**Priority:** High  
**Assignee:** QA Member 1  
**Start date:** 2026-04-14  
**Due date:** 2026-04-16  
**Estimated effort:** 10 hours  

**Description:**  
Thực thi test cases cho 2 module đầu, ghi test log và screenshot.

**Acceptance Criteria:**
- [ ] Execute tất cả test cases
- [ ] Ghi kết quả pass/fail
- [ ] Capture screenshots cho failures
- [ ] Update test log

**Depends on:**  
- Review và Finalize Test Cases

**Deliverables:**  
- Test log, Screenshot folder (partial)

## Issue: Thực thi Test Cases cho Đặt mua

**Milestone:** Tuần 5: Thực thi Kiểm thử (Phần 1)  
**Labels:** execution, module-order, high-priority  
**Priority:** High  
**Assignee:** QA Member 2  
**Start date:** 2026-04-14  
**Due date:** 2026-04-16  
**Estimated effort:** 10 hours  

**Description:**  
Thực thi test cases cho đặt mua.

**Acceptance Criteria:**
- [ ] Execute order test cases
- [ ] Ghi kết quả
- [ ] Capture evidence
- [ ] Log defects nếu có

**Depends on:**  
- Review và Finalize Test Cases

**Deliverables:**  
- Test log cập nhật

## Issue: Review Execution Phần 1

**Milestone:** Tuần 5: Thực thi Kiểm thử (Phần 1)  
**Labels:** execution, documentation, medium-priority  
**Priority:** Medium  
**Assignee:** Team Lead  
**Start date:** 2026-04-17  
**Due date:** 2026-04-18  
**Estimated effort:** 4 hours  

**Description:**  
Review kết quả execution phần 1.

**Acceptance Criteria:**
- [ ] Verify test logs
- [ ] Check screenshots
- [ ] Identify initial defects
- [ ] Prepare for next phase

**Depends on:**  
- Thực thi Test Cases cho Đăng ký và Giỏ hàng
- Thực thi Test Cases cho Đặt mua

**Deliverables:**  
- Summary execution report

## Issue: Thực thi Test Cases cho Auth

**Milestone:** Tuần 5: Thực thi Kiểm thử (Phần 1)  
**Labels:** execution, module-auth, high-priority  
**Priority:** High  
**Assignee:** QA Member 3  
**Start date:** 2026-04-19  
**Due date:** 2026-04-20  
**Estimated effort:** 8 hours  

**Description:**  
Thực thi test cases cho đăng nhập/đăng xuất.

**Acceptance Criteria:**
- [ ] Execute auth test cases
- [ ] Ghi kết quả
- [ ] Capture screenshots
- [ ] Update logs

**Depends on:**  
- Review Execution Phần 1

**Deliverables:**  
- Test log cập nhật

### Tuần 6: Thực thi Kiểm thử (Phần 2) và Báo lỗi

## Issue: Thực thi Test Cases cho Category (Backend)

**Milestone:** Tuần 6: Thực thi Kiểm thử (Phần 2) và Báo lỗi  
**Labels:** execution, module-category, backend, high-priority  
**Priority:** High  
**Assignee:** QA Member 4  
**Start date:** 2026-04-21  
**Due date:** 2026-04-22  
**Estimated effort:** 8 hours  

**Description:**  
Thực thi test cases backend cho category management.

**Acceptance Criteria:**
- [ ] Execute backend test cases
- [ ] Ghi kết quả
- [ ] Capture screenshots
- [ ] Log defects

**Depends on:**  
- Thực thi Test Cases cho Auth

**Deliverables:**  
- Test log hoàn chỉnh

## Issue: Tạo Defect Report

**Milestone:** Tuần 6: Thực thi Kiểm thử (Phần 2) và Báo lỗi  
**Labels:** defect, documentation, high-priority  
**Priority:** High  
**Assignee:** QA Member 5  
**Start date:** 2026-04-21  
**Due date:** 2026-04-23  
**Estimated effort:** 6 hours  

**Description:**  
Tạo DefectReport.xlsx với tất cả defects found.

**Acceptance Criteria:**
- [ ] List tất cả defects
- [ ] Mô tả steps to reproduce
- [ ] Attach screenshots
- [ ] Classify severity

**Depends on:**  
- Thực thi Test Cases cho Category (Backend)

**Deliverables:**  
- DefectReport.xlsx

## Issue: Review Defects và Prepare Retest

**Milestone:** Tuần 6: Thực thi Kiểm thử (Phần 2) và Báo lỗi  
**Labels:** defect, retest, medium-priority  
**Priority:** Medium  
**Assignee:** Team Lead  
**Start date:** 2026-04-24  
**Due date:** 2026-04-25  
**Estimated effort:** 4 hours  

**Description:**  
Review defect report và chuẩn bị cho retest.

**Acceptance Criteria:**
- [ ] Verify defect details
- [ ] Prioritize defects
- [ ] Plan retest schedule
- [ ] Notify development team (if applicable)

**Depends on:**  
- Tạo Defect Report

**Deliverables:**  
- Reviewed DefectReport.xlsx

## Issue: Thực thi Retest

**Milestone:** Tuần 6: Thực thi Kiểm thử (Phần 2) và Báo lỗi  
**Labels:** retest, execution, high-priority  
**Priority:** High  
**Assignee:** QA Member 1  
**Start date:** 2026-04-26  
**Due date:** 2026-04-27  
**Estimated effort:** 6 hours  

**Description:**  
Retest các defects đã được fix.

**Acceptance Criteria:**
- [ ] Execute retest cho fixed defects
- [ ] Update defect status
- [ ] Capture new screenshots
- [ ] Close resolved defects

**Depends on:**  
- Review Defects và Prepare Retest

**Deliverables:**  
- Updated DefectReport.xlsx

### Tuần 7: Retest và Viết Test Report

## Issue: Viết Test Report - Executive Summary

**Milestone:** Tuần 7: Retest và Viết Test Report  
**Labels:** report, documentation, high-priority  
**Priority:** High  
**Assignee:** Team Lead  
**Start date:** 2026-04-28  
**Due date:** 2026-04-29  
**Estimated effort:** 6 hours  

**Description:**  
Viết phần executive summary cho Test Report.

**Acceptance Criteria:**
- [ ] Tóm tắt project overview
- [ ] Liệt kê key metrics
- [ ] Mô tả overall results
- [ ] Recommendations

**Depends on:**  
- Thực thi Retest

**Deliverables:**  
- Draft TestReport.pdf (executive summary)

## Issue: Viết Test Report - Detailed Results

**Milestone:** Tuần 7: Retest và Viết Test Report  
**Labels:** report, documentation, high-priority  
**Priority:** High  
**Assignee:** QA Member 2  
**Start date:** 2026-04-28  
**Due date:** 2026-04-30  
**Estimated effort:** 8 hours  

**Description:**  
Viết phần detailed test results, defect analysis.

**Acceptance Criteria:**
- [ ] Chi tiết test execution results
- [ ] Defect summary và trends
- [ ] Coverage metrics
- [ ] Risk assessment

**Depends on:**  
- Viết Test Report - Executive Summary

**Deliverables:**  
- Cập nhật TestReport.pdf

## Issue: Viết Test Report - Conclusions và Appendices

**Milestone:** Tuần 7: Retest và Viết Test Report  
**Labels:** report, documentation, medium-priority  
**Priority:** Medium  
**Assignee:** QA Member 3  
**Start date:** 2026-05-01  
**Due date:** 2026-05-02  
**Estimated effort:** 6 hours  

**Description:**  
Hoàn thành conclusions, lessons learned, và appendices.

**Acceptance Criteria:**
- [ ] Viết conclusions
- [ ] Document lessons learned
- [ ] Add appendices (test logs, etc.)
- [ ] Format PDF properly

**Depends on:**  
- Viết Test Report - Detailed Results

**Deliverables:**  
- TestReport.pdf draft

## Issue: Review và Finalize Test Report

**Milestone:** Tuần 7: Retest và Viết Test Report  
**Labels:** report, documentation, high-priority  
**Priority:** High  
**Assignee:** Team Lead  
**Start date:** 2026-05-03  
**Due date:** 2026-05-04  
**Estimated effort:** 4 hours  

**Description:**  
Review và finalize TestReport.pdf.

**Acceptance Criteria:**
- [ ] Proofread content
- [ ] Check formatting
- [ ] Verify completeness
- [ ] Final approval

**Depends on:**  
- Viết Test Report - Conclusions và Appendices

**Deliverables:**  
- TestReport.pdf hoàn chỉnh

### Tuần 8: Final Submission và Review

## Issue: Compile Final Deliverables

**Milestone:** Tuần 8: Final Submission và Review  
**Labels:** documentation, final-submission, high-priority  
**Priority:** High  
**Assignee:** QA Member 4  
**Start date:** 2026-05-05  
**Due date:** 2026-05-06  
**Estimated effort:** 4 hours  

**Description:**  
Compile tất cả deliverables: TestPlan.docx, TestCases.xlsx, DefectReport.xlsx, TestReport.pdf, Screenshot folder.

**Acceptance Criteria:**
- [ ] Gather all files
- [ ] Verify completeness
- [ ] Organize folder structure
- [ ] Prepare submission package

**Depends on:**  
- Review và Finalize Test Report

**Deliverables:**  
- Final submission package

## Issue: Final Review và Quality Check

**Milestone:** Tuần 8: Final Submission và Review  
**Labels:** documentation, final-submission, high-priority  
**Priority:** High  
**Assignee:** Team Lead  
**Start date:** 2026-05-05  
**Due date:** 2026-05-07  
**Estimated effort:** 6 hours  

**Description:**  
Review toàn bộ project deliverables, đảm bảo quality.

**Acceptance Criteria:**
- [ ] Check all documents for errors
- [ ] Verify screenshots and evidence
- [ ] Ensure compliance with requirements
- [ ] Final sign-off

**Depends on:**  
- Compile Final Deliverables

**Deliverables:**  
- Reviewed final package

## Issue: Submit Project và Archive

**Milestone:** Tuần 8: Final Submission và Review  
**Labels:** final-submission, documentation, medium-priority  
**Priority:** Medium  
**Assignee:** QA Member 5  
**Start date:** 2026-05-08  
**Due date:** 2026-05-09  
**Estimated effort:** 2 hours  

**Description:**  
Submit deliverables theo yêu cầu và archive project.

**Acceptance Criteria:**
- [ ] Submit to instructor/platform
- [ ] Confirm receipt
- [ ] Archive all materials
- [ ] Document project completion

**Depends on:**  
- Final Review và Quality Check

**Deliverables:**  
- Submission confirmation

## Issue: Project Retrospective

**Milestone:** Tuần 8: Final Submission và Review  
**Labels:** planning, final-submission, low-priority  
**Priority:** Low  
**Assignee:** Team Lead  
**Start date:** 2026-05-10  
**Due date:** 2026-05-11  
**Estimated effort:** 2 hours  

**Description:**  
Thực hiện retrospective để học hỏi từ project.

**Acceptance Criteria:**
- [ ] Gather team feedback
- [ ] Identify successes và improvements
- [ ] Document lessons learned
- [ ] Plan for future projects

**Depends on:**  
- Submit Project và Archive

**Deliverables:**  
- Retrospective report

## Phần 3: Dependency Map Tổng quát

- **Planning Phase (Tuần 1-2):** Không phụ thuộc, là foundation.
- **Test Design (Tuần 3-4):** Phụ thuộc vào Planning và Analysis.
- **Execution (Tuần 5-6):** Phụ thuộc vào Test Design và Test Data preparation.
- **Reporting (Tuần 7):** Phụ thuộc vào Execution và Retest.
- **Final Submission (Tuần 8):** Phụ thuộc vào tất cả phases trước.

Key Dependencies:
- Tất cả Test Case design issues phụ thuộc vào "Review và Finalize Test Plan"
- Tất cả Execution issues phụ thuộc vào "Review và Finalize Test Cases"
- "Tạo Defect Report" phụ thuộc vào tất cả Execution issues
- "Viết Test Report" phụ thuộc vào "Thực thi Retest"
- "Compile Final Deliverables" phụ thuộc vào tất cả deliverables từ phases trước

## Phần 4: Gợi ý Labels

- planning
- analysis
- test-plan
- test-case
- execution
- defect
- retest
- report
- documentation
- high-priority
- medium-priority
- low-priority
- frontend
- backend
- module-auth
- module-cart
- module-order
- module-category
- module-register
- final-submission