mult13 1 = 13
mult13 n = 13 + mult13(n-1)

pow3 1 = 3
pow3 n = 3 * pow3(n-1)

odd_sum 1 = 1
odd_sum n = if n `mod` 2 == 0 then (n-1)+odd_sum(n-3) else n+odd_sum(n-2)

lucas 0 = 2
lucas 1 = 1
lucas n = lucas(n-1) + lucas(n-2)

half_sum [] = 0
half_sum list = head(list)/2 + half_sum(tail(list))

mult2 [x] = [x*2]
mult2 list = (head(list)*2) : mult2(tail(list))

drop_evens [] = []
drop_evens list = let x = head(list) in (if x `mod` 2 == 1 then [x] else []) ++ drop_evens(tail(list))
























