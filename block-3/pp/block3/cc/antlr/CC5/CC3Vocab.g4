lexer grammar CC3Vocab;

@header{package pp.block3.cc.antlr.CC5;}

POWER  : '^';
PLUS   : '+';
EQUAL  : '=';
LPAR   : '(';
RPAR   : ')';

NUM    : [0-9]+;
BOOL   : 'true' | 'false';
STR    : '\'' [a-zA-Z]+ '\'';

// ignore whitespace
WS : [ \t\n\r] -> skip;
