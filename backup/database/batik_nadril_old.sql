-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 13 Jan 2024 pada 10.41
-- Versi server: 10.4.24-MariaDB
-- Versi PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `batik_nadril`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE `admin` (
  `kode_user` char(10) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `admin`
--

INSERT INTO `admin` (`kode_user`, `username`, `password`) VALUES
('A-001', 'root', 'root'),
('A-002', 'Khoirul', 'batiknadril');

-- --------------------------------------------------------

--
-- Struktur dari tabel `detail_pakaian`
--

CREATE TABLE `detail_pakaian` (
  `kode_pakaian` char(10) NOT NULL,
  `warna_pakaian` varchar(30) NOT NULL,
  `ukuran_pakaian` char(10) NOT NULL,
  `harga_pakaian` int(11) NOT NULL,
  `stok_pakaian` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `detail_pakaian`
--

INSERT INTO `detail_pakaian` (`kode_pakaian`, `warna_pakaian`, `ukuran_pakaian`, `harga_pakaian`, `stok_pakaian`) VALUES
('G-001', 'Nude', 'M', 80000, 291),
('G-001', 'Biru Muda', 'XL', 97000, 118),
('G-002', 'Sage', 'L', 70000, 171),
('G-003', 'Hijau', 'XL', 90000, 238),
('KB-001', 'Mouve', 'L Kecil', 85000, 143);

-- --------------------------------------------------------

--
-- Struktur dari tabel `detail_penjualan`
--

CREATE TABLE `detail_penjualan` (
  `kode_penjualan` char(10) NOT NULL,
  `kode_pakaian` char(10) NOT NULL,
  `ukuran` char(10) NOT NULL,
  `qty` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `detail_penjualan`
--

INSERT INTO `detail_penjualan` (`kode_penjualan`, `kode_pakaian`, `ukuran`, `qty`) VALUES
('TRS-001', 'G-001', 'M', 2),
('TRS-002', 'G-003', 'XL', 3),
('TRS-002', 'G-002', 'L', 4),
('TRS-003', 'G-002', 'L', 3),
('TRS-004', 'G-001', 'M', 2),
('TRS-004', 'G-002', 'L', 1),
('TRS-005', 'G-001', 'M', 2),
('TRS-005', 'G-003', 'XL', 5),
('TRS-005', 'G-001', 'M', 3),
('TRS-005', 'G-003', 'XL', 2),
('TRS-005', 'G-002', 'L', 1),
('TRS-006', 'G-002', 'L', 2),
('TRS-007', 'G-002', 'L', 1),
('TRS-007', 'G-003', 'XL', 2),
('TRS-008', 'G-001', 'M', 2),
('TRS-008', 'G-002', 'L', 1),
('TRS-008', 'G-003', 'XL', 3),
('TRS-008', 'KB-001', 'L Kecil', 2),
('TRS-009', 'KB-001', 'L Kecil', 2),
('TRS-010', 'G-001', 'XL', 2),
('TRS-010', 'KB-001', 'L Kecil', 3);

--
-- Trigger `detail_penjualan`
--
DELIMITER $$
CREATE TRIGGER `mengurangi stok` AFTER INSERT ON `detail_penjualan` FOR EACH ROW UPDATE detail_pakaian set detail_pakaian.stok_pakaian = detail_pakaian.stok_pakaian - NEW.qty WHERE detail_pakaian.kode_pakaian = NEW.kode_pakaian AND detail_pakaian.ukuran_pakaian = NEW.ukuran
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `master_jenis_pakaian`
--

CREATE TABLE `master_jenis_pakaian` (
  `id_jenis` char(10) NOT NULL,
  `jenis_pakaian` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `master_jenis_pakaian`
--

INSERT INTO `master_jenis_pakaian` (`id_jenis`, `jenis_pakaian`) VALUES
('G', 'Gamis'),
('K', 'Kemeja'),
('KB', 'Kebaya');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pakaian`
--

CREATE TABLE `pakaian` (
  `kode_pakaian` char(10) NOT NULL,
  `nama_pakaian` varchar(50) NOT NULL,
  `id_jenis` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pakaian`
--

INSERT INTO `pakaian` (`kode_pakaian`, `nama_pakaian`, `id_jenis`) VALUES
('G-001', 'Adeva', 'G'),
('G-002', 'Namira', 'G'),
('G-003', 'Nadin', 'G'),
('KB-001', 'Kaluna', 'KB');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pelanggan`
--

CREATE TABLE `pelanggan` (
  `kode_pelanggan` char(10) NOT NULL,
  `nama_pelanggan` varchar(50) NOT NULL,
  `alamat_pelanggan` text NOT NULL,
  `nomor_pelanggan` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pelanggan`
--

INSERT INTO `pelanggan` (`kode_pelanggan`, `nama_pelanggan`, `alamat_pelanggan`, `nomor_pelanggan`) VALUES
('P-001', 'Rizal', 'Solo', '081221345678'),
('P-002', 'Catur', 'Solo', '085667114411'),
('P-003', 'Budi', 'Solo', '082321145098'),
('P-004', 'Wahyu', 'Solo', '081345575661');

-- --------------------------------------------------------

--
-- Struktur dari tabel `penjualan`
--

CREATE TABLE `penjualan` (
  `kode_transaksi` char(10) NOT NULL,
  `tanggal` datetime NOT NULL,
  `kode_pelanggan` char(10) NOT NULL,
  `kode_admin` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `penjualan`
--

INSERT INTO `penjualan` (`kode_transaksi`, `tanggal`, `kode_pelanggan`, `kode_admin`) VALUES
('TRS-001', '2024-01-12 13:57:53', 'P-001', 'A-002'),
('TRS-002', '2024-01-12 14:18:02', 'P-003', 'A-001'),
('TRS-003', '2024-01-12 14:44:46', 'P-004', 'A-001'),
('TRS-004', '2024-01-13 09:07:35', 'P-002', 'A-001'),
('TRS-005', '2024-01-13 09:14:57', 'P-001', 'A-001'),
('TRS-006', '2024-01-13 15:05:55', 'P-004', 'A-001'),
('TRS-007', '2024-01-13 15:06:49', 'P-004', 'A-001'),
('TRS-008', '2024-01-13 15:08:34', 'P-004', 'A-001'),
('TRS-009', '2024-01-13 15:49:21', 'P-001', 'A-001'),
('TRS-010', '2024-01-13 16:22:14', 'P-002', 'A-001');

-- --------------------------------------------------------

--
-- Struktur dari tabel `ukuran`
--

CREATE TABLE `ukuran` (
  `ukuran` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `ukuran`
--

INSERT INTO `ukuran` (`ukuran`) VALUES
('L'),
('L Kecil'),
('M'),
('S'),
('XL');

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `view_data_pakaian`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `view_data_pakaian` (
`kode_pakaian` char(10)
,`nama_pakaian` varchar(50)
,`jenis_pakaian` varchar(50)
,`warna_pakaian` varchar(30)
,`ukuran_pakaian` char(10)
,`harga_pakaian` int(11)
,`stok_pakaian` int(11)
);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `view_detail_penjualan`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `view_detail_penjualan` (
`kode_penjualan` char(10)
,`nama_pakaian` varchar(50)
,`jenis_pakaian` varchar(50)
,`ukuran` char(10)
,`qty` int(11)
);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `view_penjualan`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `view_penjualan` (
`kode_transaksi` char(10)
,`tanggal` datetime
,`nama_pelanggan` varchar(50)
,`alamat_pelanggan` text
,`nomor_pelanggan` varchar(15)
,`total` decimal(42,0)
);

-- --------------------------------------------------------

--
-- Struktur untuk view `view_data_pakaian`
--
DROP TABLE IF EXISTS `view_data_pakaian`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_data_pakaian`  AS SELECT `pakaian`.`kode_pakaian` AS `kode_pakaian`, `pakaian`.`nama_pakaian` AS `nama_pakaian`, `master_jenis_pakaian`.`jenis_pakaian` AS `jenis_pakaian`, `detail_pakaian`.`warna_pakaian` AS `warna_pakaian`, `detail_pakaian`.`ukuran_pakaian` AS `ukuran_pakaian`, `detail_pakaian`.`harga_pakaian` AS `harga_pakaian`, `detail_pakaian`.`stok_pakaian` AS `stok_pakaian` FROM ((`detail_pakaian` join `pakaian` on(`pakaian`.`kode_pakaian` = `detail_pakaian`.`kode_pakaian`)) join `master_jenis_pakaian` on(`master_jenis_pakaian`.`id_jenis` = `pakaian`.`id_jenis`))  ;

-- --------------------------------------------------------

--
-- Struktur untuk view `view_detail_penjualan`
--
DROP TABLE IF EXISTS `view_detail_penjualan`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_detail_penjualan`  AS SELECT `detail_penjualan`.`kode_penjualan` AS `kode_penjualan`, `pakaian`.`nama_pakaian` AS `nama_pakaian`, `master_jenis_pakaian`.`jenis_pakaian` AS `jenis_pakaian`, `detail_penjualan`.`ukuran` AS `ukuran`, `detail_penjualan`.`qty` AS `qty` FROM ((`detail_penjualan` join `pakaian` on(`detail_penjualan`.`kode_pakaian` = `pakaian`.`kode_pakaian`)) join `master_jenis_pakaian` on(`pakaian`.`id_jenis` = `master_jenis_pakaian`.`id_jenis`))  ;

-- --------------------------------------------------------

--
-- Struktur untuk view `view_penjualan`
--
DROP TABLE IF EXISTS `view_penjualan`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_penjualan`  AS SELECT `penjualan`.`kode_transaksi` AS `kode_transaksi`, `penjualan`.`tanggal` AS `tanggal`, `pelanggan`.`nama_pelanggan` AS `nama_pelanggan`, `pelanggan`.`alamat_pelanggan` AS `alamat_pelanggan`, `pelanggan`.`nomor_pelanggan` AS `nomor_pelanggan`, sum(`detail_penjualan`.`qty` * `detail_pakaian`.`harga_pakaian`) AS `total` FROM (((`penjualan` join `pelanggan` on(`penjualan`.`kode_pelanggan` = `pelanggan`.`kode_pelanggan`)) join `detail_penjualan` on(`detail_penjualan`.`kode_penjualan` = `penjualan`.`kode_transaksi`)) join `detail_pakaian` on(`detail_penjualan`.`kode_pakaian` = `detail_pakaian`.`kode_pakaian` and `detail_penjualan`.`ukuran` = `detail_pakaian`.`ukuran_pakaian`)) GROUP BY `penjualan`.`kode_transaksi``kode_transaksi`  ;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`kode_user`);

--
-- Indeks untuk tabel `detail_pakaian`
--
ALTER TABLE `detail_pakaian`
  ADD UNIQUE KEY `kode_pakaian` (`kode_pakaian`,`ukuran_pakaian`),
  ADD KEY `ukuran_pakaian` (`ukuran_pakaian`);

--
-- Indeks untuk tabel `detail_penjualan`
--
ALTER TABLE `detail_penjualan`
  ADD KEY `kode_pakaian` (`kode_pakaian`),
  ADD KEY `kode_penjualan` (`kode_penjualan`);

--
-- Indeks untuk tabel `master_jenis_pakaian`
--
ALTER TABLE `master_jenis_pakaian`
  ADD PRIMARY KEY (`id_jenis`);

--
-- Indeks untuk tabel `pakaian`
--
ALTER TABLE `pakaian`
  ADD PRIMARY KEY (`kode_pakaian`),
  ADD KEY `pakaian_ibfk_1` (`id_jenis`);

--
-- Indeks untuk tabel `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`kode_pelanggan`);

--
-- Indeks untuk tabel `penjualan`
--
ALTER TABLE `penjualan`
  ADD PRIMARY KEY (`kode_transaksi`),
  ADD KEY `kode_admin` (`kode_admin`),
  ADD KEY `kode_pelanggan` (`kode_pelanggan`);

--
-- Indeks untuk tabel `ukuran`
--
ALTER TABLE `ukuran`
  ADD PRIMARY KEY (`ukuran`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `detail_pakaian`
--
ALTER TABLE `detail_pakaian`
  ADD CONSTRAINT `detail_pakaian_ibfk_1` FOREIGN KEY (`kode_pakaian`) REFERENCES `pakaian` (`kode_pakaian`),
  ADD CONSTRAINT `detail_pakaian_ibfk_2` FOREIGN KEY (`ukuran_pakaian`) REFERENCES `ukuran` (`ukuran`);

--
-- Ketidakleluasaan untuk tabel `detail_penjualan`
--
ALTER TABLE `detail_penjualan`
  ADD CONSTRAINT `detail_penjualan_ibfk_1` FOREIGN KEY (`kode_pakaian`) REFERENCES `pakaian` (`kode_pakaian`),
  ADD CONSTRAINT `detail_penjualan_ibfk_2` FOREIGN KEY (`kode_penjualan`) REFERENCES `penjualan` (`kode_transaksi`);

--
-- Ketidakleluasaan untuk tabel `pakaian`
--
ALTER TABLE `pakaian`
  ADD CONSTRAINT `pakaian_ibfk_1` FOREIGN KEY (`id_jenis`) REFERENCES `master_jenis_pakaian` (`id_jenis`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `penjualan`
--
ALTER TABLE `penjualan`
  ADD CONSTRAINT `penjualan_ibfk_1` FOREIGN KEY (`kode_admin`) REFERENCES `admin` (`kode_user`),
  ADD CONSTRAINT `penjualan_ibfk_2` FOREIGN KEY (`kode_pelanggan`) REFERENCES `pelanggan` (`kode_pelanggan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
