f x
    | elem x "ABCDEFGHIJKLMNOPQRSTU" == True = 
        | x == 'D' = 'd'
        | otherwise = 'h'
    | otherwise = 'n'
