package chanjy.exception;

import chanjy.result.CodeMsg;

public class GlobalException extends RuntimeException{
    private static final long serialVersionUID=1L;

    private CodeMsg cm;

    public CodeMsg getCm() {
        return cm;
    }

    public GlobalException(CodeMsg cm){
        super((cm.toString()));
        this.cm=cm;
    }
}
