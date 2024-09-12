with
    imm
    as
    (
        select
            customer_id,
            rank() over (partition by customer_id order by order_date asc) order_rank,
            case when order_date = customer_pref_delivery_date then 1 else 0 end order_immediate
        from
            delivery
    )
select
    round( sum(order_immediate) / count(*) * 100 ,2) immediate_percentage
from
   imm
where
   order_rank = 1 
;