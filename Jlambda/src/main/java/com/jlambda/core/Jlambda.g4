grammar Jlambda;

stmt: ((let | expr) (';' | EOF))*;

expr: subexpr+ ('|' ('by' ('value'|'name'))? ('with' 'steps')?)?;

subexpr:
    let 'in' expr
    | fun
    | select
    | load
    | STRING
    | FLOAT
    | INT
    | BOOL
    | VARIABLE
    | '(' expr? ')'
    ;

fun: ('\u03BB'|'fun') VARIABLE ('.'|'->') '(' expr ')';
select: 'if' expr 'then' expr 'else' expr;
let: 'let' VARIABLE '=' expr;
load: 'native' VARIABLE ('.' VARIABLE)* '(' VARIABLE? (',' VARIABLE)* ')' ':' VARIABLE;

STRING: '"' .*? '"';
FLOAT: '-'? [0-9]+ '.' [0-9]*;
INT: '-'? [0-9]+;
BOOL: 'true'| 'false';

VARIABLE: [a-zA-Z]+;

COMMENT: '#' .*? ('\r\n' | '\n') -> skip;
WS: [ \t\r\n] -> skip;