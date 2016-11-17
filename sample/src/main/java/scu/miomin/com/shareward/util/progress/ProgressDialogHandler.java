package scu.miomin.com.shareward.util.progress;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;

/**
 * Created by liukun on 16/3/10.
 */
public class ProgressDialogHandler extends Handler {

    public static final int SHOW_PROGRESS_DIALOG = 1;
    public static final int DISMISS_PROGRESS_DIALOG = 2;

    private ProgressDialog pd;

    private Context context;
    private boolean cancelable;
    private ProgressCancelListener mProgressCancelListener;

    public ProgressDialogHandler(Context context, boolean cancelable) {
        super();
        this.context = context;
        this.cancelable = cancelable;
    }

    public ProgressDialogHandler(Context context, ProgressCancelListener mProgressCancelListener,
                                 boolean cancelable) {
        super();
        this.context = context;
        this.mProgressCancelListener = mProgressCancelListener;
        this.cancelable = cancelable;
    }

    public void setProgressCancleListener(ProgressCancelListener mProgressCancelListener) {
        this.mProgressCancelListener = mProgressCancelListener;
    }

    private void initProgressDialog(PDMessage message) {
        if (pd == null) {
            pd = new ProgressDialog(context);

            if (message != null) {
                if (message.title != null)
                    pd.setTitle(message.title);
                if (message.message != null)
                    pd.setMessage(message.message);
            }

            pd.setCancelable(cancelable);

            if (cancelable) {
                pd.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        mProgressCancelListener.onCancelProgress();
                        dismissProgressDialog();
                    }
                });
            }

            if (!pd.isShowing()) {
                pd.show();
            }
        }
    }

    private void dismissProgressDialog() {
        if (pd != null) {
            pd.dismiss();
            pd = null;
        }
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case SHOW_PROGRESS_DIALOG:
                PDMessage pdMessage = (PDMessage) msg.obj;
                initProgressDialog(pdMessage);
                break;
            case DISMISS_PROGRESS_DIALOG:
                dismissProgressDialog();
                break;
        }
    }
}
