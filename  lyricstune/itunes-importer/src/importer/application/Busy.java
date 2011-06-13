package importer.application;

import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Display;

public final class Busy {
    private Busy() {
    }
    public static void run(final Runnable runnable) {
        BusyIndicator.showWhile(Display.getCurrent(), runnable);
    }
 
    public static<T> T runWithReturn(final RunnableWithReturn<T> runnable) {
        Returner<T> r = new Returner<T>(runnable);
        BusyIndicator.showWhile(Display.getCurrent(), r);
        return  r.obj;
    }
    private static final class Returner<T> implements Runnable {
        private T obj;
        private RunnableWithReturn<T> runnable;

        private Returner(RunnableWithReturn<T> runnable) {
            this.runnable = runnable;
        }

        public void run() {
            obj = runnable.run();
        }
    }
}
