grammar CC3;

import CC3Vocab;

term : term POWER term  # hat
     | term PLUS term   # plus
     | term EQUAL term  # equal
     | LPAR term RPAR   # par
     | NUM              # number
     | BOOL             # boolean
     | STR              # string
     ;
