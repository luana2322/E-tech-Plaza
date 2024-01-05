create database e_techplaza;
use `e_techplaza`;

INSERT INTO e_techplaza.color (color_name) VALUES('Black');
INSERT INTO e_techplaza.color (color_name) VALUES ('White');
INSERT INTO e_techplaza.color (color_name) VALUES ('Silver');
INSERT INTO e_techplaza.color (color_name) VALUES ('Gold');
INSERT INTO e_techplaza.color (color_name) VALUES ('Rose Gold');
INSERT INTO e_techplaza.color (color_name) VALUES ('Space Gray');
INSERT INTO e_techplaza.color (color_name) VALUES ('Midnight Green');
INSERT INTO e_techplaza.color (color_name) VALUES ('Pacific Blue');
INSERT INTO e_techplaza.color (color_name) VALUES ('Graphite');
INSERT INTO e_techplaza.color (color_name) VALUES ('Mystic Bronze');

INSERT INTO e_techplaza.product (camera, cost_price, cpu, current_quantity, height, is_activated, is_deleted, pin, product_name, product_sku, ram, rom, sale_price, thick, weight, width) VALUES ('12 MP', 500, 'Snapdragon 865', 100, 150.5, 1, 0, 4000, 'iPhone 12', 'SKU001', 6, 128, 800, 8.5, 180, 75);
INSERT INTO e_techplaza.product (camera, cost_price, cpu, current_quantity, height, is_activated, is_deleted, pin, product_name, product_sku, ram, rom, sale_price, thick, weight, width) VALUES ('20 MP', 1200, 'Apple M1', 50, 143.6, 1, 0, 2815, 'MacBook Pro', 'SKU002', 16, 512, 2000, 15.6, 1560, 356);
INSERT INTO e_techplaza.product (camera, cost_price, cpu, current_quantity, height, is_activated, is_deleted, pin, product_name, product_sku, ram, rom, sale_price, thick, weight, width) VALUES ('32 MP', 900, 'Exynos 990', 75, 162.6, 1, 0, 4000, 'Samsung Galaxy S21', 'SKU003', 8, 256, 1100, 7.9, 169, 71);
INSERT INTO e_techplaza.product (camera, cost_price, cpu, current_quantity, height, is_activated, is_deleted, pin, product_name, product_sku, ram, rom, sale_price, thick, weight, width) VALUES ('16 MP', 800, 'Intel Core i7', 100, 200, 1, 0, 4000, 'Dell XPS 15', 'SKU004', 16, 512, 1800, 17, 2000, 300);
INSERT INTO e_techplaza.product (camera, cost_price, cpu, current_quantity, height, is_activated, is_deleted, pin, product_name, product_sku, ram, rom, sale_price, thick, weight, width) VALUES ('12 MP', 700, 'Snapdragon 888', 120, 151.7, 1, 0, 4500, 'iPhone 13', 'SKU005', 8, 256, 1000, 7.7, 180, 75.2);
INSERT INTO e_techplaza.product (camera, cost_price, cpu, current_quantity, height, is_activated, is_deleted, pin, product_name, product_sku, ram, rom, sale_price, thick, weight, width) VALUES ('64 MP', 1000, 'Apple M1', 80, 144, 1, 0, 2815, 'MacBook Air', 'SKU006', 8, 256, 1500, 13.1, 1200, 350);
INSERT INTO e_techplaza.product (camera, cost_price, cpu, current_quantity, height, is_activated, is_deleted, pin, product_name, product_sku, ram, rom, sale_price, thick, weight, width) VALUES ('12 MP', 600, 'Snapdragon 870', 90, 154, 1, 0, 4000, 'Samsung Galaxy S20', 'SKU007', 8, 128, 900, 7.9, 163, 74);
INSERT INTO e_techplaza.product (camera, cost_price, cpu, current_quantity, height, is_activated, is_deleted, pin, product_name, product_sku, ram, rom, sale_price, thick, weight, width) VALUES ('16 MP', 800, 'Intel Core i5', 80, 185, 1, 0, 4000, 'Dell Inspiron 15', 'SKU008', 8, 512, 1200, 19.9, 2100, 365);
INSERT INTO e_techplaza.product (camera, cost_price, cpu, current_quantity, height, is_activated, is_deleted, pin, product_name, product_sku, ram, rom, sale_price, thick, weight, width) VALUES ('12 MP', 400, 'Snapdragon 750G', 150, 160, 1, 0, 4000, 'iPhone SE', 'SKU009', 4, 64, 600, 7.3, 148, 67);
INSERT INTO e_techplaza.product (camera, cost_price, cpu, current_quantity, height, is_activated, is_deleted, pin, product_name, product_sku, ram, rom, sale_price, thick, weight, width) VALUES ('64 MP', 900, 'Exynos 2100', 100, 165.1, 1, 0, 4500, 'Samsung Galaxy S21 Ultra', 'SKU010', 12, 512, 1500, 8.9, 229, 75.6);
INSERT INTO e_techplaza.product (camera, cost_price, cpu, current_quantity, height, is_activated, is_deleted, pin, product_name, product_sku, ram, rom, sale_price, thick, weight, width) VALUES ('16 MP', 800, 'Intel Core i7', 90, 212, 1, 0, 4000, 'Dell XPS 17', 'SKU011', 32, 128, 2500, 19.5, 2400, 400);
INSERT INTO e_techplaza.product (camera, cost_price, cpu, current_quantity, height, is_activated, is_deleted, pin, product_name, product_sku, ram, rom, sale_price, thick, weight, width) VALUES ('12 MP', 600, 'Apple A15 Bionic', 120, 146.7, 1, 0, 2815, 'iPhone 14', 'SKU012', 8, 128, 1100, 7.7, 164, 75.7);
INSERT INTO e_techplaza.product (camera, cost_price, cpu, current_quantity, height, is_activated, is_deleted, pin, product_name, product_sku, ram, rom, sale_price, thick, weight, width) VALUES ('20 MP', 1500, 'Apple M1 Pro', 50, 143.6, 1, 0, 2815, 'MacBook Pro 14-inch', 'SKU013', 16, 256, 3000, 15.6, 1560, 356);
INSERT INTO e_techplaza.product (camera, cost_price, cpu, current_quantity, height, is_activated, is_deleted, pin, product_name, product_sku, ram, rom, sale_price, thick, weight, width) VALUES ('32 MP', 1000, 'Exynos 990', 80, 164.3, 1, 0, 4000, 'Samsung Galaxy S20 Plus', 'SKU014', 12, 256, 1300, 7.8, 186, 75.6);



INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image1.jpg',1, 1, 1);
INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image2.jpg',2, 2, 1);
INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image3.jpg',3, 3, 1);

INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image4.jpg',1, 1, 2);
INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image5.jpg',2, 2, 2);
INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image6.jpg',3, 3, 2);

INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image7.jpg',1, 1, 3);
INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image8.jpg',2, 2, 3);
INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image9.jpg',3, 3, 3);

INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image10.jpg',1, 1, 4);
INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image11.jpg',2, 2, 4);
INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image12.jpg',3, 3, 4);

INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image13.jpg',1, 1, 5);
INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image14.jpg',2, 2, 5);
INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image15.jpg',3, 3, 5);

INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image16.jpg',1, 1, 6);
INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image17.jpg',2, 2, 6);
INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image18.jpg',3, 3, 6);

INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image19.jpg',1, 1, 7);
INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image20.jpg',2, 2, 7);
INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image21.jpg',3, 3, 7);

INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image22.jpg',1, 1, 8);
INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image23.jpg',2, 2, 8);
INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image24.jpg',3, 3, 8);

INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image25.jpg',1, 1, 9);
INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image26.jpg',2, 2, 9);
INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image27.jpg',3, 3, 9);

INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image28.jpg',1, 1, 10);
INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image29.jpg',2, 2, 10);
INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image30.jpg',3, 3, 10);

INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image31.jpg',1, 1, 11);
INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image32.jpg',2, 2, 11);
INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image33.jpg',3, 3, 11);

INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image34.jpg',1, 1, 12);
INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image35.jpg',2, 2, 12);
INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image36.jpg',3, 3, 12);

INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image37.jpg',1, 1, 13);
INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image38.jpg',2, 2, 13);
INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image39.jpg',3, 3, 13);

INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image40.jpg',1, 1, 14);
INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image41.jpg',2, 2, 14);
INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image42.jpg',3, 3, 14);

INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image43.jpg',1, 1, 15);
INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image44.jpg',2, 2, 15);
INSERT INTO `e_techplaza`.`product_image` (`product_image_path`, `sort_order`, `color_id`, `product_id`) 
VALUES ('../../../../../image/product/image45.jpg',3, 3, 15);

-- END INSERT DATA FOR PRODUCT_IMAGE

-- START INSERT DATA FOR CATEGORY
INSERT INTO `e_techplaza`.`category` (`category_image_path`, `category_name`, `category_status`, `created_At`, `deleted_At`, `description`, `parent_id`)
VALUES
    ('../../../../../image/category/image1.jpg', 'Apple', 'Active', '2023-11-15 12:34:56.789', NULL, 'Apple Products', 0),
    ('../../../../../image/category/image2.jpg', 'Samsung', 'Active', '2023-11-15 12:34:56.789', NULL, 'Samsung Products', 0),
    ('../../../../../image/category/image3.jpg', 'Huawei', 'Active', '2023-11-15 12:34:56.789', NULL, 'Huawei Products', 0),
    ('../../../../../image/category/image4.jpg', 'Xiaomi', 'Active', '2023-11-15 12:34:56.789', NULL, 'Xiaomi Products', 0),
    ('../../../../../image/category/image5.jpg', 'Sony', 'Active', '2023-11-15 12:34:56.789', NULL, 'Sony Products', 0);
     INSERT INTO `e_techplaza`.`category` (`category_image_path`, `category_name`, `category_status`, `created_At`, `deleted_At`, `description`, `parent_id`)
VALUES
    ('../../../../../image/category/image6.jpg', 'Dell', 'Active', '2023-11-15 12:34:56.789', NULL, 'Dell Products', 0);

-- Chèn dữ liệu vào bảng "category" (danh mục con điện thoại)
INSERT INTO `e_techplaza`.`category` (`category_image_path`, `category_name`, `category_status`, `created_At`, `deleted_At`, `description`, `parent_id`)
VALUES
    
    ('../../../../../image/category/image7.jpg', 'Galaxy', 'Active', '2023-11-15 12:34:56.789', NULL, 'Galaxy Models', 2),
    ('../../../../../image/category/image8.jpg', 'Mate', 'Active', '2023-11-15 12:34:56.789', NULL, 'Mate Models', 3),
    ('../../../../../image/category/image9.jpg', 'Mi', 'Active', '2023-11-15 12:34:56.789', NULL, 'Mi Models', 4),
    ('../../../../../image/category/image10.jpg', 'Xperia', 'Active', '2023-11-15 12:34:56.789', NULL, 'Xperia Models', 5);

-- Chèn dữ liệu vào bảng "category" (danh mục con laptop)
INSERT INTO `e_techplaza`.`category` (`category_image_path`, `category_name`, `category_status`, `created_At`, `deleted_At`, `description`, `parent_id`)
VALUES
    ('../../../../../image/category/image11.jpg', 'MacBook', 'Active', '2023-11-15 12:34:56.789', NULL, 'MacBook Models', 1),
    ('../../../../../image/category/image12.jpg', 'Galaxy Book', 'Active', '2023-11-15 12:34:56.789', NULL, 'Galaxy Book Models', 2),
    ('../../../../../image/category/image13.jpg', 'MateBook', 'Active', '2023-11-15 12:34:56.789', NULL, 'MateBook Models', 3),
    ('../../../../../image/category/image14.jpg', 'Mi Notebook', 'Active', '2023-11-15 12:34:56.789', NULL, 'Mi Notebook Models', 4),
    ('../../../../../image/category/image15.jpg', 'VAIO', 'Active', '2023-11-15 12:34:56.789', NULL, 'VAIO Models', 5);
   
-- END INSERT DATA FOR CATEGORY 

-- START INSERT DATA FOR PRODUCT_CATEGORY
INSERT INTO `e_techplaza`.`product_category` (`category_id`, `product_id`)
VALUES
   (1, 1),
   (6, 1),
(1, 2),
(11, 2),
(2, 3),
(7, 3),
(16, 4),
(1, 5),
(6, 5),
(1, 6),
(11, 6),
(2, 7),
(7, 7),
(2, 8),
(7, 8),
(16, 9),
(1, 10),
(6, 10),
(2, 11),
(7, 11),
(16, 12),
(1, 13),
(6, 13),
(1, 14),
(11, 14),
(2, 15),
(7, 15);
-- END INSERT DATA FOR PRODUCT_CATEGORY
-- START INSERT DATA FOR COUNTRY
INSERT INTO e_techplaza.COUNTRY (country_name) VALUES('Vietnam'),
													 ('Brunei'),
													 ('Cambodia'),
													 ('Timor-Leste'),
													 ('Indonesia'),
													 ('Laos'),
													 ('Malaysia'),
													 ('Myanmar'),
													 ('Philippines'),
													 ('Singapore'),
													 ('Thailand');
-- END INSERT DATA FOR COUNTRY
-- START INSERT DATA FOR CITY
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Hà Nội',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Hồ Chí Minh',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Hải Phòng',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Đà Nẵng',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Cần Thơ',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('An Giang',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Bà Rịa-Vũng Tàu',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Bắc Giang',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Bắc Kạn',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Bạc Liêu',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Bắc Ninh',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Bến Tre',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Bình Định',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Bình Dương',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Bình Phước',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Bình Thuận',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Cà Mau',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Cao Bằng',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Đắk Lắk',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Đắk Nông',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Điện Biên',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Đồng Nai',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Đồng Tháp',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Gia Lai',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Hà Giang',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Hà Nam',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Hà Tĩnh',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Hải Dương',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Hậu Giang',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Hòa Bình',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Hưng Yên',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Khánh Hòa',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Kiên Giang',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Kon Tum',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Lai Châu',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Lâm Đồng',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Lạng Sơn',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Lào Cai',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Long An',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Nam Định',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Nghệ An',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Ninh Bình',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Ninh Thuận',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Phú Thọ',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Quảng Bình',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Quảng Nam',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Quảng Ngãi',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Quảng Ninh',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Quảng Trị',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Sóc Trăng',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Sơn La',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Tây Ninh',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Thái Bình',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Thái Nguyên',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Thanh Hóa',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Thừa Thiên-Huế',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Tiền Giang',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Trà Vinh',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Tuyên Quang',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Vĩnh Long',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Vĩnh Phúc',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Yên Bái',1);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Phú Yên',1);

INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Kota Batu',2);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Berakas A',2);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Berakas B',2);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Gadong A',2);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Gadong B',2);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Kianggeh',2);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Kilanas',2);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Kota Sentosa',2);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Lumapas',2);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Mentiri',2);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Pengkalan Batu',2);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('SengkurongBukit Sawat',2);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Kuala Balai',2);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Labi',2);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Liang',2);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Melilas',2);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Seria',2);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Sukang',2);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Sungai Liang',2);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Kuala BelaitKiudang',2);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Lamunin',2);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Pekan Tutong',2);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Rambai',2);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Tanjong Maya',2);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Amo',2);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Bangar',2);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Batu Apoi',2);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Bokok',2);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Labu',2);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Puni',2);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Rataie',2);


INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Banteay Meanchey',3);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Battambang',3);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Kampong Cham',3);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Kampong Chhnang',3);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Kampong Speu',3);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Kampong Thom',3);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Kampot',3);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Kandal',3);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Koh Kong',3);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Kratie',3);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Mondulkiri',3);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Oddar Meanchey',3);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Pailin',3);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Phnom Penh',3);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Preah Sihanouk (Sihanoukville)',3);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Preah Vihear',3);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Prey Veng',3);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Pursat',3);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Ratanakiri',3);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Siem Reap',3);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Stung Treng',3);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Svay Rieng',3);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Takeo',3);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Tboung Khmum',3);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Kep',3);


INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Dili',4);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Aileu',4);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Ainaro',4);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Baucau',4);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Bobonaro',4);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Cova Lima',4);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Ermera',4);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Lautém',4);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Liquiçá',4);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Manatuto',4);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Manufahi',4);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Oecusse',4);

INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Aceh',5);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Bali',5);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Bangka Belitung',5);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Banten',5);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Bengkulu',5);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Central Java',5);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Central Kalimantan',5);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Central Sulawesi',5);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('East Java',5);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('East Kalimantan',5);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('East Nusa Tenggara',5);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Gorontalo',5);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Jakarta Special Capital Region',5);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Jambi',5);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Lampung',5);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Maluku',5);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('North Kalimantan',5);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('North Maluku',5);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('North Sulawesi',5);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('North Sumatra',5);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Papua',5);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Riau',5);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Riau Islands',5);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('South Kalimantan',5);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('South Sulawesi',5);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('South Sumatra',5);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Southeast Sulawesi',5);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('West Java',5);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('West Kalimantan',5);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('West Nusa Tenggara',5);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('West Papua',5);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('West Sulawesi',5);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('West Sumatra',5);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Yogyakarta Special Region',5);

INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Attapeu',6);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Bokeo',6);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Bolikhamxay',6);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Champasak',6);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Houaphanh',6);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Khammouane',6);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Luang Namtha',6);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Luang Prabang',6);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Oudomxay',6);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Phongsaly',6);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Salavan',6);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Savannakhet',6);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Sekong',6);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Vientiane',6);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Xieng Khouang',6);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Xaisomboun',6);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Xekong',6);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Xiangkhouang',6);


INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Johor',7);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Kedah',7);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Kelantan',7);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Melaka (Malacca)',7);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Negeri Sembilan',7);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Pahang',7);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Perak',7);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Perlis',7);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Pulau Pinang (Penang)',7);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Sabah',7);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Sarawak',7);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Selangor',7);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Terengganu',7);

INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Kachin State',8);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Kayah State',8);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Kayin State',8);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Chin State',8);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Mon State',8);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Rakhine State',8);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Shan State',8);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Ayeyarwady Region',8);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Bago Region',8);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Magway Region',8);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Mandalay Region',8);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Sagaing Region',8);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Tanintharyi Region',8);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Yangon Region',8);

INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Abra',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Agusan del Norte',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Agusan del Sur',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Aklan',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Albay',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Antique',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Apayao',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Aurora',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Basilan',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Bataan',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Batanes',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Batangas',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Benguet',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Biliran',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Bohol',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Bukidnon',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Bulacan',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Cagayan',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Camarines Norte',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Camarines Sur',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Camiguin',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Capiz',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Catanduanes',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Cavite',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Cebu',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Compostela Valley',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Cotabato',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Davao del Norte',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Davao del Sur',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Davao Occidental',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Davao Oriental',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Dinagat Islands',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Eastern Samar',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Guimaras',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Ifugao',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Ilocos Norte',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Ilocos Sur',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Iloilo',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Isabela',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Kalinga',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('La Union',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Laguna',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Lanao del Norte',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Lanao del Sur',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Leyte',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Maguindanao',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Marinduque',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Masbate',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Misamis Occidental',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Misamis Oriental',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Mountain Province',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Negros Occidental',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Negros Oriental',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Northern Samar',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Nueva Ecija',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Nueva Vizcaya',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Occidental Mindoro',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Oriental Mindoro',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Palawan',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Pampanga',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Pangasinan',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Quezon',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Quirino',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Rizal',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Romblon',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Samar',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Sarangani',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Siquijor',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Sorsogon',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('South Cotabato',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Southern Leyte',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Sultan Kudarat',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Sulu',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Surigao del Norte',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Surigao del Sur',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Tarlac',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Tawi-Tawi',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Zambales',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Zamboanga del Norte',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Zamboanga del Sur',9);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Zamboanga Sibugay',9);


INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Ang Mo Kio',10);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Bedok',10);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Bishan',10);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Boon Lay',10);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Bukit Batok',10);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Bukit Merah',10);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Bukit Panjang',10);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Bukit Timah',10);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Changi',10);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Choa Chu Kang',10);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Clementi',10);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Geylang',10);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Hougang',10);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Jurong East',10);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Jurong West',10);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Kallang/Whampoa',10);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Marine Parade',10);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Pasir Ris',10);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Punggol',10);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Queenstown',10);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Sembawang',10);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Sengkang',10);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Serangoon',10);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Tampines',10);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Tanglin',10);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Toa Payoh',10);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Woodlands',10);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Yishun',10);

INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Amnat Charoen',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Ang Thong',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Bangkok (Krung Thep Maha Nakhon)',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Bueng Kan',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Buri Ram',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Chachoengsao',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Chai Nat',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Chaiyaphum',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Chanthaburi',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Chiang Mai',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Chiang Rai',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Chon Buri',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Chumphon',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Kalasin',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Kamphaeng Phet',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Kanchanaburi',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Khon Kaen',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Krabi',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Lampang',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Lamphun',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Loei',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Lop Buri',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Mae Hong Son',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Maha Sarakham',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Mukdahan',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Nakhon Nayok',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Nakhon Pathom',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Nakhon Phanom',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Nakhon Ratchasima',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Nakhon Sawan',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Nakhon Si Thammarat',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Nan',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Narathiwat',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Nong Bua Lamphu',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Nong Khai',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Nonthaburi',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Pathum Thani',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Pattani',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Phang Nga',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Phatthalung',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Phayao',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Phetchabun',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Phetchaburi',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Phichit',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Phitsanulok',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Phra Nakhon Si Ayutthaya',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Phrae',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Phuket',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Prachin Buri',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Prachuap Khiri Khan',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Ranong',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Ratchaburi',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Rayong',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Roi Et',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Sa Kaeo',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Sakon Nakhon',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Samut Prakan',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Samut Sakhon',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Samut Songkhram',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Saraburi',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Satun',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Sing Buri',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Sisaket',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Songkhla',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Sukhothai',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Suphan Buri',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Surat Thani',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Surin',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Tak',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Trang',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Trat',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Ubon Ratchathani',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Udon Thani',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Uthai Thani',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Uttaradit',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Yala',11);
INSERT INTO e_techplaza.CITY ( `city_name`,`country_id`) VALUES('Yasothon',11);

-- END INSERT DATA FOR CITY

-- START INSERT DATA FOR ROLE
insert into role(created_At,description,role_name,updated_At)
values(now(),'This is Customer Role','CUSTOMER',now());
-- END INSERT DATA FOR ROLE