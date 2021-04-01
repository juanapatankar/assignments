module Main (get_maze, print_maze, is_wall, place_player, move, can_move, game_loop, get_path, main) where 
-- DEADLINE 13/1/20
import System.Environment

--maze_path = "assignments/105/bigs/a3unix/maze-big-4.txt"
maze_path = "/newpartition/assignments/105/bigs/a3unix/maze4.txt"
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
is_wall m (x,y)  = get m x y == '#'  

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
can_move m (x,y) c = not is_wall m (move (x,y) c)

-- Question 7

game_loop :: [String] -> (Int, Int) -> IO ()
game_loop m (x,y) = do
    print_maze (place_player m (x,y))
    c <- getLine
    let dir = head(c)
    if can_move m (x,y) dir == True then game_loop m (move (x,y) dir) else game_loop m (x,y)
---- Part C

-- Question 8

try_up m start
    | (can_move m start 'w' == True) = move start 'w'
    | otherwise = (0,0)
try_down m start
    | (can_move m start 's' == True) = move start 's'
    | otherwise = (0,0)
try_right m start
    | (can_move m start 'd' == True) = move start 'd'
    | otherwise = (0,0)
try_left m start 
    | (can_move m start 'a' == True) = move start 'a'
    | otherwise = (0,0)

get_successors m start = let {up = try_up m start; down = try_down m start; left = try_left m start; right = try_right m start} in [down:(try_down m down):(try_left m down):(try_right m down):[], [right]]

countFalse [] = 0
countFalse (x:xs) = if x == False then (1+countFalse xs) else countFalse xs
leaforbranch m test 

    | (let {u = can_move m test 'w'; d = can_move m test 's'; l = can_move m test 'a'; r = can_move m  test 'd'} in countFalse [u,d,l,r] == 3) = "Leaf"
    | otherwise = "Branch"

-- move_me m (a,b) (x,y) 
   -- | is_wall m (a,b)  = "yes"
    -- | otherwise = "no"


frontier m start 
    | (can_move m start 's' ) = start:(frontier m (move start 's'))
    | (can_move m start 'd') = start:(frontier m (move start 'd'))
    | otherwise = [start]


get_path :: [String] -> (Int, Int) -> (Int, Int) -> [(Int, Int)]
get_path m start target = frontier m start 
-- get_path maze_path current_position target_position
--
--get_path m start target = if start == target then [start] else [(21323213,2133213)]
-- get_path m start target
   --  |( start == target) = [start]
   -- | otherwise = [(2323,2121)]
--get_path m (x,y) target = if (x,y) == target then [(x,y)] else if can_move m (x,y) 'd' then (x,y):get_path m (x+1,y) target 
--else if can_move m (x,y) 's' then (x,y):get_path m (x, y+1) target else [(2,132321212)

-- Question 9
new_maze m [] = m
new_maze m (x:xs) = new_maze (place_dot m x) xs

place_dot m (x,y) = set m x y '.'

main :: IO ()
main = do
    args <- getArgs
    let path = head args
    m <- get_maze path
    --get_path m (1,1) 
    print_maze (new_maze m (get_path  m (1,1) (7,7)))
    
   






