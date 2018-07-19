package com.example.android.builditbegger;

import android.app.Application;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ApplicationTestCase;
import android.util.Pair;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class AsyncTaskTest extends ApplicationTestCase implements EndpointsAsyncTask.ReciveJokeFromGCE {
    String Joke="";
    CountDownLatch doneSignal;
    public AsyncTaskTest() {
        super(Application.class);
        doneSignal   = new CountDownLatch(1);
    }

    @Test
    public void TestAsync() throws Exception {
        // Context of the app under test.

        new EndpointsAsyncTask(this).execute(new Pair<Context, String>(getContext(), "Manfred"));
        doneSignal.await();
        assertNotNull(Joke);

    }

    @Override
    public void onReceived(String joke) {
        this.Joke = joke;
        doneSignal.countDown();

    }
}
