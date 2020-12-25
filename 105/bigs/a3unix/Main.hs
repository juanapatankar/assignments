module Main (get_maze, print_maze, is_wall, place_player, move, can_move, game_loop, get_path, main) where 

import System.Environment

--maze_path = "assignments/105/bigs/a3unix/maze-big-4.txt"
maze_path = "assignments/105/bigs/a3unix/maze2.txt"
--maze_path = "assignments/105/bigs/a3unix/maze4.txt"

-- Useful code from Lecture 25
-- You may use this freely in your solutions

get :: [String] -> Int -> Int -> Char
get maze x y = (maze !! y) !! x 

modify_list :: [a] -> Int -> a -> [a]
modify_list list pos new =
    let
        before = take  pos    list
        after  = drop (pos+1) list
    in
        before ++ [new] ++ after

set :: [String] -> Int -> Int -> Char -> [String]
set maze x y char = 
    let
        line = maze !! y
        new_line = modify_list line x char
        new_maze = modify_list maze y new_line
    in
        new_maze

---- Part A

-- Question 1

get_maze :: String -> IO [String]
get_maze f = do
    maze <- readFile f
    let fmaze = lines maze
    return fmaze

-- Question 2

print_maze :: [String] -> IO ()
print_maze f = putStrLn(unlines f)

-- Question 3

is_wall :: [String] -> (Int, Int) -> Bool
is_wall m (x,y)  = if (get m x y) == '#' then True else False 

-- Question 4

place_player :: [String] -> (Int, Int) -> [String]
place_player m (x,y) = set m x y '@'


---- Part B

-- Question 5

move :: (Int, Int) -> Char -> (Int, Int)
move (x,y) c 
    | (c == 'w') = (x, y-1)
    | (c == 'a') = (x-1, y)
    | (c == 's') = (x, y+1)
    | (c == 'd') = (x+1, y)
    | otherwise = (x,y)

-- Question 6

can_move :: [String] -> (Int, Int) -> Char -> Bool
can_move m (x,y) c = if is_wall m (move (x,y) c) == True then False else True

-- Question 7

game_loop :: [String] -> (Int, Int) -> IO ()
game_loop m (x,y) = do
    print_maze (place_player m (x,y))
    c <- getLine
    let dir = head(c)
    if can_move m (x,y) dir == True then game_loop m (move (x,y) dir) else game_loop m (x,y)
---- Part C

-- Question 8
move_me m (a,b) (x,y) 
    | is_wall m (a,b)  = "yes"
    | otherwise = "no"
get_path :: [String] -> (Int, Int) -> (Int, Int) -> [(Int, Int)]
--get_path m start target = if start == target then [start] else [(21323213,2133213)]
get_path m start target
    |( start == target) = [start]
    | otherwise = [(2323,2121)]
--get_path m (x,y) target = if (x,y) == target then [(x,y)] else if can_move m (x,y) 'd' then (x,y):get_path m (x+1,y) target 
--else if can_move m (x,y) 's' then (x,y):get_path m (x, y+1) target else [(2,132321212)

-- Question 9

main :: IO ()
main = error "Not implemented"






