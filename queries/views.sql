-- DATA TRANSAKSI
create view data_transaksi as
SELECT
     transaksi.`id_transaksi` AS transaksi_id_transaksi,
     orang.`nama` AS orang_nama,
     transaksi.`tanggal` AS transaksi_tanggal,
     sum(det_transaksi.`jumlah`) as jumlah,
     transaksi.`total_bayar` AS transaksi_total_bayar
FROM
     `orang` orang INNER JOIN `transaksi` transaksi ON orang.`id_orang` = transaksi.`id_orang`
     INNER JOIN `det_transaksi` det_transaksi ON transaksi.`id_transaksi` = det_transaksi.`id_transaksi`
group by
     transaksi.`id_transaksi`, orang.`nama`,transaksi.`tanggal`,transaksi.`total_bayar`;


-- DATA PELANGGAN AKTIF
create view pelanggan_aktif as
SELECT
     orang.`id_orang` AS id_orang,
     orang.`nama` AS nama,
     count(transaksi.`id_orang`) as total_transaksi,
     sum(transaksi.`total_bayar`) as total_pembayaran,
     sum(det_transaksi.`jumlah`) as total_pembelian
FROM
     `orang` orang INNER JOIN `transaksi` transaksi ON orang.`id_orang` = transaksi.`id_orang`
     INNER JOIN `det_transaksi` det_transaksi ON transaksi.`id_transaksi` = det_transaksi.`id_transaksi`
--where 
     --month(transaksi.`tanggal`) = month(now()) 
group by 
     orang.`id_orang`, orang.`nama`;

-- DATA PRODUK 
create view produk_terjual as
SELECT
     produk.`id_produk` AS produk_id_produk,
     produk.`nama` AS produk_nama,
     sum(det_transaksi.`jumlah`) as terjual,
     sum(det_transaksi.`total_harga`) as haga_terjual,
     count(transaksi.`id_transaksi`) as dalam_transaksi
FROM
     `produk` produk INNER JOIN `det_transaksi` det_transaksi ON produk.`id_produk` = det_transaksi.`id_produk`
     INNER JOIN `transaksi` transaksi ON det_transaksi.`id_transaksi` = transaksi.`id_transaksi`
group by
     produk.`id_produk`, produk.`nama`;

