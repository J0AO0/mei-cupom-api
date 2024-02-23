alter table pedido add column tipo_pedido_id integer;
alter table pedido add constraint FK30s8j2ktpay6of18lbyqn3qdc foreign key (tipo_pedido_id) references tipo_pedido (id);
