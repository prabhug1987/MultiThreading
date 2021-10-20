package com.example.learning.atomic;

import java.util.concurrent.atomic.AtomicLong;
import java.util.function.LongBinaryOperator;
import java.util.function.LongUnaryOperator;

public class AtomicLongExample {

	public static void main(String[] args) {
		AtomicLong atomicLong = new AtomicLong();
		atomicLong.accumulateAndGet(0, new LongBinaryOperator() {

			@Override
			public long applyAsLong(long left, long right) {
				// TODO Auto-generated method stub
				return 0;
			}
		});

		System.out.println(atomicLong.addAndGet(0L));
		System.out.println(atomicLong.byteValue());

		long oldValue = 0, newValue = 20;
		System.out.println(atomicLong.compareAndExchange(oldValue, newValue));
		System.out.println(atomicLong.compareAndExchangeAcquire(oldValue, newValue));
		System.out.println(atomicLong.compareAndSet(oldValue, newValue));
		System.out.println(atomicLong.compareAndExchangeRelease(oldValue, newValue));
		System.out.println(atomicLong.weakCompareAndSet(oldValue, newValue));
		System.out.println(atomicLong.weakCompareAndSetAcquire(oldValue, newValue));
		System.out.println(atomicLong.weakCompareAndSetPlain(oldValue, newValue));
		System.out.println(atomicLong.weakCompareAndSetRelease(oldValue, newValue));
		System.out.println(atomicLong.weakCompareAndSetVolatile(oldValue, newValue));
		System.out.println(atomicLong.decrementAndGet());
		System.out.println(atomicLong.getAndDecrement());
		System.out.println(atomicLong.get());
		System.out.println(atomicLong.getAndAdd(newValue));
		System.out.println(atomicLong.getAndIncrement());
		System.out.println(atomicLong.floatValue());
		System.out.println(atomicLong.getAcquire());
		System.out.println(atomicLong.getAndAccumulate(newValue, new LongBinaryOperator() {

			@Override
			public long applyAsLong(long left, long right) {
				// TODO Auto-generated method stub
				return 0;
			}
		}));

		System.out.println(atomicLong.getAndAdd(newValue));
		System.out.println(atomicLong.getAndSet(newValue));
		atomicLong.set(newValue);

		atomicLong.getAndUpdate(new LongUnaryOperator() {
			@Override
			public long applyAsLong(long operand) {
				// TODO Auto-generated method stub
				return 0;
			}
		});

		System.out.println(atomicLong.intValue());
		System.out.println(atomicLong.doubleValue());
		System.out.println(atomicLong.shortValue());
		System.out.println(atomicLong.longValue());
		atomicLong.lazySet(newValue);

		
	}

}
