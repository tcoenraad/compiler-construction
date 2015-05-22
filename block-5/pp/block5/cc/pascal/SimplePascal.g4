grammar SimplePascal;

@header{package pp.block5.cc.pascal;}

/** Pascal program. */
program
    : PROGRAM ID SEMI body DOT
    ;

/** Body of a program, procedure or function. */
body
    : decl* block
    ;

/** Variable declaration. */
decl: VAR (var SEMI)+                  #varDecl
    ;

/** Variable declaration. */
var : ID (COMMA ID)* COLON type
    ;

/** Grouped sequence of statements. */
block
    : BEGIN stat (SEMI stat)* END
    ;

/** Statement. */
stat: target ASS expr                #assStat
    | IF expr THEN stat (ELSE stat)? #ifStat
    | WHILE expr DO stat             #whileStat
    | block                          #blockStat
    | IN LPAR STR COMMA target RPAR  #inStat  // auxiliary, not Pascal
    | OUT LPAR STR COMMA expr RPAR   #outStat // auxiliary, not Pascal
    ;

/** Target of an assignment. */
target 
    : ID               #idTarget
    ;

/** Expression. */
expr: prfOp expr        #prfExpr
    | expr plusOp expr  #plusExpr
    | expr multOp expr  #multExpr
    | expr compOp expr  #compExpr
    | expr boolOp expr  #boolExpr
    | LPAR expr RPAR    #parExpr
    | ID                #idExpr
    | NUM               #numExpr
    | TRUE              #trueExpr
    | FALSE             #falseExpr
    ;

/** Prefix operator. */
prfOp: MINUS | NOT;

/** Multiplicative operator. */
multOp: STAR | SLASH;

/** Additive operator. */
plusOp: PLUS | MINUS;

/** Boolean operator. */
boolOp: AND | OR;

/** Comparison operator. */
compOp: LE | LT | GE | GT | EQ | NE;

/** Data type. */
type: INTEGER  #intType
    | BOOLEAN  #boolType
    ;

// Keywords
AND:     A N D;
BEGIN:   B E G I N ;
BOOLEAN: B O O L E A N ;
INTEGER: I N T E G E R ;
DO:      D O ;
ELSE:    E L S E ;
END:     E N D ;
EXIT:    E X I T ;
FALSE:   F A L S E ;
FUNC:    F U N C T I O N ;
IF:      I F ;
IN:      I N ;
THEN:    T H E N ;
NOT:     N O T ;
OR:      O R ;
OUT:     O U T ;
PROC:    P R O C E D U R E ;
PROGRAM: P R O G R A M ;
TRUE:    T R U E ;
VAR:     V A R ;
WHILE:   W H I L E ;

ASS:    ':=';
COLON:  ':';
COMMA:  ',';
DOT:    '.';
DQUOTE: '"';
EQ:     '=';
GE:     '>=';
GT:     '>';
LE:     '<=';
LBRACE: '{';
LPAR:   '(';
LT:     '<';
MINUS:  '-';
NE:     '<>';
PLUS:   '+';
RBRACE: '}';
RPAR:   ')';
SEMI:   ';';
SLASH:  '/';
STAR:   '*';

// Content-bearing token types
ID: LETTER (LETTER | DIGIT)*;
NUM: DIGIT (DIGIT)*;
STR: DQUOTE .*? DQUOTE;

fragment LETTER: [a-zA-Z];
fragment DIGIT: [0-9];

// Skipped token types
COMMENT: LBRACE .*? RBRACE -> skip;
WS: [ \t\r\n]+ -> skip;

fragment A: [aA];
fragment B: [bB];
fragment C: [cC];
fragment D: [dD];
fragment E: [eE];
fragment F: [fF];
fragment G: [gG];
fragment H: [hH];
fragment I: [iI];
fragment J: [jJ];
fragment K: [kK];
fragment L: [lL];
fragment M: [mM];
fragment N: [nN];
fragment O: [oO];
fragment P: [pP];
fragment Q: [qQ];
fragment R: [rR];
fragment S: [sS];
fragment T: [tT];
fragment U: [uU];
fragment V: [vV];
fragment W: [wW];
fragment X: [xX];
fragment Y: [yY];
fragment Z: [zZ];
