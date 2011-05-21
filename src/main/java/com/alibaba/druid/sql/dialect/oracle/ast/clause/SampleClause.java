package com.alibaba.druid.sql.dialect.oracle.ast.clause;

import com.alibaba.druid.sql.ast.SQLExpr;
import com.alibaba.druid.sql.dialect.oracle.ast.OracleSQLObject;
import com.alibaba.druid.sql.dialect.oracle.ast.visitor.OracleASTVisitor;

public class SampleClause extends OracleSQLObject {

    private static final long serialVersionUID = 1L;

    private boolean           block            = false;

    private int               percent;

    private SQLExpr           seedValue;

    public boolean isBlock() {
        return block;
    }

    public void setBlock(boolean block) {
        this.block = block;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public SQLExpr getSeedValue() {
        return seedValue;
    }

    public void setSeedValue(SQLExpr seedValue) {
        this.seedValue = seedValue;
    }

    @Override
    protected void accept0(OracleASTVisitor visitor) {
        if (visitor.visit(this)) {
            acceptChild(visitor, seedValue);
        }
        visitor.endVisit(this);
    }

}