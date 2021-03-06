grammar Jlambda;

stmt: ((let | expr) (';' | EOF))*;

expr:
     let 'in' expr
    | fun
    | select
    | STRING
    | FLOAT
    | INT
    | BOOL
    | VARIABLE
    | '(' expr ')'
    | expr expr+
    ;

fun: ('λ'|'fun') VARIABLE ('.'|'->') '(' expr ')';
select: 'if' expr 'then' expr 'else' expr;
let: 'let' VARIABLE '=' (expr | 'free');

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