CREATE TABLE person
(
    id          INT PRIMARY KEY AUTO_INCREMENT, -- 主键，自增
    name        VARCHAR(255) NOT NULL,          -- 名字
    age         INT,                            -- 年龄
    created_time DATETIME     NOT NULL,          -- 创建时间
    updated_time DATETIME     NOT NULL           -- 更新时间
);
