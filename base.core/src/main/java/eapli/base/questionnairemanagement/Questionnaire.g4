grammar Questionnaire;

start : questionnaire ;

questionnaire : QID QTITLE welcome_message section+ final_message
        | QID QTITLE section+ final_message
        ;
welcome_message: 'Welcome message:' (PHRASE END)+ ;
final_message: 'Final message: ' (PHRASE END)+ ;
section: 'Section:' SID STITLE sdescription obligatoriness question+
        | SID STITLE obligatoriness question+
        ;
sdescription: ('Description:' (PHRASE END)+)? ;
question : Q_ID q_text qinstruction obligatoriness extra_info qtype ;
q_text : PHRASE '?' ;
qinstruction: ((PHRASE END)+)? ;
qtype: 'Type:' (free_text | numeric | single_choice | multiple_choice) ;
free_text : 'Free-Text' END ;
numeric : INT END ;
single_choice : ('Single-choice' | 'Single-Choice-Input') END opt+ ;
multiple_choice : ('Multiple-choice' | 'Multiple-Choice-Input') END opt+ ;
opts : opt opts
        | opt ;
opt : SID PHRASE END ;
obligatoriness : MANDATORY
        | OPTIONAL
        | CONDITION
        ;
extra_info : (PHRASE END)? ;
QTITLE : 'Title:' SPACE PHRASE+ END;
SID : INT END ;
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
