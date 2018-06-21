package cc.hansam.java.rxjava;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

/**
 * @author: ShiShuaishuai
 * @date: 2018/4/21 9:29
 */
public class RxJavaTest {
    public static void main(String[] args) {
        // 被观察者
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("hehe");
//                subscriber.onCompleted();
            }
        });

        // 观察者
        Observer observer = new Observer() {
            @Override
            public void onCompleted() {
                System.out.println("onCom....");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {
                System.out.println("onNext：" + o);

            }
        };

        // 订阅
        observable.subscribe(observer);

    }
}
