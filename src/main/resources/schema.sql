CREATE TABLE climate (
    id INT PRIMARY KEY AUTO_INCREMENT,
    station_name VARCHAR(100) NOT NULL,
    province VARCHAR(50) NOT NULL,
    rdate DATE,
    mean_temp VARCHAR(50) NOT NULL,
    highest_monthly_max_temp VARCHAR(50) NOT NULL,
    lowest_monthly_min_temp VARCHAR(50) NOT NULL
    );