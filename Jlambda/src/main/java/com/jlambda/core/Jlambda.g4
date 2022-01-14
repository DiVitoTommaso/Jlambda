grammar Jlambda;

stmt: ((let | expr) (';' | EOF))*;

expr:
     let 'in' expr
    | ('λ'|'fun') VARIABLE ('.'|'->') expr
    | STRING
    | FLOAT
    | INT
    | BOOL
    | VARIABLE
    | '(' expr ')'
    | expr expr+
    ;

let: 'let' VARIABLE '=' expr;

STRING: '"' .*? '"' | '\'' .*? '\'';
FLOAT: [0-9]+ '.' [0-9]*;
INT: [0-9]+;
BOOL: 'true'| 'false';

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

COMMENT: '#' .*? '#' -> skip;
WS: [ \t\r\n] -> skip;