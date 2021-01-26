-- Yes, because there are no side effects. It is deterministic, as inputting the same integers will only return the same result.
-- No, because it has a side effect of needing to connect to the web server. Additionally, if the web page changes, the difference in source code would make the function non-deterministic as entering the same URL (input) would return a different output
-- No, because it would be non-deterministic as it can be shuffled differently and therefore picked randomly. Having the same order each time would make it not random, but chosen.

minus_one = (\x -> x - 1)
quad_power = (\x -> 4 ^ x)
mod_three = (\x -> x `mod` 3)
add_three = (\x y z -> x + y + z)
min_max = (\a b c d -> min a b + max c d)
