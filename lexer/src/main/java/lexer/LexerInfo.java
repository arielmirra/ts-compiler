package lexer;

import lexer.tokens.Token;
import lexer.tokens.TokenType;

import java.util.Map;

public class LexerInfo {
    private int line = 1;
    private int column = 1;
    private int startLine = 1;
    private int startColumn = 1;
    private String currentString = "";
    private Map<String, TokenType> tokenTable;

    LexerInfo(Map<String, TokenType> tokenTable) {
        this.tokenTable = tokenTable;
    }

    public Token toToken(TokenType type) {
        return new Token(type, currentString, startLine, startColumn);
    }

    void nextLine() {
        line++;
        column = 1;
    }

    void nextColumn() {
        column++;
    }

    public void nextString() {
        startLine = line;
        startColumn = column;
        currentString = "";
    }

    public void addToString(char c) {
        currentString += c;
    }

    public String getString() {
        return currentString;
    }

    public Map<String, TokenType> getTokenTable() {
        return tokenTable;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }
}
