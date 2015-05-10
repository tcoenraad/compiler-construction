grammar Tabular;

@header{package pp.block3.cc.tabular;}

table : '\\begin{tabular}{' TABLE_OPTIONS? '}' row* '\\end{tabular}';
row : (cell '&')* cell '\\\\';
cell : TEXT?;

TABLE_OPTIONS : ['lcr']+;

COMMENT : '%' ~('\n')* '\n' -> skip;
TEXT : (~[' \t\n\r\\{}$&#ˆ_̃%']+ ~['\\{}$&#ˆ_̃%']+ ~[' \t\n\r\\{}$&#ˆ_̃%']+) | ~[' \t\n\r\\{}$&#ˆ_̃%']+;
// special chars in LaTeX: \{}$&#ˆ_̃%
// alternative 1
//  not WHITESPACE and NOT A SPECIAL CHAR for 1 or more times,
//  then NOT A SPECIAL CHAR for 1 or more times
//  then NOT WHITESPACE and NOT A SPECIAL CHAR for 1 or more times,
// alternative 2
//  NOT WHITESPACE AND NOT SPECIAL CHAR for 1 or more times

WS : [ \t\n\r]+ -> skip;
