# ENSF 409 Final Project: Supply Chain Management - Furniture.jar
#### Group 19: Amanda Nguyen, Dat Lam, Tommy Tran, Tyler Tran

## INSTRUCTIONS

1. Run the program using the following line in the command prompt:
	"java -jar Furniture.jar"

2. The panel shows "Please Enter a Username"
	-Enter your MySQL username (eg. "scm"). This is case-sensitive.
	-Hit "Enter".

3. The panel shows "Please Enter a Password"
	-Enter your MySQL password (eg. "ensf409"). This is case-sensitive.
	-Hit "Enter".
   If either the unsername or password are invalid, the panel will show
   	"Invalid Username or Password, Try Again?"
        -Click "Repeat" to return to step (2).
   If the username and password are valid, the program will continue to step (4).

4. The panel shows "Please input furniture"
	-Enter your category type followed by the furniture category separated by a space 
         (eg. "mesh chair", "staNdinG DESK"). This is not case-sensitive.
	-Hit "Enter".

5. The panel shows "Please input the quantity"
	-Enter your requested integer furniture count (eg. "0" to "9").
	-Hit "Enter".
    If the input is not an integer, the panel will show
  	"Please input an integer"
  	And repeats Step (5) till the use inputs a valid integer.

6. If the input to step (4) is invalid (nonexistent type, improper order) the panel will show
	"Furniture input is invalid"
 	-Hit "Enter"
   If the order cannot be fulfilled due to lack of quantity or parts, the panel will show
	"No available [furniture] to match the critera"
	where [furniture] is the validly requested furniture type and category,
	-Hit "Enter" and the program will output to the terminal a list of relevant manufacturers that
	can provide that furniture type and category.
   If the order can be fulfilled, an output txt file named orderform###.txt will be created, where ### is the order number.
	The txt file contains the IDs of the used items from the inventory and these items will be removed from the database.
	In addition, the order summary will be displayed in the terminal.

7. The panel shows "Continue?"
	-Hit "Yes" to return to step (4).
	-Hit "No" to terminate the program.