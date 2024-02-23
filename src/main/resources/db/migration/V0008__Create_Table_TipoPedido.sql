create table tipo_pedido (id integer not null auto_increment, tenant_id integer,nome varchar(255), primary key (id)) engine=InnoDB;
alter table tipo_pedido add constraint FK5grfw6g65w8qbqiajdspksadr foreign key (tenant_id) references tenant (id);
