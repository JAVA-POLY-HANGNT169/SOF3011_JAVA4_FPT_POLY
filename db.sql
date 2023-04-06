CREATE DATABASE SOF3011_Demo_Video;

USE SOF3011_Demo_Video;

CREATE TABLE may_tinh(
	ma UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	ten nvarchar(100),
	gia float,
	bo_nho nvarchar(100),
	mau_sac nvarchar(100),
	hang nvarchar(100),
	mieu_ta nvarchar(100)
)

INSERT INTO may_tinh
( ten, gia, bo_nho, mau_sac, hang, mieu_ta)
VALUES(N'Máy 1', 10.0, N'1', N'Đen', N'Dell', N'Tốt');
INSERT INTO may_tinh
(ten, gia, bo_nho, mau_sac, hang, mieu_ta)
VALUES( N'Máy 2', 11.0, N'512', N'Đỏ', N'Asus', N'Bình thường');
