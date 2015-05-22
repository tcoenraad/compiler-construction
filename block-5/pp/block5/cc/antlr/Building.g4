grammar Building;

@header{package pp.block5.cc.antlr;}

building: ID COLON floor+;

floor: FLOOR (LSQ room+ RSQ)?;

room: ROOM;

LSQ: '[';
RSQ: ']';
COLON: ':';
SEMI: ';';

fragment DIGIT: [0-9];
fragment LETTER: [a-zA-Z];
fragment NUMBER: DIGIT+;

ROOM: 'r' NUMBER;
FLOOR: 'f' NUMBER;

ID: LETTER+;

WS: [ \t\r\n]+ -> skip;
