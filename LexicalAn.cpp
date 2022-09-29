//COMP360-001: Programming Languages
//Project 1 done by: 
//Jordan Mozebo 
//Jordan Whitaker 

/*Language implementation systems must input a file, identify substrings, and find all syntax errors
regardless of the specific implementation approach. 
For an input program a lexical analyzer will break a file into lexemes and tokens. 
A parser will find all syntax errors. 
For each error the parser will produce an appropriate diagnostic message and recover quickly*/


/*LexicalAn.cpp - a lexical analyzer system to analyze program input from a file*/
#include <stdio.h>
#include <ctype.h>
#include <string>
#include <iostream>
#include <fstream>
#include <stdlib.h>
using namespace std;

/*Global delcarations*/
/*variables*/
int charClass;  //the character class of the input character from the program input file
char lexeme[100]; //array of character that will contain the lexemes
char nextChar; //the next character to be parsed
int lexLen; //the length of the array of lexemes
int token; //the token
int nextToken; //the token to be parsed
FILE *in_fp,*fopen(); 
char ch;

/*Function declarations*/
void addChar(); //put the next character into the array of lexemes
void getChar(); //get the next character of input from the input program
void getNonBlank(); //used to skip white space every time the analyzer is called
int lex();

/*Character classes*/
#define LETTER 0
#define DIGIT 1
#define UNKNOWN 99

/*Token codes*/
#define INT_LIT 10
#define IDENT 11
#define ASSIGN_OP 20
#define ADD_OP 21
#define SUB_OP 22
#define MULT_OP 23
#define DIV_OP 24
#define LEFT_PAREN 25
#define RIGHT_PAREN 26
#define LEFT_CURLY_BRACE 27
#define RIGHT_CURLY_BRACE 28
#define EQUAL_OP 29
#define SEMI_COLON 30
#define COMMA 31

/*addChar - a function to add nextChar to lexeme*/
void addChar(){
    if(lexLen <= 98){
        lexeme[lexLen++] = nextChar;
        lexeme[lexLen++] = 0;
    }
   
    
} /*End of function addChar()*/

/*------------------------------------------------------------------------------------------------------------------------------------------*/

/*getChar - a function to get the next character of input and determine its character class*/
void getChar(){
    if((nextChar = getc(in_fp)) != EOF){
        if(isalpha(nextChar)){
            charClass = LETTER;
            
        }
        else {
            if(isdigit(nextChar)){
                charClass = DIGIT;
                
            }
            else{
                charClass = UNKNOWN;
            } 
        }
    }

    else{
        charClass = EOF;
    }
    
} /*End of function getChar()*/

/*------------------------------------------------------------------------------------------------------------------------------------------*/

/*getNonBlank - a function to call getChar until it returns a non-whitespace character */
void getNonBlank(){
    while(isspace(nextChar)){
        getChar();
    }
} /*End of function getNonBlank*/

/*------------------------------------------------------------------------------------------------------------------------------------------*/

/*lookup - a function to lookup operators and parentheses and return the token */
int lookup (char ch){
    switch(ch){
        case '(':
        addChar();
        nextToken = LEFT_PAREN;
        break;

        case ')':
        addChar();
        nextToken = RIGHT_PAREN;
        break;

        case '{':
        addChar();
        nextToken = LEFT_CURLY_BRACE;
        break;

        case '}':
        addChar();
        nextToken = RIGHT_CURLY_BRACE;
        break;

        case '+':
        addChar();
        nextToken = ADD_OP;
        break;

        case '-':
        addChar();
        nextToken = SUB_OP;
        break;

        case '*':
        addChar();
        nextToken = MULT_OP;
        break;

        case '/':
        addChar();
        nextToken = DIV_OP;
        break;

        case '=':
        addChar();
        nextToken = EQUAL_OP;
        break;

        case ';':
        addChar();
        nextToken = SEMI_COLON;
        break;

        case ',':
        addChar();
        nextToken = COMMA;
        break;

        default:
        addChar();
        nextToken = EOF;
        break;

    }

    return nextToken;
} /*End of function lookup */

/*------------------------------------------------------------------------------------------------------------------------------------------*/

/*lex - a simple lexical analyzer for arithmetic expressions*/
int lex(){
    lexLen = 0;
    getNonBlank();
    switch (charClass) {

        /*Parse identifiers*/
        case LETTER:
        addChar();
        getChar();
        while (charClass == LETTER || charClass == DIGIT){
            addChar();
            getChar();
        }
        nextToken = IDENT;
        break;

        /*Parse integer literals*/
        case DIGIT:
        addChar();
        getChar();
        while (charClass == DIGIT){
            addChar();
            getChar();
        }
        nextToken = INT_LIT;
        break;

        /*Parentheses and operators*/
        case UNKNOWN:
        lookup(nextChar);
        getChar();
        break;

        /*EOF*/
        case EOF:
        nextToken = EOF;
        lexeme[0] = 'E';
        lexeme[1] = 'O';
        lexeme[2] = 'F';
        lexeme[3] = 0;
        break;

    }/*End of switch*/

    printf("Next token is: %d, Next lexeme is %s\n", nextToken, lexeme);
    return nextToken;
} /*End of function lex*/

/*------------------------------------------------------------------------------------------------------------------------------------------*/

/*keyword - check if the first token is a keyword*/
void keyword(){
    
    /*Determine which right hand side*/
    if(nextToken == IDENT){
        lex();   
        
    }   
   
    
} /*End of keyword function*/

/*-----------------------------------------------------------------------------------------------------------------------------------------*/

/*identifier - check if the first token is an identifier*/
bool identifier(){
    bool id = false;
    /*Determine which right hand side*/
    if(nextToken == IDENT){
        id = true;
        
        
    }

    return id;
    
    
} /*end of the function indentifier*/

/*-----------------------------------------------------------------------------------------------------------------------------------------*/


/*program() - the analyze the first line of the demo language */
void program(){

    /*Parse the first keyword */
    keyword();

    /*Parse the first identifier*/
    identifier();


    /*check if the next token is a left parenthesis */
    if(nextToken == LEFT_PAREN){
        lex();
        if(identifier() == true){
            printf("The program cannot be generated by the demo language.\n");
            exit(1);
        }
        else{
            lex();
        }
        
    }

    if(nextToken == RIGHT_PAREN){
        lex();
        
    }
    if(nextToken == LEFT_CURLY_BRACE){
        lex();
          
    }

    if(nextToken == SEMI_COLON){
        lex();   
        
    }
    if(nextToken == EQUAL_OP){
        lex();
        
    }

    if(nextToken == MULT_OP){
        lex();
    }

    if(nextToken == DIV_OP){
        lex();
       
    }
    
    else{
        if(nextToken == EOF){
            
            printf("The program is generated by the grammar.\n");
            
        }  
        
    }
   
} /*End of function program*/

/*-------------------------------------------------------------------------------------------------------------------------------------------*/


int main(){
    
    if((in_fp = fopen("program.txt","r")) == NULL){
        printf("ERROR - cannot open program.txt \n");
    }
    else{
        getChar();
        do{
            lex();
            program();
        }
        while (nextToken !=EOF);
        
        
    }
}//End of main function


