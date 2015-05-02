lexer grammar CC4;

@header{package pp.block2.cc.ll;}

A : 'a';
B : 'b';
C : 'c';

// ignore whitespace
WS : [ \t\n\r] -> skip;

// everything else is a typo
TYPO : (~(' ' | '\t' | '\n' | '\r'))+;
