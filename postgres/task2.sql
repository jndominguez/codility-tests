--
-- Get date difference in minutes
--
SELECT id, 
	start_time, 
	end_time, 
	EXTRACT(EPOCH FROM (to_timestamp(end_time,'HH24:MI') - to_timestamp(start_time,'HH24:MI')))/60 AS minutes
FROM meetings ORDER BY id;

--
-- Task 2
--
SELECT id,
	CASE
		WHEN count(1) < 4 THEN '4'
		ELSE count(1)
	END as rooms
FROM (
	--SELECT m1.id, m2.id, m1.start_time,m1.end_time,m2.start_time,m2.end_time
	SELECT m1.id
	FROM meetings m1
	JOIN meetings m2
	ON ((to_timestamp(m1.start_time,'HH24:MI'),to_timestamp(m1.end_time,'HH24:MI')) OVERLAPS (to_timestamp(m2.start_time,'HH24:MI'), to_timestamp(m2.end_time,'HH24:MI')))
	AND m1.id != m2.id
	ORDER BY m1.start_time
	)t
GROUP BY id
ORDER BY rooms desc
LIMIT 1
;
