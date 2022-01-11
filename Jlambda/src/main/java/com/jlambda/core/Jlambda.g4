grammar Jlambda;


expr:
    '(' expr ')'  expr+ | expr ('(' expr ')')+ | '(' expr ')'
    | ('λ'|'fun') VARIABLE ('.'|'->') expr
    | let 'in' expr
    | OPERATOR
    | STRING
    | FLOAT
    | INT
    | BOOL
    | VARIABLE
    ;


let: 'let' (VARIABLE|OPERATOR) '=' expr;

stmt: (let|expr)*;

fragment IdentifierPart
    : IdentifierStart
    | [\p{Mn}]
    | [\p{Nd}]
    | [\p{Pc}]
    ;
fragment IdentifierStart
    : [\p{L}]
    | [$_]
    ;

VARIABLE: IdentifierStart IdentifierPart*;

OPERATOR: '+'|'-'|'*'|'**'|'/'|'==';
STRING: '"' .*? '"' | '\'' .*? '\'';
FLOAT: [0-9]+ '.' [0-9]*;
INT: [0-9]+;
BOOL: 'true'| 'false';

COOMENT: '#' .*? '#' -> skip;
WS: [ \t\r\n] -> skip;