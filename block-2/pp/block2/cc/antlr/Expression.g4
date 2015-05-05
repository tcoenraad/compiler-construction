grammar Expression;

@header{package pp.block2.cc.antlr;}

expression :
LPAR expression RPAR # parenthesis
| <assoc=right> expression POWER expression # power
| MINUS expression # minus
| expression TIMES expression # multiplication
| expression PLUS expression # addition
| expression MINUS expression # subtraction
| NUMBER # number;

NUMBER : [0-9]+;
POWER : '^';
TIMES : '*';
PLUS : '+';
MINUS : '-';
LPAR : '(';
RPAR : ')';

WS : [ \t\n\r] -> skip;
