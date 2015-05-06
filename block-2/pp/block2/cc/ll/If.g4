lexer grammar If;

@header{package pp.block2.cc.ll;}

IF : 'if' ;
THEN : 'then' ;
COND : 'cond' ;
ELSE : 'else' ;
ASSIGN : 'assign' ;

// ignore whitespace
WS : [ \t\n\r] -> skip;

// everything else is a typo
TYPO : (~(' ' | '\t' | '\n' | '\r'))+;
