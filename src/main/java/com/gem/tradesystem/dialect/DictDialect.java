package com.gem.tradesystem.dialect;

import com.gem.tradesystem.utils.DictUtils;
import org.thymeleaf.context.IExpressionContext;
import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.dialect.IExpressionObjectDialect;
import org.thymeleaf.expression.IExpressionObjectFactory;

import java.util.Collections;
import java.util.Set;

/**
 * @Auther: NoTomato
 * @DATE:2020/2/28 16:36
 * @Description:
 */
public class DictDialect extends AbstractDialect implements IExpressionObjectDialect {

    public DictDialect(String name) {
        super(name);
    }

    @Override
    public IExpressionObjectFactory getExpressionObjectFactory() {
        return new IExpressionObjectFactory() {
            @Override
            public Set<String> getAllExpressionObjectNames() {
                return Collections.singleton("dict") ;
            }

            @Override
            public Object buildObject(IExpressionContext iExpressionContext, String s) {
                return new DictUtils();
            }

            @Override
            public boolean isCacheable(String s) {
                return true;
            }
        };
    }
}
