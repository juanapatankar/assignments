plus_ten = (+) 10.0
is_twenty = (\x -> if x == 20 then True else False)
three_power = (3**)
power_three = (**3)
xisy x y = x ++ " is " ++ y
cakeis = xisy "cake"

-- Num a => a -> a -> a
-- (Integral a, Fractional b) => a -> b -> (a,b)
-- [a] -> Bool
-- Num a => [a] -> [a]

f = (\x -> x - 1)
h = (\(x,y) -> (y,x))
i = (\(_:y:_) -> y)
-- (\x y -> show x ++ show y)

j = head . head $ [[1]]
k = (+1) . (* 2) $ 4
l = sum . tail. tail $ [1,2,3,4]
m = filter ( >10) $ map  (*2)  $ [1..10]

triple list = map (*3) list
list_to_str list = map show list
second_char list = map (\(x:y:xs) -> y) list
add_pairs list = map (\(x,y) -> x + y) list

only_odds list = filter (odd) list
between a b list = filter (\x -> x > a && x < b) list
ordered list = filter (\(x,y) -> x > y) list
singletons list = filter (\x -> length x == 1) list
