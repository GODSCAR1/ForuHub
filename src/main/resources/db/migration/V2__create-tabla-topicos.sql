create table topicos(
                        id bigint not null auto_increment,
                        titulo varchar(100) not null unique,
                        mensaje varchar(100) not null unique,
                        usuario_id varchar(100) not null,
                        curso varchar(100) not null,

                        primary key(id),

                        constraint fk_topicos_usuario_idforeign key (usuario_id) references usuarios(id)
);