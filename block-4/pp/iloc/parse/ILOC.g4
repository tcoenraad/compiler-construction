grammar ILOC;

@header{package pp.iloc.parse;}

fragment LETTER: [a-zA-Z];
fragment DIGIT: [0-9];

/** Full ILOC program. */
program: instr+;

/** Instruction: single op or []-bracketed non-empty op sequence. */
instr
    : (label ':')? op           #singleInstr
    | (label ':')? LSQ op+ RSQ  #instrList
    ;

/** Single operation. */
op  : COMMENT                   #comment
    | opCode sources ((ARROW|DARROW) targets)? 
      SEMI?
      COMMENT?                  #realOp
    ;

sources: (operand (COMMA operand)*)?;

targets: operand (COMMA operand)*;

/** Operation label. */
label: ID;

/** Opcode: not distinguished by the parser. */
opCode: ID;

/** Operand: ID (label or register), number or string. */
operand : ID | NUM | SYMB | STR;
 
MINUS:  '-';
COMMA:  ',';
SEMI:   ';';
LSQ:    '[';
RSQ:    ']';
DARROW: '=>';
ARROW:  '->';

/** Identifier. */
ID: LETTER (LETTER|DIGIT|[\-_])*;
/** Symbolic name. */
SYMB: '@' ID;
/** Number. */
NUM: MINUS? DIGIT+;
/** String with optional escaped double quotes. */
STR : '"' (~["\n\r] | '\\"')* '"';
/** Java-style comment: // to end of line */
COMMENT: '//' ~[\r\n]* [\r\n][\r\n]?;
/** Whitespace. */
WS : [ \t\r\n]+ -> skip;
