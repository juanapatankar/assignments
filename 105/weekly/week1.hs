-- Yes, because any two inputs will always return the same output. For example, inputting 4 and 11 will always give an output of 225. There are no side effects, as the function only needs to return the output, rather than printing it or storing it to a (global) variable.
-- No, because the function could give a different output for the same input, if the source code for the page had been changed. This would make the function non-deterministic, as it can't be guaranteed that the same URL will always return the same HTML source code. It is also not specified in the question how the source code is outputted - if it was printed, this would not be possible as part of a pure function alone.
-- No, because providing the same list of cards could return different order outputs. This would first be dependent on how the cards were shuffled - the shuffled list would also need to be stored to a variable, which is not possible in a pure function - and then the random return of each card would make the function even more non-deterministic.

-- 7*11*13<17*59
-- max (5*199) (3*331)
plus_one x = x + 1
five_sum x y = (x+y) * 5
-- broken x = x + 1 + "hi"

minus_one x = x - 1
quad_power x = 4 ^ x
mod_three x = mod x 3
add_three x y z = x + y + z
min_max a b c d = (min a b) + (max c d)
