--
-- PL/pgSQL
--

DO $$
DECLARE
	totalWeight integer := 0;
	v_turn integer;
	v_name varchar(50);
	v_cursor CURSOR FOR SELECT name, weight, turn FROM bolis.line ORDER BY turn ASC;
BEGIN
	FOR v_row IN v_cursor
	LOOP
		totalWeight := totalWeight + v_row.weight;
		IF totalWeight > 1000
		THEN
			EXIT;
		ELSE
			v_turn := v_row.turn;
			v_name := v_row.name;
		END IF;
	END LOOP;
	RAISE NOTICE 'Last turn = % , Name: %', v_turn, v_name;
END $$;

--
-- Window Functions
--

SELECT name FROM
	(SELECT id, name, weight, SUM(weight) OVER (order by turn) AS total
		FROM line
	)t
WHERE total <= 1000
ORDER BY total DESC
LIMIT 1
;
