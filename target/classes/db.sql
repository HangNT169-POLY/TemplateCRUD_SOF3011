CREATE DATABASE hibernate_demo;
USE hibernate_demo;
CREATE TABLE dong_vat(
    id BIGINT IDENTITY PRIMARY KEY NOT NULL,
    ten NVARCHAR(100),
    can_nang FLOAT,
    gioi_tinh BIT,
    nam_sinh INT
)