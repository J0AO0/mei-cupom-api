create table estoque_produto (quantidade integer, tenant_id integer, produto_id integer not null, estoque_id integer not null, status bit, primary key (produto_id, estoque_id)) engine=InnoDB;
alter table estoque_produto add constraint FK5v3x8uwb51v7l9mk41dy2jjia foreign key (produto_id) references pedido (id);
alter table estoque_produto add constraint FKoya2x5ip1q2t3s0936vgji123 foreign key ( estoque_id) references produto (id);
alter table estoque_produto add constraint FKdrkgx9furxyv09fpsfv4wag34 foreign key (tenant_id) references tenant (id);