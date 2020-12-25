--get_maze :: String -> IO [String]
get_maze = do
	maze <- readFile
	return lines(maze)
