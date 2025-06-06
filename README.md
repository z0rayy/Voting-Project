# Voting-Project

Voting-Project adalah aplikasi sistem pemungutan suara berbasis web yang dikembangkan sebagai bagian dari Tugas Besar Pemrograman Berorientasi Objek (PBO). Proyek ini bertujuan untuk menyediakan platform pemungutan suara yang aman, efisien, dan mudah digunakan, memungkinkan pengguna untuk memberikan suara mereka secara online dengan antarmuka yang intuitif.

## Fitur Utama

* **Pendaftaran Pengguna**: Pengguna dapat mendaftar dengan informasi pribadi yang diperlukan.
* **Otentikasi Pengguna**: Sistem login yang aman untuk memastikan hanya pengguna terdaftar yang dapat mengakses sistem.
* **Pembuatan dan Manajemen Pemilihan**: Administrator dapat membuat pemilihan baru, menambahkan kandidat, dan mengatur jadwal pemungutan suara.
* **Pemungutan Suara**: Pengguna dapat memberikan suara mereka dalam pemilihan yang tersedia.
* **Penghitungan Suara Otomatis**: Sistem secara otomatis menghitung suara dan menampilkan hasilnya.
* **Antarmuka Pengguna yang Responsif**: Desain antarmuka yang ramah pengguna dan responsif untuk berbagai perangkat.

## Teknologi yang Digunakan

* **Bahasa Pemrograman**: Java
* **Framework**: JavaFX untuk antarmuka pengguna
* **Basis Data**: MySQL
* **Desain Antarmuka**: CSS untuk styling([github.com][1], [github.com][2], [github.com][3])

## Instalasi dan Penggunaan

### Prasyarat

* Java Development Kit (JDK) 8 atau lebih tinggi
* MySQL Server
* IDE seperti IntelliJ IDEA atau Eclipse

### Langkah-langkah Instalasi

1. **Kloning Repositori**

   ```bash
   git clone https://github.com/z0rayy/Voting-Project.git
   ```

  
2. **Impor Proyek ke IDE**

   * Buka IDE pilihan Anda.
   * Pilih opsi untuk mengimpor proyek sebagai proyek Maven atau Gradle (sesuai dengan konfigurasi proyek).
   * Navigasikan ke direktori `Voting-Project` yang telah dikloning.

3. **Konfigurasi Basis Data**

   * Buat basis data baru di MySQL dengan nama `voting_project`.
   * Impor skrip SQL yang terdapat di `database/voting_project.sql` untuk membuat tabel dan data awal.
   * Perbarui konfigurasi koneksi basis data di file konfigurasi aplikasi (misalnya, `config.properties`) dengan kredensial MySQL Anda.

4. **Menjalankan Aplikasi**

   * Jalankan kelas `Main.java` sebagai aplikasi Java.
   * Antarmuka pengguna akan muncul, dan Anda dapat mulai menggunakan aplikasi.

## Kontribusi

Kontribusi sangat dihargai! Jika Anda ingin berkontribusi pada proyek ini:

1. Fork repositori ini.
2. Buat branch fitur baru: `git checkout -b fitur-anda`.
3. Lakukan perubahan dan commit: `git commit -m 'Menambahkan fitur baru'`.
4. Push ke branch Anda: `git push origin fitur-anda`.
5. Buka Pull Request untuk ditinjau.
