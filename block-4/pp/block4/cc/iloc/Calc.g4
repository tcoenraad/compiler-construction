grammar Calc;

@header{package pp.block4.cc.iloc;}

/** Complete expression. */
complete
	: expr EOF
	;

/** Recursively defined expression. */
expr : expr TIMES expr # times
     | MINUS expr      # minus
     | expr PLUS expr  # plus
     | LPAR expr RPAR  # par
     | NUMBER          # number
     ;

TIMES  : '*';
PLUS   : '+';
MINUS  : '-';
LPAR   : '(';
RPAR   : ')';

NUMBER : [0-9]+;

// ignore whitespace
WS : [ \t\n\r] -> skip;
     