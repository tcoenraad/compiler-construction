lexer grammar CalcVocab;

@header{package pp.block3.cc.antlr;}

TIMES  : '*';
PLUS   : '+';
MINUS  : '-';
LPAR   : '(';
RPAR   : ')';

NUMBER : [0-9]+;

// ignore whitespace
WS : [ \t\n\r] -> skip;
