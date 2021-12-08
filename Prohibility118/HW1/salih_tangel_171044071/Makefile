all:
	g++ salih_tangel_171044071.cpp -o run 

valgrind:
	gcc -g -o valgrind_check 3.o
	valgrind --track-origins=yes --leak-check=full ./valgrind_check