create table ocorrencia (
    id serial NOT NULL,
    entrega_id bigint not null,
    descricao text not null,
    data_registro date not null,
    
    primary key (id)
);

alter table ocorrencia add constraint fk_ocorrencia_entrega foreign key (entrega_id) references entrega (id);