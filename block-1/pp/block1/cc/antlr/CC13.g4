lexer grammar CC13;

@header{package pp.block1.cc.antlr;}

STRING: ('"' (~('"'))* '"')+;
