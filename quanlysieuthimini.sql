-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 20, 2021 at 12:25 PM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanlysieuthimini`
--

-- --------------------------------------------------------

--
-- Table structure for table `chitiethd`
--

CREATE TABLE `chitiethd` (
  `mahd` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `masp` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `tensp` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `dongia` int(10) NOT NULL,
  `soluong` int(10) NOT NULL,
  `thanhtien` int(10) NOT NULL,
  `giamgia` int(10) NOT NULL,
  `tongtien` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `chitiethd`
--

INSERT INTO `chitiethd` (`mahd`, `masp`, `tensp`, `dongia`, `soluong`, `thanhtien`, `giamgia`, `tongtien`) VALUES
('001', '004', 'Táo Fuji ', 15000, 1, 15000, 0, 15000),
('001', '006', 'Mì Hảo Hảo', 3500, 5, 17500, 0, 17500),
('001', '021', 'Nước Monster', 30000, 1, 30000, 0, 30000),
('002', '009', 'BCS Durex Pleasuremax', 55000, 1, 55000, 10, 49500),
('002', '016', 'Cà rốt', 7000, 3, 21000, 10, 18900),
('002', '019', 'Xịt khủ mùi AXE Apolo', 105000, 1, 105000, 15, 89250),
('002', '024', 'KDR Colgate', 32000, 1, 32000, 0, 32000),
('002', '028', 'Mì hộp Kokomi', 8000, 2, 16000, 0, 16000),
('003', '002', 'Trứng gà', 20000, 2, 40000, 0, 40000),
('003', '008', 'Nước CocaCola', 10000, 1, 10000, 0, 10000),
('003', '010', 'Chuối', 8000, 2, 16000, 0, 16000),
('003', '013', 'Snack Mực', 6000, 1, 6000, 0, 6000),
('003', '014', 'Snack Bí đỏ', 6000, 1, 6000, 0, 6000),
('003', '015', 'Sữa TH True Milk', 8000, 5, 40000, 0, 40000),
('003', '030', 'Sữa chua TH True Milk', 12000, 1, 24000, 0, 24000),
('004', '012', 'BVS Diana ', 23000, 5, 115000, 0, 115000),
('005', '011', 'Bia Tiger', 20000, 2, 40000, 0, 40000),
('005', '024', 'KDR Colgate', 32000, 1, 32000, 0, 32000),
('006', '003', 'Nước Đảnh Thạnh', 10000, 2, 20000, 0, 20000),
('006', '004', 'Táo Fuji ', 15000, 2, 30000, 0, 30000),
('006', '019', 'Xịt khủ mùi AXE Apolo', 105000, 1, 105000, 0, 105000),
('006', '030', 'Sữa chua TH True Milk', 12000, 5, 60000, 0, 60000),
('007', '005', 'Xúc xích heo', 20000, 1, 20000, 0, 20000),
('007', '009', 'BCS Durex Pleasuremax', 55000, 1, 55000, 0, 55000),
('007', '026', 'Nước Sting', 10000, 2, 20000, 0, 20000),
('007', '030', 'Sữa chua TH True Milk', 12000, 5, 60000, 0, 60000),
('008', '001', 'Dầu gội đầu Dove', 150000, 1, 150000, 0, 150000),
('008', '007', 'Mì gấu đỏ', 4000, 5, 20000, 0, 20000),
('008', '024', 'KDR Colgate', 32000, 1, 32000, 0, 32000),
('008', '030', 'Sữa chua TH True Milk', 12000, 5, 60000, 0, 60000),
('009', '002', 'Trứng gà', 20000, 2, 40000, 0, 40000),
('009', '006', 'Mì Hảo Hảo', 3500, 5, 17500, 0, 17500),
('009', '010', 'Chuối', 8000, 5, 40000, 0, 40000),
('009', '023', 'Đùi gà', 45000, 1, 45000, 0, 45000),
('009', '026', 'Nước Sting', 10000, 1, 10000, 0, 10000),
('009', '028', 'Mì hộp Kokomi', 8000, 2, 16000, 0, 16000),
('010', '005', 'Xúc xích heo', 20000, 2, 40000, 0, 40000),
('010', '013', 'Snack Mực', 6000, 1, 6000, 0, 6000),
('010', '021', 'Nước Monster', 30000, 1, 30000, 0, 30000),
('011', '002', 'Trứng gà', 20000, 2, 40000, 0, 40000),
('011', '004', 'Táo Fuji ', 15000, 2, 30000, 0, 30000),
('011', '006', 'Mì Hảo Hảo', 3500, 5, 17500, 0, 17500),
('011', '026', 'Nước Sting', 10000, 1, 10000, 0, 10000),
('012', '002', 'Trứng gà', 20000, 4, 80000, 0, 80000),
('012', '003', 'Nước Đảnh Thạnh', 10000, 5, 50000, 10, 45000),
('012', '007', 'Mì gấu đỏ', 4000, 2, 8000, 10, 7200),
('012', '017', 'Thịt bò', 100000, 1, 100000, 20, 80000),
('012', '019', 'Xịt khủ mùi AXE Apolo', 105000, 1, 105000, 15, 89250),
('012', '028', 'Mì hộp Kokomi', 8000, 1, 8000, 0, 8000),
('013', '003', 'Nước Đảnh Thạnh', 10000, 3, 30000, 0, 30000),
('013', '007', 'Mì gấu đỏ', 4000, 3, 12000, 0, 12000),
('013', '009', 'BCS Durex Pleasuremax', 55000, 1, 55000, 0, 55000),
('013', '015', 'Sữa TH True Milk', 8000, 5, 40000, 0, 40000),
('013', '019', 'Xịt khủ mùi AXE Apolo', 105000, 3, 315000, 0, 315000),
('013', '022', 'Đủ đủ', 12000, 2, 24000, 0, 24000),
('014', '005', 'Xúc xích heo', 20000, 1, 20000, 0, 20000),
('014', '010', 'Chuối', 8000, 5, 40000, 10, 36000),
('014', '018', 'Nước Aquafina', 6000, 5, 30000, 0, 30000),
('014', '024', 'KDR Colgate', 32000, 1, 32000, 0, 32000),
('014', '026', 'Nước Sting', 10000, 1, 10000, 0, 10000),
('014', '030', 'Sữa chua TH True Milk', 12000, 3, 36000, 0, 36000),
('015', '001', 'Dầu gội đầu Dove', 150000, 1, 150000, 0, 150000),
('015', '006', 'Mì Hảo Hảo', 3500, 5, 17500, 0, 17500),
('015', '019', 'Xịt khủ mùi AXE Apolo', 105000, 1, 105000, 10, 94500),
('015', '023', 'Đùi gà', 45000, 1, 45000, 15, 38250),
('015', '026', 'Nước Sting', 10000, 1, 10000, 0, 10000),
('016', '003', 'Nước Đảnh Thạnh', 10000, 5, 50000, 0, 50000),
('016', '009', 'BCS Durex Pleasuremax', 55000, 1, 55000, 0, 55000),
('016', '015', 'Sữa TH True Milk', 8000, 5, 40000, 0, 40000),
('016', '021', 'Nước Monster', 30000, 1, 30000, 0, 30000),
('016', '028', 'Mì hộp Kokomi', 8000, 1, 8000, 0, 8000),
('017', '013', 'Snack Mực', 6000, 1, 6000, 0, 6000),
('017', '014', 'Snack Bí đỏ', 6000, 2, 12000, 0, 12000),
('017', '022', 'Đủ đủ', 12000, 2, 24000, 0, 24000),
('017', '027', 'NRC Sunlight', 25000, 1, 25000, 0, 25000),
('017', '030', 'Sữa chua TH True Milk', 12000, 2, 24000, 0, 24000),
('018', '002', 'Trứng gà', 20000, 1, 20000, 0, 20000),
('018', '006', 'Mì Hảo Hảo', 3500, 2, 7000, 0, 7000),
('018', '010', 'Chuối', 8000, 5, 40000, 10, 36000),
('018', '025', 'Lẩu thái', 80000, 1, 80000, 0, 80000),
('018', '026', 'Nước Sting', 10000, 1, 10000, 0, 10000),
('018', '028', 'Mì hộp Kokomi', 8000, 2, 16000, 0, 16000),
('019', '002', 'Trứng gà', 20000, 2, 40000, 0, 40000),
('019', '005', 'Xúc xích heo', 20000, 3, 60000, 0, 60000),
('019', '006', 'Mì Hảo Hảo', 3500, 3, 10500, 0, 10500),
('019', '026', 'Nước Sting', 10000, 3, 30000, 0, 30000),
('020', '008', 'Nước CocaCola', 10000, 4, 40000, 0, 40000),
('020', '013', 'Snack Mực', 6000, 1, 6000, 0, 6000);

--
-- Triggers `chitiethd`
--
DELIMITER $$
CREATE TRIGGER `Them_ChiTietHD` AFTER INSERT ON `chitiethd` FOR EACH ROW UPDATE `sanpham`
SET sanpham.soluong = sanpham.soluong - NEW.soluong
WHERE masp = NEW.masp
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `Xoa_ChiTietHD` AFTER DELETE ON `chitiethd` FOR EACH ROW UPDATE `sanpham`
SET sanpham.soluong = sanpham.soluong + OLD.soluong
WHERE masp = OLD.masp
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `chitietpnh`
--

CREATE TABLE `chitietpnh` (
  `mapnh` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `masp` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `tensp` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `dongia` int(10) NOT NULL,
  `soluong` int(10) NOT NULL,
  `thanhtien` int(10) NOT NULL,
  `giamgia` int(10) NOT NULL,
  `tongtien` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `chitietpnh`
--

INSERT INTO `chitietpnh` (`mapnh`, `masp`, `tensp`, `dongia`, `soluong`, `thanhtien`, `giamgia`, `tongtien`) VALUES
('001', '006', 'Mì Hảo Hảo', 3500, 20, 70000, 0, 70000),
('001', '010', 'Chuối', 8000, 10, 80000, 0, 80000),
('002', '013', 'Snack Mực', 6000, 20, 120000, 30, 84000),
('002', '028', 'Mì hộp Kokomi', 8000, 20, 160000, 30, 112000),
('002', '029', 'Bánh mì', 4000, 20, 80000, 30, 56000),
('002', '030', 'Sữa chua TH True Milk', 12000, 30, 360000, 30, 252000),
('003', '005', 'Xúc xích heo', 20000, 15, 300000, 30, 210000),
('003', '007', 'Mì gấu đỏ', 4000, 20, 80000, 30, 56000),
('003', '014', 'Snack Bí đỏ', 6000, 20, 120000, 30, 84000),
('003', '023', 'Đùi gà', 45000, 20, 900000, 30, 630000),
('003', '025', 'Lẩu thái', 80000, 10, 800000, 30, 560000),
('004', '001', 'Dầu gội đầu Dove', 150000, 15, 2250000, 30, 1575000),
('004', '003', 'Nước Đảnh Thạnh', 10000, 15, 150000, 30, 105000),
('004', '012', 'BVS Diana ', 23000, 10, 230000, 30, 161000),
('004', '016', 'Cà rốt', 7000, 20, 140000, 30, 98000),
('004', '017', 'Thịt bò', 100000, 20, 2000000, 30, 1400000),
('004', '027', 'NRC Sunlight', 25000, 15, 375000, 30, 262500),
('005', '002', 'Trứng gà', 20000, 15, 300000, 30, 210000),
('005', '009', 'BCS Durex Pleasuremax', 55000, 10, 550000, 30, 385000),
('005', '019', 'Xịt khủ mùi AXE Apolo', 105000, 10, 1050000, 30, 735000),
('005', '024', 'KDR Colgate', 32000, 10, 320000, 30, 224000),
('005', '025', 'Lẩu thái', 80000, 10, 800000, 30, 560000),
('006', '004', 'Táo Fuji ', 15000, 20, 300000, 30, 210000),
('006', '008', 'Nước CocaCola', 10000, 10, 100000, 30, 70000),
('006', '026', 'Nước Sting', 10000, 20, 200000, 30, 140000),
('007', '001', 'Dầu gội đầu Dove', 150000, 7, 1050000, 30, 735000),
('007', '009', 'BCS Durex Pleasuremax', 55000, 12, 660000, 30, 462000),
('007', '010', 'Chuối', 8000, 10, 80000, 30, 56000),
('007', '011', 'Bia Tiger', 20000, 12, 240000, 30, 168000),
('007', '013', 'Snack Mực', 6000, 10, 60000, 30, 42000),
('007', '018', 'Nước Aquafina', 6000, 20, 120000, 30, 84000),
('007', '024', 'KDR Colgate', 32000, 13, 416000, 30, 291200),
('007', '028', 'Mì hộp Kokomi', 8000, 10, 80000, 30, 56000),
('007', '029', 'Bánh mì', 4000, 10, 40000, 30, 28000),
('008', '005', 'Xúc xích heo', 20000, 3, 60000, 30, 42000),
('008', '020', 'SRM Nivea Men', 60000, 10, 600000, 30, 420000),
('008', '021', 'Nước Monster', 30000, 12, 360000, 30, 252000),
('008', '025', 'Lẩu thái', 80000, 16, 1280000, 30, 896000),
('008', '029', 'Bánh mì', 4000, 10, 40000, 30, 28000),
('009', '002', 'Trứng gà', 20000, 11, 220000, 30, 154000),
('009', '003', 'Nước Đảnh Thạnh', 10000, 15, 150000, 30, 105000),
('009', '007', 'Mì gấu đỏ', 4000, 10, 40000, 30, 28000),
('009', '010', 'Chuối', 8000, 15, 120000, 30, 84000),
('009', '012', 'BVS Diana ', 23000, 19, 437000, 30, 305900),
('009', '014', 'Snack Bí đỏ', 6000, 13, 78000, 30, 54600),
('009', '023', 'Đùi gà', 45000, 12, 540000, 30, 378000),
('009', '027', 'NRC Sunlight', 25000, 11, 275000, 30, 192500),
('009', '030', 'Sữa chua TH True Milk', 12000, 12, 144000, 30, 100800),
('010', '005', 'Xúc xích heo', 20000, 14, 280000, 30, 196000),
('010', '015', 'Sữa TH True Milk', 8000, 25, 200000, 30, 140000),
('010', '017', 'Thịt bò', 100000, 11, 1100000, 30, 770000),
('010', '021', 'Nước Monster', 30000, 11, 330000, 30, 231000);

--
-- Triggers `chitietpnh`
--
DELIMITER $$
CREATE TRIGGER `Them_ChiTietPNH` AFTER INSERT ON `chitietpnh` FOR EACH ROW UPDATE `sanpham`
SET sanpham.soluong = sanpham.soluong + NEW.soluong
WHERE sanpham.masp = NEW.masp
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `mahd` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `manv` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `tennv` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `makh` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `tenkh` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `tongtienhd` int(10) NOT NULL,
  `thanhtoan` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `thoigian` datetime NOT NULL,
  `ghichu` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `hoadon`
--

INSERT INTO `hoadon` (`mahd`, `manv`, `tennv`, `makh`, `tenkh`, `tongtienhd`, `thanhtoan`, `thoigian`, `ghichu`) VALUES
('001', '001', 'Trần Hữu Nghĩa', '006', 'Nguyễn Huỳnh Long', 62500, 'CASH', '2021-08-10 06:01:49', ''),
('002', '003', 'Lê Đăng Hải', '016', 'Lưu Bá Quát', 205650, 'ATM', '2021-08-10 06:03:31', ''),
('003', '005', 'Trần Bảo Châu', '015', 'Nguyễn Hoàng Huy', 142000, 'ATM', '2021-08-10 06:09:31', ''),
('004', '002', 'Nguyễn Thành Lộc', '009', 'Nguyễn Kiều Trinh', 115000, 'CASH', '2021-08-10 06:12:28', ''),
('005', '004', 'Nguyễn Bá Long', '011', 'Trần Khánh Kim', 72000, 'ATM', '2021-08-10 06:15:14', ''),
('006', '005', 'Trần Bảo Châu', '015', 'Nguyễn Hoàng Huy', 215000, 'ATM', '2021-08-11 08:31:26', ''),
('007', '002', 'Nguyễn Thành Lộc', '013', 'Phạm Hữu Nhân', 155000, 'CASH', '2021-08-12 05:11:14', ''),
('008', '005', 'Trần Bảo Châu', '016', 'Lưu Bá Quát', 262000, 'ATM', '2021-08-13 06:15:01', ''),
('009', '001', 'Trần Hữu Nghĩa', '001', 'Bùi Hữu Long', 168500, 'ATM', '2021-08-14 05:27:10', ''),
('010', '005', 'Trần Bảo Châu', '014', 'Mạc Thế Hào', 76000, 'CASH', '2021-08-15 06:35:09', ''),
('011', '002', 'Nguyễn Thành Lộc', '008', 'Trần Châu Cường', 97500, 'CASH', '2021-08-16 06:06:18', ''),
('012', '001', 'Trần Hữu Nghĩa', '001', 'Trần Hữu Long', 309450, 'ATM', '2021-08-19 03:56:44', ''),
('013', '004', 'Nguyễn Bá Long', '013', 'Phạm Hữu Nhân', 476000, 'ATM', '2021-08-19 04:00:27', ''),
('014', '002', 'Nguyễn Thành Lộc', '015', 'Nguyễn Hoàng Huy', 164000, 'CASH', '2021-08-19 04:02:34', ''),
('015', '004', 'Nguyễn Bá Long', '011', 'Trần Khánh Kim', 310250, 'CASH', '2021-08-20 05:08:57', ''),
('016', '003', 'Lê Đăng Hải', '016', 'Lưu Bá Quát', 183000, 'ATM', '2021-08-20 05:10:17', ''),
('017', '002', 'Nguyễn Thành Lộc', '002', 'Nguyễn Ngọc Linh', 91000, 'ATM', '2021-08-20 05:11:26', ''),
('018', '005', 'Trần Bảo Châu', '001', 'Bùi Hữu Long', 169000, 'ATM', '2021-08-20 05:13:46', ''),
('019', '001', 'Trần Hữu Nghĩa', '014', 'Mạc Thế Hào', 140500, 'ATM', '2021-08-20 05:17:08', ''),
('020', '004', 'Nguyễn Bá Long', '013', 'Phạm Hữu Nhân', 46000, 'CASH', '2021-08-20 05:18:16', '');

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `makh` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `hokh` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `tenkh` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `diachi` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `sdt` int(10) NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`makh`, `hokh`, `tenkh`, `diachi`, `sdt`, `email`) VALUES
('001', 'Trần', 'Hữu Long', '20 Nguyễn Trãi, P3, Q5, TP.HCM', 368519840, 'abc@gmail.com'),
('002', 'Nguyễn', 'Ngọc Linh', 'Thị xã Ninh Hòa, Tỉnh Khánh Hòa', 358957520, 'abc@gmail.com'),
('003', 'Nguyễn', 'Hữu Tuấn', 'Thị xã Ninh Hòa, Tỉnh Khánh Hòa', 358965870, 'abc@gmail.com'),
('004', 'Phạm', 'Thúy Hạnh', 'TP. Vũng tàu', 685245985, 'abc@gmail.com'),
('005', 'Trần', 'Bảo Châu', '273 An Dương Vương, P5, Q5, TP.HCM', 359851853, 'abc@gmail.com'),
('006', 'Nguyễn', 'Huỳnh Long', '60 CMT8, P5, Q10, TP.HCM', 246589521, 'abc@gmail.com'),
('007', 'Lê', 'Minh Đat', 'Đồng Nai', 359862810, 'abc@gmail.com'),
('008', 'Trần', 'Châu Cường', '86 Vĩnh Viễn, P2, Q5, TP.HCM', 658251381, 'abc@gmail.com'),
('009', 'Nguyễn', 'Kiều Trinh', '56 Nguyễn Kim, P12, Q5, TP.HCM', 358961570, 'abc@gmail.com'),
('010', 'Kiều', 'Lão Đại', 'TP. Phú Yên', 359857510, 'abc@gmail.com'),
('011', 'Trần', 'Khánh Kim', 'Khánh Hòa', 526854085, 'abc@gmail.com'),
('012', 'Bùi', 'Hữu Long', '35 Võ Thị Sau, P3, Q3, TP.HCM', 235621857, 'abc@gmail.com'),
('013', 'Phạm', 'Hữu Nhân', 'Bến Tre', 368520682, 'abc@gmail.com'),
('014', 'Mạc', 'Thế Hào', '165 Nguyễn Trãi, P8, Q5, TP.HCM', 256857152, 'abc@gmail.com'),
('015', 'Nguyễn', 'Hoàng Huy', '75 CMT8, P8, Q3, TP.HCM', 568524781, 'abc@gmail.com'),
('016', 'Lưu', 'Bá Quát', '22 Nguyễn Kim, P8, Q5, TP.HCM', 268547521, 'abc@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `loaisp`
--

CREATE TABLE `loaisp` (
  `maloai` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `tenloai` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `loaisp`
--

INSERT INTO `loaisp` (`maloai`, `tenloai`) VALUES
('A01', 'Thức ăn'),
('A02', 'Thức uống'),
('A03', 'Hàng gia dụng');

-- --------------------------------------------------------

--
-- Table structure for table `nguoidung`
--

CREATE TABLE `nguoidung` (
  `id` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `role` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `nguoidung`
--

INSERT INTO `nguoidung` (`id`, `username`, `password`, `role`) VALUES
('1', 'Admin', 'Admin', 'Admin'),
('2', 'Staff', 'Staff', 'Staff');

-- --------------------------------------------------------

--
-- Table structure for table `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `mancc` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `tenncc` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `diachi` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `mst` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `fax` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `nhacungcap`
--

INSERT INTO `nhacungcap` (`mancc`, `tenncc`, `diachi`, `mst`, `fax`) VALUES
('001', 'Coop Mart LTK', '497 Hòa Hảo, P7, Q5, TP.HCM', '38648598', '0286359851'),
('002', 'Coop Mart CQ', '189C Cống Quỳnh, P NCT, Q1, TP.HCM', '38578658', '0286259241'),
('003', 'BigC THT', '268 Tô Hiến Thành, P15, Q10, TP.HCM', '38528512', '0286259838');

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `manv` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `honv` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `tennv` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `gioitinh` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `namsinh` int(10) NOT NULL,
  `diachi` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `sdt` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `image` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`manv`, `honv`, `tennv`, `gioitinh`, `namsinh`, `diachi`, `sdt`, `image`) VALUES
('001', 'Trần', 'Hữu Nghĩa', 'Nam', 1992, 'Thị xã Nình Hòa, Tỉnh Khánh Hòa', '0393978341', '001.png'),
('002', 'Nguyễn', 'Thành Lộc', 'Nam', 1999, '122 An Bình, P5, Q5, TP.HCM', '0369257620', '002.png'),
('003', 'Lê', 'Đăng Hải', 'Nam', 1996, 'Thị xã Ninh Hòa, Tỉnh Khánh Hòa', '0356824590', '003.png'),
('004', 'Nguyễn', 'Bá Long', 'Nam', 1995, '20 Nguyễn Trãi, P5, Q5, TPHCM', '0356824970', '004.png'),
('005', 'Trần', 'Bảo Châu', 'Nam', 1991, '273 An Dương Vương, Q5, TP.HCM', '0358251925', '005.png');

-- --------------------------------------------------------

--
-- Table structure for table `phieunhaphang`
--

CREATE TABLE `phieunhaphang` (
  `mapnh` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `manv` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `tennv` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `mancc` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `tenncc` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `tongtienpnh` int(10) NOT NULL,
  `thanhtoan` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `thoigian` datetime NOT NULL,
  `ghichu` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `phieunhaphang`
--

INSERT INTO `phieunhaphang` (`mapnh`, `manv`, `tennv`, `mancc`, `tenncc`, `tongtienpnh`, `thanhtoan`, `thoigian`, `ghichu`) VALUES
('001', '001', 'Trần Hữu Nghĩa', '001', 'Coop Mart LTK', 150000, 'ATM', '2021-08-10 06:43:08', ''),
('002', '002', 'Nguyễn Thành Lộc', '003', 'BigC THT', 504000, 'CASH', '2021-08-12 05:13:51', ''),
('003', '003', 'Lê Đăng Hải', '002', 'Coop Mart CQ', 1540000, 'ATM', '2021-08-13 06:17:04', ''),
('004', '004', 'Nguyễn Bá Long', '003', 'BigC THT', 3601500, 'CASH', '2021-08-14 05:50:04', ''),
('005', '002', 'Nguyễn Thành Lộc', '001', 'Coop Mart LTK', 2114000, 'CASH', '2021-08-15 05:02:22', ''),
('006', '005', 'Trần Bảo Châu', '001', 'Coop Mart LTK', 420000, 'ATM', '2021-08-16 06:08:08', ''),
('007', '005', 'Trần Bảo Châu', '003', 'BigC THT', 1922200, 'ATM', '2021-08-16 06:16:33', ''),
('008', '003', 'Lê Đăng Hải', '003', 'BigC THT', 1638000, 'CASH', '2021-08-19 03:58:15', ''),
('009', '002', 'Nguyễn Thành Lộc', '002', 'Coop Mart CQ', 1402800, 'ATM', '2021-08-20 05:15:02', ''),
('010', '005', 'Trần Bảo Châu', '001', 'Coop Mart LTK', 1337000, 'ATM', '2021-08-20 05:20:47', '');

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `masp` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `tensp` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `dongia` int(11) NOT NULL,
  `soluong` int(10) NOT NULL,
  `donvitinh` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `maloai` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `mancc` char(6) COLLATE utf8_unicode_ci NOT NULL,
  `image` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`masp`, `tensp`, `dongia`, `soluong`, `donvitinh`, `maloai`, `mancc`, `image`) VALUES
('001', 'Dầu gội đầu Dove', 150000, 49, 'Chai', 'A03', '002', '001.png'),
('002', 'Trứng gà', 20000, 48, 'Hộp', 'A01', '001', '002.png'),
('003', 'Nước Đảnh Thạnh', 10000, 45, 'Chai', 'A02', '002', '003.png'),
('004', 'Táo Fuji ', 15000, 51, 'Quả', 'A01', '002', '004.png'),
('005', 'Xúc xích heo', 20000, 50, 'Gói', 'A01', '001', '005.png'),
('006', 'Mì Hảo Hảo', 3500, 40, 'Gói', 'A01', '003', '006.png'),
('007', 'Mì gấu đỏ', 4000, 50, 'Gói', 'A01', '002', '007.png'),
('008', 'Nước CocaCola', 10000, 40, 'Lon', 'A02', '002', '008.png'),
('009', 'BCS Durex Pleasuremax', 55000, 48, 'Hộp', 'A03', '001', '009.png'),
('010', 'Chuối', 8000, 50, 'Quả', 'A01', '003', '010.png'),
('011', 'Bia Tiger', 20000, 50, 'Lon', 'A02', '002', '011.png'),
('012', 'BVS Diana ', 23000, 60, 'Hộp', 'A03', '002', '012.png'),
('013', 'Snack Mực', 6000, 46, 'Gói', 'A01', '001', '013.png'),
('014', 'Snack Bí đỏ', 6000, 55, 'Gói', 'A01', '003', '014.png'),
('015', 'Sữa TH True Milk', 8000, 50, 'Hộp', 'A02', '001', '015.png'),
('016', 'Cà rốt', 7000, 47, 'Quả', 'A01', '002', '016.png'),
('017', 'Thịt bò', 100000, 50, 'Hộp', 'A01', '001', '017.png'),
('018', 'Nước Aquafina', 6000, 45, 'Chai', 'A02', '002', '018.png'),
('019', 'Xịt khủ mùi AXE Apolo', 105000, 33, 'Chai', 'A03', '003', '019.png'),
('020', 'SRM Nivea Men', 60000, 40, 'Chai', 'A03', '002', '020.png'),
('021', 'Nước Monster', 30000, 50, 'Chai', 'A02', '003', '021.png'),
('022', 'Đủ đủ', 12000, 26, 'Quả', 'A01', '001', '022.png'),
('023', 'Đùi gà', 45000, 50, 'Hộp', 'A01', '001', '023.png'),
('024', 'KDR Colgate', 32000, 49, 'Hộp', 'A03', '003', '024.png'),
('025', 'Lẩu thái', 80000, 59, 'Gói', 'A01', '003', '025.png'),
('026', 'Nước Sting', 10000, 40, 'Chai', 'A02', '002', '026.png'),
('027', 'NRC Sunlight', 25000, 50, 'Chai', 'A03', '001', '027.png'),
('028', 'Mì hộp Kokomi', 8000, 47, 'Hộp', 'A01', '003', '028.png'),
('029', 'Bánh mì', 4000, 60, 'Gói', 'A01', '002', '029.png'),
('030', 'Sữa chua TH True Milk', 12000, 50, 'Hộp', 'A01', '001', '030.png');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chitiethd`
--
ALTER TABLE `chitiethd`
  ADD PRIMARY KEY (`mahd`,`masp`) USING BTREE,
  ADD KEY `FK_SP` (`masp`,`mahd`) USING BTREE;

--
-- Indexes for table `chitietpnh`
--
ALTER TABLE `chitietpnh`
  ADD PRIMARY KEY (`mapnh`,`masp`) USING BTREE,
  ADD KEY `PK_SP` (`masp`,`mapnh`) USING BTREE;

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`mahd`),
  ADD KEY `FK_NV` (`manv`),
  ADD KEY `PK_KH` (`makh`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`makh`);

--
-- Indexes for table `loaisp`
--
ALTER TABLE `loaisp`
  ADD PRIMARY KEY (`maloai`);

--
-- Indexes for table `nguoidung`
--
ALTER TABLE `nguoidung`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`mancc`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`manv`);

--
-- Indexes for table `phieunhaphang`
--
ALTER TABLE `phieunhaphang`
  ADD PRIMARY KEY (`mapnh`),
  ADD KEY `FK_NCC` (`mancc`),
  ADD KEY `FK_NHANVIEN` (`manv`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`masp`),
  ADD KEY `FK_MALOAI` (`maloai`),
  ADD KEY `FK_MANCC` (`mancc`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chitiethd`
--
ALTER TABLE `chitiethd`
  ADD CONSTRAINT `FK_HD` FOREIGN KEY (`mahd`) REFERENCES `hoadon` (`mahd`),
  ADD CONSTRAINT `FK_SP` FOREIGN KEY (`masp`) REFERENCES `sanpham` (`masp`);

--
-- Constraints for table `chitietpnh`
--
ALTER TABLE `chitietpnh`
  ADD CONSTRAINT `FK_PNH` FOREIGN KEY (`mapnh`) REFERENCES `phieunhaphang` (`mapnh`),
  ADD CONSTRAINT `PK_SP` FOREIGN KEY (`masp`) REFERENCES `sanpham` (`masp`);

--
-- Constraints for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `FK_NV` FOREIGN KEY (`manv`) REFERENCES `nhanvien` (`manv`),
  ADD CONSTRAINT `PK_KH` FOREIGN KEY (`makh`) REFERENCES `khachhang` (`makh`);

--
-- Constraints for table `phieunhaphang`
--
ALTER TABLE `phieunhaphang`
  ADD CONSTRAINT `FK_NCC` FOREIGN KEY (`mancc`) REFERENCES `nhacungcap` (`mancc`),
  ADD CONSTRAINT `FK_NHANVIEN` FOREIGN KEY (`manv`) REFERENCES `nhanvien` (`manv`);

--
-- Constraints for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `FK_MALOAI` FOREIGN KEY (`maloai`) REFERENCES `loaisp` (`maloai`),
  ADD CONSTRAINT `FK_MANCC` FOREIGN KEY (`mancc`) REFERENCES `nhacungcap` (`mancc`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
