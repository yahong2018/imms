package com.zhxh.imms.code.entity;

import com.zhxh.core.data.EntityObject;

public class CodeSeed implements EntityObject {
    private String codeSeedId;
    private String codeSeedNo;
    private String codeSeedName;
    private int codeSeedInitialValue;
    private String codeSeedPrefix;
    private String codeSeedPostfix;
    private int codeSeedTotalLength;

    public String getCodeSeedId() {
        return codeSeedId;
    }

    public void setCodeSeedId(String codeSeedId) {
        this.codeSeedId = codeSeedId;
    }

    public String getCodeSeedNo() {
        return codeSeedNo;
    }

    public void setCodeSeedNo(String codeSeedNo) {
        this.codeSeedNo = codeSeedNo;
    }

    public String getCodeSeedName() {
        return codeSeedName;
    }

    public void setCodeSeedName(String codeSeedName) {
        this.codeSeedName = codeSeedName;
    }



    public String getCodeSeedPrefix() {
        return codeSeedPrefix;
    }

    public void setCodeSeedPrefix(String codeSeedPrefix) {
        this.codeSeedPrefix = codeSeedPrefix;
    }

    public String getCodeSeedPostfix() {
        return codeSeedPostfix;
    }

    public void setCodeSeedPostfix(String codeSeedPostfix) {
        this.codeSeedPostfix = codeSeedPostfix;
    }

    public int getCodeSeedTotalLength() {
        return codeSeedTotalLength;
    }

    public void setCodeSeedTotalLength(int codeSeedTotalLength) {
        this.codeSeedTotalLength = codeSeedTotalLength;
    }



    public int getCodeSeedInitialValue() {
        return codeSeedInitialValue;
    }

    public void setCodeSeedInitialValue(int codeSeedInitialValue) {
        this.codeSeedInitialValue = codeSeedInitialValue;
    }


    
}
