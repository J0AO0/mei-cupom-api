ALTER TABLE estoque
ADD COLUMN produto_id INT,
ADD CONSTRAINT fk_produto_id FOREIGN KEY (produto_id) REFERENCES produto(id);
