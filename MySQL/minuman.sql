-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 01, 2023 at 07:26 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `database_pbo`
--

-- --------------------------------------------------------

--
-- Table structure for table `minuman`
--

CREATE TABLE `minuman` (
  `IDMinuman` int(11) NOT NULL,
  `namaMakanan` varchar(50) NOT NULL,
  `stok` int(11) NOT NULL,
  `harga` int(11) NOT NULL,
  `deskripsi` varchar(750) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `minuman`
--

INSERT INTO `minuman` (`IDMinuman`, `namaMakanan`, `stok`, `harga`, `deskripsi`) VALUES
(1, 'Es Teh Manis', 520, 5000, 'Teh manis yang disajikan dingin dengan es batu.'),
(2, 'Es Jeruk Segar', 350, 8000, 'Jeruk segar yang diperas dengan gula dan es, menyegarkan.'),
(3, 'Wedang Jahe', 120, 10000, 'Minuman jahe hangat dengan tambahan gula dan rempah, cocok untuk menghangatkan tubuh.'),
(4, 'Es Cincau Hijau', 120, 15000, 'Minuman segar dengan cincau hijau, santan kelapa, dan sirup gula merah.'),
(5, 'Sekoteng', 120, 12000, 'Minuman tradisional dengan campuran jahe, kacang hijau, pacar cina, dan biji salak.'),
(6, 'Bandrek', 120, 10000, 'Minuman hangat dengan campuran jahe, kelapa parut, dan gula aren.'),
(7, 'Es Doger', 200, 20000, 'Minuman es campur dengan campuran kelapa muda, alpukat, nangka, dan es serut.'),
(8, 'Bir Pletok', 300, 25000, 'Minuman tradisional beralkohol dengan campuran rempah-rempah khas Betawi.'),
(9, 'Es Cendol', 120, 18000, 'Minuman segar dengan campuran cendol, kelapa muda, santan, dan gula merah.'),
(10, 'Teh Tarik', 500, 12000, 'Teh susu yang dihasilkan dengan cara tarik yang memberikan tekstur yang lembut.');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `minuman`
--
ALTER TABLE `minuman`
  ADD PRIMARY KEY (`IDMinuman`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `minuman`
--
ALTER TABLE `minuman`
  MODIFY `IDMinuman` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
