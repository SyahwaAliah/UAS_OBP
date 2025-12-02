-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 02, 2025 at 04:45 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `uas`
--

-- --------------------------------------------------------

--
-- Table structure for table `appointment`
--

CREATE TABLE `appointment` (
  `id` bigint(20) NOT NULL,
  `id_pasien` bigint(20) NOT NULL,
  `id_dokter` bigint(20) NOT NULL,
  `jam` varchar(255) DEFAULT NULL,
  `id_dokterz` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `appointment`
--

INSERT INTO `appointment` (`id`, `id_pasien`, `id_dokter`, `jam`, `id_dokterz`) VALUES
(18, 110, 101, '15 00', NULL),
(19, 109, 101, '15 00', NULL),
(20, 111, 101, '15 00', NULL),
(21, 112, 101, '10 30', NULL),
(22, 114, 101, '10 30', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `dokter`
--

CREATE TABLE `dokter` (
  `id` bigint(20) NOT NULL,
  `spesialis` varchar(255) DEFAULT NULL,
  `kontak_dokter` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `dokter`
--

INSERT INTO `dokter` (`id`, `spesialis`, `kontak_dokter`) VALUES
(101, 'Anak', '0825240025'),
(102, 'Anak', '0825240099'),
(103, 'Anak', '0825240139');

-- --------------------------------------------------------

--
-- Table structure for table `obat`
--

CREATE TABLE `obat` (
  `id_obat` int(11) NOT NULL,
  `nama_obat` varchar(255) DEFAULT NULL,
  `pemakaian_obat` varchar(255) DEFAULT NULL,
  `harga_obat` float DEFAULT NULL,
  `id_transaksi` bigint(20) DEFAULT NULL,
  `id_appointment` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `obat`
--

INSERT INTO `obat` (`id_obat`, `nama_obat`, `pemakaian_obat`, `harga_obat`, `id_transaksi`, `id_appointment`) VALUES
(1, 'Paracetamol Sirup Anak', 'Menurunkan demam dan meredakan nyeri', 18000, NULL, NULL),
(2, 'Ibuprofen Suspensi Anak', 'Antinyeri dan antiradang', 22000, NULL, NULL),
(3, 'Ambroxol Sirup Anak', 'Mengencerkan dahak pada batuk berdahak', 17000, 1, NULL),
(4, 'Salbutamol Sirup', 'Meredakan batuk mengi dan asma ringan', 24000, NULL, NULL),
(5, 'Cetirizine Sirup Anak', 'Mengatasi alergi dan gatal', 20000, 6, NULL),
(6, 'Loratadine Sirup Anak', 'Mengatasi alergi pernapasan dan kulit', 23000, 7, NULL),
(7, 'Zinc Sirup', 'Membantu pemulihan saat diare', 15000, 2, NULL),
(8, 'ORS Larutan Elektrolit Anak', 'Mengatasi dehidrasi akibat diare', 12000, 4, NULL),
(9, 'Vitamin C Sirup Anak', 'Meningkatkan daya tahan tubuh', 16000, NULL, NULL),
(10, 'Multivitamin Sirup Anak', 'Menambah nutrisi harian dan nafsu makan', 19000, 8, NULL),
(11, 'Dextromethorphan Sirup Anak', 'Meredakan batuk kering', 14000, NULL, NULL),
(12, 'Chlorphenamine Maleate Sirup', 'Mengatasi pilek dan alergi', 13000, 9, NULL),
(13, 'Domperidone Sirup Anak', 'Mengatasi mual dan muntah', 21000, NULL, NULL),
(14, 'Probiotik Cair Anak', 'Menjaga kesehatan pencernaan', 25000, NULL, NULL),
(15, 'Saline Nasal Spray Anak', 'Mengatasi hidung tersumbat', 30000, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `pasien`
--

CREATE TABLE `pasien` (
  `id` bigint(20) NOT NULL,
  `umur` varchar(255) DEFAULT NULL,
  `diagnosa` varchar(255) DEFAULT NULL,
  `riwayat` varchar(255) DEFAULT NULL,
  `tiket_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pasien`
--

INSERT INTO `pasien` (`id`, `umur`, `diagnosa`, `riwayat`, `tiket_id`) VALUES
(109, '10', 'flu', 'tidak ada', NULL),
(110, '9', 'demam', 'tidak ada', NULL),
(111, '11', 'batuk', 'tidak ada', NULL),
(112, '11', 'flu', 'tidak ada', NULL),
(113, NULL, NULL, NULL, NULL),
(114, '2', 'demam', 'tidak ada', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tiket`
--

CREATE TABLE `tiket` (
  `id` bigint(20) NOT NULL,
  `no_tiket` int(11) NOT NULL,
  `pasien_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tiket`
--

INSERT INTO `tiket` (`id`, `no_tiket`, `pasien_id`) VALUES
(109, 1, 109),
(110, 2, NULL),
(111, 3, NULL),
(112, 4, 110),
(113, 5, 111),
(114, 6, 112),
(115, 7, 114);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` bigint(20) NOT NULL,
  `id_obat` int(11) DEFAULT NULL,
  `id_appointment` bigint(20) DEFAULT NULL,
  `total_transaksi` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `id_obat`, `id_appointment`, `total_transaksi`) VALUES
(1, NULL, NULL, 17000),
(2, NULL, NULL, 15000),
(3, NULL, NULL, 12000),
(4, NULL, NULL, 12000),
(5, NULL, NULL, 20000),
(6, NULL, NULL, 20000),
(7, NULL, NULL, 23000),
(8, NULL, NULL, 19000),
(9, NULL, NULL, 13000),
(10, 5, 1, 20000),
(11, 12, 1, 13000),
(12, 5, 1, 20000),
(13, 9, 1, 16000),
(14, 3, 1, 17000),
(15, 4, 17, 24000),
(16, 6, 17, 23000),
(17, 3, 19, 17000),
(18, 1, 22, 18000);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `tanggal_lahir` varchar(255) DEFAULT NULL,
  `kontak` varchar(255) DEFAULT NULL,
  `notifikasi` varchar(255) DEFAULT NULL,
  `role_type` varchar(31) NOT NULL,
  `tiket_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `email`, `password`, `nama`, `tanggal_lahir`, `kontak`, `notifikasi`, `role_type`, `tiket_id`) VALUES
(101, 'suellen@gmail.com', '125', 'Dr. Suellen Abelvia', '1999-11-12', '0825240025', 'on', 'dokter', NULL),
(102, 'tracy@gmail.com', '199', 'Dr. Tracy Prycillia', '1999-01-09', '0825240099', 'on', 'dokter', NULL),
(103, 'syahwa@gmail.com', '139', 'Dr. Syahwa Aliah', '1999-11-12', '0825240139', 'on', 'dokter', NULL),
(109, 'testing@gmail.com', '123', 'lala', '2025-11-21', NULL, NULL, 'pasien', NULL),
(110, 'pasien@gmail.com', '123', 'nisa', '2025-11-22', NULL, NULL, 'pasien', NULL),
(111, 'dummy@gmail.com', '123', 'dummy', '2025-11-23', NULL, NULL, 'pasien', NULL),
(112, 'aa@gmail.com', '123', 'lala', '2025-11-23', NULL, NULL, 'pasien', NULL),
(113, 'lily@gmail.com', '123', NULL, NULL, NULL, NULL, 'pasien', NULL),
(114, 'lorem@gmail.com', '123', 'testing', '2025-11-29', NULL, NULL, 'pasien', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointment`
--
ALTER TABLE `appointment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_appointment_pasien` (`id_pasien`),
  ADD KEY `fk_appointment_dokter` (`id_dokter`),
  ADD KEY `FK2njvusi2dm04c8ukmmthm88v8` (`id_dokterz`);

--
-- Indexes for table `dokter`
--
ALTER TABLE `dokter`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idx_dokter_id` (`id`);

--
-- Indexes for table `obat`
--
ALTER TABLE `obat`
  ADD PRIMARY KEY (`id_obat`),
  ADD KEY `FKbccut9j6ufxepvwrfa3ib7dit` (`id_transaksi`);

--
-- Indexes for table `pasien`
--
ALTER TABLE `pasien`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_pasien_tiket` (`tiket_id`),
  ADD KEY `idx_pasien_id` (`id`);

--
-- Indexes for table `tiket`
--
ALTER TABLE `tiket`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKdtafnu22l7i9tho79ctf5jr8l` (`pasien_id`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `id_obat` (`id_obat`),
  ADD KEY `FKmthurxmch1par57n030rwe35f` (`id_appointment`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `UKtpysvtmwwrfnbhp8o9cdujot9` (`tiket_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appointment`
--
ALTER TABLE `appointment`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `obat`
--
ALTER TABLE `obat`
  MODIFY `id_obat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `tiket`
--
ALTER TABLE `tiket`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=116;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id_transaksi` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=115;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `appointment`
--
ALTER TABLE `appointment`
  ADD CONSTRAINT `FK2njvusi2dm04c8ukmmthm88v8` FOREIGN KEY (`id_dokterz`) REFERENCES `dokter` (`id`),
  ADD CONSTRAINT `fk_appointment_dokter` FOREIGN KEY (`id_dokter`) REFERENCES `dokter` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_appointment_pasien` FOREIGN KEY (`id_pasien`) REFERENCES `pasien` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `dokter`
--
ALTER TABLE `dokter`
  ADD CONSTRAINT `fk_dokter_user` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `obat`
--
ALTER TABLE `obat`
  ADD CONSTRAINT `FKbccut9j6ufxepvwrfa3ib7dit` FOREIGN KEY (`id_transaksi`) REFERENCES `transaksi` (`id_transaksi`);

--
-- Constraints for table `pasien`
--
ALTER TABLE `pasien`
  ADD CONSTRAINT `fk_pasien_tiket` FOREIGN KEY (`tiket_id`) REFERENCES `tiket` (`id`),
  ADD CONSTRAINT `fk_pasien_user` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tiket`
--
ALTER TABLE `tiket`
  ADD CONSTRAINT `FK6g5tf1sa18fqcl7h3ju9ijyf7` FOREIGN KEY (`pasien_id`) REFERENCES `pasien` (`id`);

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `FKmthurxmch1par57n030rwe35f` FOREIGN KEY (`id_appointment`) REFERENCES `appointment` (`id`),
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`id_obat`) REFERENCES `obat` (`id_obat`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FK5k4wtqooj5r9mo8hdgsl9yl34` FOREIGN KEY (`tiket_id`) REFERENCES `tiket` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
