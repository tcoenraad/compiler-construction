grammar ILOC;

@header{package pp.iloc.parse;}

fragment LETTER: [a-zA-Z];
fragment DIGIT: [0-9];

/** Full ILOC program. */
program: decl* instr (EOL+ instr)* EOL* EOF;

decl: ID ASS NUM COMMENT? EOL+
    ;
    
/** Instruction: single op or []-bracketed non-empty op sequence. */
instr
    : (label ':')?
      op           #singleInstr
    | (label ':')?
      LSQ
      EOL*
      op
      (EOL+ op)*
      EOL*
      RSQ          #instrList
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
operand : ID | NUM | SYMB | LAB | STR;
 
MINUS:  '-';
COMMA:  ',';
SEMI:   ';';
LSQ:    '[';
RSQ:    ']';
DARROW: '=>';
ARROW:  '->';
ASS:    '<-';

/** Identifier. */
ID: LETTER (LETTER|DIGIT|[\-_])*;
/** Symbolic name. */
SYMB: '@' ID;
/** Label used as numeric parameter. */
LAB: '#' ID;
/** Number. */
NUM: MINUS? DIGIT+;
/** String with optional escaped double quotes. */
STR : '"' (~["\n\r] | '\\"')* '"';
/** Java-style comment: // to end of line */
COMMENT: '//' ~[\r\n]*;
/** Whitespace. */
WS  : [ \t]+ -> skip;
EOL : [\r\n]+;