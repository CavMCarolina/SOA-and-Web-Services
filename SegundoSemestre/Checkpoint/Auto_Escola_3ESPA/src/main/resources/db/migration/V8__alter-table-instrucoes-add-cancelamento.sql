alter table instrucoes add cancelada tinyint not null default 0;
alter table instrucoes add motivo_cancelamento varchar(30);
