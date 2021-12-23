create index IX_2168D203 on SalesTaxe_SaleCategory (name[$COLUMN_LENGTH:75$]);

create index IX_B2B3C8F4 on SalesTaxe_SaleProduct (name[$COLUMN_LENGTH:75$]);
create index IX_2A5BC724 on SalesTaxe_SaleProduct (price);

create index IX_D550DE31 on SalesTaxe_SaleStock (name[$COLUMN_LENGTH:75$], typeId, categoryId);

create index IX_579AA83F on SalesTaxe_SaleType (name[$COLUMN_LENGTH:75$]);