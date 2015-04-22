lexer grammar CC12;

@header{package pp.block1.cc.antlr;}

fragment LETTER : 'a'..'z'|'A'..'Z';
fragment ALPHANUMERIC : (LETTER | '0'..'9');

IDENTIFIER: LETTER ALPHANUMERIC ALPHANUMERIC ALPHANUMERIC ALPHANUMERIC ALPHANUMERIC;
