package io.mycat.router.function;

import io.mycat.router.RuleAlgorithm;
import java.util.Map;

public class PartitionByJumpConsistentHash extends RuleAlgorithm {

  private static final long UNSIGNED_MASK = 0x7fffffffffffffffL;
  private static final long JUMP = 1L << 31;
  // If JDK >= 1.8, just use Long.parseUnsignedLong("2862933555777941757") instead.
  private static final long CONSTANT = Long.parseLong("286293355577794175", 10) * 10 + 7;
  private int totalBuckets;

  private static int jumpConsistentHash(final long key, final int buckets) {
    checkBuckets(buckets);
    long k = key;
    long b = -1;
    long j = 0;

    while (j < buckets) {
      b = j;
      k = k * CONSTANT + 1L;

      j = (long) ((b + 1L) * (JUMP / toDouble((k >>> 33) + 1L)));
    }
    return (int) b;
  }

  private static void checkBuckets(final int buckets) {
    if (buckets < 0) {
      throw new IllegalArgumentException("Buckets cannot be less than 0");
    }
  }

  private static double toDouble(final long n) {
    double d = n & UNSIGNED_MASK;
    if (n < 0) {
      d += 0x1.0p63;
    }
    return d;
  }

  @Override
  public String name() {
    return "PartitionByJumpConsistentHash";
  }

  @Override
  public int calculate(String columnValue) {
    return jumpConsistentHash(columnValue.hashCode(), totalBuckets);
  }

  @Override
  public int[] calculateRange(String beginValue, String endValue) {
    return calculateSequenceRange(this, beginValue, endValue);
  }

  @Override
  public int getPartitionNum() {
    return this.totalBuckets;
  }

  @Override
  public void init(Map<String, String> prot, Map<String, String> ranges) {
    this.totalBuckets = Integer.parseInt(prot.get("totalBuckets"));
  }
}