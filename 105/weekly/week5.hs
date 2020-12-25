plus_ten = (+10)
is_twenty = (==20)
three_power = (**) 3
power_three = (**3)

xisy x y = x ++ " is " ++ y
cakeis x = (++) "cake is " x

-- func1 :: Num a => a -> a
-- func2 :: (Integral b, fractional b) => b -> b -> (b, b)
-- func3 :: Eq a => [a] -> Bool
-- func4 :: (Ord a, Num a) => [a] -> [a]

-- (\x -> x-1)
-- (\ x y -> show x ++ show y)
-- (\ (x,y) -> (y,x))
-- (\ (x:y:xs) -> y)

-- head.head $  [[1]]
-- (+1).(*2) $ 4
-- sum.tail.tail $ [1,2,3,4]
-- filter (>10).map (*2) $ [1..10]

triple (x:y:xs) = map (*3) xs
list_to_str list = map show(list)
second_char list = map (\ (x:y:xs) -> y) list
add_pairs list = map (\ (x, y) -> x + y) list

only_odds list = filter (\x -> odd x) list
between a b list = filter (\x -> x > a && x < b) list
ordered list = filter (\(x,y) -> x > y) list
singletons list = filter (\x -> length(x) == 1) list
--fu (x:y:xs) = yx
