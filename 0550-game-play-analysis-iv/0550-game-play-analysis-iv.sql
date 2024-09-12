With cte as (
    Select player_id,
    event_date - min(event_date) over(partition by player_id ) diff
    from activity
)
Select round(sum(case when diff = 1 then 1 else 0 end) /count(distinct player_id),2
) as fraction
from cte;