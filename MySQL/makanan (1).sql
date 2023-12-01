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
-- Table structure for table `makanan`
--

CREATE TABLE `makanan` (
  `IDMakanan` int(11) NOT NULL,
  `namaMakanan` varchar(30) NOT NULL,
  `stok` int(11) NOT NULL,
  `harga` int(11) NOT NULL,
  `deskripsi` varchar(750) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `makanan`
--

INSERT INTO `makanan` (`IDMakanan`, `namaMakanan`, `stok`, `harga`, `deskripsi`) VALUES
(1, 'Nasi Goreng Special', 50, 35000, 'Nasi goreng yang lezat dengan campuran daging ayam, udang, telur, dan sayuran, disajikan dengan irisan mentimun dan kerupuk'),
(2, 'Sate Ayam Madura', 100, 25000, 'Sate ayam yang dibumbui dengan rempah khas Madura, disajikan dengan bumbu kacang dan lontong.'),
(3, 'Rendang Daging', 46, 50000, 'Daging sapi yang dimasak dalam santan dan bumbu rempah-rempah kaya rasa, disajikan dengan nasi putih.'),
(4, 'Gado-Gado', 38, 30000, 'Sayuran segar seperti kubis, tauge, kentang, dan telur rebus yang disajikan dengan bumbu kacang khas gado-gado.'),
(5, 'Soto Ayam', 67, 40000, 'Sup ayam dengan kuah bening, disajikan dengan mie, potongan ayam, telur rebus, seledri, dan bawang goreng.'),
(6, 'Pecel Lele', 43, 35000, 'Lele goreng yang renyah disajikan dengan sambal pecel, lalapan, dan nasi.'),
(7, 'Nasi Padang', 64, 60000, 'Beberapa hidangan Padang seperti rendang, gulai ayam, sambal ijo, dan telur balado, disajikan dengan nasi.'),
(8, 'Bakso Malang', 90, 25000, 'Bakso yang lezat dengan tambahan mie, tahu, pangsit, dan kuah kaldu sapi.'),
(9, 'Ayam Goreng Kalasan', 120, 45000, 'Bakso yang lezat dengan tambahan mie, tahu, pangsit, dan kuah kaldu sapi.'),
(10, 'Lontong Sayur Betawi', 34, 30000, 'Sayur lodeh dengan tahu, tempe, dan telur rebus, disajikan dengan lontong dan sambal.');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `makanan`
--
ALTER TABLE `makanan`
  ADD PRIMARY KEY (`IDMakanan`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `makanan`
--
ALTER TABLE `makanan`
  MODIFY `IDMakanan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
