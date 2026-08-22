# UECS2354 – PrintMaster Group Assignment
### Software Testing Group Project | Semester 202606

---

## 📋 Table of Contents
1. [Project Overview](#project-overview)
2. [Team Members & Branch Ownership](#team-members--branch-ownership)
3. [Repository Structure](#repository-structure)
4. [Getting Started](#getting-started)
5. [Git Branching Strategy](#git-branching-strategy)
6. [Daily Workflow (Step-by-Step Git Commands)](#daily-workflow)
7. [Commit Message Rules](#commit-message-rules)
8. [Pull Request Rules](#pull-request-rules)
9. [File Submission Guidelines](#file-submission-guidelines)
10. [Merge Conflict Prevention](#merge-conflict-prevention)
11. [Final Integration Checklist](#final-integration-checklist)

---

## Project Overview

**System:** PrintMaster Printing Service Management System  
**Language:** Java  
**Testing Framework:** JUnit 4 + JUnitParams + Mockito  
**Submission Deadline:** W12 – Friday, 04 September 2026  
**Total Marks:** 100 (30% of final grade)

> ⚠️ **GenAI Policy Reminder:** GenAI may only be used for application code. All test plans, decision tables, test cases, and JUnit test code must be entirely your own work.

---

## Team Members & Branch Ownership

| Member | Name | Branch | Responsibility |
|--------|------|--------|----------------|
| Member 1 (Lead Developer) | *(your name)* | `main` + `feature/member1` | Test Plan · customer.java · readCustomer.java · addNewCustomer.java · File I/O tests |
| Member 2 | *(name)* | `feature/member2` | applyDiscount.java · Decision Table · EP/BVA · Discount unit tests |
| Member 3 | *(name)* | `feature/member3` | printOrder.java · calculatePrintingCharge.java · printerAvailability.java · Test Cases · Valid unit tests |
| Member 4 | *(name)* | `feature/member4` | generateInvoice.java · payment.java · emailInvoice.java · Invalid tests · Mockito tests · External data · Integration tests |

> **Only the Lead Developer (Member 1) merges into `main`.** All other members submit via Pull Request only.

---

## Repository Structure

```
UECS2354_GroupNumber_XX/
│
├── README.md                          ← This file
├── customer.txt                       ← External customer data file (project root)
├── testData_calculateCharge.csv       ← External test data file (project root)
│
├── src/
│   ├── application/                   ← All application (business logic) code
│   │   ├── customer.java              ← Member 1
│   │   ├── readCustomer.java          ← Member 1
│   │   ├── addNewCustomer.java        ← Member 1
│   │   ├── printOrder.java            ← Member 3
│   │   ├── calculatePrintingCharge.java ← Member 3
│   │   ├── printerAvailability.java   ← Member 3 (skeleton for mocking)
│   │   ├── applyDiscount.java         ← Member 2
│   │   ├── generateInvoice.java       ← Member 4
│   │   ├── payment.java               ← Member 4 (signatures only)
│   │   └── emailInvoice.java          ← Member 4 (signatures only)
│   │
│   └── test/                          ← All JUnit test code
│       ├── TestCustomerFileIO.java    ← Member 1
│       ├── TestApplyDiscount.java     ← Member 2
│       ├── TestCalculatePrintingChargeValid.java   ← Member 3 (C.1)
│       ├── TestCalculatePrintingChargeInvalid.java ← Member 4 (C.2)
│       ├── TestWithMockito.java       ← Member 4 (C.3)
│       ├── TestFromExternalFile.java  ← Member 4 (C.4)
│       └── TestIntegration.java       ← Member 4 (C.5)
│
└── docs/
    ├── UECS2354_GroupNumber_XX_TestPlan.docx          ← Member 1
    ├── UECS2354_GroupNumber_XX_DecisionTableEPBVA.xlsx ← Member 2
    ├── UECS2354_GroupNumber_XX_TestCase.xlsx          ← Member 3
    └── ClassDiagram.png                               ← Member 1 (after team review)
```

---

## Getting Started

### Step 1 – Clone the Repository

Every member runs this once on their own machine:

```bash
git clone https://github.com/YOUR_USERNAME/UECS2354_GroupNumber_XX.git
cd UECS2354_GroupNumber_XX
```

### Step 2 – Set Up Your Identity (run once per machine)

```bash
git config --global user.name "Your Full Name"
git config --global user.email "your_email@example.com"
```

### Step 3 – Verify You Are on `main` First

```bash
git branch
# Should show:   * main
```

### Step 4 – Create Your Personal Branch

Each member creates their own branch **once** at the start:

```bash
# Member 2
git checkout -b feature/member2

# Member 3
git checkout -b feature/member3

# Member 4
git checkout -b feature/member4
```

### Step 5 – Push Your Branch to GitHub

```bash
git push -u origin feature/memberX
# Replace X with your member number
```

You are now ready to start coding on your own branch.

---

## Git Branching Strategy

We use a simplified **Feature Branch Workflow**:

```
main  ──────────────────────────────────────────────► (final submission)
        ↑            ↑            ↑            ↑
        │ PR merge   │ PR merge   │ PR merge   │ PR merge
        │            │            │            │
feature/member1  feature/member2  feature/member3  feature/member4
```

### Branch Rules

| Branch | Who Uses It | Purpose |
|--------|-------------|---------|
| `main` | Lead Developer only | Clean, working, submission-ready code |
| `feature/member1` | Member 1 | Member 1's work in progress |
| `feature/member2` | Member 2 | Member 2's work in progress |
| `feature/member3` | Member 3 | Member 3's work in progress |
| `feature/member4` | Member 4 | Member 4's work in progress |

> ❌ **Never commit directly to `main`.** Even Member 1 should commit to `feature/member1` and merge locally after review.  
> ❌ **Never edit another member's files** on your own branch. Work only in your assigned files.

---

## Daily Workflow

Follow these steps every time you sit down to work:

### 1 – Switch to Your Branch

```bash
git checkout feature/memberX
```

### 2 – Pull Latest Changes from Remote

Always sync before you start coding to avoid conflicts:

```bash
git pull origin feature/memberX
```

### 3 – Write Your Code

Edit only the files assigned to you (see [Team Members & Branch Ownership](#team-members--branch-ownership)).

### 4 – Check What You Have Changed

```bash
git status
```

### 5 – Stage Your Changes

To stage specific files (recommended — avoids accidentally staging wrong files):

```bash
git add src/application/applyDiscount.java
git add src/test/TestApplyDiscount.java
```

To stage everything you changed:

```bash
git add .
```

### 6 – Commit Your Changes

```bash
git commit -m "feat(member2): implement applyDiscount sequential logic"
```

See [Commit Message Rules](#commit-message-rules) below for the exact format.

### 7 – Push to Your Remote Branch

```bash
git push origin feature/memberX
```

### 8 – Repeat Steps 2–7 as You Work

Push at least **once per work session**, even if your work is incomplete. This acts as a backup and lets the Lead Developer monitor progress.

---

## Commit Message Rules

Use this format for every commit:

```
type(scope): short description (max 72 chars)
```

### Types

| Type | When to Use |
|------|-------------|
| `feat` | Adding new code or a new feature |
| `test` | Adding or updating test code |
| `fix` | Fixing a bug |
| `docs` | Adding/updating documentation files |
| `refactor` | Restructuring code without changing behaviour |
| `chore` | Setup tasks (adding JARs, project config) |

### Scope = Your Member Number

Always include your member number as the scope so it's easy to filter commits.

### Examples

```bash
# Member 1
git commit -m "feat(member1): add customer.java with all getters"
git commit -m "feat(member1): implement readCustomer file reading logic"
git commit -m "test(member1): add parameterised JUnit tests for readCustomer"
git commit -m "docs(member1): complete Test Plan Part A sections 1.1 to 2.6"

# Member 2
git commit -m "feat(member2): implement sequential discount logic in applyDiscount"
git commit -m "test(member2): add BVA tests for RM300 boundary in TestApplyDiscount"
git commit -m "docs(member2): complete Decision Table with all 12 valid rules"

# Member 3
git commit -m "feat(member3): implement calculateBaseCharge with all paper sizes"
git commit -m "feat(member3): add printOrder constructor with page/copy validation"
git commit -m "test(member3): add JUnitParams valid tests for all colour paper sizes"
git commit -m "docs(member3): complete test cases for calculatePrintingCharge"

# Member 4
git commit -m "feat(member4): implement generateInvoice string builder"
git commit -m "test(member4): add Mockito stub for printer unavailable scenario"
git commit -m "test(member4): add integration test for calculateCharge + applyDiscount"
git commit -m "test(member4): wire CSV external data to parameterised test (C.4)"
```

> ❌ Bad commit messages (do not use):  
> `git commit -m "done"`  
> `git commit -m "update"`  
> `git commit -m "fix stuff"`

---

## Pull Request Rules

When your code is ready for integration into `main`, open a Pull Request (PR) on GitHub.

### How to Open a Pull Request

1. Go to the repository on **GitHub.com**
2. Click **"Pull requests"** → **"New pull request"**
3. Set **base:** `main` ← **compare:** `feature/memberX`
4. Fill in the PR template below
5. Assign **Member 1 (Lead Developer)** as the reviewer
6. Click **"Create Pull Request"**

### PR Title Format

```
[MemberX] Brief description of what is being merged
```

Examples:
```
[Member2] applyDiscount.java + discount unit tests complete
[Member3] calculatePrintingCharge + valid JUnit tests (C.1) ready
[Member4] All test code: C.2 invalid, C.3 Mockito, C.4 file, C.5 integration
```

### PR Description Template

Copy and fill this in for every PR:

```markdown
## Summary
Brief description of what this PR contains.

## Files Changed
- `src/application/applyDiscount.java` – new file
- `src/test/TestApplyDiscount.java` – new file

## Testing
- [ ] All my JUnit tests pass locally (0 failures)
- [ ] I have added comments to every test stating the technique used (EP / BVA / DT)
- [ ] No hardcoded absolute file paths (e.g. no C:\Users\...)
- [ ] customer.txt and CSV files are in project root, not inside src/

## Assignment Checklist
- [ ] My application code compiles without errors
- [ ] My test code compiles without errors
- [ ] I have NOT edited any other member's files
- [ ] I have NOT included any .jar files

## Notes for Lead Developer
Any assumptions made, design decisions, or things to watch out for during merge.
```

### PR Rules

| Rule | Detail |
|------|--------|
| **One PR per member** | Do not open multiple PRs unless asked |
| **PR must pass self-review first** | Run all tests locally before opening a PR |
| **No direct pushes to `main`** | Lead Developer only |
| **Lead Developer reviews within 24 hours** | Leave comments if changes are needed |
| **Do not merge your own PR** | Lead Developer performs all merges |
| **Resolve conflicts before requesting review** | See [Merge Conflict Prevention](#merge-conflict-prevention) |

---

## File Submission Guidelines

### What Goes Where

| File Type | Location | Notes |
|-----------|----------|-------|
| Application `.java` files | `src/application/` | One class per file, filename matches class name exactly |
| Test `.java` files | `src/test/` | Filename must start with `Test` |
| `customer.txt` | Project root | Not inside `src/` |
| `testData_calculateCharge.csv` | Project root | Not inside `src/` |
| Documents (`.docx`, `.xlsx`) | `docs/` | Use exact naming convention from assignment brief |
| `.jar` files | **DO NOT COMMIT** | Add `*.jar` to `.gitignore` |

### Naming Conventions (Exact)

Follow these exactly — the lecturer checks filenames:

```
docs/UECS2354_GroupNumber_XX_TestPlan.docx
docs/UECS2354_GroupNumber_XX_DecisionTableEPBVA.xlsx
docs/UECS2354_GroupNumber_XX_TestCase.xlsx
```

Replace `XX` with your actual group number.

### `.gitignore` (already configured in this repo)

The following are excluded from version control:

```
# Java compiled files
*.class
*.jar

# Eclipse project files
.classpath
.project
.settings/
bin/

# IntelliJ IDEA files
.idea/
*.iml
out/

# OS files
.DS_Store
Thumbs.db
```

---

## Merge Conflict Prevention

The single biggest cause of merge conflicts in a group project is **editing another member's files**. Follow these rules to prevent them:

### Golden Rules

1. **Only edit files assigned to you.** If you need a method from another member's class, import it — do not rewrite it.
2. **Agree on shared interfaces early.** Before Week 2, the whole team must agree on method signatures for `calculatePrintingCharge()`, `applyDiscount()`, and `generateInvoice()` so everyone can code against them.
3. **Use constructor injection** in `calculatePrintingCharge.java` — pass `printerAvailability` and `applyDiscount` as constructor parameters so Member 4 can mock them without touching Member 3's code.
4. **Sync with `main` before your PR.** Before opening your PR, pull the latest `main` into your branch:

```bash
# While on your feature branch:
git fetch origin
git merge origin/main

# Resolve any conflicts if they appear, then:
git push origin feature/memberX
```

### If You Get a Merge Conflict

```bash
# 1. See which files have conflicts
git status

# 2. Open the conflicted file — look for conflict markers:
# <<<<<<< HEAD
# (your code)
# =======
# (incoming code)
# >>>>>>> origin/main

# 3. Edit the file to keep the correct version, remove the markers

# 4. Stage the resolved file
git add src/application/conflicted_file.java

# 5. Complete the merge
git commit -m "fix: resolve merge conflict in conflicted_file.java"

# 6. Push
git push origin feature/memberX
```

> Always message the Lead Developer on WhatsApp/Teams before resolving a conflict in a shared file.

---

## Final Integration Checklist

The Lead Developer runs this checklist before submitting:

### Code
- [ ] All 10 application classes are present in `src/application/`
- [ ] All 7 test classes are present in `src/test/`
- [ ] Every class compiles without errors in Eclipse
- [ ] Every JUnit test runs and passes (0 failures, 0 errors)
- [ ] `customer.txt` is in project root
- [ ] `testData_calculateCharge.csv` is in project root
- [ ] No `.jar` files anywhere in the project folder
- [ ] No `main()` method in any application class
- [ ] No hardcoded absolute file paths in any file

### Documents
- [ ] `docs/UECS2354_GroupNumber_XX_TestPlan.docx` present
- [ ] `docs/UECS2354_GroupNumber_XX_DecisionTableEPBVA.xlsx` present
- [ ] `docs/UECS2354_GroupNumber_XX_TestCase.xlsx` present
- [ ] Report with cover page, assumptions, class diagram, and code appendix

### Submission
- [ ] Folder renamed to `UECS2354_GroupNumber_XX`
- [ ] Folder zipped
- [ ] Submitted via WBLE before **Friday, 04 September 2026**
- [ ] Group registered in WBLE Google Sheet

---

## Quick Reference – Most Used Commands

```bash
# Check your current branch
git branch

# Switch to your branch
git checkout feature/memberX

# Pull latest from remote
git pull origin feature/memberX

# See what files you changed
git status

# Stage specific files
git add src/application/yourFile.java

# Commit
git commit -m "feat(memberX): describe what you did"

# Push
git push origin feature/memberX

# Sync your branch with latest main (before PR)
git fetch origin
git merge origin/main
```

---

*Last updated by Lead Developer (Member 1) – UECS2354 Group Assignment 202606*
