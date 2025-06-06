delete from user_coupons;
delete from coupons;

insert into coupons (id, name, description, maximum_issue_count)
values (1, '10% off', 'Get 10% off your next purchase', 100);