CREATE TABLE "point-system".user_point (
	user_point_id uuid NOT NULL,
	user_id uuid NOT NULL,
	point_id uuid NOT NULL,
	transaction_id uuid NOT NULL,
	point int4 NOT NULL,
	created_at varchar NULL,
	updated_at timestamp NULL,
	created_by varchar NULL,
	updated_by varchar NULL,
	CONSTRAINT user_point_pk PRIMARY KEY (user_point_id)
);