grammar Answer;

init : answers ;

answers : answer+
        ;

answer : Q_ID q_text obligatoriness c_answer
        ;

q_text : PHRASE '?' ;

c_answer : INT
        | PHRASE
        | PHRASE END ;

obligatoriness : MANDATORY
        | OPTIONAL
        | CONDITION
        ;
INT: [0-9]+;
END: [.!;] ;
SPACE: [ \t] -> skip;
COMMA: [,] -> skip;
SPECIAL_CHAR: [()+/\-'#"] -> skip;
NEWLINE: [ \n\r] -> skip;
STRING : [a-zA-Z]+[0-9]+ | '_' | '\'' ;
SIGNAL : '-'
        | '.'
        | ';'
        | ', '
        ;
QID : STRING INT SIGNAL INT ;
Q_ID : 'Q' [0-9]+ ':' ;
STITLE : 'Stitle: ' PHRASE END ;
MANDATORY : 'Obligatoriness: Mandatory.' ;
OPTIONAL : 'Obligatoriness: Optional.' ;
CONDITION : 'Obligatoriness: Condition.' ;
PHRASE: SPECIAL_CHAR? (WORD|INT) (WORD|INT|SPACE|SPECIAL_CHAR|COMMA)* SPECIAL_CHAR? ;
WORD: [A-Za-z]+;
WS : [ \t\r\n]+ -> skip ;
