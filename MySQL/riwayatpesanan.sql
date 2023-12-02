-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 02, 2023 at 04:07 PM
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
-- Table structure for table `riwayatpesanan`
--

CREATE TABLE `riwayatpesanan` (
  `IDPesanan` int(11) NOT NULL,
  `IDMakanan` int(11) DEFAULT NULL,
  `jumlahMakanan` int(4) DEFAULT NULL,
  `IDMinuman` int(11) DEFAULT NULL,
  `jumlahMinuman` int(4) DEFAULT NULL,
  `totalHarga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `riwayatpesanan`
--

INSERT INTO `riwayatpesanan` (`IDPesanan`, `IDMakanan`, `jumlahMakanan`, `IDMinuman`, `jumlahMinuman`, `totalHarga`) VALUES
(1, 2, 3, 1, 6, 105000),
(2, 3, 4, 2, 6, 248000),
(3, 7, 3, 1, 6, 210000);

--
-- Triggers `riwayatpesanan`
--
DELIMITER $$
CREATE TRIGGER `hitung_total_harga` BEFORE INSERT ON `riwayatpesanan` FOR EACH ROW BEGIN
DECLARE harga_makanan INT;
DECLARE harga_minuman INT;
	SELECT hargaMakanan INTO harga_makanan FROM makanan WHERE IDMakanan = NEW.IDMakanan;
	SELECT hargaMinuman INTO harga_minuman FROM minuman WHERE IDMinuman = NEW.IDMinuman;
	SET NEW.totalHarga = (harga_makanan * NEW.jumlahMakanan) + (harga_minuman * NEW.jumlahMinuman);
END
$$
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `riwayatpesanan`
--
ALTER TABLE `riwayatpesanan`
  ADD PRIMARY KEY (`IDPesanan`),
  ADD KEY `fk_IDMakanan` (`IDMakanan`),
  ADD KEY `fk_IDMinuman` (`IDMinuman`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `riwayatpesanan`
--
ALTER TABLE `riwayatpesanan`
  MODIFY `IDPesanan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `riwayatpesanan`
--
ALTER TABLE `riwayatpesanan`
  ADD CONSTRAINT `fk_IDMakanan` FOREIGN KEY (`IDMakanan`) REFERENCES `makanan` (`IDMakanan`),
  ADD CONSTRAINT `fk_IDMinuman` FOREIGN KEY (`IDMinuman`) REFERENCES `minuman` (`IDMinuman`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
