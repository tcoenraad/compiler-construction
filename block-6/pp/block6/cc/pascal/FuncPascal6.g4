grammar FuncPascal6;

import SimplePascal6;

/** Body of a program. */
body
    : (funcDecl | varDecl)* block
    ;

/** Function declaration. */
funcDecl
    : FUNC ID params COLON type SEMI varDecl* block SEMI
    ;

/** Parameter list in a function or procedure declaration. */
params
    : LPAR (var (SEMI var)*)? RPAR 
    ;

/** Expression. 
 * Extends the imported rule with a call expression. */
expr: prfOp expr        #prfExpr
    | expr multOp expr  #multExpr
    | expr plusOp expr  #plusExpr
    | expr boolOp expr  #boolExpr
    | expr compOp expr  #compExpr
    | LPAR expr RPAR    #parExpr
    | ID args           #callExpr // this is the only new expr
    | ID                #idExpr
    | NUM               #numExpr
    | TRUE              #trueExpr
    | FALSE             #falseExpr
    ;

 /** Arguments of a call. */   
args: LPAR (expr (COMMA expr)*)? RPAR
    ;
    