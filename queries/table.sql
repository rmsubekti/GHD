use ghdesktop;
create table orang(
    id_orang varchar(8) primary key,
    nama varchar(30) not null,
    telpon varchar(15) not null,
    alamat varchar(60),
    email varchar(60)
)engine=innodb;

create table akun(
    id varchar(7) primary key,
    id_orang varchar(8) not null,
    username varchar(15) not null,
    password varchar(18) not null,
    role varchar(5) null,
    foreign key (id_orang) references orang(id_orang)
)engine=innodb;

create table kategori(
    id_kategori varchar(5) primary key,
    nama varchar(15) not null,
    keterangan text
)engine=innodb;

create table produk(
    id_produk varchar(6) primary key,
    nama varchar(20) not null,
    id_kategori varchar(5) not null,
    keterangan text,
    harga int not null,
    stok int not null,
    foreign key (id_kategori) references kategori(id_kategori)
)engine=innodb;

create table transaksi(
    id_transaksi varchar(9) primary key,
    id_orang varchar(8),
    tanggal date not null,
    total_bayar int not null,
    foreign key (id_orang) references orang(id_orang)
)engine=innodb;

create table det_transaksi(
    id_detail varchar(11) primary key,
    id_transaksi varchar(9) not null,
    id_produk varchar(6) not null,
    jumlah int not null,
    total_harga int not null,
    foreign key (id_transaksi) references transaksi(id_transaksi),
    foreign key (id_produk) references produk(id_produk)
)engine=innodb;