gt_100 x = if x > 100 then return 1 else return 0
switch x y c = if c == 1 then return x else return y
fizzbuzz x = if x `mod` 3 == 0 && x `mod` 5 == 0 then return "Fizzbuzz!" else return "Nope."
question1 x = let a = x*x in 2*a
question2 x = let {a = x+1; b = a*a; c = 2^b} in a + b - c
bounded_square x = let a = x*x in if (a < 100) then return a else return 100
