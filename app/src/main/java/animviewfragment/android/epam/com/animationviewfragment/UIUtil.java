package animviewfragment.android.epam.com.animationviewfragment;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewTreeObserver;

public class UIUtil {

    private static long SPEED = 500;

    public static void moveView(View rootView, final SerializableView serializableRemoteView) {
        final View currentView = rootView.findViewById(serializableRemoteView.getId());
        ViewTreeObserver vto = currentView.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            SerializableView serializableCurrentView;

            @Override
            public void onGlobalLayout() {
                currentView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                serializableCurrentView = SerializableView.create(currentView);

                currentView.setLeft(serializableRemoteView.getLeft());
                currentView.setTop(serializableRemoteView.getTop());
                currentView.setRight(serializableRemoteView.getRight());
                currentView.setBottom(serializableRemoteView.getBottom());

                ValueAnimator animator = ValueAnimator.ofInt(serializableRemoteView.getLeft(), serializableCurrentView.getLeft()).setDuration(SPEED);
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int value = (Integer) valueAnimator.getAnimatedValue();
                        currentView.setLeft(value);
                    }
                });
                ;
                animator.start();

                ValueAnimator animator2 = ValueAnimator.ofInt(serializableRemoteView.getTop(), serializableCurrentView.getTop()).setDuration(SPEED);
                animator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int value = (Integer) valueAnimator.getAnimatedValue();
                        currentView.setTop(value);
                    }
                });
                animator2.start();

                ValueAnimator animator3 = ValueAnimator.ofInt(serializableRemoteView.getRight(), serializableCurrentView.getRight()).setDuration(SPEED);
                animator3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int value = (Integer) valueAnimator.getAnimatedValue();
                        currentView.setRight(value);
                    }
                });
                animator3.start();

                ValueAnimator animator4 = ValueAnimator.ofInt(serializableRemoteView.getBottom(), serializableCurrentView.getBottom()).setDuration(SPEED);
                animator4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int value = (Integer) valueAnimator.getAnimatedValue();
                        currentView.setBottom(value);
                    }
                });
                animator4.start();
            }
        });
    }
}
