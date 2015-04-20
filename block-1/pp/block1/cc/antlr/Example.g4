lexer grammar Example;

@header{package pp.block1.cc.antlr;}

WHILE : 'while';             // Keyword
DO    : 'do';                // Keyword
WS    : [ \t\r\n]+ -> skip ; // At least one whitespace char; don't make token
