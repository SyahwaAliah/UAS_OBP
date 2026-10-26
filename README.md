# 🏥 Trysellen Klinik

Website klinik anak **Trysellen Klinik** yang memiliki dua sudut pandang pengguna: **Pasien** (orang tua/wali) dan **Dokter**. Dibangun menggunakan Spring Boot sebagai proyek UAS mata kuliah Pemrograman Berorientasi Objek (OBP).

---

## ✨ Fitur

### 👨‍👩‍👧 Sisi Pasien
- Registrasi dan login
- Mengelola data pasien/anak
- Melihat daftar dokter dan jadwal praktik
- Membuat janji temu
- Melihat riwayat pemeriksaan

### 🩺 Sisi Dokter
- Login dokter
- Melihat daftar janji temu dan pasien
- Mengisi hasil pemeriksaan, diagnosis, dan resep
- Mengelola jadwal praktik

---

## 🛠 Teknologi

| Komponen | Teknologi |
|----------|-----------|
| Bahasa | Java 21 |
| Framework | Spring Boot 3.5.6 |
| Template Engine | Thymeleaf |
| ORM | Spring Data JPA (Hibernate) |
| Database | MySQL |
| Validasi | Spring Boot Starter Validation |
| Utilitas | Lombok, Spring Boot DevTools, Actuator |
| Build Tool | Maven (Maven Wrapper) |

---

## 📂 Struktur Proyek

```
UAS_OBP/
├── src/                # Kode sumber aplikasi (Java, template, resources)
├── uas (1).sql         # File database MySQL (import ke database)
├── pom.xml             # Konfigurasi Maven & dependensi
├── mvnw / mvnw.cmd     # Maven Wrapper (Linux/Mac & Windows)
├── HELP.md
└── README.md
```

---

## 🚀 Cara Menjalankan

### Prasyarat
- JDK 21
- MySQL Server (bisa lewat XAMPP/Laragon)
- Git

### Langkah-langkah

1. **Clone repositori**

   ```bash
   git clone https://github.com/SyahwaAliah/UAS_OBP.git
   cd UAS_OBP
   ```

2. **Buat database dan import file SQL**

   Buat database baru di MySQL, lalu import file `uas (1).sql`:

   ```bash
   mysql -u root -p -e "CREATE DATABASE uas;"
   mysql -u root -p uas < "uas (1).sql"
   ```

   Atau import lewat phpMyAdmin.

3. **Atur koneksi database**

   Buka `src/main/resources/application.properties`, lalu sesuaikan:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/uas
   spring.datasource.username=root
   spring.datasource.password=
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

   > Ganti nama database, username, dan password sesuai pengaturan MySQL Anda.

4. **Jalankan aplikasi**

   Windows:
   ```bash
   mvnw.cmd spring-boot:run
   ```

   Linux/Mac:
   ```bash
   ./mvnw spring-boot:run
   ```

5. **Buka di browser**

   ```
   http://localhost:8080
   ```

---

## 👥 Peran Pengguna

| Peran | Akses |
|-------|-------|
| **Pasien** | Daftar/login, kelola data anak, buat janji, lihat riwayat |
| **Dokter** | Login, lihat pasien dan janji temu, input hasil pemeriksaan |

---

## 👩‍💻 Pembuat

**Suellen Abelvia**
**Tracy Prycillia Kusmana**
**Syahwa Aliah Wandi**
GitHub: [@SyahwaAliah](https://github.com/SyahwaAliah)

---

## 📄 Catatan

Proyek ini dibuat untuk keperluan tugas UAS dan pembelajaran.
