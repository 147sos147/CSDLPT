use test;



insert into account(email,password,full_name,number_phone,address) values('test1@email.com','$2a$10$zIi1f7c7v1s.mj5NQhvGz..slXaG5LeldTvZxYodoxlRnrptm18FO','test1','0901213','test1');
insert into account(email,password,full_name,number_phone,address) values('test2@email.com','$2a$10$zIi1f7c7v1s.mj5NQhvGz..slXaG5LeldTvZxYodoxlRnrptm18FO','test1','0901213','test1');
insert into account(email,password,full_name,number_phone,address) values('test3@email.com','$2a$10$zIi1f7c7v1s.mj5NQhvGz..slXaG5LeldTvZxYodoxlRnrptm18FO','test1','0901213','test1');
insert into account(email,password,full_name,number_phone,address) values('test4@email.com','$2a$10$zIi1f7c7v1s.mj5NQhvGz..slXaG5LeldTvZxYodoxlRnrptm18FO','test1','0901213','test1');

insert into account_role(id_account,id_role) values(3,2);
insert into account_role(id_account,id_role) values(4,2);
insert into account_role(id_account,id_role) values(5,2);
insert into account_role(id_account,id_role) values(6,2);


INSERT INTO branch(name_branch,address) values ('Chi nhánh Hồ Chí Minh','126 Ngô Quyền quận 7 HCM');
INSERT INTO branch(name_branch,address) values ('Chi Nhánh Hà Nội','126 Đống Đa,quận Hoàn Kiếm');
INSERT INTO branch(name_branch,address) values ('Chi Nhánh Đà Nẵng','126 Hàm Nghi, quận 3, ĐN');



INSERT INTO product(name_product,type_product,price,information,id_branch) values('Iphone 10','Dien Thoai',3000,'Thong tin san pham',3);
INSERT INTO product(name_product,type_product,price,information,id_branch) values('Iphone 11','Dien Thoai',4000,'Thong tin san pham',2);
INSERT INTO product(name_product,type_product,price,information,id_branch) values('Iphone 12','Dien Thoai',3000,'Thong tin san pham',1);
INSERT INTO product(name_product,type_product,price,information,id_branch) values('Iphone 13','Dien Thoai',2000,'Thong tin san pham',1);
INSERT INTO product(name_product,type_product,price,information,id_branch) values('Iphone 14','Dien Thoai',5000,'Thong tin san pham',2);
INSERT INTO product(name_product,type_product,price,information,id_branch) values('Iphone 15','Dien Thoai',6000,'Thong tin san pham',3);
INSERT INTO product(name_product,type_product,price,information,id_branch) values('Iphone 16','Dien Thoai',3000,'Thong tin san pham',2);
INSERT INTO product(name_product,type_product,price,information,id_branch) values('Iphone 17','Dien Thoai',5000,'Thong tin san pham',1);
