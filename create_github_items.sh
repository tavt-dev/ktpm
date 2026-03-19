#!/bin/bash

# Create milestones
gh milestone create --title "Week 1: Project Initiation and Planning" --description "Analyze requirements and create test plan" --due-date "2026-03-25"
gh milestone create --title "Week 2: Requirement Analysis" --description "Detailed analysis of website functions" --due-date "2026-04-01"
gh milestone create --title "Week 3: Test Planning" --description "Develop comprehensive test plan" --due-date "2026-04-08"
gh milestone create --title "Week 4: Test Design - Part 1" --description "Design test cases for registration and cart management" --due-date "2026-04-15"
gh milestone create --title "Week 5: Test Design - Part 2" --description "Design test cases for ordering and login/logout" --due-date "2026-04-22"
gh milestone create --title "Week 6: Test Execution and Defect Logging" --description "Execute tests and log defects" --due-date "2026-04-29"
gh milestone create --title "Week 7: Retest and Reporting" --description "Retest fixes and prepare reports" --due-date "2026-05-06"
gh milestone create --title "Week 8: Final Submission" --description "Compile all deliverables and submit" --due-date "2026-05-13"

# Create issues for Week 1
gh issue create --title "Analyze Project Requirements" --body "## Milestone: Week 1: Project Initiation and Planning
**Labels:** analysis, high-priority
**Priority:** High
**Assignee:** Team Lead
**Start date:** 2026-03-19
**Due date:** 2026-03-21
**Estimated effort:** 2 days

**Description:**
Analyze the website functions and requirements for the eyeglass sales website.

**Acceptance Criteria:**
- [ ] Documented functional requirements for all 5 modules
- [ ] Identified test scope and boundaries
- [ ] Listed test accounts and access details

**Depends on:**
None

**Deliverables:**
- Requirements analysis document" --milestone "Week 1" --label "analysis,high-priority"

gh issue create --title "Create Test Plan Document" --body "## Milestone: Week 1: Project Initiation and Planning
**Labels:** test-plan, documentation, high-priority
**Priority:** High
**Assignee:** QA Member 1
**Start date:** 2026-03-19
**Due date:** 2026-03-25
**Estimated effort:** 3 days

**Description:**
Write the Test Plan document covering scope, approach, and schedule.

**Acceptance Criteria:**
- [ ] Test objectives defined
- [ ] Test scope documented
- [ ] Test schedule outlined
- [ ] Risk assessment included

**Depends on:**
- Analyze Project Requirements

**Deliverables:**
- TestPlan.docx" --milestone "Week 1" --label "test-plan,documentation,high-priority"

gh issue create --title "Set Up Project Documentation Structure" --body "## Milestone: Week 1: Project Initiation and Planning
**Labels:** documentation, planning
**Priority:** Medium
**Assignee:** QA Member 2
**Start date:** 2026-03-19
**Due date:** 2026-03-22
**Estimated effort:** 1 day

**Description:**
Create folder structure for all project deliverables.

**Acceptance Criteria:**
- [ ] Created folders for TestPlan, TestCases, DefectReport, TestReport
- [ ] Set up Screenshot folder
- [ ] Organized documentation structure

**Depends on:**
None

**Deliverables:**
- Project folder structure" --milestone "Week 1" --label "documentation,planning"

# Create issues for Week 2
gh issue create --title "Analyze Registration Module Requirements" --body "## Milestone: Week 2: Requirement Analysis
**Labels:** analysis, module-register
**Priority:** High
**Assignee:** QA Member 1
**Start date:** 2026-03-26
**Due date:** 2026-03-28
**Estimated effort:** 1.5 days

**Description:**
Detailed analysis of user registration functionality.

**Acceptance Criteria:**
- [ ] Identified all registration fields
- [ ] Documented validation rules
- [ ] Listed edge cases

**Depends on:**
- Analyze Project Requirements

**Deliverables:**
- Registration requirements document" --milestone "Week 2" --label "analysis,module-register"

gh issue create --title "Analyze Cart Management Module" --body "## Milestone: Week 2: Requirement Analysis
**Labels:** analysis, module-cart
**Priority:** High
**Assignee:** QA Member 2
**Start date:** 2026-03-26
**Due date:** 2026-03-30
**Estimated effort:** 2 days

**Description:**
Analyze shopping cart functionality and requirements.

**Acceptance Criteria:**
- [ ] Documented add/remove items logic
- [ ] Identified quantity limits
- [ ] Listed cart persistence rules

**Depends on:**
- Analyze Project Requirements

**Deliverables:**
- Cart management requirements" --milestone "Week 2" --label "analysis,module-cart"

gh issue create --title "Analyze Ordering Module" --body "## Milestone: Week 2: Requirement Analysis
**Labels:** analysis, module-order
**Priority:** High
**Assignee:** QA Member 3
**Start date:** 2026-03-26
**Due date:** 2026-04-01
**Estimated effort:** 2 days

**Description:**
Analyze purchase ordering process.

**Acceptance Criteria:**
- [ ] Documented order flow
- [ ] Identified payment integration
- [ ] Listed order confirmation steps

**Depends on:**
- Analyze Project Requirements

**Deliverables:**
- Ordering requirements document" --milestone "Week 2" --label "analysis,module-order"

gh issue create --title "Analyze Login/Logout Module" --body "## Milestone: Week 2: Requirement Analysis
**Labels:** analysis, module-auth
**Priority:** High
**Assignee:** QA Member 4
**Start date:** 2026-03-26
**Due date:** 2026-03-29
**Estimated effort:** 1.5 days

**Description:**
Analyze authentication functionality.

**Acceptance Criteria:**
- [ ] Documented login/logout flows
- [ ] Identified session management
- [ ] Listed security requirements

**Depends on:**
- Analyze Project Requirements

**Deliverables:**
- Auth module requirements" --milestone "Week 2" --label "analysis,module-auth"

gh issue create --title "Analyze Category Maintenance Module" --body "## Milestone: Week 2: Requirement Analysis
**Labels:** analysis, module-category
**Priority:** High
**Assignee:** QA Member 5
**Start date:** 2026-03-26
**Due date:** 2026-03-31
**Estimated effort:** 1.5 days

**Description:**
Analyze backend category management.

**Acceptance Criteria:**
- [ ] Documented CRUD operations
- [ ] Identified admin permissions
- [ ] Listed category hierarchy

**Depends on:**
- Analyze Project Requirements

**Deliverables:**
- Category maintenance requirements" --milestone "Week 2" --label "analysis,module-category"

# Create issues for Week 3
gh issue create --title "Develop Detailed Test Plan" --body "## Milestone: Week 3: Test Planning
**Labels:** test-plan, documentation, high-priority
**Priority:** High
**Assignee:** Team Lead
**Start date:** 2026-04-02
**Due date:** 2026-04-08
**Estimated effort:** 4 days

**Description:**
Expand the test plan with detailed procedures and schedules.

**Acceptance Criteria:**
- [ ] Detailed test procedures
- [ ] Entry/exit criteria defined
- [ ] Test environment setup documented

**Depends on:**
- Create Test Plan Document
- Analyze Registration Module Requirements
- Analyze Cart Management Module
- Analyze Ordering Module
- Analyze Login/Logout Module
- Analyze Category Maintenance Module

**Deliverables:**
- Updated TestPlan.docx" --milestone "Week 3" --label "test-plan,documentation,high-priority"

# Create issues for Week 4
gh issue create --title "Design Test Cases for Registration" --body "## Milestone: Week 4: Test Design - Part 1
**Labels:** test-case, module-register
**Priority:** High
**Assignee:** QA Member 1
**Start date:** 2026-04-09
**Due date:** 2026-04-12
**Estimated effort:** 2 days

**Description:**
Create functional, negative, and boundary test cases for registration.

**Acceptance Criteria:**
- [ ] At least 10 test cases created
- [ ] Covers all scenarios
- [ ] Includes boundary and negative tests

**Depends on:**
- Analyze Registration Module Requirements

**Deliverables:**
- Registration test cases in TestCases.xlsx" --milestone "Week 4" --label "test-case,module-register"

gh issue create --title "Design Test Cases for Cart Management" --body "## Milestone: Week 4: Test Design - Part 1
**Labels:** test-case, module-cart
**Priority:** High
**Assignee:** QA Member 2
**Start date:** 2026-04-09
**Due date:** 2026-04-15
**Estimated effort:** 3 days

**Description:**
Create comprehensive test cases for cart functionality.

**Acceptance Criteria:**
- [ ] At least 12 test cases
- [ ] Covers add, remove, update scenarios
- [ ] Includes boundary conditions

**Depends on:**
- Analyze Cart Management Module

**Deliverables:**
- Cart test cases in TestCases.xlsx" --milestone "Week 4" --label "test-case,module-cart"

# Create issues for Week 5
gh issue create --title "Design Test Cases for Ordering" --body "## Milestone: Week 5: Test Design - Part 2
**Labels:** test-case, module-order
**Priority:** High
**Assignee:** QA Member 3
**Start date:** 2026-04-16
**Due date:** 2026-04-19
**Estimated effort:** 2 days

**Description:**
Design test cases for purchase ordering process.

**Acceptance Criteria:**
- [ ] At least 10 test cases
- [ ] Covers full order flow
- [ ] Includes payment scenarios

**Depends on:**
- Analyze Ordering Module

**Deliverables:**
- Ordering test cases in TestCases.xlsx" --milestone "Week 5" --label "test-case,module-order"

gh issue create --title "Design Test Cases for Login/Logout" --body "## Milestone: Week 5: Test Design - Part 2
**Labels:** test-case, module-auth
**Priority:** High
**Assignee:** QA Member 4
**Start date:** 2026-04-16
**Due date:** 2026-04-20
**Estimated effort:** 2 days

**Description:**
Create test cases for authentication features.

**Acceptance Criteria:**
- [ ] At least 8 test cases
- [ ] Covers login, logout, session
- [ ] Includes security tests

**Depends on:**
- Analyze Login/Logout Module

**Deliverables:**
- Auth test cases in TestCases.xlsx" --milestone "Week 5" --label "test-case,module-auth"

gh issue create --title "Design Test Cases for Category Maintenance" --body "## Milestone: Week 5: Test Design - Part 2
**Labels:** test-case, module-category, backend
**Priority:** High
**Assignee:** QA Member 5
**Start date:** 2026-04-16
**Due date:** 2026-04-22
**Estimated effort:** 2 days

**Description:**
Design test cases for backend category management.

**Acceptance Criteria:**
- [ ] At least 8 test cases
- [ ] Covers CRUD operations
- [ ] Includes admin access tests

**Depends on:**
- Analyze Category Maintenance Module

**Deliverables:**
- Category test cases in TestCases.xlsx" --milestone "Week 5" --label "test-case,module-category,backend"

# Create issues for Week 6
gh issue create --title "Prepare Test Data and Environment" --body "## Milestone: Week 6: Test Execution and Defect Logging
**Labels:** execution, planning
**Priority:** High
**Assignee:** QA Member 1
**Start date:** 2026-04-23
**Due date:** 2026-04-25
**Estimated effort:** 1.5 days

**Description:**
Set up test data and ensure test environment is ready.

**Acceptance Criteria:**
- [ ] Test accounts configured
- [ ] Sample data prepared
- [ ] Environment verified

**Depends on:**
- Develop Detailed Test Plan

**Deliverables:**
- Test data setup confirmation" --milestone "Week 6" --label "execution,planning"

gh issue create --title "Execute Registration Test Cases" --body "## Milestone: Week 6: Test Execution and Defect Logging
**Labels:** execution, module-register
**Priority:** High
**Assignee:** QA Member 2
**Start date:** 2026-04-23
**Due date:** 2026-04-27
**Estimated effort:** 3 days

**Description:**
Execute all registration test cases and log results.

**Acceptance Criteria:**
- [ ] All test cases executed
- [ ] Test log maintained
- [ ] Screenshots captured for failures

**Depends on:**
- Design Test Cases for Registration
- Prepare Test Data and Environment

**Deliverables:**
- Test execution log for registration" --milestone "Week 6" --label "execution,module-register"

gh issue create --title "Execute Cart and Ordering Test Cases" --body "## Milestone: Week 6: Test Execution and Defect Logging
**Labels:** execution, module-cart, module-order
**Priority:** High
**Assignee:** QA Member 3
**Start date:** 2026-04-23
**Due date:** 2026-04-29
**Estimated effort:** 4 days

**Description:**
Execute cart and ordering test cases.

**Acceptance Criteria:**
- [ ] Cart tests completed
- [ ] Ordering tests completed
- [ ] Defects logged with screenshots

**Depends on:**
- Design Test Cases for Cart Management
- Design Test Cases for Ordering
- Prepare Test Data and Environment

**Deliverables:**
- Test logs for cart and ordering" --milestone "Week 6" --label "execution,module-cart,module-order"

gh issue create --title "Execute Auth and Category Test Cases" --body "## Milestone: Week 6: Test Execution and Defect Logging
**Labels:** execution, module-auth, module-category
**Priority:** High
**Assignee:** QA Member 4
**Start date:** 2026-04-23
**Due date:** 2026-04-28
**Estimated effort:** 3 days

**Description:**
Execute authentication and category maintenance tests.

**Acceptance Criteria:**
- [ ] Auth tests completed
- [ ] Category tests completed
- [ ] All defects reported

**Depends on:**
- Design Test Cases for Login/Logout
- Design Test Cases for Category Maintenance
- Prepare Test Data and Environment

**Deliverables:**
- Test logs for auth and category" --milestone "Week 6" --label "execution,module-auth,module-category"

gh issue create --title "Log All Defects" --body "## Milestone: Week 6: Test Execution and Defect Logging
**Labels:** defect, documentation
**Priority:** High
**Assignee:** QA Member 5
**Start date:** 2026-04-23
**Due date:** 2026-04-29
**Estimated effort:** 3 days

**Description:**
Compile all defects into DefectReport.xlsx.

**Acceptance Criteria:**
- [ ] All defects documented
- [ ] Screenshots attached
- [ ] Severity and priority assigned

**Depends on:**
- Execute Registration Test Cases
- Execute Cart and Ordering Test Cases
- Execute Auth and Category Test Cases

**Deliverables:**
- DefectReport.xlsx" --milestone "Week 6" --label "defect,documentation"

# Create issues for Week 7
gh issue create --title "Retest Fixed Defects" --body "## Milestone: Week 7: Retest and Reporting
**Labels:** retest, execution
**Priority:** High
**Assignee:** QA Member 1
**Start date:** 2026-04-30
**Due date:** 2026-05-04
**Estimated effort:** 3 days

**Description:**
Retest all reported defects after fixes.

**Acceptance Criteria:**
- [ ] All defects retested
- [ ] Status updated
- [ ] New screenshots if needed

**Depends on:**
- Log All Defects

**Deliverables:**
- Retest results" --milestone "Week 7" --label "retest,execution"

gh issue create --title "Prepare Test Report" --body "## Milestone: Week 7: Retest and Reporting
**Labels:** report, documentation, high-priority
**Priority:** High
**Assignee:** Team Lead
**Start date:** 2026-04-30
**Due date:** 2026-05-06
**Estimated effort:** 4 days

**Description:**
Compile comprehensive test report.

**Acceptance Criteria:**
- [ ] Test summary included
- [ ] Defect statistics
- [ ] Recommendations provided

**Depends on:**
- Retest Fixed Defects
- Execute Registration Test Cases
- Execute Cart and Ordering Test Cases
- Execute Auth and Category Test Cases

**Deliverables:**
- TestReport.pdf" --milestone "Week 7" --label "report,documentation,high-priority"

# Create issues for Week 8
gh issue create --title "Compile All Deliverables" --body "## Milestone: Week 8: Final Submission
**Labels:** documentation, final
**Priority:** High
**Assignee:** QA Member 2
**Start date:** 2026-05-07
**Due date:** 2026-05-10
**Estimated effort:** 2 days

**Description:**
Organize all documents and screenshots.

**Acceptance Criteria:**
- [ ] All files compiled
- [ ] Folder structure verified
- [ ] Files checked for completeness

**Depends on:**
- Prepare Test Report
- Log All Defects

**Deliverables:**
- Complete deliverables package" --milestone "Week 8" --label "documentation"

gh issue create --title "Final Review and Submission" --body "## Milestone: Week 8: Final Submission
**Labels:** review, final, high-priority
**Priority:** High
**Assignee:** Team Lead
**Start date:** 2026-05-07
**Due date:** 2026-05-13
**Estimated effort:** 3 days

**Description:**
Review all work and prepare for submission.

**Acceptance Criteria:**
- [ ] All deliverables reviewed
- [ ] Quality check completed
- [ ] Submission ready

**Depends on:**
- Compile All Deliverables

**Deliverables:**
- Final submission package" --milestone "Week 8" --label "review,final,high-priority"