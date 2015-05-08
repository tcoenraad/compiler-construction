grammar CC3Attr;

import CC3Vocab;

term returns [ Type type ]
     : t0=term POWER t1=term
       { if ($t1.type != Type.NUM) {
           $type = Type.ERR;
         } else if ($t0.type == Type.NUM || ($t0.type == Type.STR)) {
           $type = $t0.type;
         } else {
           $type = Type.ERR;
         }
       }
     | t0=term PLUS t1=term
       { if ($t0.type == $t1.type) {
           $type = $t0.type;
         } else {
           $type = Type.ERR;
         }
       }
     | t0=term EQUAL t1=term
       { if ($t0.type == $t1.type) {
           $type = Type.BOOL;
         } else {
           $type = Type.ERR;
         }
       }
     | LPAR t0=term RPAR
       { $type = $t0.type; }
     | NUM { $type = Type.NUM; }
     | BOOL { $type = Type.BOOL; }
     | STR { $type = Type.STR; }
     ;