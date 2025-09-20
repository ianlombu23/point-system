CREATE TABLE "point-system".point (
	point_id uuid NOT NULL,
	transaction_type varchar NOT NULL,
	point int4 NOT NULL,
	created_at varchar NULL,
	updated_at timestamp NULL,
	created_by varchar NULL,
	updated_by varchar NULL,
	CONSTRAINT point_pk PRIMARY KEY (point_id)
);