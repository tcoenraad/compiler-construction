grammar Calc;

import CalcVocab;

expr : expr TIMES expr # times
     | expr PLUS expr  # plus
     | LPAR expr RPAR  # par
     | NUMBER          # number
     ;
