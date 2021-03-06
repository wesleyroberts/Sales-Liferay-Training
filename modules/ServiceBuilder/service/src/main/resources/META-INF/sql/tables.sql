create table SalesTaxe_CartProductsList (
	productId LONG not null primary key,
	cartId LONG
);

create table SalesTaxe_SaleCart (
	cartId LONG not null primary key,
	totalPrice DOUBLE,
	able BOOLEAN
);

create table SalesTaxe_SaleCategory (
	categoryId LONG not null primary key,
	name VARCHAR(75) null,
	tax DOUBLE
);

create table SalesTaxe_SaleProduct (
	productId LONG not null primary key,
	name VARCHAR(75) null,
	price DOUBLE,
	categoryId LONG,
	typeId LONG
);

create table SalesTaxe_SaleStock (
	StockId LONG not null primary key,
	name VARCHAR(75) null,
	quantity INTEGER,
	typeId LONG,
	categoryId LONG,
	price DOUBLE
);

create table SalesTaxe_SaleType (
	typeId LONG not null primary key,
	name VARCHAR(75) null,
	tax DOUBLE
);

create table SalesTaxe_StockProductsList (
	productId LONG not null primary key,
	StockId LONG
);