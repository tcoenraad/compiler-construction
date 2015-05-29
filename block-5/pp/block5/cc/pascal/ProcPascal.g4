grammar ProcPascal;

import SimplePascal;

/** Function, procedure or variable declaration. */
decl: FUNC ID pars? COLON type SEMI
      body SEMI                       #funcDecl
    | PROC ID pars? SEMI
      body SEMI                       #procDecl
    | VAR (var SEMI)+                  #varDecl
    ;

/** Parameter list in a function or procedure declaration. */
pars: LPAR VAR? var (SEMI VAR? var)* RPAR 
    ;

/** Statement. 
 * Extends the imported rule with call and exit statements. */
stat: target ASS expr                #assStat
    | IF expr THEN stat (ELSE stat)? #ifStat
    | WHILE expr DO stat             #whileStat
    | block                          #blockStat
    | IN LPAR STR COMMA ID RPAR      #inStat  // auxiliary, not Pascal
    | OUT LPAR STR COMMA expr RPAR   #outStat // auxiliary, not Pascal
    | ID args?                       #callStat
    | EXIT                           #exitStat
    ;

 /** Arguments of a call. */   
args: LPAR (expr (COMMA expr)*)? RPAR
    ;

/** Expression. 
 * Extends the imported rule with a call expression. */
expr: prfOp expr        #prfExpr
    | expr plusOp expr  #plusExpr
    | expr boolOp expr  #boolExpr
    | expr compOp expr  #compExpr
    | LPAR expr RPAR    #parExpr
    | ID args           #callExpr
    | ID                #idExpr
    | NUM               #numExpr
    | TRUE              #trueExpr
    | FALSE             #falseExpr
    ;
