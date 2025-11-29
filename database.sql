DROP DATABASE IF EXISTS quanlycuahang;

CREATE DATABASE quanlycuahang;

USE quanlycuahang;

CREATE TABLE nhanvien (
    manhanvien VARCHAR(255) PRIMARY KEY,
    hoten VARCHAR(255),
    cccd VARCHAR(255),
    sodienthoai VARCHAR(255),
    gioitinh VARCHAR(255),
    vaitro VARCHAR(255),
    username VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    luong BIGINT,
    ngaysinh VARCHAR(255),
    diachi VARCHAR(255),
    trangthai VARCHAR(255)
);

CREATE TABLE sanpham (
    masanpham VARCHAR(255) PRIMARY KEY,
    tensanpham VARCHAR(255),
    loaisanpham VARCHAR(255),
    nguongoc VARCHAR(255),
    mota VARCHAR(255),
    donvi VARCHAR(255),
    giaban INT,
    giamua INT,
    tonkho INT,
    daban INT
);

CREATE TABLE donvicungcap (
    madonvi VARCHAR(255) PRIMARY KEY,
    tendonvi VARCHAR(255),
    mathang VARCHAR(255),
    diachi VARCHAR(255)
);

CREATE TABLE phieunhaphang (
    maphieu INT PRIMARY KEY,
    ngaynhap DATETIME,
    tongtien INT,
    manhanvien VARCHAR(255),
    madonvi VARCHAR(255),
    FOREIGN KEY (manhanvien) REFERENCES nhanvien(manhanvien),
    FOREIGN KEY (madonvi) REFERENCES donvicungcap(madonvi)
);

CREATE TABLE chitietphieunhap (
    maphieu INT,
    masanpham VARCHAR(255),
    soluong INT,
    dongia INT,
    thanhtien INT,
    PRIMARY KEY (maphieu, masanpham),
    FOREIGN KEY (maphieu) REFERENCES phieunhaphang(maphieu),
    FOREIGN KEY (masanpham) REFERENCES sanpham(masanpham)
);

INSERT INTO nhanvien (manhanvien, hoten, vaitro, username, password)
VALUES ('NV01', 'Admin', 'Quản trị', 'admin', '');