use furuma_resort;

-- cau 1: 
select *from nhan_vien
where ho_ten like 'H%' or ho_ten like 'T%' or ho_ten like 'K%'
    and LENGTH(ho_ten) <= 15;
-- cau 2:
select *from khach_hang
where year(CURDATE()) - year(ngay_sinh) between 18 and 50
    and (dia_chi like '%Đà Nẵng%' or dia_chi like '%Quảng Trị%');
-- cau 3:
SELECT khach_hang.ma_khach_hang, khach_hang.ho_ten, COUNT(hop_dong.ma_hop_dong) AS so_lan_dat_phong
FROM khach_hang
JOIN hop_dong ON khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
JOIN loai_khach ON khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
WHERE loai_khach.ten_loai_khach = 'Diamond'
GROUP BY khach_hang.ma_khach_hang, khach_hang.ho_ten
ORDER BY so_lan_dat_phong ASC;
-- cau 4:
SELECT
    khach_hang.ma_khach_hang,
    khach_hang.ho_ten,
    loai_khach.ten_loai_khach,
    hop_dong.ma_hop_dong,
    dich_vu.ten_dich_vu,
    hop_dong.ngay_lam_hop_dong,
    hop_dong.ngay_ket_thuc,
    SUM(hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia) + dich_vu.chi_phi_thue AS tong_tien
FROM
    khach_hang
LEFT JOIN hop_dong ON khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
LEFT JOIN loai_khach ON khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
LEFT JOIN hop_dong_chi_tiet ON hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
LEFT JOIN dich_vu_di_kem ON hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
LEFT JOIN dich_vu ON hop_dong_chi_tiet.ma_dich_vu = dich_vu.ma_dich_vu
GROUP BY
    khach_hang.ma_khach_hang,
    hop_dong.ma_hop_dong,
    dich_vu_di_kem.ma_dich_vu_di_kem
ORDER BY
    khach_hang.ma_khach_hang, hop_dong.ma_hop_dong;
    -- cau 5:
SELECT dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.chi_phi_thue, ldv.ten_loai_dich_vu
FROM dich_vu dv
JOIN loai_dich_vu ldv ON dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
WHERE dv.ma_dich_vu NOT IN (
    SELECT DISTINCT hd.ma_dich_vu
    FROM hop_dong hd
    WHERE MONTH(hd.ngay_lam_hop_dong) IN (1, 2, 3)
    AND YEAR(hd.ngay_lam_hop_dong) = 2021
);
-- cau 6:
SELECT dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.so_nguoi_toi_da, dv.chi_phi_thue, ldv.ten_loai_dich_vu
FROM dich_vu dv
JOIN loai_dich_vu ldv ON dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
WHERE dv.ma_dich_vu IN (
    SELECT DISTINCT hd.ma_dich_vu
    FROM hop_dong hd
    WHERE YEAR(hd.ngay_lam_hop_dong) = 2020
)
AND dv.ma_dich_vu NOT IN (
    SELECT DISTINCT hd.ma_dich_vu
    FROM hop_dong hd
    WHERE YEAR(hd.ngay_lam_hop_dong) = 2021
);
-- cau 7:
-- use distinct:
SELECT DISTINCT ho_ten
FROM khach_hang;
-- use group by:
SELECT ho_ten
FROM khach_hang
GROUP BY ho_ten;
-- use row-column:
SELECT ho_ten
FROM (
    SELECT ho_ten, ROW_NUMBER() OVER (PARTITION BY ho_ten ORDER BY ho_ten) AS row_num
    FROM khach_hang
) AS ranked
WHERE row_num = 1;
--  cau 8:
SELECT
    MONTH(ngay_lam_hop_dong) AS thang,
    COUNT(DISTINCT ma_khach_hang) AS so_luong_khach_hang
FROM hop_dong
WHERE YEAR(ngay_lam_hop_dong) = 2021
GROUP BY thang;
-- cau 9:
SELECT
    hd.ma_hop_dong,
    hd.ngay_lam_hop_dong,
    hd.ngay_ket_thuc,
    hd.tien_dat_coc,
    COALESCE(SUM(hdct.so_luong), 0) AS so_luong_dich_vu_di_kem
FROM
    hop_dong hd
LEFT JOIN
    hop_dong_chi_tiet hdct ON hd.ma_hop_dong = hdct.ma_hop_dong
GROUP BY
    hd.ma_hop_dong, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, hd.tien_dat_coc;
-- cau 10:
SELECT
    dvdk.ma_dich_vu_di_kem,
    dvdk.ten_dich_vu_di_kem,
    dvdk.gia,
    dvdk.don_vi,
    dvdk.trang_thai
FROM
    dich_vu_di_kem dvdk
JOIN
    hop_dong_chi_tiet hdct ON dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
JOIN
    hop_dong hd ON hdct.ma_hop_dong = hd.ma_hop_dong
JOIN
    khach_hang kh ON hd.ma_khach_hang = kh.ma_khach_hang
JOIN
    loai_khach lk ON kh.ma_loai_khach = lk.ma_loai_khach
WHERE
    lk.ten_loai_khach = 'Diamond'
    AND (kh.dia_chi = 'Vinh' OR kh.dia_chi = 'Quảng Ngãi');

 


 



 
