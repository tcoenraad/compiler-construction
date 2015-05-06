grammar DeclUse;

@header{package pp.block3.cc.symbol;}

program : '(' series ')' ;
series  : unit* ;
unit    : decl | use | '(' series ')' ;
decl    : 'D:' ID ;
use     : 'U:' ID ;

ID : [a-zA-Z]+;
WS : [ \t\n\r]+ -> skip;
