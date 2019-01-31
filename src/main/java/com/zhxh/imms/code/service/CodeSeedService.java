package com.zhxh.imms.code.service;


import com.zhxh.imms.code.dao.CodeSeedDAO;
import com.zhxh.imms.code.entity.CodeSeed;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Hashtable;
import java.util.List;

import static com.zhxh.core.exception.ErrorCode.*;
import static com.zhxh.core.exception.ExceptionHelper.throwException;

@Component("codeSeedService")

public class CodeSeedService {
    @Resource(name = "codeSeedDAO")
    private CodeSeedDAO codeSeedDAO;
    private Hashtable<String, CodeSeed> seedList = new Hashtable<>();

    @PostConstruct
    public void init() {
        List<CodeSeed> codeSeedList = this.codeSeedDAO.getAll();
        for (CodeSeed codeSeed : codeSeedList) {
            this.seedList.put(codeSeed.getSeedName(), codeSeed);
        }
    }

    public synchronized String createCode(String seedNo) {
        if (!seedList.containsKey(seedNo)) {
            throwException(ERROR_DATA_NOT_EXISTS, String.format("指定的CodeSeedNo:{%s}不存在！", seedNo));
        }

        CodeSeed codeSeed = seedList.get(seedNo);
        codeSeed.setInitialValue(codeSeed.getInitialValue() + 1);
        codeSeedDAO.update(codeSeed);
        return this.buildCode(codeSeed);
    }

    private String buildCode(CodeSeed codeSeed) {
        int prefixLength = codeSeed.getPrefix().length();
        int postFixLength = codeSeed.getPostfix().length();
        int snLength = codeSeed.getTotalLength() - prefixLength - postFixLength;
        StringBuffer buffer = new StringBuffer("%s").append("%0").append(snLength).append("%s");
        String formatter = buffer.toString();
        return String.format(formatter, codeSeed.getPrefix(), codeSeed.getInitialValue(), codeSeed.getPostfix());
    }
}
