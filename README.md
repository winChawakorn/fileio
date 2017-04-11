# fileio(Lab6)
fileio is a file copying testing by read a String one line per time and then write it into new file.
There are 2 classes in this Lab.
- FileUtil is used to reading and writing a file by many solution.
- FileCopyTask is a task runner and measure the time taken.

## Result

Task 										| Time
--------------------------------------------------------------------------------|--------------:
Copy a file byte by byte 							| 6.614472 sec
Copy a file 1 KB per array							| 0.010002 sec
Copy a file 4 KB per array	 						| 0.003968 sec
Copy a file 64 KB per array	 						| 0.001668 sec
Copy a file 256 KB per array							| 0.002099 sec
Copy a file using BufferedReader and PrintWriter with one line of string	| 0.059027 sec
Copy a file using BufferedReader and BufferedWriter with an array of char	| 0.019426 sec

## Explanation of Results
- Group one (block size)
Copy file by block size is like a division. The higher divisor we use, the faster time we spend.
As we can see in the result table, the time taken is reduce when the block size is increase.
But when the block size is larger than my PC's RAM size, the program will use computer's memory to copy
the rest block size(RAM working faster than computer's memory). That's why copy a file 256 KB
per array use more time than 64 KB per array.

- Group two (BufferedReader)
This group is about the data type. Why copy file using array of char is faster than string,
because the program have to convert the data type to char or string before writing to a new file
and the order of converting is [code]byte > byte[] > char > char[] > string[/code]. So the
program have to convert char[] to string before writing to a new file(using one more step than char[]).

Author Chawakorn Suphepre