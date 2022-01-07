grammar Jlambda;


expr:
    STRING
    | OPERATOR
    | INT
    | VARIABLE
    | let 'in' expr
    | ('λ'|'fun') VARIABLE ('.'|'->') expr
    | '(' expr ')'  expr+ | expr ('(' expr ')')+ | '(' expr ')'
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
STRING: '"' .*? '"' | '\'' .*? '\'';
INT: [0-9]+;

OPERATOR: '+'|'-'|'*'|'**'|'/';

WS: [ \t\r\n] -> skip;