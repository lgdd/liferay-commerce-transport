create index IX_CAA01FF0 on CommerceDemo_TransportEvent (carrier[$COLUMN_LENGTH:75$]);
create index IX_B63BBD3C on CommerceDemo_TransportEvent (commerceShipmentId);
create index IX_BEAA898C on CommerceDemo_TransportEvent (trackingNumber[$COLUMN_LENGTH:75$]);
create index IX_B1B5D32C on CommerceDemo_TransportEvent (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_D2B134AE on CommerceDemo_TransportEvent (uuid_[$COLUMN_LENGTH:75$], groupId);