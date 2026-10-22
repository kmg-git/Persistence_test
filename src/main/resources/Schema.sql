create table entity_b (
    id bigserial primary key,
    text_b varchar
);

create table entity_a(
    id bigserial primary key ,
    text_a varchar,
    b_id bigint references entity_b(id)
);