grammar ArrayPascal;

import SimplePascal;

/** Target of an assignment.
 * Extends the imported rule with an array target.
 */
target 
    : ID               #idTarget
    | ID LSQ expr RSQ  #arrayTarget
    ;

/** Expression. 
 * Extends the imported rule with indexed and array expressions.
 */
expr: prfOp expr        #prfExpr
    | expr plusOp expr  #plusExpr
    | expr boolOp expr  #boolExpr
    | expr compOp expr  #compExpr
    | LPAR expr RPAR    #parExpr
    | ID                #idExpr
    | NUM               #numExpr
    | TRUE              #trueExpr
    | FALSE             #falseExpr
    | ID LSQ expr RSQ   #indexExpr
    | RSQ (expr (COMMA expr)*)? RSQ
                        #arrayExpr
    ;

/** Data type.
 * Extends the imported rule with array types. */
type: INTEGER  #intType
    | BOOLEAN  #boolType
    | ARRAY LSQ bound DOTDOT bound NUM RSQ OF type
               #arrayType
    ;

/** Array upper or lowed bound. */
bound : MINUS? NUM;

// Keywords
ARRAY:   A R R A Y;
OF:      O F ;


DOTDOT: '..';
LSQ:    '[';
RSQ:    ']';