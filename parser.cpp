#include "parser.h"

map<string, bool> defVar;
map<string, Token> SymTable;
int thens=0;
string lastDeclLen = "";
bool ifDeclLen = false;
namespace Parser {
	bool pushed_back = false;
	LexItem	pushed_token;

	static LexItem GetNextToken(istream& in, int& line) {
		if( pushed_back ) {
			pushed_back = false;
			return pushed_token;
		}
		return getNextToken(in, line);
	}

	static void PushBackToken(LexItem & t) {
		if( pushed_back ) {
			abort();
		}
		pushed_back = true;
		pushed_token = t;	
	}

}

static int error_count = 0;

int ErrCount()
{
    return error_count;
}

void ParseError(int line, string msg)
{
	++error_count;
	cout << line << ": " << msg << endl;
}

bool IdentList(istream& in, int& line)
{
    LexItem t= Parser::GetNextToken(in, line); //cout<<t.GetLexeme()<<"|Is in list?||";
    if (defVar.find(t.GetLexeme()) == defVar.end())
    {
        defVar[t.GetLexeme()]=true;
        return true;
    }
    else{
		ParseError(line, "Variable Redefinition");
		return false;
	}
        
}

//Prog ::= PROGRAM IDENT {Decl} {Stmt} END PROGRAM IDENT
bool Prog(istream& in, int& line){
    LexItem t;
	t = Parser::GetNextToken(in, line);    //cout<<t<<"|1||";
    if(t!=PROGRAM){
		ParseError(line, "Program statement syntax error.");
		return false;
	}
    
	t = Parser::GetNextToken(in, line);    //cout<<t<<"|2||";
    if(t!=IDENT){
		ParseError(line, "Program statement syntax error.");
		return false;
	}
    
    t = Parser::GetNextToken(in, line);
    //cout<<t<<" +DeclOrStmt+|3||";
    LexItem v=t;    Parser::PushBackToken(t);
            t=Parser::GetNextToken(in, line);
    
    while(v==INTEGER||v==CHARACTER||v==REAL)
    {
            //t=Parser::GetNextToken(in, line);     t=v;   
            //cout<<"()()()"<<v<< " as v vs"<<t<<" as t()()()";
            //cout<<v<<" +pre+||||";//if()
            Parser::PushBackToken(t);    //cout<<t<<"|d||"; 
            bool stat1=Decl(in, line);
            if(!stat1){ParseError(line, "Program statement syntax error.");return false;}t=Parser::GetNextToken(in, line);    v=t;
    }
    while(v==IDENT||v==IF||v==PRINT)
    {
            Parser::PushBackToken(t);   
            //cout<<"[][][]"<<v<< " as v vs "<<t<<" as t[][][]";
            //t=Parser::GetNextToken(in, line); 
                //cout<<t<<"|s||";
            bool stat1=Stmt(in, line);
            if(!stat1){    ParseError(line, "Program statement syntax error.");return false;}t=Parser::GetNextToken(in, line);v=t;//ParseError(line, "Arbitrary error.");return false;
    }
    
    //Parser::PushBackToken(t);    
    //cout<<t<<"|ToEnd||";
    //Parser::PushBackToken(t);    
    
	//t = Parser::GetNextToken(in, line);    cout<<t<<"\t";
    if(t!=END){
		ParseError(line, "Program statement syntax error.");
		return false;
	}
    t = Parser::GetNextToken(in, line);    
    if(t!=PROGRAM){
		ParseError(line, "Program statement syntax error.");
		return false;
	}t = Parser::GetNextToken(in, line);    
    if(t!=IDENT){
		ParseError(line, "Program statement syntax error.");
		return false;
	}
    cout<<"(DONE)\n";
    return true;
        
}
//End of Prog

//Decl::= Type ::VarList
bool Decl(istream& in, int& line)
{
    LexItem t;
    bool s1=Type(in, line);
    if(!s1){
        ParseError(line, "Declaration statement syntax error type.");return false;}
    
	t = Parser::GetNextToken(in, line);Parser::PushBackToken(t);   // cout<<t<<"|::||";
	
    if(t!=DCOLON){
        ParseError(line, "Declaration statement syntax error dcolon.");return false;
    }
    //t=Parser::GetNextToken(in, line);
    bool s2=VarList(in, line);
    if(!s2){
        ParseError(line, "Declaration statement syntax error varlist.");return false;}
    
    if(ifDeclLen){
        cout << "Definition of Strings with length of "<< lastDeclLen <<" in declaration statement.\n";
        ifDeclLen = false;
    }
    
    
    return s2;
    
    
}
//End of Decl

//Type ::= INTEGER | REAL | CHARARACTER [(LEN = ICONST)]
bool Type(istream& in, int& line)
{
    LexItem t;
    
	t = Parser::GetNextToken(in, line);//    cout<<t<<"|b|";
    //if(!(t==INTEGER||t==REAL||t==CHARACTER))    {ParseError(line, "Type statement syntax error not int real char");return false;}
    t=Parser::GetNextToken(in, line);    //cout<<t<<"|lp or bust||";
    if(t==LPAREN)
    {
        t=Parser::GetNextToken(in, line);   // cout<<t<<"\t";
        if(t!=LEN)    {ParseError(line, "Type statement syntax error len mess up");return false;}
        t=Parser::GetNextToken(in, line);   // cout<<t<<"\t";
        if(t!=ASSOP)    {ParseError(line, "Type statement syntax error assop mess up");return false;}
        t=Parser::GetNextToken(in, line);  //  cout<<t<<"\t";
        if(t!=ICONST)    {ParseError(line, "Type statement syntax error iconst messup");return false;}
        lastDeclLen = t.GetLexeme();
        t=Parser::GetNextToken(in, line);  //  cout<<t<<"\t";
        if(t!=RPAREN)    {ParseError(line, "Type statement syntax error rparen mess up");return false;}
        ifDeclLen = true;
        return true;
    }
    else if(t.GetToken() == ERR){
        ParseError(line, "Unrecognized Input Pattern");
        cout << "(" << t.GetLexeme() << ")" << endl;
        return false;
    }
    else{
    Parser::PushBackToken(t);    //cout<<t<<"|else|";
        //cout<<t;
    return true;
    }
}
//End of Type

//VarList ::= Var [= Expr] {, Var [= Expr]}
bool VarList(istream& in, int& line)
{
    LexItem t,v;
	t = Parser::GetNextToken(in, line);    //cout<<t<<"|varlist||";    /*cout<<"First, in varlist, t getnexttoken is called once. the t val is "<<t<<endl;t=Parser::GetNextToken(in, line);*/
     t = Parser::GetNextToken(in, line);Parser::PushBackToken(t);v=t;//cout<<t<<"|A test||";
    bool s1=Var(in, line);    //cout<<"\nFirst T is "<<t;     /*if(s1)    cout<<"\tt is an ident, ";else    cout<<"\tt isn't an ident, ";//cout<<"\tT is "<<t;*/
    
    if(!s1){ParseError(line, "VarList statement syntax error no var.");return false;}    //cout<<" problem with t should be around here: "<<t;
     /*
        cout<<t<<"|Just out||";
        cout<<t<<"|To be compared||";*/Parser::PushBackToken(t);
    bool ex=IdentList(in, line);
    if(!ex){
		ParseError(line, "Missing Variables List.");
		return false;
	}
     t=Parser::GetNextToken(in, line);    
   // cout<<t<<"|,or=||";    //if(t==ASSOP)    cout<<"\nthere a equals\n";
    if(t==ASSOP)
    {        //cout<<"setting equals ";        //Parser::PushBackToken(t);
        bool sAs=false;
        sAs=Expr(in, line);        //if(sAs)    cout<<"\nGot Assop\n";
        if(!sAs){ParseError(line, "VarList statement syntax error no expr.");return false;}
        cout << "Initialization of the variable " << v.GetLexeme()<<" in the declaration statement.\n";
    }
    else if(t.GetToken() == ERR)    {ParseError(line, "Unrecognized Input Pattern");cout << "(" << t.GetLexeme() << ")" << endl;return false;}
    else
    {        //cout<<"end of assop check ";
        Parser::PushBackToken(t);    //cout<<t<<"|!=||";
    }
    
    t=Parser::GetNextToken(in, line);   // cout<<t<<"|,||";
    if(t==COMMA)
    {
        //cout<<"recursion ";
        Parser::PushBackToken(t);    //cout<<t<<"\t";
        s1=VarList(in, line);
    }
    else if(t.GetToken() == ERR)    {ParseError(line, "Unrecognized Input Pattern");cout << "(" << t.GetLexeme() << ")" << endl;return false;}
    else
    {
        //cout<<"end of recurstion ";
        Parser::PushBackToken(t);   // cout<<"/\\/\\"<<t;
        return true;
    }
    return s1;
}
//End of VarList

//Stmt ::= AssignStmt | BlockIfStmt | PrintStmt | SimpleIfStmt
bool Stmt(istream& in, int& line)
{
    LexItem t=Parser::GetNextToken(in, line);        //  cout<<t<<"|stmt||";
    bool s1;
    if(t==PRINT)
    {
        Parser::PushBackToken(t);   
        s1=PrintStmt(in,line);
    }
    else if(t==IDENT)
    {
        Parser::PushBackToken(t); 
        s1=AssignStmt(in, line);
    }
    else if(t==IF)
    {
        t = Parser::GetNextToken(in, line);    //cout<<t<<"|(||";
        
        if(t!=LPAREN)    {ParseError(line, "If statement syntax error.");return false;}
        t = Parser::GetNextToken(in, line);        Parser::PushBackToken(t);   

        bool bb=RelExpr(in, line);
        if(!bb)    {ParseError(line, "If statement syntax error.");return false;}
        t = Parser::GetNextToken(in, line);    //cout<<t<<"|)||";

        if(t!=RPAREN)    {ParseError(line, "If statement syntax error.");return false;}
        t = Parser::GetNextToken(in, line);   // cout<<t<<"|Simple or Block||";    
        if(t==THEN)
        {
            thens++;
           Parser::PushBackToken(t);
            s1=BlockIfStmt(in,line);
        }
        else if(t==PRINT||t==IDENT)
        {
           Parser::PushBackToken(t);
            s1=SimpleIfStmt(in, line);
        }
        else{ParseError(line, "If statement syntax error.");return false;}
    }
    if(!s1)    {ParseError(line, "Stmt statement syntax error.");return false;}
    return s1;
}
//End of Stmt

//PrintStmt:= PRINT *, ExpreList 
bool PrintStmt(istream& in, int& line) {
LexItem t = Parser::GetNextToken(in, line);
t = Parser::GetNextToken(in, line);   // cout<<t<< "|INP||";
if( t != DEF ) {
ParseError(line, "Print statement syntax error.");
return false;}
t = Parser::GetNextToken(in, line);
if( t != COMMA ) {
ParseError(line, "Missing Comma.");
return false;
}
bool ex = ExprList(in, line);
if( !ex ) {
ParseError(line, "Missing expression after writeln");
return false;}
    //ParseError(line, "Arbitrary Error");return false;
return ex;
}//End of PrintStmt

//BlockIfStmt ::= IF (RelExpr) THEN {Stmt} [ELSE {Stmt}] END IF
bool BlockIfStmt (istream& in, int& line) {
    LexItem t;
	
    t = Parser::GetNextToken(in, line);    //cout<<t<<"\t";
    
    while(t!=ELSE && t!=END){
        bool bb=Stmt(in, line);
        if(!bb)    {ParseError(line, "BlockIf statement syntax error.");return false;}
        t = Parser::GetNextToken(in, line);   // cout<<t<<"|Else or End to break||";
        //if(t!=END)
            Parser::PushBackToken(t);
     }
    //Parser::PushBackToken(t);
    t = Parser::GetNextToken(in, line);
    if(t==ELSE)
    {
        while(t!=END){
           // cout<<t<<"|Should be||";
        bool bc=Stmt(in, line);
        if(!bc)    {ParseError(line, "BlockIf statement syntax error.");return false;}t = Parser::GetNextToken(in, line);Parser::PushBackToken(t);//cout<<t<<"|End of While||";
    } t = Parser::GetNextToken(in, line);
    }
       // cout<<t<<"|Should be End||";
    
    if(t!=END)    {ParseError(line, "BlockIf statement syntax error.");return false;}
    t = Parser::GetNextToken(in, line);   // cout<<t<<"|Should be If||";
    
    if(t!=IF)    {ParseError(line, "BlockIf statement syntax error.");return false;}
    //t = Parser::GetNextToken(in, line);    cout<<t<<"|What?||";
    cout<<"End of Block If statement at nesting level "<<thens<<endl;
    thens--;
    return true;
}
//End of BlockIfStmt 

//SimpleIfStmt ::= IF (RelExpr) SimpleStmt
bool SimpleIfStmt (istream& in, int& line) {
    LexItem t;
	
	t = Parser::GetNextToken(in, line);               // cout<<t<<"|Simple If Stmt||"; 
    Parser::PushBackToken(t);
    bool bb=SimpleStmt(in, line);  
    if(!bb)    {ParseError(line, "SimpleIf statement syntax error.");return false;}
    return true;
}
//End of SimpleIfStmt 

//SimpleStmt ::= AssignStmt | PrintStmt
bool SimpleStmt(istream& in, int& line)
{
    bool aOp;
    LexItem t=Parser::GetNextToken(in, line);Parser::PushBackToken(t);     //cout<<t<<"|Print or Ident||";   
    
    if(t==PRINT)
    { 
        aOp=PrintStmt(in, line);
        cout << "Print statement in a Simple If statement.\n";
    }
    else if(t==IDENT)
    {
        //Parser::PushBackToken(t);
        aOp=AssignStmt(in, line);
        cout << "Assign statement in a Simple If statement.\n";
    }
    if(!aOp)    {ParseError(line, "SimpleStmt statement syntax error.");return false;}
    return aOp;
}
//End of SimpleStmt

//AssignStmt ::= Var = Expr
bool AssignStmt(istream& in, int& line)
{
    LexItem t;
    bool s1=Var(in, line);
    if(!s1)    {ParseError(line, "Assign statement syntax error.");return false;}
    t=Parser::GetNextToken(in, line);   // cout<<t<<"|=||";
    if(t!=ASSOP)    {ParseError(line, "Assign statement syntax error.");return false;}
    t=Parser::GetNextToken(in, line);    Parser::PushBackToken(t);//cout<<t<<"|Expr||";
    s1=Expr(in, line);
    if(!s1)    {ParseError(line, "Assign statement syntax error.");return false;}
    return s1;
}
//End of AssignStmt

//ExprList:= Expr {,Expr}
bool ExprList(istream& in, int& line) {
	bool status = false;
	
	status = Expr(in, line);
	if(!status){
		ParseError(line, "Missing Expression");
		return false;
	}
	
	LexItem tok = Parser::GetNextToken(in, line);    //cout<<tok<<"\t";
	
	if (tok == COMMA) {
		status = ExprList(in, line);
	}
	else if(tok.GetToken() == ERR){
		ParseError(line, "Unrecognized Input Pattern");
		cout << "(" << tok.GetLexeme() << ")" << endl;
		return false;
	}
	else{
		Parser::PushBackToken(tok);
		return true;
	}
	return status;
}//End of ExprList

//RelExpr ::= Expr [ ( == | < | > ) Expr ] ;; GTHAN, EQ, LTHAN
bool RelExpr(istream& in, int& line) {
    bool status=false;
    status= Expr(in, line);
    if(!status){
    ParseError(line, "Missing Expression");return false;}
    LexItem tok = Parser::GetNextToken(in, line);   // cout<<tok<<"|Relation||";
    if (tok == GTHAN||tok==LTHAN||tok==EQ) {
		status = Expr(in, line);
	}
	else if(tok.GetToken() == ERR){
		ParseError(line, "Unrecognized Input Pattern");
		cout << "(" << tok.GetLexeme() << ")" << endl;
		return false;
	}
	else{
		Parser::PushBackToken(tok);
		return true;
	}
	return status;
}
//End of RelExpr

//Expr ::= MultExpr { ( + | - | // ) MultExpr } ;; PLUS, MINUS, CAT
bool Expr(istream& in, int& line) {
    bool status=false;
    status= MultExpr(in, line);
    if(!status){
    ParseError(line, "Missing Expression");return false;}
    LexItem tok = Parser::GetNextToken(in, line);
    if (tok == PLUS||tok==MINUS||tok==CAT) {
		status = Expr(in, line);
	}
	else if(tok.GetToken() == ERR){
		ParseError(line, "Unrecognized Input Pattern");
		cout << "(" << tok.GetLexeme() << ")" << endl;
		return false;
	}
	else{
		Parser::PushBackToken(tok);
		return true;
	}
	return status;
}
//End of Expr

//MultExpr ::= TermExpr { ( * | / ) TermExpr }
bool MultExpr(istream& in, int& line) {
    bool status=false;
    status= TermExpr(in, line);
    if(!status)    {ParseError(line, "Missing Expression");return false;}
    LexItem tok = Parser::GetNextToken(in, line);
    if (tok == MULT||tok==DIV) {
		status = MultExpr(in, line);
	}
	else if(tok.GetToken() == ERR){
		ParseError(line, "Unrecognized Input Pattern");
		cout << "(" << tok.GetLexeme() << ")" << endl;
		return false;
	}
	else{
		Parser::PushBackToken(tok);
		return true;
	}
    
	return status;
}
//End of MultExpr

//TermExpr ::= SFactor { ** SFactor }
bool TermExpr(istream& in, int& line) {
    bool status = false;
    status = SFactor(in, line);
    if(!status){
    ParseError(line, "Missing Expression");
    return false;
    }
    LexItem tok = Parser::GetNextToken(in, line);
    if (tok == POW) {
    status = TermExpr(in, line);
    }
    else if(tok.GetToken() == ERR){
    ParseError(line, "Unrecognized Input Pattern");
    cout << "(" << tok.GetLexeme() << ")" << endl;
    return false;
    }
    else{
    Parser::PushBackToken(tok);
    return true;
    }
    return status;
}
//End of TermExpr

//SFactor ::= [+ | -] Factor
bool SFactor(istream& in, int& line) {
    LexItem t=Parser::GetNextToken(in, line);// cout<<t<<"|SFactor||";
    if(t==PLUS)
    {//cout<<t;
        //t=Parser::GetNextToken(in, line);
    // cout<<t<<"|posSfactor||";
        bool cc=Factor(in, line, 1);
        if(!cc)    {ParseError(line, "Missing Expression");return false;}
    }
    else if(t==MINUS)
    {//cout<<t;
        //t=Parser::GetNextToken(in, line);
   //  cout<<t<<"|negSfactor||";
        bool cc=Factor(in, line, -1);
        if(!cc)    {ParseError(line, "Missing Expression");return false;}
    }
    else
    {
    // cout<<t<<"|posSfactor||";
        Parser::PushBackToken(t);
        bool cc=Factor(in, line, 1);
        if(!cc)    {ParseError(line, "Missing Expression");return false;} //cout<<"Test for t as "<<t;
    }
    return true;
}
//End of SFactor

//Var ::= IDENT
bool Var(istream& in, int& line) {
    LexItem t=Parser::GetNextToken(in, line);   //cout<<t<<" |Var||";
    /*t=Parser::GetNextToken(in, line); 
    Parser::PushBackToken(t);
    bool ex=IdentList(in, line);
    if(!ex){
		ParseError(line, "Missing Variables List.");
		return false;}*/
    bool tempo=(t==IDENT);
    if(tempo)
    {
        return true;Parser::PushBackToken(t);
    }
    return false;
}
//Factor ::= IDENT | ICONST | RCONST | SCONST | (Expr)
bool Factor(istream& in, int& line, int sign) {
    LexItem t=Parser::GetNextToken(in, line);    //cout<<t<<"|Factor||";
    if(t==IDENT||t==ICONST||t==RCONST||t==SCONST)
    {
       // cout<<t<<"|Factor||";
       if(t==IDENT){
           if(defVar.find(t.GetLexeme())==defVar.end()){
               ParseError(line, "var redef");
               return false;
                       
           }
       }
        
        return true;
    }
    else if (t==LPAREN)
    {
        //t=Parser::GetNextToken(in, line);
       // cout<<t<<"|Expr||";
        bool bb=Expr(in, line);
        if(bb)
            {t=Parser::GetNextToken(in, line);
             if(t==RPAREN)
                 return true;
            }
        return false;
    }
    return false;
}