package cc.hansam.java.rxjava;

import rx.Observable;
import rx.Subscriber;

/**
 * @author: ShiShuaishuai
 * @date: 2018/4/21 9:59
 */
public class RxJavaTest2 {
    public static void main(String[] args) {
        Observable.from(new Integer[]{1, 2, 3}).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer);
            }
        });
    }
}
