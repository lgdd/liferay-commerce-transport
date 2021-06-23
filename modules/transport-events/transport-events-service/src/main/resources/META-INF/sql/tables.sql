create table CommerceDemo_TransportEvent (
	uuid_ VARCHAR(75) null,
	transportEventId LONG not null primary key,
	commerceShipmentId LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	carrier VARCHAR(75) null,
	trackingNumber VARCHAR(75) null,
	expectedDate DATE null,
	shippingDate DATE null,
	status INTEGER,
	commerceAccountName VARCHAR(75) null
);