# Automation Testing Project – Assertions, Validations & Data-Driven Test

Project ini dibuat sebagai bagian dari assignment untuk membangun automation testing dengan fokus pada:

- Assertions & validation pada test case
- Data-driven testing menggunakan file Excel
- Test Runner & Test Suites
- Website target: https://www.saucedemo.com/

---

## Project Overview

Dalam project ini, automation test dijalankan untuk melakukan validasi pada fitur login dan fitur-fitur lain dari website Saucedemo.  
Project ini wajib memiliki:

1. Test case dengan assertions & validations
2. File test data (Excel)
3. Data-driven testing untuk beberapa skenario login
4. Test suites untuk menjalankan semua test case secara terstruktur
5. Test Runner untuk eksekusi otomatis

---

## Project Structure
'project-name/
├─ src/
│ ├─ main/java/
│ └─ test/java/
├─ test-data/
│ └─ users.xlsx
├─ test-output/
├─ testng.xml
├─ build.gradle.kts
└─ settings.gradle.kts'


---

## Tech Stack

- Java  
- TestNG  
- Gradle  
- Apache POI (untuk baca file Excel)  
- Selenium WebDriver  
- Assertions bawaan TestNG  

---

## Features

### 1. Data-Driven Testing (Excel)
- Menggunakan file `users.xlsx` untuk menyimpan test data login.
- Data dibaca menggunakan Apache POI.
- Setiap baris dalam Excel akan dijalankan sebagai 1 test case.

### 2. Assertions & Validation
Test case mencakup:
- Validasi login berhasil  
- Validasi error message ketika login gagal  
- Assertions untuk memastikan halaman dan elemen tampil sesuai ekspektasi  

### 3. Test Runner & Test Suites
- File `testng.xml` digunakan untuk menjalankan seluruh test case.
- Test case dapat dijalankan:
  - Per class
  - Per method
  - Per suite

---

## Test Data

Buat file Excel pada folder:

Contoh struktur:

| username | password | expectedResult |
|----------|-----------|----------------|
| standard_user | secret_sauce | success |
| locked_out_user | secret_sauce | fail |
| problem_user | secret_sauce | success |
| invalid_user | wrong_pass | fail |

---

## How to Run

### 1. Clone repository

### 2. Jalankan test suite
./gradlew test

Atau langsung dari `testng.xml`:
- Right click → Run 'testng.xml'

---

## Assignment Checklist
- [x] Menambahkan test data file user (Excel)  
- [x] Membuat data-driven testing  
- [x] Assertions & validations pada test case  
- [x] Konfigurasi test suites (testng.xml)  
- [x] Test runner berjalan dengan benar  

---

## Author
flo
