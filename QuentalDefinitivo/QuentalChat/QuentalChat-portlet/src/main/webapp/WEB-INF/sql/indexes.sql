create index IX_7A5747D1 on Asignacion (conversacionId);
create index IX_61665DE8 on Asignacion (userId);

create index IX_1E19425C on Conversacion (asignado);
create index IX_DCF55B92 on Conversacion (cerrada);

create index IX_91B318E8 on Mensaje (conversacionId);