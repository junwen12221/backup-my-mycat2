package cn.lightfish.sql.ast.expr.arithmeticExpr.longOperator;

import cn.lightfish.sql.context.RootSessionContext;
import cn.lightfish.sql.ast.expr.numberExpr.LongExpr;
import cn.lightfish.sql.ast.expr.ValueExpr;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LongSubtractExpr implements LongExpr {

  private final RootSessionContext context;
  private final ValueExpr left;
  private final ValueExpr right;

  @Override
  public Long getValue() {
    Long leftValue = (Long) this.left.getValue();
    if (leftValue == null) {
      return null;
    }
    Long rightValue = (Long) this.right.getValue();
    if (rightValue == null) {
      return null;
    }
    return leftValue - rightValue;
  }
}