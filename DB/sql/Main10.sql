-- 創建資料庫
CREATE DATABASE IF NOT EXISTS db06_sym;
-- 使用資料庫
use db06_sym;

/*==========================================================================*/
-- 總共26張表
DROP TABLE IF EXISTS orderDetail;
drop table if exists advertise;
DROP TABLE IF EXISTS `order`;
DROP TABLE IF EXISTS groupBuyOrder;
drop table if exists msgOfAdministratorAndMember;
drop table if exists msgOfShopAndMember;
drop table if exists msgOfAdministratorAndShop;
drop table if exists groupBuyDiscount;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS storeBlockList;
DROP TABLE IF EXISTS couponUsageHistory;
drop table if exists chatRoomOfShopAndMember;
drop table if exists chatRoomOfMemberAndAdministrator;
drop table if exists memberBlockList;
drop table if exists chatRoomOfShopAndAdministrator;
drop table if exists groupBuying;
DROP TABLE IF EXISTS productSec;
DROP TABLE IF EXISTS store;
DROP TABLE IF EXISTS shoppingGoldRecord;
DROP TABLE IF EXISTS creditCard;
drop table if exists announcement;
DROP TABLE IF EXISTS productMain;
DROP TABLE IF EXISTS coupon;
DROP TABLE IF EXISTS member;
DROP TABLE IF EXISTS groupBuyProduct;
DROP TABLE IF EXISTS administrator;
DROP VIEW IF EXISTS v_memberblocklist;
DROP VIEW IF EXISTS category;





-- select * from orderDetail;
-- select * from advertise;
-- select * from `order`;
-- select * from groupBuyOrder;
-- select * from msgOfAdministratorAndMember;
-- select * from msgOfShopAndMember;
-- select * from msgOfAdministratorAndShop;
-- select * from groupBuyDiscount;
-- select * from product;
-- select * from storeBlockList;
-- select * from couponUsageHistory;
-- select * from chatRoomOfShopAndMember;
-- select * from chatRoomOfMemberAndAdministrator;
-- select * from memberBlockList;
-- select * from chatRoomOfShopAndAdministrator;
-- select * from groupBuying;
-- select * from productSec;
-- select * from store;
-- select * from shoppingGoldRecord;
-- select * from creditCard;
-- select * from announcement;
-- select * from productMain;
-- select * from coupon;
-- select * from member;
-- select * from groupBuyProduct;
-- Select * from administrator;
/*==========================================================================*/
-- 沒有外來鍵  5張表
-- DROP TABLE IF EXISTS productMain;
-- DROP TABLE IF EXISTS coupon;
-- DROP TABLE IF EXISTS member;
-- DROP TABLE IF EXISTS groupBuyProduct;
-- DROP TABLE IF EXISTS administrator;


-- select * from productMain;
-- select * from coupon;
-- select * from member;
-- select * from groupBuyProduct;
-- Select * from administrator;
/*==========================================================================*/
-- 一個外來鍵 跟 依賴一個外來鍵 外來鍵又有一個外來鍵 6張表
-- DROP TABLE IF EXISTS productSec;
-- DROP TABLE IF EXISTS store;
-- DROP TABLE IF EXISTS shoppingGoldRecord;
-- DROP TABLE IF EXISTS creditCard;
-- drop table if exists announcement;

-- select * from productSec;
-- select * from store;
-- select * from shoppingGoldRecord;
-- select * from creditCard;
-- select * from announcement;
/*==========================================================================*/
-- 兩個外來鍵 8張表
-- DROP TABLE IF EXISTS product;
-- DROP TABLE IF EXISTS storeBlockList;
-- DROP TABLE IF EXISTS couponUsageHistory;
-- drop table if exists chatRoomOfShopAndMember;
-- drop table if exists chatRoomOfMemberAndAdministrator;
-- drop table if exists memberBlockList;
-- drop table if exists chatRoomOfShopAndAdministrator;
-- drop table if exists groupBuying;


-- select * from product;
-- select * from storeBlockList;
-- select * from couponUsageHistory;
-- select * from chatRoomOfShopAndMember;
-- select * from chatRoomOfMemberAndAdministrator;
-- select * from memberBlockList;
-- select * from chatRoomOfShopAndAdministrator;
-- select * from groupBuying;

/*==========================================================================*/
-- 一個外來鍵  但是外來鍵 依賴 兩個外來鍵 4張表 
-- drop table if exists msgOfAdministratorAndMember;
-- drop table if exists msgOfShopAndMember;
-- drop table if exists msgOfAdministratorAndShop;
-- drop table if exists groupBuyDiscount;

-- select * from msgOfAdministratorAndMember;
-- select * from msgOfShopAndMember;
-- select * from msgOfAdministratorAndShop;
-- select * from groupBuyDiscount;

/*==========================================================================*/
-- 三個外來鍵 2張表
-- DROP TABLE IF EXISTS `order`;
-- DROP TABLE IF EXISTS groupBuyOrder;

-- select * from `order`;
-- select * from groupBuyOrder;
/*==========================================================================*/
-- 兩個外來鍵 依賴多個外來鍵 2張表
-- DROP TABLE IF EXISTS orderDetail;
-- drop table if exists advertise;

-- select * from orderDetail;
-- select * from advertise;
/*==========================================================================*/
-- create table 商品主分類 
create table productMain(
	productMainID int not null auto_increment comment '商品主分類ID',
    productMainName varchar(200) not null comment '商品主分類名稱',
    primary key(productMainID)
); 
INSERT INTO productMain (productMainName) VALUES('3C');
INSERT INTO productMain (productMainName) VALUES('周邊');
INSERT INTO productMain (productMainName) VALUES('精品');
INSERT INTO productMain (productMainName) VALUES('家電');
INSERT INTO productMain (productMainName) VALUES('日用');
INSERT INTO productMain (productMainName) VALUES('食品');
INSERT INTO productMain (productMainName) VALUES('服飾');




-- 優惠券
CREATE TABLE coupon (
	couponID int auto_increment comment'優惠券ID',
    couponName varchar(200) comment '優惠券名稱',
    startDate timestamp comment '有效期起',
    endDate timestamp comment '有效期止',
    discount double(20,2)comment '優惠折數',
    discountAmount int comment '折抵金額',
    fullCondition int comment '滿額條件減金額',
    couponTimeBegins timestamp comment '搶券時間起',
    couponTimeEnd timestamp comment '搶券時間止',
    exchangeAmount int(200) comment '已兌換數量',
    couponPicture Longblob comment '優惠券圖片',
    couponDescription Varchar(500) comment '優惠券描述',
    primary key(couponID)
);

insert into coupon (couponName, startDate, endDate, discount, discountAmount, fullCondition, couponTimeBegins, couponTimeEnd, exchangeAmount, couponPicture, couponDescription)
values
('全館優惠85折', '2022-11-11', '2022-11-22', '0.85', '0', '0', '2022-11-08', '2022-11-10', '200', '', '
'),
('全館優惠85折', '2022-11-12', '2022-11-23', '0.85', '0', '0', '2022-11-10', '2022-11-11', '200', '', '優惠券每筆訂單只限一個賣場一次使用'),
('全館滿額折抵100', '2022-11-13', '2022-11-24', '1', '100', '1000', '2022-11-11', '2022-11-12', '200', '', '優惠券每筆訂單只限一個賣場一次使用'),
('全館滿額折抵200', '2022-11-14', '2022-11-25', '1', '200', '1500', '2022-11-12', '2022-11-13', '200', '', '優惠券每筆訂單只限一個賣場一次使用'),
('全館優惠85折', '2022-11-15', '2022-11-26', '0.85', '0', '0', '2022-11-14', '2022-11-15', '200', '', '優惠券每筆訂單只限一個賣場一次使用'),
('全館優惠85折', '2022-11-16', '2022-11-27', '0.85', '0', '0', '2022-11-14', '2022-11-15', '200', '', '優惠券每筆訂單只限一個賣場一次使用');



-- 會員資料
CREATE TABLE member (
	memberID int not null auto_increment comment '會員ID',
    userAccount varchar(200) comment '使用者帳號',
    userPassword varchar(200) comment '使用者密碼',
    userName varchar(200) comment '使用者姓名',
    phone varchar(200) comment '會員電話',
    mail varchar(200) comment '信箱',
    gender varchar(200)  comment '性別',
    birthday date comment '生日',
    userPhoto longblob comment '照片',
    registrationTime datetime comment '註冊時間',
    mailCertification boolean comment '信箱認證',
    idNumber varchar(200) comment '身分證字號',
    address varchar(200) comment '收件地址',
    sellerAuditApprovalState boolean comment '賣家審核狀態',
    currentShoppingCoin int comment '當前購物金總額customer',
    primary key(memberID)
);

INSERT INTO member (userAccount,userPassword,userName,mail,gender,registrationTime,mailCertification,sellerAuditApprovalState,currentShoppingCoin) 
VALUES('A123456','aaaaaa','與決','1234@gmail.com','M',now(),0,0,0);
INSERT INTO member (userAccount,userPassword,userName,mail,gender,registrationTime,mailCertification,sellerAuditApprovalState,currentShoppingCoin) 
VALUES('B123456','aaaaaa','土豪','5678@gmail.com','M',now(),0,0,0);
INSERT INTO member (userAccount,userPassword,userName,mail,gender,registrationTime,mailCertification,sellerAuditApprovalState,currentShoppingCoin) 
VALUES('C123456','aaaaaa','企鵝','abcd@gmail.com','M',now(),0,0,0);
INSERT INTO member (userAccount,userPassword,userName,mail,gender,registrationTime,mailCertification,sellerAuditApprovalState,currentShoppingCoin) 
VALUES('D123456','aaaaaa','議員','wasd@gmail.com','M',now(),0,0,0);
INSERT INTO member (userAccount,userPassword,userName,mail,gender,registrationTime,mailCertification,sellerAuditApprovalState,currentShoppingCoin) 
VALUES('E123456','aaaaaa','彥峰','rgfrg@gmail.com','M',now(),0,0,0);
INSERT INTO member (userAccount,userPassword,userName,mail,gender,registrationTime,mailCertification,sellerAuditApprovalState,currentShoppingCoin) 
VALUES('F123456','aaaaaa','彥和','wqdwqew@gmail.com','M',now(),0,0,0);
INSERT INTO member (userAccount,userPassword,userName,mail,registrationTime,mailCertification,sellerAuditApprovalState,currentShoppingCoin) 
VALUES('F123456','aaaaaa','彥和','wqdwqew@gmail.com',now(),0,0,0);



-- 團購商品
CREATE TABLE groupBuyProduct(
	groupbuyProductID int auto_increment comment'團購商品ID',
    groupbuyProductPrice int comment'團購商品原價',
    groupbuyProductPicture longblob comment'團購商品圖片',
    groupbuyProductDescrip varchar(200) comment'團購商品描述',
    primary key(groupbuyProductID)
);
-- 假資料
INSERT INTO groupBuyProduct(groupbuyProductPrice,groupbuyProductDescrip) 
VALUES(666,"好東西");   


-- 管理員
create table administrator (
administratorID int not null auto_increment comment '管理員編號',
administratorAccount varchar(25) not null comment '管理員帳號',
administratorPassword varchar(25) not null comment '管理員密碼',
buildTime date comment '創建時間',
lastLogin timestamp default current_timestamp on update current_timestamp comment '上次登入',
primary key(administratorID)
);

insert into  administrator (administratorAccount, administratorPassword)
values 
('AD0001', '123'),
('AD0002', '123'),
('AD0003', '123'),
('AD0004', '123'),
('AD0005', '123');



/*==========================================================================*/
-- 以上5張表
/*==========================================================================*/

-- create table 商品次分類
create table productSec(
	productSecID int not null auto_increment comment '商品次分類ID',
    productMainID int not null comment '商品主分類ID',
    productSecName varchar(200) not null comment '商品次分類',
    primary key(productSecID),
    constraint FK_productSec_productMainID foreign key(productMainID)
    references productMain(productMainID)
); 

INSERT INTO productSec (productMainID,productSecName) VALUES('1','桌上型電腦');
INSERT INTO productSec (productMainID,productSecName) VALUES('1','手機');
INSERT INTO productSec (productMainID,productSecName) VALUES('1','隨身碟');
INSERT INTO productSec (productMainID,productSecName) VALUES('1','螢幕');
INSERT INTO productSec (productMainID,productSecName) VALUES('1','筆記型電腦');
INSERT INTO productSec (productMainID,productSecName) VALUES('2','美甲');
INSERT INTO productSec (productMainID,productSecName) VALUES('2','沙龍髮品');
INSERT INTO productSec (productMainID,productSecName) VALUES('2','保養');
INSERT INTO productSec (productMainID,productSecName) VALUES('2','肥皂');
INSERT INTO productSec (productMainID,productSecName) VALUES('2','香水');
INSERT INTO productSec (productMainID,productSecName) VALUES('3','珠寶');
INSERT INTO productSec (productMainID,productSecName) VALUES('3','飾品');
INSERT INTO productSec (productMainID,productSecName) VALUES('3','鐘錶');
INSERT INTO productSec (productMainID,productSecName) VALUES('3','包包');
INSERT INTO productSec (productMainID,productSecName) VALUES('3','皮夾');
INSERT INTO productSec (productMainID,productSecName) VALUES('4','冰箱');
INSERT INTO productSec (productMainID,productSecName) VALUES('4','電視');
INSERT INTO productSec (productMainID,productSecName) VALUES('4','洗衣機');
INSERT INTO productSec (productMainID,productSecName) VALUES('4','烘碗機');
INSERT INTO productSec (productMainID,productSecName) VALUES('4','冷氣');
INSERT INTO productSec (productMainID,productSecName) VALUES('5','沙發');
INSERT INTO productSec (productMainID,productSecName) VALUES('5','椅子');
INSERT INTO productSec (productMainID,productSecName) VALUES('5','桌子');
INSERT INTO productSec (productMainID,productSecName) VALUES('5','床');
INSERT INTO productSec (productMainID,productSecName) VALUES('5','櫃子');
INSERT INTO productSec (productMainID,productSecName) VALUES('6','泡麵');
INSERT INTO productSec (productMainID,productSecName) VALUES('6','飲料');
INSERT INTO productSec (productMainID,productSecName) VALUES('6','麵包');
INSERT INTO productSec (productMainID,productSecName) VALUES('6','罐頭');
INSERT INTO productSec (productMainID,productSecName) VALUES('6','調味醬');
INSERT INTO productSec (productMainID,productSecName) VALUES('7','上衣');
INSERT INTO productSec (productMainID,productSecName) VALUES('7','褲子');
INSERT INTO productSec (productMainID,productSecName) VALUES('7','裙子');
INSERT INTO productSec (productMainID,productSecName) VALUES('7','全身衣物');
INSERT INTO productSec (productMainID,productSecName) VALUES('7','帽子');



-- create table 賣場
create table store(
	storeID int not null auto_increment comment '賣場ID',
    memberID int not null comment '會員ID',
    storeName varchar(200) not null comment '賣場名稱',
    storeDelBankCode varchar(200) not null comment '賣場銀行代碼',
    storeBankAccount varchar(200) not null comment '賣場銀行帳號',
    storeAddress varchar(200) not null comment '賣場地址',
    phoneNumber varchar(200) not null comment '連絡電話',
    createDate datetime not null comment '賣場創建時間',
    updateDate datetime not null comment '賣場更新日期',
    taxID varchar(200) not null comment '統一編號',
    storeAuditStatus int not null comment '賣場審核狀態',
    primary key(storeID),
    constraint FK_store_memberID foreign key(memberID)
    references member(memberID)
); 

INSERT INTO store (memberID,storeName,storeDelBankCode,storeBankAccount,storeAddress,phoneNumber,createDate,updateDate,taxID,storeAuditStatus) 
VALUES('1','與決賣場','Q123456','W123456','西門町','123456789',now(),now(),'OX123456',1);
INSERT INTO store (memberID,storeName,storeDelBankCode,storeBankAccount,storeAddress,phoneNumber,createDate,updateDate,taxID,storeAuditStatus) 
VALUES('2','土豪賣場','A123456','S123456','內湖','234567891',now(),now(),'XO123456',1);
INSERT INTO store (memberID,storeName,storeDelBankCode,storeBankAccount,storeAddress,phoneNumber,createDate,updateDate,taxID,storeAuditStatus) 
VALUES('3','與決賣場','Z123456','X123456','中和','34567891',now(),now(),'KO123456',1);


-- 購物金紀錄
CREATE TABLE shoppingGoldRecord(
	shoppingGoldRecordID int not null auto_increment comment '購物金歷程',
    memberID int not null comment '會員ID',
    useDate timestamp comment '使用日期',
    obtainShoppingCoin int comment '購物金異動金額',
    plusOrMinus boolean not null comment '0:使用 / 1:獲得',
    primary key(shoppingGoldRecordID),
    constraint Fk_shoppingGoldRecord_memberID foreign key(memberID)
    references member(memberID)
);

insert into shoppingGoldRecord(memberID, useDate, obtainShoppingCoin, plusOrMinus)
values
('1', '2022-11-12', '100', '0'),
('2', '2022-11-13', '100', '0'),
('3', '2022-11-14', '100', '1'),
('1', '2022-11-15', '100', '1'),
('1', '2022-11-16', '50', '1'),
('2', '2022-11-17', '30', '1');


-- 信用卡
CREATE TABLE creditCard (
	creditCardID int not null auto_increment comment '信用卡ID',
    memberID int not null comment '會員ID',
    creditcardNumber varchar(200) comment '信用卡卡號',
    securityCode varchar(200) comment '信用卡安全碼',
	exDate Date comment '信用卡到期日',
    primary key(creditCardID),
    constraint FK_creditCard_memberID foreign key(memberID)
    references member(memberID)
);

INSERT INTO creditCard (memberID,creditcardNumber,securityCode,exDate)
VALUES('1','ASDF123456','wx996','20230501');
INSERT INTO creditCard (memberID,creditcardNumber,securityCode,exDate)
VALUES('2','QWER123456','EX007','20230501');


-- 公告消息
create table announcement (
announcementSerialID int auto_increment comment "公告流水編號",
administratorID int comment '管理員編號',
announcementTitle varchar(200) comment "公告標題",
announcementContent varchar(500) comment "公告內容",
startDate date comment "開始日期",
endDate date comment "結束日期",
updateTime timestamp default current_timestamp on update current_timestamp comment "更新時間",
offLoadStatus boolean comment "上架狀態 : 0 : ON / 1: OFF",
showStatus boolean  comment "0 : 首頁 / 1: 賣場",
primary key(announcementSerialID)
-- constraint Fk_announcement_administratorID
-- 	foreign key (administratorID)
-- 	references administrator(administratorID)
);

INSERT INTO announcement (administratorID, announcementTitle, announcementContent, startDate, endDate, updateTime, offLoadStatus, showStatus)
VALUES
('1', '賣場公告', '滿百免運', '2022-11-11', '2022-11-20', now(), 1, 1),
('2', '賣場公告', '滿千打九折', '2022-11-11', '2022-11-20', now(), 0, 1),
('3', '最新消息', '團購活動開跑囉！', '2022-11-11', '2022-11-20', now(), 0, 0),
('1', '最新消息', '甘霖涼～～～', '2022-11-11', '2022-11-20', now(), 1, 0),
('1', '最新消息', '非常涼～～～', '2022-11-11', '2022-11-20', now(), 0, 0),
('1', '最新消息', '非常涼～～～', '2022-12-31', '2022-11-20', now(), 0, 0);


/*==========================================================================*/
-- 以上5張表  累計11張表
/*==========================================================================*/


-- create table 商品
create table product(
	productID int not null auto_increment comment '商品ID',
    storeID int not null comment '賣場ID',
    productSecID int not null comment '商品次分類ID',
    productName varchar(200) not null comment '商品名稱',
    productStock int not null comment '商品庫存數量',
    productDesc varchar(200) comment '商品描述',
    productPrice int comment '商品價格',
    source varchar(200) not null comment '出貨地',
    productImg longblob comment "商品圖片",
    productImg2 longblob comment "商品圖片2",
    productImg3 longblob comment "商品圖片3",
    insertTime datetime not null comment "新增商品時間",
    productStatus int not null comment "商品狀態",
    commentTotal int comment "評價總人數",
    commentAvgStar double comment "評價平均星數",
    primary key(productID),
    constraint FK_product_productSecID foreign key(productSecID)
    references productSec(productSecID),
    constraint FK_product_storeID foreign key(storeID)
    references store(storeID)
); 
INSERT INTO product (storeID,productSecID,productName,productStock,productDesc,productPrice,source,insertTime,productStatus) 
VALUES('1','1','華碩桌上型電腦','200000','可以拿來打遊戲的桌上型電腦','50000','中國小黃人製造',now(),'1');
INSERT INTO product (storeID,productSecID,productName,productStock,productDesc,productPrice,source,insertTime,productStatus) 
VALUES('1','2','小米手機','600000','可以拿來打電話的小黃人手機','5000','中國小黃人製造',now(),'1');
INSERT INTO product (storeID,productSecID,productName,productStock,productDesc,productPrice,source,insertTime,productStatus) 
VALUES('1','3','ForFun隨身碟','10000','可以拿來儲存資料的裝置','500','中國小黃人製造',now(),'1');
INSERT INTO product (storeID,productSecID,productName,productStock,productDesc,productPrice,source,insertTime,productStatus) 
VALUES('1','4','三星螢幕','3000','可以拿來顯示資料的神奇物品','1000','中國小黃人製造',now(),'1');
INSERT INTO product (storeID,productSecID,productName,productStock,productDesc,productPrice,source,insertTime,productStatus) 
VALUES('1','5','聯想筆記本電腦','10','可以拿來打遊戲的筆記型電腦','20000','中國小黃人製造',now(),'1');
INSERT INTO product (storeID,productSecID,productName,productStock,productDesc,productPrice,source,insertTime,productStatus) 
VALUES('1','6','Glaze凝膠美甲貼','200000','可以拿來貼指甲的道具','100','中國小黃人製造',now(),'1');
INSERT INTO product (storeID,productSecID,productName,productStock,productDesc,productPrice,source,insertTime,productStatus) 
VALUES('1','7','柳屋-髮根營養液','600','可以拿來催生頭髮的魔法道具','50000000','中國小黃人製造',now(),'1');
INSERT INTO product (storeID,productSecID,productName,productStock,productDesc,productPrice,source,insertTime,productStatus) 
VALUES('2','8','SK-II_青春露-330ml','200000','可以讓人短暫回復青春的詛咒商品','33333333','中國小黃人製造',now(),'1');
INSERT INTO product (storeID,productSecID,productName,productStock,productDesc,productPrice,source,insertTime,productStatus) 
VALUES('2','9','阿原-抹草皂4入','600000','有阿罵味道的肥皂','500','中國小黃人製造',now(),'1');
INSERT INTO product (storeID,productSecID,productName,productStock,productDesc,productPrice,source,insertTime,productStatus) 
VALUES('2','10','CREED阿文圖斯龍蘊','10000','真香','50000','中國小黃人製造',now(),'1');
INSERT INTO product (storeID,productSecID,productName,productStock,productDesc,productPrice,source,insertTime,productStatus) 
VALUES('2','11','【大東山珠寶】天然小米粒珍珠項鍊 輕時尚氣質','2000','小黃人專用項鍊','3000','中國小黃人製造',now(),'1');
INSERT INTO product (storeID,productSecID,productName,productStock,productDesc,productPrice,source,insertTime,productStatus) 
VALUES('2','12','拉福，層次新郎結婚領結糾糾(深藍)','10','這可以幹嘛','200','中國小黃人製造',now(),'1');
INSERT INTO product (storeID,productSecID,productName,productStock,productDesc,productPrice,source,insertTime,productStatus) 
VALUES('2','13','CASIO G-SHOCK 秘境海岸系列農家橡樹計時錶/','200000','稀有道具','999999999','中國小黃人製造',now(),'1');
INSERT INTO product (storeID,productSecID,productName,productStock,productDesc,productPrice,source,insertTime,productStatus) 
VALUES('2','14','柳屋-【LINE FRIENDS】JOLIE雙面兩用斜背包','600','可以拿來放道具的道具','5000','中國小黃人製造',now(),'1');



-- create table 賣場黑名單
create table storeBlockList(
	blockListID int not null auto_increment comment '賣場黑名單ID',
    memberID int not null comment '買家ID',
    storeID int not null comment '賣場ID',
    primary key(blockListID),
    constraint FK_storeBlockList_memberID foreign key(memberID)
    references member (memberID),
    constraint FK_storeBlockList_storeID foreign key(storeID)
    references store(storeID)
); 

INSERT INTO storeBlockList (memberID,storeID) VALUES('4','1');
INSERT INTO storeBlockList (memberID,storeID) VALUES('5','1');
INSERT INTO storeBlockList (memberID,storeID) VALUES('6','1');


-- 優惠券使用紀錄
CREATE TABLE couponUsageHistory(
	memberID int not null comment '會員ID',
    couponID int comment '優惠券ID',
    usageRecord boolean not null comment "使用紀錄 : 0 : false / 1 : true",
    useDate timestamp comment "使用日期",
    
    constraint Fk_couponUsageHistory_memberID foreign key(memberID)
    references member(memberID),
    constraint Fk_couponUsageHistory_couponID foreign key(couponID)
    references coupon(couponID)
);

insert into couponUsageHistory(memberID,couponID, usageRecord, useDate)
values
('1','1', '0', '2022-11-12'),
('1','2', '0', '2022-11-13'),
('1','3', '1', '2022-11-14');


-- 聊天室_賣場和會員
CREATE TABLE chatRoomOfShopAndMember(
chatRoomID int not null auto_increment comment '聊天室ID',
storeID int not null comment '賣場ID',
memberID int not null comment '會員ID',
primary key(chatRoomID),
constraint FK_chatRoomOfShopAndMember_storeID foreign key(storeID)
references store(storeID),
constraint FK_chatRoomOfShopAndMember_memberID foreign key(memberID)
references member(memberID)
) comment'買賣家聊天室';

INSERT INTO chatRoomOfShopAndMember(storeID, memberID) 
VALUES
('1', '1');


-- 聊天室_管理員和會員
CREATE TABLE chatRoomOfMemberAndAdministrator(
chatRoomID int not null auto_increment comment '聊天室ID',
memberID int not null comment '會員ID',
administratorID int not null comment '管理員ID',
primary key(chatRoomID),
constraint FK_chatRoomOfMemberAndAdministrator_memberID foreign key(memberID)
references member(memberID),
constraint FK_chatRoomOfMemberAndAdministrator_administratorID foreign key(administratorID)
references administrator(administratorID)
) comment'客服買家聊天室';


insert into chatRoomOfMemberAndAdministrator (memberID, administratorID)
VALUES
('1', '1');


-- 會員黑名單
CREATE TABLE memberBlockList (
	blockListID int not null auto_increment comment '會員黑名單ID',
    memberID int not null comment '會員ID',
    storeID int not null comment '賣場ID',
    primary key(blockListID),
    constraint FK_memberBlockList_memberID foreign key(memberID)
    references member(memberID),
    constraint FK_memberBlockList_storeID foreign key(storeID)
    references store(storeID)
);

INSERT INTO memberBlockList (memberID,storeID)
VALUES('6','1');
INSERT INTO memberBlockList (memberID,storeID)
VALUES('5','2');


-- 聊天室_管理員和賣場
CREATE TABLE chatRoomOfShopAndAdministrator(
chatRoomID int not null auto_increment comment '聊天室ID',
storeID int not null comment '賣場ID',
administratorID int not null comment '管理員ID',
primary key(chatRoomID),
constraint FK_chatRoomOfShopAndAdministrator_shopID foreign key(storeID)
references store(storeID),
constraint FK_chatRoomOfShopAndAdministrator_administratorID foreign key(administratorID)
references administrator(administratorID)
) comment'客服賣場聊天室';


insert into chatRoomOfShopAndAdministrator (storeID, administratorID)
values
('1', '1'),
('2', '1');

-- 團購管理
create table groupBuying (
groupBuyID int not null auto_increment comment '團購編號ID',
groupBuyProductID int not null comment '團購商品ID',
administratorID int not null comment '管理員編號',
groupBuyProductOrderTotal int not null comment '團購商品訂購總數量',
groupBuyingState Boolean not null comment '團購狀態',
groupBuyingOnLoadDate date not null comment '團購上架日期', 
groupBuyingOffLoadDate date not null comment '團購下架日期',
updateTime timestamp default current_timestamp() on update current_timestamp comment '更新時間',
primary key(groupBuyID),
constraint Fk_groupBuying_administratorID
	foreign key (administratorID)
	references administrator(administratorID)
);

insert into groupBuying (groupBuyProductID, administratorID, groupBuyProductOrderTotal, groupBuyingState, groupBuyingOnLoadDate, groupBuyingOffLoadDate, updateTime)
values
('1', '1', '0', '0', '2022-11-11', '2022-11-20', now()),
('2', '2', '0', '1', '2022-11-11', '2022-11-20', now()),
('3', '3', '0', '1', '2022-11-11', '2022-11-20', now());

/*==========================================================================*/
-- 以上8張表  累計19張表
/*==========================================================================*/

-- 訊息_管理員和會員
CREATE TABLE msgOfAdministratorAndMember(
msgID int not null auto_increment comment '訊息ID',
chatRoomID int not null comment '聊天室ID',
msg varchar(500) comment '訊息內容',
sender int default 0 comment '0買家1客服',
primary key(msgID),
constraint FK_msgOfAdministratorAndMember_chatRoomID foreign key(chatRoomID)
references chatRoomOfMemberAndAdministrator(chatRoomID)
) comment '客服買家聊天訊息';	


insert into msgOfAdministratorAndMember (chatRoomID, msg, sender)
values
( '1', 'XXXXX', '0'),
( '1', 'YYYYY', '1');

-- 訊息_賣場和會員
CREATE TABLE msgOfShopAndMember(
msgID int not null auto_increment comment '訊息ID',
chatRoomID int not null comment '聊天室ID',
msg varchar(500) comment '訊息內容',
sender int default 0 comment '0賣家1買家',
primary key(msgID),
constraint FK_msgOfShopAndMember_chatRoomID foreign key(chatRoomID)
references chatRoomOfShopAndMember(chatRoomID)
) comment '買賣家聊天訊息';

insert into msgOfShopAndMember (chatRoomID, msg, sender)
VALUES
('1', 'HI~你好！我是買家', '0');


-- 訊息_管理員和賣場
CREATE TABLE msgOfAdministratorAndShop(
msgID int not null auto_increment comment '訊息ID',
chatRoomID int not null comment '聊天室ID',
msg varchar(500) comment '訊息內容',
sender int default 0 comment '0賣場1客服',
primary key(msgID),
constraint FK_msgOfAdministratorAndShop_chatRoomID foreign key(chatRoomID)
references chatRoomOfShopAndAdministrator(chatRoomID)
) comment '客服賣場聊天訊息';	

insert into msgOfAdministratorAndShop (chatRoomID, msg, sender)
values
(  '1',  'XXXXX', '1'),
(  '1',  'XXXXX', '1');


-- 折扣表
CREATE TABLE groupBuyDiscount(
	countTableID int auto_increment comment '折扣表編號',
    groupBuyID int comment '團購編號ID',
	groupBuyProductOrderTotal int comment '團購商品訂購總數',
	groupBuyCount double comment '折扣數',
	primary key(countTableID),
	constraint FK_groupBuyDiscount_groupBuyID foreign key(groupBuyID)
	references groupBuying(groupBuyID)
	);
    INSERT INTO groupBuyDiscount(groupBuyID,
    groupBuyProductOrderTotal,groupBuyCount)
    VALUES(1,1000,0.9);
    
/*==========================================================================*/
-- 以上4張表  累計22張表
/*==========================================================================*/

-- create table 訂單
create table `order`(
	orderID int not null auto_increment comment '訂單ID',
    storeID int not null comment '賣場ID',
    storeName varchar(200) not null comment '賣場名稱',
    memberID int not null comment '會員ID',
    orderDate datetime not null comment '訂單日期',
    orderStatus int not null comment '訂單狀態',
    receiver varchar(200) not null comment '收件人',
    phone varchar(200) not null comment '聯絡人電話',
    creditcardNumber varchar(200) comment '信用卡號',
    address varchar(200) not null comment '寄送地址',
    payType varchar(200) not null comment '付款方式',
	couponID int comment '優惠券ID',
    originalTotal int not null comment '原總金額',
    useShoppingGold int not null comment '購物折抵金額',
    useCouponGold int not null comment '優惠券折抵金額',
    finalTotal int not null comment '最後總金額',
    primary key(orderID),
    constraint FK_order_storeID foreign key(storeID)
    references store(storeID),
    constraint FK_order_memberID foreign key(memberID)
    references member(memberID),
    constraint FK_order_couponID foreign key(couponID)
    references coupon(couponID)
); 

INSERT INTO `order`(storeID, storeName, memberID,orderDate,orderStatus,receiver,phone,address,payType,originalTotal,useShoppingGold,useCouponGold,finalTotal)
 VALUES('1', '玩具店','4',now(),'0','議員','0911111111','中和','貨到付款','500','0','0','500');
INSERT INTO `order` (storeID, storeName, memberID,orderDate,orderStatus,receiver,phone,address,payType,originalTotal,useShoppingGold,useCouponGold,finalTotal)
 VALUES('1', '二手', '5',now(),'0','彥峰','0911111111','台北','貨到付款','1000','0','0','1000');


-- 團購訂單
CREATE TABLE groupBuyOrder(
	groupBuyOrderId int auto_increment comment'團購訂單ID',
    groupBuyID int comment '團購ID',
	memberID int comment '會員ID',
    groupBuyProductID int comment '團購商品ID',
    groupBuyQuantity int comment '訂購數量',
    groupBuyTotal int comment '結帳金額',
    orderTime timestamp comment '訂單日期',
    paymentTerm varchar(200) comment '付款方式',
    paymentState boolean comment '結帳狀態',
    giftVoucher int comment '購物金折抵返還',
    contactNumber varchar(200) comment '連絡電話',
    shippingLocation varchar(200) comment '運送地點',
    primary key(groupBuyOrderId),
    constraint FK_groupBuyOrder_groupBuyID foreign key(groupBuyID)
    references groupBuying(groupBuyID),
    constraint FK_groupBuyOrder_memberID foreign key(memberID)
    references member(memberID),
    constraint FK_groupBuyOrder_groupBuyProductID foreign key(groupBuyProductID)
    references groupBuyProduct(groupBuyProductID)
    );

INSERT INTO groupBuyOrder (memberID,groupBuyProductID,groupBuyQuantity,
groupBuyTotal,orderTime,paymentTerm,paymentState,giftVoucher,
contactNumber,shippingLocation) 
VALUES(1,1,20,1000,now(),"信用卡",1,50,"0975119374","台北市");

/*==========================================================================*/
-- 以上2張表  累計24張表
/*==========================================================================*/

-- create table 訂單明細
create table orderDetail(
	orderDetailID int not null auto_increment comment '訂單明細ID', 
	orderID int not null comment '訂單ID',
    productID int not null comment '商品ID',
    productName varchar(200) not null comment '商品名稱',
    userAccount varchar(200) comment '會員帳號',
    orderDate datetime comment '訂單日期',
    quantity int not null comment '訂購數量',
    price int not null comment '訂購單價',
    subTotal int not null comment '小計',
    shopReview int comment '訂單評價(賣場對買家)',
    shopComment varchar(200) comment '訂單評論(賣場對買家)',
    buyerReview int comment '訂單評價(買家對賣場)',
    buyerComment varchar(200) comment '訂單評論(買家對賣場)',
    buyerCommentPic longblob comment '評價圖片(買家對賣場)',
    primary key(orderDetailID),
    constraint FK_orderDetail_orderID foreign key(orderID)
    references `order`(orderID),
    constraint FK_orderDetail_productID foreign key(productID)
    references product(productID)
); 

INSERT INTO orderDetail (orderID, productID, productName, quantity, price,subTotal) 
VALUES('1','1', '公仔','10','50000','500000');
INSERT INTO orderDetail (orderID, productID, productName, quantity, price, subTotal) 
VALUES('1','2', '玩偶', '10','3000','30000');


-- 首頁廣告
create table advertise (
adSerialID int  not null auto_increment comment "廣告流水編號",
administratorID int not null comment '管理員編號',
groupBuyID int not null comment "團購編號ID",
adTitle varchar(25) not null comment "廣告標題",
adType varchar(25) not null comment "廣告類別",
adDescribe varchar(200) comment "廣告描述",
adPhoto longblob comment "廣告圖片",
adStartDate date not null comment "廣告上架日期",
adEndDate date not null comment "廣告下架日期",
updateTime timestamp default current_timestamp on update current_timestamp comment "更新時間",
primary key(adSerialID)
);

insert into advertise (administratorID, groupBuyID, adTitle, adType, adDescribe, adPhoto, adStartDate, adEndDate, updateTime)
values 
('1', '1', '團購優惠活動', '團購相關','人數達標享有9折優惠', '', '2022-11-11', '2022-11-20', now()),
('1', '2', '團購優惠活動', '團購相關','人數達標享有9折優惠', '', '2022-11-11', '2022-11-20', now()),
('1', '3', '團購優惠活動', '團購相關','人數達標享有9折優惠', '', '2022-11-11', '2022-11-20', now()),
('1', '4', '團購優惠活動', '團購相關','人數達標享有9折優惠', '', '2022-11-11', '2022-11-20', now()),
('1', '5', '團購優惠活動', '團購相關','人數達標享有9折優惠', '', '2022-11-11', '2022-11-20', now());

/*==========================================================================*/


create view v_memberBlockList as
	select 
    s.storeName, 
    mb.blockListID,
    mb.memberID
    from store s join memberBlockList mb on mb.storeID = s.storeID ;
-- 以上2張表  累計26張表
/*==========================================================================*/
create view category as
select 
	p.productID,
    p.storeID ,
    p.productName ,
    p.productStock ,
    p.productDesc ,
    p.productPrice ,
    p.source ,
    p.productImg ,
    p.productImg2 ,
    p.productImg3 ,
    p.insertTime ,
    p.productStatus ,
    p.commentTotal ,
    p.commentAvgStar ,
    r.storeName,
    r.storeAddress,
    r.phoneNumber,
    s.productSecID,
    s.productSecName,
    m.productMainID,
    m.productMainName
  
from product p
	join store r on p.storeID = r.storeID
	join productSec s on p.productSecID = s.productSecID
		join productMain m on s.productMainID=m.productMainID;
			


