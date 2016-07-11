select xb,count(*) from xs_xjb group by xb

select dwmc,
       rs,
       to_char(round(rs / (select count(*) from xs_xjb) * 100, 2)) || '%'
  from (select distinct dwmc, rs
          from (select b.dwmc, count(*) over(partition by b.dwmc) rs
                  from xs_xjb a, code_dwb b
                 where a.dwb_id = b.id))