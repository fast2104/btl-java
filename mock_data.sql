INSERT INTO nhanvien (manhanvien, hoten, cccd, sodienthoai, gioitinh, vaitro, username, password, luong, ngaysinh, diachi, trangthai) VALUES
('NV02', 'Lê Thị B', '012345678902', '0912345679', 'Nữ', 'Nhân viên', 'nhanvien1', '123', 10000000, '1995-10-20', '234 Đường B, Quận C, TP. HCM', 'Đang làm việc'),
('NV03', 'Trần Văn C', '012345678903', '0912345680', 'Nam', 'Nhân viên', 'nhanvien2', '123', 9500000, '1998-03-15', '567 Đường D, Quận E, TP. HCM', 'Đang làm việc'),
('NV04', 'Phạm Thị D', '012345678904', '0912345681', 'Nữ', 'Nhân viên', 'nhanvien3', '123', 9000000, '2000-07-30', '890 Đường F, Quận G, TP. HCM', 'Đã nghỉ');

INSERT INTO donvicungcap (madonvi, tendonvi, mathang, diachi) VALUES
('NCC01', 'Công ty Điện tử ABC', 'Điện tử', '123 Đường X, Quận Y, TP. Hà Nội'),
('NCC02', 'Nhà phân phối Gia dụng XYZ', 'Gia dụng', '456 Đường A, Quận B, TP. Đà Nẵng'),
('NCC03', 'Trang trại Nông sản Sạch', 'Thực phẩm', '789 Làng D, Huyện E, Tỉnh Lâm Đồng'),
('NCC04', 'Xưởng may Thời trang DEF', 'Thời trang', 'Khu công nghiệp G, Tỉnh Hưng Yên');

INSERT INTO sanpham (masanpham, tensanpham, loaisanpham, nguongoc, mota, donvi, giaban, giamua, tonkho, daban) VALUES
('SP001', 'Laptop Dell XPS 15', 'Điện tử', 'Trung Quốc', 'Laptop cao cấp, Core i7, 16GB RAM', 'Cái', 35000000, 32000000, 50, 12),
('SP002', 'Nồi cơm điện Cuckoo', 'Gia dụng', 'Hàn Quốc', 'Nồi cơm điện tử dung tích 1.8L', 'Cái', 2500000, 2200000, 100, 25),
('SP003', 'Thịt bò Úc (Thăn ngoại)', 'Thực phẩm', 'Úc', 'Thịt bò tươi nhập khẩu', 'Kg', 550000, 480000, 80, 43),
('SP004', 'Áo thun Uniqlo Airism', 'Thời trang', 'Nhật Bản', 'Áo thun nam, chất liệu mát', 'Cái', 450000, 380000, 300, 150),
('SP005', 'Tivi Sony Bravia 55 inch', 'Điện tử', 'Nhật Bản', 'Tivi 4K HDR, Android TV', 'Cái', 21000000, 19500000, 30, 7),
('SP006', 'Máy giặt Electrolux 9kg', 'Gia dụng', 'Thụy Điển', 'Máy giặt cửa trước, Inverter', 'Cái', 12000000, 10500000, 40, 11),
('SP007', 'Cá hồi Na-uy', 'Thực phẩm', 'Na-uy', 'Cá hồi phi-lê tươi', 'Kg', 700000, 620000, 60, 33);

