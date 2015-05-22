grammar NumWord;

@header{package pp.block5.cc.antlr;}

sentence: (number word)+ EOF;
number: NUMBER;
word: WORD;

fragment DIGIT: [0-9];
fragment LETTER: [a-zA-Z];
WORD: LETTER+;
NUMBER: DIGIT+;
WS: [ \t\r\n]+ -> skip;