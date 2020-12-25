-- 4 because firstly the else statement would have to be executed, therefore b must be False, so it must be either 3. or 4. Secondly, it has to return an error. Input 3 would cause the function to return 3, whereas 4 would return the error.
-- 4 would terminate, as all the other queries involve infinite lists. However, 4 has the limitation of only going up to the 1000th index (1001) of each list

product' :: [Int] -> Int
pr_chain [] acc = acc
pr_chain (x:xs) acc = (pr_chain xs acc) * x
product' list = pr_chain list 1

sum_up_to :: Int -> Int
add_me 0 acc = acc
add_me n acc = n + add_me (n-1) acc
sum_up_to n = add_me n 0

even_sum :: Int -> Int
add_even 0 acc = acc
add_even n acc = if n `mod` 2 == 0 then (n + add_even (n-2) acc) else ((n-1) + add_even (n-3) acc)
even_sum n = add_even n 0

even_product :: [Int] -> Int
even_product list = foldr (\x acc -> if (x `mod` 2 == 0) then (x*acc ) else acc) 1 list

-- sum_fst should be implemented with lazy evaluation since not every element in the list has to be computed - only the first ones in each tuple are added to the accumulator. This means that foldr should be used. 

sum_fst list = foldr (\x acc -> fst(x)+acc) 0 list
even_elements list = foldr (\x acc -> if x `mod` 2 == 0 then x:acc else acc) [] list

-- even_elements should be computed with lazy evaluation, as this would allow it to compute an infinite list. The output in this case would be infinite, but it wouldn't return an error. Either foldl or foldr should be used. However, not every value will be used with the accumulator - odd numbers don't need to be used in evaluation except for finding out that they are odd. For this reason, using foldr would be better. 


-- even_product doesn't require every element to be consumed and used with the accumulator. For this reason, foldr should be used - since that would only consume the even elements, rather than also multiplying the odd ones with the accumulator like foldl or foldl' does. 
