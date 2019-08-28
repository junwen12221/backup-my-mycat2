package cn.lightfish.sql.executor;

import cn.lightfish.sql.executor.logicExecutor.Executor;
import cn.lightfish.sql.schema.BaseColumnDefinition;

public enum EmptyExecutor implements Executor {
  INSTACNE;

  @Override
  public BaseColumnDefinition[] columnDefList() {
    return new BaseColumnDefinition[0];
  }

  @Override
  public boolean hasNext() {
    return false;
  }

  @Override
  public Object[] next() {
    return new Object[0];
  }
}