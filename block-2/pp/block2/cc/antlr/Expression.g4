grammar Expression;

@header{package pp.block2.cc.antlr;}

expression :
LPAR expression RPAR # parenthesis
| <assoc=right> expression POWER expression # power
| MINUS expression # unary
| expression TIMES expression # times
| expression PLUS expression # plus
| expression MINUS expression # minus
| NUMBER # number;

NUMBER : [0-9]+;
POWER : '^';
TIMES : '*';
PLUS : '+';
MINUS : '-';
LPAR : '(';
RPAR : ')';

WS : [ \t\n\r] -> skip;
