grammar NumWordGroup;

@header{package pp.block5.cc.antlr;}

sentence
    : (group* penultimateGroup)? lastGroup EOF;
    
group
    : number word;
    
penultimateGroup
    : number word;
    
lastGroup
    : number word;

number: NUMBER;
word: WORD;

fragment DIGIT: [0-9];
fragment LETTER: [a-zA-Z];
WORD: LETTER+;
NUMBER: DIGIT+;
WS: [ \t\r\n]+ -> skip;